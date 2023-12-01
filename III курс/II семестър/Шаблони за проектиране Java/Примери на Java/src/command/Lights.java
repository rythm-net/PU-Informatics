package command;

public class Lights {

    private Boolean lightsOn;

    public void switchOn() {
        System.out.println("Lights are on");
        this.lightsOn = true;
    }

    public void switchOff() {
        System.out.println("Lights are off");
        this.lightsOn = false;
    }

}
