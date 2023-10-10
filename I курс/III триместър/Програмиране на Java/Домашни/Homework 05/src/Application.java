import comands.*;
import util.Collection;
import util.Console;

public class Application {

    private static final int MENU_COMMAND_SORT_ASC      = 1;
    private static final int MENU_COMMAND_SORT_DESC     = 2;
    private static final int MENU_COMMAND_FIND_POSITION = 3;
    private static final int MENU_COMMAND_SHAFLE        = 4;
    private static final int MENU_COMMAND_SUM           = 5;
    private static final int MENU_COMMAND_FIND_MAX      = 6;
    private static final int MENU_COMMAND_FIND_MIN      = 7;
    private static final int MENU_COMMAND_FIND_AVG      = 8;
    private static final int MENU_COMMAND_IS_SIMETRICAL = 9;
    private static final int MENU_COMMAND_REVERSE       = 10;
    private static final int MENU_COMMAND_IS_RENDER     = 11;
    private static final int MENU_COMMAND_EXIT          = 12;

    public static int[] buildCollection() {

        int numberOfEntry = Console.input("Въведете колко на брой числа ще въвеждате:");

        int[] numberCollection = new int[numberOfEntry];
        for(int i = 0; i < numberOfEntry; i++) {
            numberCollection[i] = Console.input();
        }
        return numberCollection;
    }

    public static void renderMenu() {

        Console.println("***");
        Console.println("1 . Сортиране на въведените числа във възходящ ред");
        Console.println("2 . Сортиране на въведените числа в низходящ ред");
        Console.println("3 . Търсене на позиция на конкретно число");
        Console.println("4 . Разбъркване на числата");
        Console.println("5 . Изчисляване на сбора на всички числа");
        Console.println("6 . Намиране на най-голямото число");
        Console.println("7 . Намиране на най-малкото число");
        Console.println("8 . Намиране средно-аритметично на числата");
        Console.println("9 . Проверка за симетричност на масива от числа");
        Console.println("10. Обръщане на масива от числа");
        Console.println("11. Визуализирай въведените числа");
        Console.println("12. Изход");
        Console.println("***");
    }

    public static void main(String[] args) {

        int[] numberCollection  = buildCollection();
        int menuIndex           = 0;

        while(menuIndex != MENU_COMMAND_EXIT) {

            renderMenu();
            menuIndex = Console.input();

            if(menuIndex == MENU_COMMAND_SORT_ASC) {
                Collection.print(SortCommand.sort(numberCollection, true));
            }

            if(menuIndex == MENU_COMMAND_SORT_DESC) {
                Collection.print(SortCommand.sort(numberCollection, false));
            }

            if(menuIndex == MENU_COMMAND_FIND_POSITION) {
                int element         = Console.input("Въведете числото, чиято позиция искате да намерите");
                int elementIndex    = SearchCommand.findElementIndex(numberCollection, element);
                String message      = (elementIndex != -1)
                        ? "Числото " + elementIndex + " е намерено на позиция " + elementIndex
                        : "Числото " + elementIndex + " не е намерено ";
                Console.println(message);
            }

            if(menuIndex == MENU_COMMAND_SHAFLE) {
                Collection.print(ShufleCommand.shuffle(numberCollection));
            }

            if(menuIndex == MENU_COMMAND_SUM){
                Console.println("Сумата е " + SumCommand.execute(numberCollection));
            }

            if(menuIndex == MENU_COMMAND_FIND_MIN){
                Console.println("Минималното число е  " + MinMaxCommand.findMin(numberCollection));
            }

            if(menuIndex == MENU_COMMAND_FIND_MAX){
                Console.println("Максималното число е " + MinMaxCommand.findMax(numberCollection));
            }

            if(menuIndex == MENU_COMMAND_FIND_AVG) {
                Console.println("Средно аритметично е " + AvgCommand.execute(numberCollection));
            }

            if(menuIndex == MENU_COMMAND_REVERSE) {
                Collection.print(ReverseCommand.execute(numberCollection));
            }

            if(menuIndex == MENU_COMMAND_IS_SIMETRICAL) {
                boolean isSymetrical = IsSymetricalCommand.execute(numberCollection);
                String message = (isSymetrical)
                        ? "Масива е симетричен"
                        : "Масива не е симетричен";

                Console.println(message);
            }

            if(menuIndex == MENU_COMMAND_IS_RENDER) {
                Collection.print(numberCollection);
            }
        }
    }
}