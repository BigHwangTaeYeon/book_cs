package study.querysdl.entity;

import com.querydsl.core.QueryResults;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.dsl.CaseBuilder;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static study.querysdl.entity.QMember.*;
import static study.querysdl.entity.QTeam.*;
import static org.assertj.core.api.Assertions.*;



@SpringBootTest
@Transactional
public class QuerydslBasicTest {
    @Autowired
    EntityManager em;

    JPAQueryFactory queryFactory;

    @BeforeEach
    public void before() {
        queryFactory = new JPAQueryFactory(em);
        Team teamA = new Team("teamA");
        Team teamB = new Team("teamB");
        em.persist(teamA);
        em.persist(teamB);

        Member member1 = new Member("member1", 10, teamA);
        Member member2 = new Member("member2", 20, teamA);
        Member member3 = new Member("member3", 30, teamB);
        Member member4 = new Member("member4", 40, teamB);
        em.persist(member1);
        em.persist(member2);
        em.persist(member3);
        em.persist(member4);
    }

    @Test
    public void startJPQL() {
        // member1
        Member findMember = em.createQuery("select m from Member m where m.username = :username", Member.class)
                .setParameter("username", "member1")
                .getSingleResult();

        assertThat(findMember.getUsername()).isEqualTo("member1");
    }

    @Test
    public void startQuerydsl() {
//        QMember m = new QMember("m");
//        QMember m = QMember.member;

        Member findMember = queryFactory
                .select(member)
                .from(member)
                .where(member.username.eq("member1"))
                .fetchOne();

        assertThat(findMember.getUsername()).isEqualTo("member1");
    }

    @Test
    @DisplayName("JPQL 이 제공하는 검색 조건")
    public void search() {
        Member findMember = queryFactory
                .selectFrom(member)
                .where(member.username.eq("member1")
                        .and(member.age.eq(10)))    // .and 를 , 쉼표로 바꿀 수 있다.(and() 메소드의 괄호를 없애기에 더 깔끔)
                .fetchOne();
//        where
//        m1_0.username=?
//        and m1_0.age=?            member.age.eq(10).not()   반대 개념
        assertThat(findMember.getUsername()).isEqualTo("member1");
    }

    @Test
    public void searchAndParam() {
        Member findMember = queryFactory
                .selectFrom(member)
                .where(
                        member.username.eq("member1")
                        , member.age.eq(10))
                .fetchOne();

        assertThat(findMember.getUsername()).isEqualTo("member1");
    }

    @Test
    public void resultFetch() {
//        List<Member> findMember = queryFactory
//                .selectFrom(member)
//                .fetch();
//        Member fetchOne = queryFactory
//                .selectFrom(member)
//                .fetchOne();
//        Member fetchFirst = queryFactory
//                .selectFrom(member)
//                .fetchFirst();
        QueryResults<Member> results = queryFactory
                .selectFrom(member)
                .fetchResults();
        long total = results.getTotal();
        List<Member> content = results.getResults();

        long count = queryFactory
                .selectFrom(member)
                .fetchCount();
    }

    /*
     * 회원 정렬 순서
     * 1. 회원 나이 내림차순 desc
     * 2. 회원 이름 올림차순 asc
     * 단, 2에서 회원 이름이 없으면 마지막에 출력(nulls last)
     */
    @Test
    public void sort() {
        em.persist(new Member(null, 100));
        em.persist(new Member("member5", 100));
        em.persist(new Member("member6", 100));

        List<Member> result = queryFactory
                .selectFrom(member)
                .where(member.age.eq(100))
                .orderBy(member.age.desc(), member.username.asc().nullsLast())
                .fetch();

        Member member5 = result.get(0);
        Member member6 = result.get(1);
        Member memberNull = result.get(2);
        assertThat(member5.getUsername()).isEqualTo("member5");
        assertThat(member6.getUsername()).isEqualTo("member6");
        assertThat(memberNull.getUsername()).isNull();
    }

    @Test
    public void paging1() throws Exception {
        // given
        // when
        List<Member> result = queryFactory
                .selectFrom(member)
                .orderBy(member.username.desc())
                .offset(1)
                .limit(2)
                .fetch();
        // then
        assertThat(result.size()).isEqualTo(2);
    }

    @Test
    public void paging2() throws Exception {
        // given
        // when
        QueryResults<Member> result = queryFactory
                .selectFrom(member)
                .orderBy(member.username.desc())
                .offset(1)
                .limit(2)
                .fetchResults();
        // then
        assertThat(result.getTotal()).isEqualTo(4);
        assertThat(result.getLimit()).isEqualTo(2);
        assertThat(result.getOffset()).isEqualTo(1);
        assertThat(result.getResults().size()).isEqualTo(2);
    }

