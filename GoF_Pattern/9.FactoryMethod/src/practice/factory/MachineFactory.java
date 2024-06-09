package practice.factory;

import practice.machine.Airplane;
import practice.machine.CarMachine;
import practice.machine.Machine;
import practice.machine.TrainMachine;

public class MachineFactory extends Factory {

    @Override
    public Machine createMachine(String instance, int money, int quantity) {
        switch (instance) {
            case "car":
                return CarMachine.getInstance(money, quantity);
            case "train":
                return TrainMachine.getInstance(money, quantity);
            case "airplane":
                return Airplane.getInstance(money, quantity);
        }
        return null;
    }
    
}
