public class BubleSort {

    public static int[] sortAsc(int[] collection) {
        return sort(collection, true);
    }

    public static int[] sortDesc(int[] collection) {
        return sort(collection, false);
    }

    private static int[] sort(int[] collection, boolean isAscending) {

        for(int numberOfTrial = 0; numberOfTrial < collection.length; numberOfTrial++) {

            for(int weightPosition = 0; weightPosition < collection.length - 1 - numberOfTrial; weightPosition++) {

                // взимам с лявата ръка
                int leftHandWeightPosition  = weightPosition;
                int leftHandWeight          = collection[weightPosition];

                // взимам с дясната ръка
                int rightHandWeightPosition = weightPosition + 1;
                int rightHandWeight         = collection[weightPosition + 1];

                // ако в лявата ръка тежеста е по-тежка от тази в дясната направи размяна
                boolean isReadyForSwap = (isAscending)
                        ? rightHandWeight < leftHandWeight
                        : rightHandWeight > leftHandWeight;

                if(isReadyForSwap) {

                    // временно място където да си пазя стойнноста на тежста от ляво или от дясно
                    collection[leftHandWeightPosition] = rightHandWeight;
                    collection[rightHandWeightPosition] = leftHandWeight;
                    // размени
                }
            }
        }
        return collection;
    }
}