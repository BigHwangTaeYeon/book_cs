package practice;

import practice.factory.Factory;
import practice.factory.MachineFactory;
import practice.machine.Machine;

public class PracApp {
    public static void main(String[] args) throws Exception {

        Factory carFactory = new MachineFactory();
        Machine car = carFactory.createMachine("car", 2000, 10);
        System.out.println(car.getMoney());
        System.out.println(car.getQuantity());

        car.make(1);

        System.out.println(car.getMoney());
        System.out.println(car.getQuantity());
        
        car.sell(1);

        Machine train = carFactory.createMachine("train", 50000, 5);

    }
}
