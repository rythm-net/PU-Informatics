public class BSearch {

    // Работим пряко с метода
    // работим с неговите аргументи
    public static int search(int[] collection, int findThisElement, int leftIndex, int rightIndex) {

        int leftHandIndex   = leftIndex;
        int rightHandIndex  = rightIndex;

        // необходимо условие да почна да обхождам масива
        if(leftHandIndex <= rightHandIndex) {
            int middleIndex     = leftHandIndex + (rightHandIndex - leftHandIndex) / 2;

            if(collection[middleIndex] == findThisElement) {
                return middleIndex;
            }

            if(collection[middleIndex] > findThisElement) {
                // скочи към върха на програмата
                int newLeftHandIndex = leftHandIndex;
                int newRightHandIndex = middleIndex - 1;

                return search(collection, findThisElement, leftHandIndex, newRightHandIndex) ;
            }

            else {
                // скочи към върха на програмата
                return search(collection, findThisElement, middleIndex + 1, rightHandIndex);
            }
        }
        return -1;
    }
}