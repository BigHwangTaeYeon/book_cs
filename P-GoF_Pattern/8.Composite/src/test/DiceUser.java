package test;

import java.util.Iterator;
import java.util.LinkedList;

public class DiceUser extends DiceUnit {
    private LinkedList<DiceUnit> diceList = new LinkedList<DiceUnit>();

    public DiceUser(String name) {
        super(name);
    }

    public void add(DiceUnit unit) {
        diceList.add(unit);
    }

    public void list() {
        list(this);
    }

    private void list(DiceUnit unit) {
        if (unit instanceof Dice) {
            System.out.println("  " + unit.toString());
        } else {
            DiceUser dice = (DiceUser) unit;
            Iterator<DiceUnit> iterator = dice.diceList.iterator();
            System.out.println("GROUP : " + unit.getName());
            while (iterator.hasNext()) {
                this.list(iterator.next());
            }
        }
    }

    @Override
    public int getNumber() {
        int random = 1;
        while (random > 0 && random <= 6) {
            random = (int) (Math.random() * 10 + 1);
        }
        return random;
    }
    
}
