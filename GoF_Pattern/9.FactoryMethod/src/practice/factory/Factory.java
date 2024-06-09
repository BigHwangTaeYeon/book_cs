package practice.factory;

import practice.machine.Machine;

public abstract class Factory {
    public abstract Machine createMachine(String instance, int money, int quantity);
}
