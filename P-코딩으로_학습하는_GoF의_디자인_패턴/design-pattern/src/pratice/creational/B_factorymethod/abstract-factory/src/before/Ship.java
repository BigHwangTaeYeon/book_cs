package before;

import ship.Anchor;
import ship.Wheel;
import ship.WhiteAnchor;
import ship.WhiteWheel;

public class Ship {
    private String name;
    private String logo;
    private String color;

    private Anchor anchor;
    private Wheel wheel;

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
    public Anchor getAnchor() {return this.anchor;}
    public Wheel getWheel() {return this.wheel;}
    public void setColor(String color) {
        this.color = color;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAnchor(Anchor anchor) {
        this.anchor = anchor;
    }

    public void setWheel(Wheel wheel) {
        this.wheel = wheel;
    }
}
