package test;

public class AppTest {
    public static void main(String[] args) throws Exception {
        DiceUser dice1 = new DiceUser("A TEAM");
        dice1.add(new Dice("Player1", dice1.getNumber()));
        dice1.add(new Dice("Player2", dice1.getNumber()));
        dice1.add(new Dice("Player3", dice1.getNumber()));
        
        DiceUser dice2 = new DiceUser("B TEAM");
        dice1.add(dice2);
        dice2.add(new Dice("Player1", dice1.getNumber()));

        dice1.list();
    }
}
