# 스프링 데이터 JPA 분석

### 스프링 데이터 JPA 구현체 분석
SimpleJpaRepository class 보면 보통 전부 JPA 의 내부 기능을 가져다 사용하는 것이다.

@Transaction(readOnly = true)<br>
Flush 를 안하기 때문에 변경감지를 안한다.<br>
더티 체킹들이 생략되어 약간의 성능 최적화가 된다.

save() 메서드
```java
@Transactional
public <S extends T> S save(S entity) {
    Assert.notNull(entity, "Entity must not be null");
    if (this.entityInformation.isNew(entity)) {
        this.entityManager.persist(entity);
        return entity;
    } else {
        return this.entityManager.merge(entity);
    }
}
```
this.entityInformation.isNew(entity) 새로운 Entity 면 저장하고 아니면 merge<br>
(merge 호출하면 DB 에 있는 데이터를 꺼내어 파라미터로 넘기며 교체를 해버린다.<br>
merge 단점은 DB select 를 한번 한다는 것이다.)

가급적이면 merge 하면 안되고 변경감지를 이용해야 한다.<br>
merge 는 영속 상태 엔티티가 영속상태를 벗어났을 때 잠깐 사용하기 위해서 사용한다.

##### this.entityInformation.isNew(entity) 새로운 엔티티 구별 방법
```java
@Transactional
public <S extends T> S save(S entity) {
    Assert.notNull(entity, "Entity must not be null");
    if (this.entityInformation.isNew(entity)) {
        this.entityManager.persist(entity);
        return entity;
    } else {
        return this.entityManager.merge(entity);
    }
}
```
this.entityInformation.isNew(entity) 체크하면 entity 안에 id 가 null 로 되어있다.<br>
this.entityManager.persist(entity); 여기서 부터 id 값을 가져오게 된다.

```java
@SpringBootTest
@Rollback(value = false)
class ItemRepositoryTest {
    @Autowired ItemRepository itemRepository;
    @Test
    @DisplayName("")
    public void save() throws Exception {
        //given
        Item item = new Item();
        itemRepository.save(item);
    }
}
```
테스트에 @Transactional 을 하지 않아도 트랜잭션이 걸려있다.<br>
이유는 아래와 같다.
```java
@Transactional
public <S extends T> S save(S entity) {
    ...
}
```

***id 가 개체일 경우는***
```java
public class Item {
    @Id
    private String id;

    protected Item() {}

    public Item(String id) {
        this.id = id;
    }
}

public void save() throws Exception {
    //given
    Item item = new Item("A");
    itemRepository.save(item);
}
```
return this.entityManager.merge(entity); 를 타게 된다.
이럴땐,
```java
public class Item implements Persistable<String> {
    @Id
    private String id;

    protected Item() {}

    public Item(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }
    
    @Override
    public boolean isNew() {
        return false;
    }
}
```
Persistable 를 상속받아서 isNew() 로직을 통해 새로운 엔티티라고 알려줘야한다.
실무에서는 아래와 같이 사용한다.
```java
@Entity
@Getter
@EntityListeners(AuditingEntityListener.class)
public class Item implements Persistable<String> {
    @Id
    private String id;

    @CreatedDate
    private LocalDateTime createDate;
    
    @Override
    public boolean isNew() {
        // 새로운 개체
        return createDate == null;
    }
}
```
