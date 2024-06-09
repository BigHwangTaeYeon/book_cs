package prac;

import java.util.Random;

public class DiceGetNumber implements NumberStrategy {

    @Override
    public int getNumb() {
        Random ran = new Random();
        int num = 0;
        while (true) {
            num = ran.nextInt(6);
            if (Integer.compare(0, num) != 0)
                break;
        }
        System.out.println("DiceGetNumber : " + num);
        return num;
    }

}
