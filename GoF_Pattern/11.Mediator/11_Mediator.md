# Mediator

CollAircon    HeatBoiler    Door    Window

문이 열려있으면, 에어컨을 꺼야한다고 요청하고
기온이 내려가면 보일러를 켜야하고 에어컨을 중지시키고 창과 문을 닫는다.

복잡한 객체간의 관계가 있을 경우,
Mediator(중재자)를 두어 복잡한 객체간의 관계를 단순화 시킨다.
        <<abstract>>                        <<interface>>
         Paricipant                         Mediator

Door  Window  HeatBoiler  CollAircon        SmartHome












