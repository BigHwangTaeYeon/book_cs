package test;

import java.util.Random;

public class getItemToDice implements getItemArticle {
    private int count;
    private int[] diceNum;

    public getItemToDice(int count) {
        this.count = count;
    }

    public Object getItem(){
        return (Object) diceNum;
    }

    @Override
    public void setItem() {
        Random rd = new Random();
        diceNum = new int[count];
        for (int i = 0; i < count; i++) {
            int num = rd.nextInt(6);
            while (true) {
                if (Integer.compare(0, num) != 0)
                    break;
            }
            System.out.println("get Number[" + i + "] : " + num);
            this.diceNum[i] = num;
        }
        
    }
    
}
