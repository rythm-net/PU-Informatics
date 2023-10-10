package MobileRobot;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        // декларираме няколщко констани които ще пазят границите на сериини номер
        final int EARLY_ADOPTER_BORDER  = 99;
        final int LAGER_BORDER          = 999_999;
        final int NORMAL_BORDER         = 100_000;

        // text output
        // изход
        // това е метод - функция която не връща стойност

        System.out.println("Добре дошли в първа по рода си мобилна пекарна");
        System.out.println("Моля въведете номера на вашата карта");
        Scanner scanner = new Scanner(System.in);

        // това е метод - функция която връща стойност
        // тоест присвояваме на променлива
        // променливата трябва да е от същия тип като връщаната стойност
        //        String serialNumber = scanner.nextLine();

        int serialNumber = scanner.nextInt();

        // >
        // <
        // ==

        boolean isCustomerOfTypeLager = (serialNumber > LAGER_BORDER);

        // && -> логическо и (AND)
        // serialNumber > 100_000 --> 1
        // serialNumber < 999_999 --> 1
        // serialNumber > 100_000 AND serialNumber < 999_999  --> 1 * 1 = 1

        // || -> логическо или (OR)
        // (serialNumber > 100_000) --> 1
        // (serialNumber == 100_000) --> 0
        // (serialNumber > 100_000) OR (serialNumber == 100_000) --> 1 + 0 = 1

        // интервал без включване на долна и горна граница - отворен интервал
        // boolean isNumberExactlySixDigits     = ((serialNumber > 100_000) && (serialNumber < 999_999));
        // интервал с включване на долна и горна граница - затворен интервал
        //        boolean isNumberExactlySixDigits     = (
        //                ((serialNumber > 100_000) || (serialNumber == 100_000)) &&
        //                ((serialNumber < 999_999) || (serialNumber == 999_999))
        //        );

        // всякакъв интервал по кратък запис
        // >= -> по голямо или равно

        boolean isCustomerOfTypeNormal     = (  (serialNumber >= NORMAL_BORDER) &&
                (serialNumber <= LAGER_BORDER));

        boolean isCustomerOfTypeEarlyAdopter = ((serialNumber > EARLY_ADOPTER_BORDER) &&
                (isCustomerOfTypeLager == false) &&
                (isCustomerOfTypeNormal == false));

        // проверка на две възможности
        // String customerType = (isCustomerOfTypeEarlyAdopter) ? "EARLY ADOPTER" : "NO SPECIFIC TYPE";

        String customerType = (isCustomerOfTypeEarlyAdopter)
                ? "EARLY ADOPTER"
                : (isCustomerOfTypeLager)
                ? "LAGER"
                : (isCustomerOfTypeNormal)
                ? "NORMAL"
                : "Нямам идея";

        System.out.println("Потребителя е от ти " + customerType);

        // оператори за аритметика
        // -> + (събиране)
        // -> - (изваждане)
        // -> * (умножение)
        // -> / (деление)
        // -> % (модулно деление || остатъчно деление )

        // целочислен резултат при деление на 10
        // 150 / 10 -> 15,0 -> 15
        // 150 / 100 -> 1,50 -> 1

        // модулно деление при деление на 10
        // 150 % 10  -> 15,0 -> 0
        // 150 % 100 -> 1,50 -> 50

        int lastDigitFOfSerialNumber = serialNumber % 10;

        // 2 / 2 -> 1
        // 2 % 2 -> 0
        // NUMBER % 2 == 0
        // проверка за четно число

        boolean isCustomerVip = (lastDigitFOfSerialNumber % 2 == 0);

        // 64540 % 100 -> 40 / 10

        int beforeLastDigitOfSerialNumber   = ((serialNumber % 100) / 10);
        boolean isFreeMealPermitted         = (beforeLastDigitOfSerialNumber > 3);
        boolean isCustomerSuperVip = isCustomerVip && isFreeMealPermitted;

        System.out.println("Изберете си хапване");
        System.out.println("(1) Бургер");
        System.out.println("(2) Салатка");
        System.out.println("(3) Сладолед");
        int orderNumber = scanner.nextInt();

        String orderItemName = (orderNumber == 1)
                ? "Бургер"
                : (orderNumber == 2)
                ? "Салатка"
                : (orderNumber == 3)
                ? "Сладолед"
                : "опитайте отново";

        double orderItemPrice = (orderNumber == 1)
                ? 10.50
                : (orderNumber == 2)
                ? 5.80
                : (orderNumber == 3)
                ? 2.50
                : 0;
    }
}