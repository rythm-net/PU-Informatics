import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Display {

    private static Scanner scanner = new Scanner(System.in);
    private static int days        = 1;
    private static double Discount = 0;
    private static double DDS      = 0.2;
    private static double balance  = 1000;

    public static List<Double> ReferanceStorage = new ArrayList<>();
    public static List<ItemCollection> collectionList = new ArrayList<>();

    private static int previousDayOperations  = 0;
    private static int previousDayPurchases   = 0;
    private static double previousDayEarnings = 0;
    private static double expenses            = 0;
    private static double profit              = 0;

    private static String secretCode = " ";

    private static boolean isCaptainsBasementActive = false;
    private static boolean isKarakudaActive         = false;
    private static boolean isSharanActive           = false;
    private static boolean isDayStarted             = false;

    public static void OptionMenu() {

        System.out.println("1. Стартиране на деня");
        System.out.println("2. Покупка");
        System.out.println("3. Продажба");
        System.out.println("4. Справка");
        System.out.println("5. Рушвети");
        System.out.println("6. Приключване на деня");
        System.out.println("7. Изход от системата");

        int command = scanner.nextInt();
//--------------------------------------------------------------------------------------------------------
        if (command == 1) {
            if (!isDayStarted) {
                isDayStarted = true;
                SecretCodeMethod();
                System.out.println("Ващия таен код е : " + secretCode);
                OptionMenu();
            } else {
                System.out.println("Не може да отворите деня си повторно");
                OptionMenu();
            }
        }
//--------------------------------------------------------------------------------------------------------
        if (command == 2) {
            if (isDayStarted) {
                Shopping();
                previousDayOperations++;
            } else {
                System.out.println("Трябва да стартирате деня , за да може да изпълните тази команда");
                OptionMenu();
            }
        }
//--------------------------------------------------------------------------------------------------------
        if (command == 3) {
            if (isDayStarted) {
                SellingMethod();
                previousDayOperations++;
            } else {
                System.out.println("Трябва да стартирате деня , за да може да изпълните тази команда");
                OptionMenu();
            }
        }
//--------------------------------------------------------------------------------------------------------
        if (command == 4) {
            if (isDayStarted) {
                Referance();
                previousDayOperations++;
            } else {
                System.out.println("Трябва да стартирате деня , за да може да изпълните тази команда");
                OptionMenu();
            }
        }
//--------------------------------------------------------------------------------------------------------
        if (command == 5) {
            if (isDayStarted) {
                BackHanderMethod();
                previousDayOperations++;
            } else {
                System.out.println("Трябва да стартирате деня , за да може да изпълните тази команда");
                OptionMenu();
            }
        }
//--------------------------------------------------------------------------------------------------------
        if (command == 6) {
            if (isDayStarted) {
                isDayStarted = false;
                days++;
            } else {
                System.out.println("Трябва да стартирате деня , за да го приключите");
                OptionMenu();
            }
        }
//--------------------------------------------------------------------------------------------------------
        if (command == 7) {
            return;
//--------------------------------------------------------------------------------------------------------
        }
    }

    private static void SecretCodeMethod() {
        String prevDayEarn = " ";

        if (previousDayEarnings == 0) {
            prevDayEarn = "00";
        } else {
            prevDayEarn = String.valueOf(previousDayEarnings);
        }

        String prevDayPurchases = " ";
        if (previousDayPurchases == 0) {
            prevDayPurchases = "**";
        } else {
            prevDayPurchases = String.valueOf(previousDayPurchases);
        }

        String prevDayOp = " ";
        if (previousDayOperations == 0) {
            prevDayOp = "#@";
        } else {
            prevDayOp = String.valueOf(previousDayOperations);
        }

        secretCode = prevDayOp + "%%" + prevDayPurchases + "%%" + prevDayEarn;
    }

    private static void Shopping() {
        System.out.println("Въведете тайния си код");
        String secretText = scanner.next();

        if (!secretText.equals(secretCode)) {
            System.out.println("Тайния код не съвпада!");
            OptionMenu();
        }

        System.out.println("Изберете категория на продукта");
        String category = scanner.next();

        System.out.println("Въведете име на стоката");
        String name = scanner.next();

        System.out.println("Въведете количество продукти");
        int quantity = scanner.nextInt();

        System.out.println("Въведете цената , ня която закупувате стоката");
        double buyPrice = scanner.nextDouble();

        System.out.println("Въведете цената , ня която ще продадете стоката");
        double sellPrice = scanner.nextDouble();

        System.out.println("1.Име на продукт: " + name);
        System.out.println("2.Количество: " + quantity);
        System.out.println("3.Цена за покупка: " + buyPrice);
        System.out.println("4.Цена за продажба: " + sellPrice);
        System.out.println("5.Категория на продукт: " + category);
        System.out.println("Искате ли да редактирате нещо ?(Y/N)");

        String command = scanner.next();

        while (!command.equals("N")) {
            System.out.println("Изберете кое искате да редактирате");
            int number = scanner.nextInt();
            if (number == 1) {
                System.out.println("Въведете ново име на продукта");
                name = scanner.nextLine();
            }

            if (number == 2) {
                System.out.println("Въведете ново количество");
                quantity = scanner.nextInt();
            }

            if (number == 3) {
                System.out.println("Въведете нова цена на покупка");
                buyPrice = scanner.nextDouble();
            }

            if (number == 4) {
                System.out.println("Въведете нова цена на продажба");
                sellPrice = scanner.nextDouble();
            }

            if (number == 5) {
                System.out.println("Въведете нова категория на продукта");
                category = scanner.nextLine();
            }

            System.out.println("Искате ли да редактирате нещо ?(Y/N)");
            command = scanner.next();
        }

        balance -= (buyPrice * quantity) + (buyPrice * quantity * DDS);
        System.out.println("Покупката е успешна!");
        expenses -= (buyPrice * quantity) + (buyPrice * quantity * DDS);
        ItemCollection newItem = new ItemCollection(name, quantity, buyPrice, sellPrice, category);
        collectionList.add(newItem);
        OptionMenu();
    }

    private static void SellingMethod() {
        System.out.println("1.Ръчно");
        System.out.println("2.С бар код");

        int command = scanner.nextInt();
        double fullPrice = 0;

        if (command == 1) {
            System.out.println("Изберете една от следните категории");
            for (ItemCollection item : collectionList) {
                System.out.println(item.Category());
            }

            String category = scanner.next();
            System.out.println("Изберете един от следните продукти");
            for (ItemCollection item : collectionList) {
                if (category.equals(item.Category())) {
                    System.out.println(item.ItemName());
                }
            }

            String name = scanner.next();
            System.out.println("Въведете количество");
            int quantity = scanner.nextInt();
            double itemPrice = 0;
            for (ItemCollection item : collectionList) {
                if (name.equals(item.ItemName())) {
                    itemPrice = item.SellPrice();
                    if (quantity < item.getQuantity()) {
                        item.Quantity(item.getQuantity() - quantity);
                    } else {
                        System.out.println("Няма толкова налични " + item.ItemName());
                        OptionMenu();
                    }
                }
            }

            if (isCaptainsBasementActive) {
                Discount += 0.05;
                fullPrice = (itemPrice * quantity) - ((itemPrice * quantity * 0.01) - (itemPrice * quantity * 0.01) * Discount);
            }

            if (isKarakudaActive) {
                Discount += 0.1;
                fullPrice = (itemPrice * quantity) - ((itemPrice * quantity * 0.01) - (itemPrice * quantity * 0.01) * Discount);
            }

            if (isSharanActive) {
                Discount += 0.15;
                fullPrice = (itemPrice * quantity) - ((itemPrice * quantity * 0.01) - (itemPrice * quantity * 0.01) * Discount);
            } else {
                fullPrice = (itemPrice * quantity) - (itemPrice * quantity * 0.01);
            }

            System.out.println("Крайна цена: " + fullPrice);
            System.out.println("Сигурни ли сте , че искате да направите тази поръчка? (Y/N)");
            String yN = scanner.next();

            if (yN.equals("Y")) {
                System.out.println("Поръчката е потвърдена");
                balance += fullPrice;
                profit += fullPrice;
                OptionMenu();
            }

            if (yN.equals("N")) {
                System.out.println("Поръчката е отменена");
                OptionMenu();
            }
        }

        if (command == 2) {
            System.out.println("Въведете баркода на избран от вас продукт");
            ItemCollection.getAllItems();
            String barcode = scanner.next();
            System.out.println("Въведете количество");
            int quantity = scanner.nextInt();
            double itemPrice = 0;
            for (ItemCollection item : collectionList) {
                if (barcode.equals(item.Barcode())) {
                    itemPrice = item.SellPrice();
                    if (quantity < item.getQuantity()) {
                        item.Quantity(item.getQuantity() - quantity);
                    } else {
                        System.out.println("Няма толкова налични " + item.ItemName());
                        OptionMenu();
                    }
                }
            }

            if (isCaptainsBasementActive) {
                fullPrice = (itemPrice * quantity) - ((itemPrice * quantity * 0.01) - (itemPrice * quantity * 0.01) * 0.05);
            }

            if (isKarakudaActive) {
                Discount += 0.1;
                fullPrice = (itemPrice * quantity) - ((itemPrice * quantity * 0.01) - (itemPrice * quantity * 0.01) * Discount);
            }

            if (isSharanActive) {
                Discount += 0.15;
                fullPrice = (itemPrice * quantity) - ((itemPrice * quantity * 0.01) - (itemPrice * quantity * 0.01) * Discount);
            } else {
                fullPrice = (itemPrice * quantity) - (itemPrice * quantity * 0.01);
            }

            System.out.println("Крайна цена: " + fullPrice);
            System.out.println("Сигурни ли сте , че искате да направите тази поръчка? (Y/N)");
            String yN = scanner.next();

            if (yN.equals("Y")) {
                System.out.println("Поръчката е потвърдена");
                balance += fullPrice;
                profit += fullPrice;
                previousDayPurchases++;
                OptionMenu();
            }

            if (yN.equals("N")) {
                System.out.println("Поръчката е отменена");
                OptionMenu();
            }
        }
    }

    private static void Referance() {
        System.out.println("1.Справка - Финансов Резултат");
        System.out.println("2.Справка - Оборот");
        System.out.println("3.Справка - Други");
        System.out.println("4.Назад");

        int command = scanner.nextInt();

        if (command == 1) {
            System.out.println("1.Листване на текущ дневен финансов резултат");
            System.out.println("2.Листване на всички вчерашни финансови резултати последователно");
            System.out.println("3.Листване на всички вчерашни финансови резултати във възходящ ред");
            System.out.println("4.Листване на всички вчерашни финансови резултати в низходящ ред");
            System.out.println("5.Средно аритметичната стойност на всички вчерашни финансови резултати");
            System.out.println("6.Назад");

            int number = scanner.nextInt();

            if (number == 1) {
                previousDayEarnings = profit - expenses;
                System.out.println("Пари от продажби: " + profit);
                System.out.println("Разходи: " + expenses);
                System.out.println("Текуща печалба " + previousDayEarnings);
                Referance();
            }

            if (number == 2) {
                for (int i = 0; i < ReferanceStorage.size(); i++) {
                    System.out.println("Ден " + i + 1 + " " + ReferanceStorage.get(i));
                }
                Referance();
            }

            if (number == 3) {
                List<Double> tempList = ReferanceStorage.stream().sorted().collect(Collectors.toList());
                tempList.forEach(System.out::println);
            }

            if (number == 4) {
                List<Double> tempList = ReferanceStorage.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
                tempList.forEach(System.out::println);
            }

            if (number == 5) {
                int sum = 0;
                for (int i = 0; i < ReferanceStorage.size() - 1; i++) {
                    sum += ReferanceStorage.get(i);
                }
                System.out.println("Средно аритметично от всички дни до сега: " + sum);
            }

            if (number == 6) {
                OptionMenu();
            }

        }
        if (command == 2) {
            System.out.println("1.Справка дневен оборот");
            System.out.println("2.Справка дневен оборот по категория");
            System.out.println("3.Справка вчерашен оборот");
            System.out.println("4.Справка за конкретен вчерашен оборот");
            System.out.println("5.Справка месечни вчерашни обороти във възходящ ред");
            System.out.println("6.Справка месечни вчерашни обороти в низходящ ред");
            System.out.println("7.Изход");

            int number = scanner.nextInt();

            if (number == 1) {
                System.out.println("Вашия оборот: " + balance);
            }

            if (number == 2) {

            }
            if (number == 3) {
                System.out.println("Вчерашния ви оборот : " + ReferanceStorage.get(ReferanceStorage.size() - 2));
            }

            if (number == 4) {
                System.out.println("Изберете конкретен ден");
                int day = scanner.nextInt();
                System.out.println("Оборота за този ден е " + ReferanceStorage.get(day - 1));
            }

            if (number == 5) {
                if (days >= 30) {
                    List<Double> tempList = ReferanceStorage.stream().sorted().collect(Collectors.toList());
                    tempList.forEach(System.out::println);
                }
            }

            if (number == 6) {
                if (days >= 30) {
                    List<Double> tempList = ReferanceStorage.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
                    tempList.forEach(System.out::println);
                }
            }

            if (number == 7) {
                Referance();
            }
        }

        if (command == 3) {
            ItemCollection.getAllItems();
            Referance();
        }

        if (command == 4) {
            OptionMenu();
        }
    }

    private static void BackHanderMethod() {
        System.out.println("Въведете идентификационния си код");
        String idCode = scanner.next();

        if (!idCode.equals(secretCode)) {
            System.out.println("Господин честен данъчен тук нищо не се случило");
            OptionMenu();
        }

        String BackHanderName = " ";
        System.out.println("Изберете тарифен план");
        System.out.println("    название                                 облаги                                       разход");
        System.out.println("1.Мазето на капитана     премахва 5% от всички начислени данъци при продажба               50 ");
        System.out.println("2.Каракуда               премахва 10% от всички начислени данъци\n" +
                "продажба и намалява ДДС покупка с 1% за\n" +
                "всички бъдещи периоди                                       200");
        System.out.println("3.Шаран                   премахва 15% от всички начислени данъци\n" +
                "продажба намалява ДДС покупка с 5%\n" +
                "следващата стока която закупите не се\n" +
                "облага с ДДС                                                300");

        int number = scanner.nextInt();

        if (number == 1) {
            isCaptainsBasementActive = true;
            balance -= 50;
        }

        if (number == 2) {
            isKarakudaActive = true;
            balance -= 200;
        }

        if (number == 3) {
            isSharanActive = true;
            balance -= 300;
        }
    }
}