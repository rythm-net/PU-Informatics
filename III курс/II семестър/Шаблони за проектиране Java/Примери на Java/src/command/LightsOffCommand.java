package command;

public class LightsOffCommand implements Command {

    private Lights lights;

    public LightsOffCommand(Lights lights) {
        this.lights = lights;
    }

    @Override
    public void execute() {
        this.lights.switchOff();
    }

    @Override
    public void undo() {
        this.lights.switchOn();
    }
}