    @Test
    public void aggregation() throws Exception {
        // given
        // QueryDSL 이 제공하는 Tuple, 여러 타입일 때 편히 가져오게 만드는 것.
        List<Tuple> result = queryFactory
                .select(
                        member.count(),
                        member.age.sum(),
                        member.age.avg(),
                        member.age.max(),
                        member.age.min()
                )
                .from(member)
                .fetch();
        // when
        Tuple tuple = result.get(0);
        // then
        assertThat(tuple.get(member.count())).isEqualTo(4);
        assertThat(tuple.get(member.age.sum())).isEqualTo(100);
        assertThat(tuple.get(member.age.avg())).isEqualTo(25);
        assertThat(tuple.get(member.age.max())).isEqualTo(40);
        assertThat(tuple.get(member.age.min())).isEqualTo(10);
    }

    /**
     * 팀의 이름과 각 팀의 평균 연령을 구하라.
     * @throws Exception
     */
    @Test
    public void group() throws Exception {
        // given
        List<Tuple> result = queryFactory
                .select(team.name, member.age.avg())
                .from(member)
                .join(member.team, team)
                .groupBy(team.name)
//                .having() 가능
                .fetch();
        // when
        Tuple teamA = result.get(0);
        Tuple teamB = result.get(1);
        // then
        assertThat(teamA.get(team.name)).isEqualTo("teamA");
        assertThat(teamA.get(member.age.avg())).isEqualTo(15);

        assertThat(teamB.get(team.name)).isEqualTo("teamB");
        assertThat(teamB.get(member.age.avg())).isEqualTo(35);
    }

    /**
     * 팀 A에 소속된 모든 회원
     * @throws Exception
     */
    @Test
    public void join() throws Exception {
        // given
        List<Member> result = queryFactory
                .selectFrom(member)
                .join(member.team, team)
//                 모두 가능
//                .innerJoin()
//                .rightJoin()
                .where(team.name.eq("teamA"))
                .fetch();
        // when

        // then
        assertThat(result)
                .extracting("username")
                .containsExactly("member1", "member2");
    }

    /**
     * 회원의 이름이 팀 이름과 같은 회원 조회
     * @throws Exception
     */
    @Test
    public void theta_join() throws Exception {
        // given
        em.persist(new Member("teamA"));
        em.persist(new Member("teamB"));
        em.persist(new Member("teamC"));
        // when
        List<Member> result = queryFactory
                .select(member)
                .from(member, team) // 기존 조인과는 다르게 두 엔티티를 나열한다.
                .where(member.username.eq(team.name))   // 관계 지정
                .fetch();
        // then
        assertThat(result)
                .extracting("username")
                .containsExactly("teamA", "teamB");
        // 외부 조인, left join right join 이 불가했는데, 하이버네이트에서 버전 업데이트 되면서 가능하게 할 수 있는 방법이 있다.
    }

    /**
     * 회원과 팀을 조인하면서, 팀 이름이 teamA인 팀만 조인하고 회원은 모두 조회
     * JPQL : select m, t from Member m left join m.team t on t.name = 'teamA'
     * @throws Exception
     */
    @Test
    public void join_on() throws Exception {
        // given
        List<Tuple> result = queryFactory
                .select(member, team)
                .from(member)
                .leftJoin(member.team, team).on(team.name.eq("teamA"))
                .fetch();
        // when
        for (Tuple tuple : result) {
            System.out.println("tuple = " + tuple);
        }
//        tuple = [Member(id=1, username=member1, age=10), Team(id=1, name=teamA)]
//        tuple = [Member(id=2, username=member2, age=20), Team(id=1, name=teamA)]
//        tuple = [Member(id=3, username=member3, age=30), null]
//        tuple = [Member(id=4, username=member4, age=40), null]
        // then

    }

    /**
     * 연관관계가 없는 엔티티의 외부 조인
     * 회원의 이름이 팀 이름과 같은 대상 외부 조인
     * @throws Exception
     */
    @Test
    public void join_on_no_relation() throws Exception {
        // given
        em.persist(new Member("teamA"));
        em.persist(new Member("teamB"));
        em.persist(new Member("teamC"));
        // when
        List<Tuple> result = queryFactory
                .select(member, team)
                .from(member) // 기존 조인과는 다르게 두 엔티티를 나열한다.
                .leftJoin(team).on(member.username.eq(team.name))
                .fetch();
        // then
        for (Tuple tuple : result) {
            System.out.println("tuple = " + tuple);
        }
    }

    // test 증명
    @PersistenceUnit
    EntityManagerFactory emf;

    /**
     * fetch 조인, 연관된 엔티티의 데이터를 한번에 가져옴
     *
     * @throws Exception
     */
    @Test
    public void fetchJoinNo() throws Exception {
        // given
        em.flush();
        em.clear();
        // when
        Member findMember = queryFactory
                .selectFrom(member)
                .where(member.username.eq("member1"))
                .fetchOne();
        // then
        boolean loaded = emf.getPersistenceUnitUtil().isLoaded(findMember.getTeam());
        assertThat(loaded).as("페치 조인 미적용").isFalse();

    }

