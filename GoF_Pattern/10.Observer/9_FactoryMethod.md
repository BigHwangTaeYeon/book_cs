# Observer

관찰자
어떤 상태가 변경되었을 때, 이 상태 변경에 관심이 있는 관찰자들에게 알려주는 패턴

            ->      관찰자
  대상      ->      관찰자
(Subject)   ->      관찰자
            ->      관찰자


<<abstract>>      <<abstract>>
  DiceGame           Player
    대상             관찰자

이를 통해 확장을 원한다면 대상을 상속받고, Player를 늘린다면 관찰자를 상속받아 사용하면 된다.
