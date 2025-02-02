package B_after;

public class Client {
    public static void main(String[] args) {
        BlueLightRedLight blueLightRedLight = new BlueLightRedLight(new Faster());
        blueLightRedLight.blueLight();
        blueLightRedLight.redLight();
    }
}
