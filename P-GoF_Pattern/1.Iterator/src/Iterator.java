public interface Iterator {
    // 다음 데이터를 얻을 수 있으면 true, 없으면 false
    boolean next();
    // 구성 데이터에 대한 타입은 정해질 수 없으므로 Object
    Object current();
}
