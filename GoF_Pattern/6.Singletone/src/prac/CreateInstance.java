package prac;

public class CreateInstance {
    private static CreateInstance createInstance1 = new CreateInstance();
    public static CreateInstance getInstance1(){
        return createInstance1;
    }

    private CreateInstance createInstance2;
    public CreateInstance getInstance2(){
        if(this.createInstance2 == null) {
            this.createInstance2 = new CreateInstance();
        }
        return createInstance2;
    }

    private CreateInstance(){};
    private static class getInstance3{
        private static final CreateInstance createInstance3 = new CreateInstance();
    }
    public static CreateInstance getInstance() {
        return getInstance3.createInstance3;
    }

}
