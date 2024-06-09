public abstract class State {
    protected Player player;

    public State(Player player) {
        this.player = player;
    }
    // 상태 메서드
    public abstract void standUp();
    public abstract void sitDown();
    public abstract void walk();
    public abstract void run();
    // 현재 상태를 console로 띄움
    public abstract String getDescription();
}
