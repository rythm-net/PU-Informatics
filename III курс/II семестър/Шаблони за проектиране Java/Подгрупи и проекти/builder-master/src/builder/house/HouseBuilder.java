package builder.house;

public interface HouseBuilder {
    void buildWalls();
    void buildRoof();
    void buildWindows();
    void buildDoor();
    void buildChimney();
    House getHouse();
}
