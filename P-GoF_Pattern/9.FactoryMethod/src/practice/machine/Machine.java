package practice.machine;

public interface Machine {
    int getMoney();

    int getQuantity();

    void sell(int quantity);

    void make(int quantity);
}
