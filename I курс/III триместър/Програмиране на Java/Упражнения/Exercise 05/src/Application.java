public class Application {

    public static void main(String[] args) {

        int[] weightCollection = {
                1,7,21,12,5,20,25,15,22
        };

        // ако подам true искам да ми върнеш възходящ ред
        // ако не подам нищо искам низходящ ред
        // BubleSort.sort(weightCollection, false);

        // възходящо сортиране на weightCollection
        int[] newWeightCollection = BubleSort.sortAsc(Util.copyArray(weightCollection));
        Util.loop(newWeightCollection);
        System.out.println();
        BubleSort.sortDesc(newWeightCollection);

        System.out.println("New weight collection ");
        Util.loop(newWeightCollection);

        System.out.println("Weight collection");
        Util.loop(weightCollection);

        System.out.println("Selection Sort");
        int[] selectionSortCollection = SelectionSort.sort(Util.copyArray(weightCollection));
        Util.loop(selectionSortCollection);

        if(BinarySearch.isAvailable(weightCollection, 23)) {
            System.out.println("The element is available");
        }
    }
}