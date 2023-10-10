package comands;

public class SumCommand {

    public static int execute(int[] collection) {
        int sum = 0;
        for(int i = 0; i < collection.length; i++) {
            sum += collection[i];
        }
        return sum;
    }
}