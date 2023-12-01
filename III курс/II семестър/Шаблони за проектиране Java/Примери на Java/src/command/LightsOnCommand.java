package command;

public class LightsOnCommand implements Command {

    private Lights lights;

    public LightsOnCommand(Lights lights) {
        this.lights = lights;
    }

    @Override
    public void execute() {
        this.lights.switchOn();
    }

    @Override
    public void undo() {
        this.lights.switchOff();
    }
}
