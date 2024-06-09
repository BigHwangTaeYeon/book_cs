import java.util.ArrayList;

import prac.AudioAdapter;
import prac.ComputerMachine;
import prac.Machine;
import prac.TvMachine;

public class App {
    public static void main(String[] args) throws Exception {

        // ArrayList<Animal> animals = new ArrayList<Animal>();
        // animals.add(new Dog("댕댕"));
        // animals.add(new Cat("송털"));
        // animals.add(new Cat("츄츄츄츄츄"));
        // // adopter가 없을 때, 에러
        // // animals.add(new Tiger("타이온"));
        // animals.add(new TigerAdapter("쿠르르"));

        // animals.forEach(animal -> {
        //     animal.sound();
        // });

        ArrayList<Machine> mc = new ArrayList<Machine>();
        mc.add(new ComputerMachine("A part"));
        mc.add(new TvMachine("B part"));
        mc.add(new AudioAdapter("B part"));
        mc.add(new AudioAdapter("D part"));
        
        mc.forEach(mcOper -> {
            mcOper.operate();
        });
        // mc.get(0).operate();
        // mc.get(1).operate();
    }
}
