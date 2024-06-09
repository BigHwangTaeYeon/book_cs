public interface Shape {
    // 도형을 표현하는 문자열
    String draw();
    // 도형을 일정한 값으로 이동시키는 method
    void moveOffset(int dx, int dy);
}
