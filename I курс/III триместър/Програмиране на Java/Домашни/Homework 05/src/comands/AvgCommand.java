package comands;

public class AvgCommand {

    public static int execute(int[] collection) {
        int length = collection.length;
        int sum = SumCommand.execute(collection);
        return  sum / length;
    }
}