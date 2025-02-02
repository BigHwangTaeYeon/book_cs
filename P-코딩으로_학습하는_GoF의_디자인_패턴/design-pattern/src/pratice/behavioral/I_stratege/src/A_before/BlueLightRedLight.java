package A_before;

public class BlueLightRedLight {
    private int speed;

    public BlueLightRedLight(int speed) {
        this.speed = speed;
    }

    public void blueLight() {
        if(speed == 1) {
            System.out.println("무궁화 꽃이 ");
        } else if (speed == 2) {
            System.out.println("무궁화");
        } else if (speed == 3) {
            System.out.println("무궁");
        }
    }
    public void redLight() {
        if(speed == 1) {
            System.out.println("피었습니다.");
        } else if(speed==2) {
            System.out.println("피었습ㄴ");
        } else if (speed==3) {
            System.out.println("폈어");
        }
    }
}
