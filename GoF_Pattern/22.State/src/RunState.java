public class RunState extends State {

    public RunState(Player player) {
        super(player);
    }

    @Override
    public void standUp() {
        player.talk("뛰다가 갑자기 서면 무릎 연골 나갑니다..!");
        player.setSpeed(0);
        player.setState(new StandUpState(player));
    }

    @Override
    public void sitDown() {
        player.talk("뛰다가 앉으라고..?! 미쳤어..");
        player.setSpeed(0);
        player.setState(new StandUpState(player));
    }

    @Override
    public void walk() {
        player.talk("속도를 줄일게요 !");
        player.setSpeed(8);
        player.setState(new WalkState(player));
    }

    @Override
    public void run() {
        player.talk("더 빨리 뛰라는 얘기지 ?");
        player.setSpeed(player.getSpeed() + 2);
    }

    @Override
    public String getDescription() {
        return "뛰는 중..";
    }
    
}
