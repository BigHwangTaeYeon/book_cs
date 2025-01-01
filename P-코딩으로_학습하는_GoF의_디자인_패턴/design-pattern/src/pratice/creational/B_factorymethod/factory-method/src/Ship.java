public class Ship {
    private String name;
    private String logo;
    private String color;

    @Override
    public String toString() {
        return "{name = " + name + ", logo = " + logo + ", color = " + color + "}";
    }

    public String getName() {
        return this.name;
    }
    public String getLogo() {
        return this.logo;
    }
    public String getColor() {
        return this.color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public void setName(String name) {
        this.name = name;
    }
}
