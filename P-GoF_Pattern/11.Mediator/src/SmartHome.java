public class SmartHome implements Mediator {

    public Door door = new Door(this);
    public Window window = new Window(this);
    public CoolAircon aircon = new CoolAircon(this);
    public HeatBoiler boiler = new HeatBoiler(this);

    @Override
    public void participantChanged(Participant Participant) {
        if (Participant == door && !door.isClosed()) {
            aircon.off();
            boiler.off();
        }

        if (Participant == window && !window.isClosed()) {
            aircon.off();
            boiler.off();
        }

        if (Participant == aircon && aircon.isRunning()) {
            boiler.off();
            window.close();
            door.close();
        }

        if (Participant == boiler && boiler.isRunning()) {
            aircon.off();
            window.close();
            door.close();
        }
    }
    
    public void report() {
        System.out.println("\033[H\033[2J[집안 상태]");
        System.out.println(door);
        System.out.println(window);
        System.out.println(aircon);
        System.out.println(boiler);
        System.out.println();
    }
}
