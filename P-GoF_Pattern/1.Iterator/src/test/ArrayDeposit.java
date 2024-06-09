package test;

import java.util.ArrayList;


public class ArrayDeposit implements Aggregator{
    private ArrayList<Deposit> list = new ArrayList<Deposit>();

    public ArrayDeposit(Deposit[] list) {
        for (int i = 0; i < list.length; i++) {
            this.list.add(list[i]);
        }
    }

    @Override
    public Iterator iterator() {
        return new IteratorDeposit(list);
    }
}
