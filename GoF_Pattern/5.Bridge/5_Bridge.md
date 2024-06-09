# Bridge

기능 계층과 구현 계층의 분리로 시스템의 확장성과 유지보수성을 높이는 패턴

기존 시스템에 새로운 기능을 추가해도 기능 계층을 통해 기존의 작성된 코드의 변경을 최소화 할 수 있으며,
기존의 기능에 대해 구현 계층을 통해 확장을 용이하게 해준다.

    기능 계층               구현 계층
(매서드의 추가 계층)    (인터페이스의 구현 계층)

  Draft                   Display
(기능계층)               (구현계층)

Publication       SimpleDisplay   CaptionDisplay

SimpleDisplay   CaptionDisplay 구현 계층을 통해 하나의 데이터를 다향한 데이터로 표현했고,
Publication 기능 계층을 통해 새로운 요구사항이 생겼을 때, 기존의 코드를 변경하지 않고 새로운 기능을 확장하였다.