package builder.house;

public class VillaHouseBuilder implements HouseBuilder {
    private House house;

    public VillaHouseBuilder() {
        this.house = new House();
    }

    @Override
    public void buildWalls() {
        this.house.setWalls("Bricks");
    }

    @Override
    public void buildRoof() {
        this.house.setRoof("Tiles");
    }

    @Override
    public void buildWindows() {
        this.house.setWindows("Glass");
    }

    @Override
    public void buildDoor() {
        this.house.setDoor("Wooden");
    }

    @Override
    public void buildChimney() {
        this.house.setChimney("Bricks");
    }

    @Override
    public House getHouse() {
        return this.house;
    }
}
