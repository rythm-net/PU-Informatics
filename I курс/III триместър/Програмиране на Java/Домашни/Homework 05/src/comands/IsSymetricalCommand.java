package comands;

public class IsSymetricalCommand {

    public static boolean execute(int[] collection) {
        for(int i = 0; i < collection.length / 2; i++) {

            if(collection[i] != collection[collection.length - i - 1]) {
                return false;
            }
        }
        return true;
    }

}