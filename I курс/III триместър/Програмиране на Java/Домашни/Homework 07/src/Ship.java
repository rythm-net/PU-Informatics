import java.util.ArrayList;
import java.util.List;

public class Ship {

    public static final String SHIP_ICON = " # ";

    public List<int[]> shipTravelingCoordinates=new ArrayList<>();

    public int numberOfShipMovements = 0;
    public int currentShipMovement   = 0;

    public  String[][] shipMovement(String[][] gameBoard,int row ,int col,Ship  ship){
        gameBoard[row][col]=SHIP_ICON;

        if(!Turns.hasShipArrived){
            if(currentShipMovement!=0) {
                int[] lastPosArray = ship.shipTravelingCoordinates.get(ship.currentShipMovement - 1);
                gameBoard[lastPosArray[0]][lastPosArray[1]] = "   ";
            }
        }

        if(Turns.hasShipArrived){
            int temp=ship.numberOfShipMovements-1;
            if(currentShipMovement!=7){
                if(temp>0) {
                    int[] lastPosArray = ship.shipTravelingCoordinates.get(temp);
                    gameBoard[lastPosArray[0]][lastPosArray[1]] = "   ";
                    temp--;
                }
            }

            if(temp==0){
                temp=ship.numberOfShipMovements-1;
            }
        }
        return gameBoard;
    }
}