package builder.house;

public class HouseMain {
    public static void main(String[] args) {
        HouseBuilder villaHouseBuilder = new VillaHouseBuilder();
        HouseBuilder castleHouseBuilder = new CastleHouseBuilder();

        /* Villa */
        CivilEngineer civilEngineer = new CivilEngineer(villaHouseBuilder);
        civilEngineer.constructHouse();
        House villa = villaHouseBuilder.getHouse();
        System.out.println("\nVilla built result:");
        villa.printHouse();

        System.out.println();

        /* Castle */
        civilEngineer.setHouseBuilder(castleHouseBuilder);
        civilEngineer.constructHouse();
        House castle = castleHouseBuilder.getHouse();
        System.out.println("\nCastle built result:");
        castle.printHouse();
    }
}
