public class TigerAdapter extends Animal {
    
    private Tiger tiger;

    public TigerAdapter(String name) {
        super(name);
        tiger = new Tiger();
        tiger.setName(name);
    }

    @Override
    public void sound() {
        System.out.println(tiger.getName() + " 우우우아아아아아");
        tiger.roar();
    }


}
