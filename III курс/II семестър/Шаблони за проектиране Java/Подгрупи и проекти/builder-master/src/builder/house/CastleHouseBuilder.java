package builder.house;

public class CastleHouseBuilder implements HouseBuilder {
    private House house;

    public CastleHouseBuilder() {
        this.house = new House();
    }

    @Override
    public void buildWalls() {
        this.house.setWalls("Stone");
    }

    @Override
    public void buildRoof() {
        this.house.setRoof("Stone");
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
        this.house.setChimney("Stone");
    }

    @Override
    public House getHouse() {
        return this.house;
    }
}
