public class Logic {

    public static int AvarageArray(int[] arrayOfNumbers) {
        int sum=0;

        for (int i=0;i<arrayOfNumbers.length;i++) {
            sum+=arrayOfNumbers[i];
        }

        int average=sum/arrayOfNumbers.length;
        return average;
    }

    public static int[] linearSearch(String[][] gameBoard,String searchedElement) {

        int[] elementPosition=new int[]{0,0};

        for (int row=0;row<18;row++) {
            for (int col=0;col<12;col++){
                if(searchedElement.equals(gameBoard[row][col])) {
                    elementPosition[0]=row;
                    elementPosition[1]=col;
                }
            }
        }
        return elementPosition;
    }

    public static int[] sortDesc(int[] collection) {

        for (int numberOfTrial = 0; numberOfTrial < collection.length; numberOfTrial++) {
            for (int weightPosition = 0; weightPosition < collection.length - 1 - numberOfTrial; weightPosition++) {

                int leftHandWeightPosition = weightPosition;
                int leftHandWeight = collection[weightPosition];

                int rightHandWeightPosition = weightPosition + 1;
                int rightHandWeight = collection[weightPosition + 1];

                if (rightHandWeight > leftHandWeight) {
                    int temp = leftHandWeight;
                    collection[leftHandWeightPosition] = collection[rightHandWeightPosition];
                    collection[rightHandWeightPosition] = leftHandWeight;
                }
            }
        }
        return collection;
    }
}