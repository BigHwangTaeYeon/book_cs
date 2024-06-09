package test;

import java.util.ArrayList;

public class IteratorDeposit implements Iterator{
    private ArrayList<Deposit> data;

    private int index;

    public IteratorDeposit(ArrayList<Deposit> data) {
        this.data = data;
        this.index = -1;
    }

    @Override
    public boolean next() {
        this.index++;
        return data.size() > index;
    }

    @Override
    public Object current() {
        return data.get(this.index);
    }
    
}
