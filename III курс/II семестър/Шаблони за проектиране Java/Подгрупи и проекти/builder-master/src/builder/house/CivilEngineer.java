package builder.house;

public class CivilEngineer {
    private HouseBuilder houseBuilder;

    public CivilEngineer(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    public void constructHouse(){
        this.houseBuilder.buildWalls();
        this.houseBuilder.buildWindows();
        this.houseBuilder.buildDoor();
        this.houseBuilder.buildRoof();
        this.houseBuilder.buildChimney();
    }

    public void setHouseBuilder(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }
}
