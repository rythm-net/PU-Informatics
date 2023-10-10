public class SelectionSort {

    public static int[] sort(int[] collection) {
        // [1,7,21,12,5,20,25,15,22]
        for(int numberOfTrial = 0; numberOfTrial < collection.length; numberOfTrial++) {

            // взимам с лявата ръка
            int leftHandWeightPosition  = numberOfTrial; // 0
            int leftHandWeight          = collection[numberOfTrial]; // 1
            int rightHandWeightPosition = 0;
            int rightHandWeight         = collection[0];

            for(int weightPosition = numberOfTrial; weightPosition < collection.length; weightPosition++) {

                rightHandWeightPosition = weightPosition;
                rightHandWeight         = collection[weightPosition];

                if(leftHandWeight > rightHandWeight) {
                    leftHandWeight          = rightHandWeight;
                    leftHandWeightPosition  = rightHandWeightPosition;
                }
            }

            int currentElementValue             = collection[numberOfTrial];
            collection[numberOfTrial]           = leftHandWeight;
            collection[leftHandWeightPosition]  = currentElementValue;

            // collection[leftHandWeightPosition] = rightHandWeight;
            // collection[rightHandWeightPosition] = leftHandWeight;
        }
        return collection;
    }
}