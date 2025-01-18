package B_after;

public class Item implements Component {
    private String name;
    private int price;

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override // compile 당시 어노테이션을 인식하고 해당 interface 의 형식이 맞는지 확인을 해준다. 아니면 컴파일 에러를 뱉는다.
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