    /**
     * fetch 조인, 연관된 엔티티의 데이터를 한번에 가져옴
     *
     * @throws Exception
     */
    @Test
    public void fetchJoinUse() throws Exception {
        // given
        em.flush();
        em.clear();
        // when
        Member findMember = queryFactory
                .selectFrom(member)
                .join(member.team, team).fetchJoin()
                .where(member.username.eq("member1"))
                .fetchOne();
        // then
        boolean loaded = emf.getPersistenceUnitUtil().isLoaded(findMember.getTeam());
        assertThat(loaded).as("페치 조인 미적용").isTrue();
    }

    /**
     * subQuery 서브쿼리
     * 나이가 가장 많은 회원 조회
     * @throws Exception
     */
    @Test
    public void subQuery() throws Exception {
        // 별칭이 중복되면 안되면 새로 Q를 만들어줘야한다.
        QMember memberSub = new QMember("memberSub");
        // given
        List<Member> result = queryFactory
                .selectFrom(member)
                .where(member.age.eq(
                        JPAExpressions
                                .select(memberSub.age.max())
                                .from(memberSub)
                ))
                .fetch();
        // when
            /* select member1
            from Member member1
            where member1.age = (select max(memberSub.age)
            from Member memberSub) */
        // then
        assertThat(result).extracting("age").containsExactly(40);
    }

    /**
     * subQuery 서브쿼리
     * 나이가 평균 이상 회원 조회
     * @throws Exception
     */
    @Test
    public void subQueryGoe() throws Exception {
        // 별칭이 중복되면 안되면 새로 Q를 만들어줘야한다.
        QMember memberSub = new QMember("memberSub");
        // given
        List<Member> result = queryFactory
                .selectFrom(member)
                .where(member.age.goe(
                        JPAExpressions
                                .select(memberSub.age.avg())
                                .from(memberSub)
                ))
                .fetch();
            /* select
                member1
            from
                Member member1
            where
                member1.age >= (
                    select
                        avg(memberSub.age)
                    from
                        Member memberSub
            ) */
        assertThat(result).extracting("age").containsExactly(30, 40);
    }

    /**
     * subQuery 서브쿼리
     * @throws Exception
     */
    @Test
    public void subQueryIn() throws Exception {
        // 별칭이 중복되면 안되면 새로 Q를 만들어줘야한다.
        QMember memberSub = new QMember("memberSub");
        // given
        List<Member> result = queryFactory
                .selectFrom(member)
                .where(member.age.in(
                        JPAExpressions
                                .select(memberSub.age)
                                .from(memberSub)
                                .where(memberSub.age.gt(10))
                ))
                .fetch();
            /* select
                member1
            from
                Member member1
            where
                member1.age in (select
                    memberSub.age
                from
                    Member memberSub
                where
                    memberSub.age > ?1) */
        assertThat(result).extracting("age").containsExactly(20, 30, 40);
    }

    /**
     * subQuery 서브쿼리
     * @throws Exception
     */
    @Test
    public void selectSubQuery() throws Exception {
        QMember memberSub = new QMember("memberSub");
        List<Tuple> result = queryFactory
                .select(member.username, //JPAExpressions static import 가능
                        JPAExpressions
                                .select(memberSub.age.avg())
                                .from(memberSub))
                .from(member)
                .fetch();

        for (Tuple tuple : result) {
            System.out.println("tuple = " + tuple);
        }
        /* select member1.username, (select avg(memberSub.age)
            from Member memberSub)
            from Member member1 */
    }

    @Test
    public void basicCase() throws Exception {
        List<String> fetch = queryFactory
                .select(member.age
                        .when(10).then("열살")
                        .when(20).then("스무살")
                        .otherwise("기타")
                )
                .from(member)
                .fetch();
        for (String s : fetch) {
            System.out.println("s = " + s);
        }
//        s = 열살
//        s = 스무살
//        s = 기타
//        s = 기타
    }

    @Test
    public void complexCase() throws Exception {
        // given
        List<String> fetch = queryFactory
                .select(new CaseBuilder()
                        .when(member.age.between(0, 20)).then("0~20")
                        .when(member.age.between(21, 30)).then("21~30")
                        .otherwise("other..")
                )
                .from(member)
                .fetch();
        // when
        for (String s : fetch) {
            System.out.println("s = " + s);
        }
        // then
//        s = 0~20
//        s = 0~20
//        s = 21~30
//        s = other..
    }

    @Test
    public void constant() throws Exception {
        List<Tuple> fetch = queryFactory
                .select(member.username, Expressions.constant("A"))
                .from(member)
                .fetch();
        for (Tuple tuple : fetch) {
            System.out.println("tuple = " + tuple);
        }
//        tuple = [member1, A]
//        tuple = [member2, A]
//        tuple = [member3, A]
//        tuple = [member4, A]
    }

    @Test
    public void concat() throws Exception {
        // {username}_{age}
        List<String> fetch = queryFactory
                .select(member.username.concat("_").concat(member.age.stringValue()))
                .from(member)
                .where(member.username.eq("member1"))
                .fetch();
        for (Object o :fetch) {
            System.out.println("o = " + o);
        }
//        o = member1_10
    }
}
