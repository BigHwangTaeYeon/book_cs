public interface Expression {
    // 구체적인 구문 클레스 생성
    boolean parse(Context context);
    // 구문에 대한 어떤 기능
    boolean run();
}
