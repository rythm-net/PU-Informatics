import java.util.Scanner;

public class Powers {

    public static void VGOPower(String[][] gameBoard, int numberOfSquaresToSum) {

        System.out.println("Кой числа искате да съберете:");
        Scanner scanner=new Scanner(System.in);

        if(numberOfSquaresToSum==2) {

            String elementOne=scanner.nextLine();
            String elementTwo=scanner.nextLine();
            scanner.next();

            int[] elementOnePosition=Logic.linearSearch(gameBoard,elementOne);
            int[] elementTwoPosition=Logic.linearSearch(gameBoard,elementTwo);

            int numberOne=Integer.parseInt(gameBoard[elementOnePosition[0]][elementOnePosition[1]]);
            int numberTwo=Integer.parseInt(gameBoard[elementTwoPosition[0]][elementTwoPosition[1]]);

            numberTwo+=numberOne;
            String newElement=String.valueOf(numberTwo);
            gameBoard[elementTwoPosition[0]][elementTwoPosition[1]]=newElement;
        }

        if(numberOfSquaresToSum==3) {

            String elementOne=scanner.nextLine();
            scanner.next();
            String elementTwo=scanner.nextLine();
            scanner.next();
            String elementThree= scanner.nextLine();

            int[] elementOnePosition=Logic.linearSearch(gameBoard,elementOne);
            int[] elementTwoPosition=Logic.linearSearch(gameBoard,elementTwo);

            int[] elementThreePosition=Logic.linearSearch(gameBoard,elementThree);

            int numberOne=Integer.parseInt(gameBoard[elementOnePosition[0]][elementOnePosition[1]]);
            int numberTwo=Integer.parseInt(gameBoard[elementTwoPosition[0]][elementTwoPosition[1]]);
            int numberThree=Integer.parseInt(gameBoard[elementThreePosition[0]][elementThreePosition[1]]);
            numberTwo+=numberOne;
            numberThree+=numberTwo;

            String newElement=String.valueOf(numberTwo);
            gameBoard[elementTwoPosition[0]][elementTwoPosition[1]]=newElement;
            String secondNewElement=String.valueOf(numberThree);
            gameBoard[elementThreePosition[0]][elementThreePosition[1]]=secondNewElement;
        }
    }

    public static void SBDPowers(String[][] gameBoard) {

        System.out.println("Въведете двете числа, чиито позиции искате да размените: ");
        Scanner scanner=new Scanner(System.in);

        String elementOne=scanner.nextLine();
        String elementTwo=scanner.nextLine();
        scanner.next();

        int[] elementOnePos=Logic.linearSearch(gameBoard,elementOne);
        int[] elementTwoPos=Logic.linearSearch(gameBoard,elementTwo);

        gameBoard[elementOnePos[0]][elementOnePos[1]]=elementTwo;
        gameBoard[elementTwoPos[0]][elementTwoPos[1]]=elementOne;
    }

    public static void LFZPOWER(String[][] gameBoard) {

        System.out.println("Изберете началния и крайния елемент на елементите ,който искате да сортирате");
        Scanner scanner =new Scanner(System.in);

        String elementOne=scanner.nextLine();
        scanner.next();
        String elementTwo=scanner.nextLine();

        int[] elementOnePos=Logic.linearSearch(gameBoard,elementOne);
        int[] elementTwoPos=Logic.linearSearch(gameBoard,elementTwo);

        int arraySize=(elementTwoPos[1]-elementOnePos[1])+1;

        int[] tempArray=new int[arraySize];
        int i=0;

        if((elementOnePos[0]==elementTwoPos[0])&&(elementOnePos[1]!=elementTwoPos[1])) {
            for (int row=elementOnePos[0];row<elementOnePos[0]+1;row++) {
                for (int col = elementOnePos[1]; col < elementTwoPos[1]; col++) {
                    tempArray[i] = Integer.parseInt(gameBoard[row][col]);
                    i++;
                }
            }

            tempArray=Logic.sortDesc(tempArray);
            i=0;

            for (int row=elementOnePos[0];row<elementOnePos[0]+1;row++) {
                for (int col = elementOnePos[1]; col < elementTwoPos[1]; col++) {
                    gameBoard[row][col]=String.valueOf(tempArray[i]);
                    i++;
                }
            }
        }

        if((elementOnePos[1]==elementTwoPos[1])&&(elementOnePos[0]!=elementTwoPos[0])) {
            for (int row=elementOnePos[0];row<elementTwoPos[0]+1;row++) {
                for(int col=elementOnePos[1];col<elementOnePos[1]+1;col++) {
                    tempArray[i]=Integer.parseInt(gameBoard[row][col]);
                    i++;
                }
            }

            tempArray=Logic.sortDesc(tempArray);
            for (int row=elementOnePos[0];row<elementTwoPos[0]+1;row++) {
                for(int col=elementOnePos[1];col<elementOnePos[1]+1;col++) {
                    gameBoard[row][col]=String.valueOf(tempArray[i]);
                    i++;
                }
            }
        }
    }
}
