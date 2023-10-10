import util.Collection;
import util.Console;

import java.util.Scanner;
import java.util.SplittableRandom;

public class Application {

    public static final int FIELD_ROW_COUNT = 15;
    public static final int FIELD_COL_COUNT = 15;

    public static final int PASSABLE_TERRAIN = 0;
    public static final int BUILDING_S_BRICK = 1;
    public static final int BUILDING_M_BRICK = 2;
    public static final int BUILDING_L_BRICK = 3;

    public static final int UNIT_TANK       = 11; // 10
    public static final int UNIT_SNAIPER    = 12; // 20
    public static final int UNIT_SPY        = 13; // 30
    public static final int UNIT_DEMO       = 14; // 40

    static int[][] unitCollection = {
            {14,11, UNIT_TANK       }, // единица 1 - роля
            {14,12, UNIT_SNAIPER    }, // единица 2 - роля
//            {14,13, UNIT_SPY        }, // единица 3 - роля
            {14,14, UNIT_DEMO       }  // единица 4 - роля
    };

    static int[][] buildingS = {
            {2, 2, BUILDING_S_BRICK},  {2, 3, BUILDING_S_BRICK},
            {3, 2, BUILDING_S_BRICK},  {3, 3, BUILDING_S_BRICK}
    };

    static int[][] buildingM = {
            {4, 7, BUILDING_M_BRICK},  {4, 8, BUILDING_M_BRICK}, {4, 9, BUILDING_M_BRICK},
            {5, 7, BUILDING_M_BRICK},  {5, 8, BUILDING_M_BRICK}, {5, 9, BUILDING_M_BRICK},
    };

    static int[][] buildingL = {
            {8, 1, BUILDING_L_BRICK},  {8 , 2, BUILDING_L_BRICK}, {8, 3, BUILDING_L_BRICK},
            {9, 1, BUILDING_L_BRICK},  {9 , 2, BUILDING_L_BRICK}, {9, 3, BUILDING_L_BRICK},
            {10, 1, BUILDING_L_BRICK}, {10, 2, BUILDING_L_BRICK}, {10, 3, BUILDING_L_BRICK}
    };

    static int[][][] buildingCollection = {
            buildingS, buildingM, buildingL
    };

    public static boolean isUnitAvailable(int unit) {

        for(int i = 0; i < unitCollection.length; i++) {
            if(unitCollection[i][2] == unit) return true;
        }

        return false;
    }

    public static boolean isTankAvailable() {
        return isUnitAvailable(UNIT_TANK);
    }

    public static boolean isSpyAvailable() {
        return isUnitAvailable(UNIT_SPY);
    }

    public static boolean isSnaiperAvailable() {
        return isUnitAvailable(UNIT_SNAIPER);
    }

    public static boolean isDemoAvailable() {
        return isUnitAvailable(UNIT_DEMO);
    }


    public static void main(String[] args) {

        int[][] collection;

        while(true) {

            collection = bootstrap();
            render(collection);

            Scanner scanner     = new Scanner(System.in);
            String direction    = scanner.nextLine();

            move(direction);
        }
    }

    public static boolean isMovePossible(int row, int col) {

        if(isSpyAvailable()) return true;

        if(row >= FIELD_ROW_COUNT) return false;
        if(col >= FIELD_COL_COUNT) return false;

        return true;
    }

    public static void move(String direction) {

        int[][] originalUnitCollection = Collection.copy(unitCollection);

        int destinationRow = unitCollection[0][0] + getRowCoefficient(direction);
        int destinationCol = unitCollection[0][1] + getColCoefficient(direction);

        if(isMovePossible(destinationRow, destinationCol)) {

            destinationRow = transformRow(destinationRow);
            destinationCol = transformCol(destinationCol);

            unitCollection[0][0] = destinationRow;
            unitCollection[0][1] = destinationCol;

            for(int i = 1; i < unitCollection.length; i++) {
                unitCollection[i][0] = originalUnitCollection[i - 1][0];
                unitCollection[i][1] = originalUnitCollection[i - 1][1];
            }
        }
    }

    public static int transformRow(int row) {
        if(row >= FIELD_ROW_COUNT   ) return 0;
        if(row < 0                  ) return FIELD_ROW_COUNT - 1;
        return row;
    }

    public static int transformCol(int col) {
        if(col >= FIELD_COL_COUNT   ) return 0;
        if(col < 0                  ) return FIELD_COL_COUNT - 1;
        return col;
    }

    public static int getRowCoefficient(String direction) {
        if(direction.equals("w")) return -1;
        if(direction.equals("s")) return +1;
        return 0;
    }

    public static int getColCoefficient(String direction) {
        if(direction.equals("a")) return -1;
        if(direction.equals("d")) return +1;
        return 0;
    }


    public static int[][] bootstrap() {
        int[][] collection = new int[15][15];

        for(int buildingCountIndex = 0; buildingCountIndex < buildingCollection.length; buildingCountIndex++) {

            int[][] buildingElement = buildingCollection[buildingCountIndex];
            for(int i = 0; i < buildingElement.length; i++) {

                int row     = buildingElement[i][0];
                int col     = buildingElement[i][1];
                int sign    = buildingElement[i][2];
                collection[row][col] = sign;
            }
        }

        for(int i = 0; i < unitCollection.length; i++) {
            int row         = unitCollection[i][0];
            int col         = unitCollection[i][1];
            int battleOrder = (i + 1) * 10;
            int unitSign    = (unitCollection[i][2] - 10);
            int sign        = battleOrder + unitSign;

            collection[row][col] = sign;
        }
        return collection;
    }

    public static void render(int[][] collection) {

        for(int row = 0; row < FIELD_ROW_COUNT; row++) {
            for(int col = 0; col < FIELD_COL_COUNT; col++) {

                int element = collection[row][col];

                if(element == PASSABLE_TERRAIN) {
                    System.out.print("X  "); continue;
                }

                if(element == BUILDING_S_BRICK) {
                    Console.red("*  "); continue;
                }

                if(element == BUILDING_M_BRICK) {
                    Console.green("%  "); continue;
                }

                if(element == BUILDING_L_BRICK) {
                    Console.blue("&  "); continue;
                }

                Console.yellow(element + " ");
            }
            Console.println("");
        }
    }
}