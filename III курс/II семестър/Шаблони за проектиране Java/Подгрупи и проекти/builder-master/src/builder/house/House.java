package builder.house;

public class House {
    private String walls;
    private String roof;
    private String windows;
    private String door;
    private String chimney;

    public String getWalls() {
        return walls;
    }

    public void setWalls(String walls) {
        this.walls = walls;
    }

    public String getRoof() {
        return roof;
    }

    public void setRoof(String roof) {
        this.roof = roof;
    }

    public String getWindows() {
        return windows;
    }

    public void setWindows(String windows) {
        this.windows = windows;
    }

    public String getDoor() {
        return door;
    }

    public void setDoor(String door) {
        this.door = door;
    }

    public String getChimney() {
        return chimney;
    }

    public void setChimney(String chimney) {
        this.chimney = chimney;
    }

    public void printHouse() {
        System.out.print("\tWalls: " + this.getWalls() + "\n" +
                "\tWindows: " + this.getWindows() + "\n" +
                "\tDoor: " + this.getDoor() + "\n" +
                "\tRoof: " + this.getRoof() + "\n" +
                "\tChimney: " + this.getChimney());
    }
}
