import java.util.Scanner;

public class Application {

    public static boolean isRich(int cardNumber) {

        final int RICH_COEFICIENT = 999_999;
        return cardNumber > RICH_COEFICIENT;
    }

    public static boolean isPoor(int cardNumber) {

        final int POOR_COEFICIENT    =  99;
        final int NORMAL_LOWAR_BOUND = 100_000;

        return cardNumber > POOR_COEFICIENT &&
                cardNumber < NORMAL_LOWAR_BOUND;
    }

    public static boolean isNormal(int cardNumber) {

        final int RICH_COEFICIENT    = 999_999;
        final int NORMAL_LOWAR_BOUND = 100_000;

        return (cardNumber >= NORMAL_LOWAR_BOUND) &&
                (cardNumber <= RICH_COEFICIENT);
    }

    public static String getVoteMessage(int cardNumber) {

        if(isRich(cardNumber)) {
            return ("Има за нас, има и за вас");
        }
        if(isPoor(cardNumber)) {
            return  ("Хайде по-бързо и да те няма");
        }
        if(isNormal(cardNumber)) {
            return ("Радваме се, че нормални хора вече гласуват");
        }

        return "Ти кой беше ?";
    }

    public static boolean isVoterVip(int cardNumber) {

        int lastDigitOfCardNumber   = cardNumber % 10;
        return (lastDigitOfCardNumber % 2 == 0);
    }

    public static boolean isVoterPotentialTaxFraud(int cardNumber) {

        int nextToLastDigitOfCardNumber   = (cardNumber % 100) / 10;
        return nextToLastDigitOfCardNumber > 3;
    }

    public static String getPartyTitle(int ballotNumber) {

        if(ballotNumber == 1) {
            return ("Партия за прогресивен канибализъм");
        }

        if(ballotNumber == 27) {
            return ("Замундска вегетарианска партия");
        }

        if(ballotNumber == 666) {
            return ("Синдикат на вуду-трактористите");
        }

        if(ballotNumber == 999) {
            return ("Партия на труда, мотиката и наковалнята");
        }

        return "Нема такава партия бе брат";
    }

    public static void main(String[] args) {

        System.out.println("Моля въведете номера на вашата карта:");
        Scanner systemScanner = new Scanner(System.in);
        int cardNumber = systemScanner.nextInt();

        System.out.println(getVoteMessage(cardNumber));

        System.out.println("Моля изберете вашите бъдещи господари");
        System.out.println("1   . Партия за прогресивен канибализъм");
        System.out.println("27  . Замундска вегетарианска партия");
        System.out.println("666 . Синдикат на вуду-трактористите");
        System.out.println("999 . Партия на труда, мотиката и наковалнята");
        int ballotNumber = systemScanner.nextInt();
        System.out.println("Вие си поръчахте да ви управлява " + getPartyTitle(ballotNumber));

        boolean isVoterATaxFraud = false;
        if(isVoterPotentialTaxFraud(cardNumber)) {

            System.out.println("Укриваш ли данъци. Отговори с Y / N");
            String questionAnswer = systemScanner.nextLine();
            String message =  (questionAnswer.equals("Y"))
                    ? "Браво моето момче"
                    : "Будала";
            isVoterATaxFraud = (questionAnswer.equals("Y"));
            System.out.println(message);
        }

        boolean isVoterApplicableForExtraTreat = isVoterVip(cardNumber) &&
                (!isVoterATaxFraud);
        boolean doesVoterWantsPastry = false;
        if(isVoterApplicableForExtraTreat) {

            System.out.println("Колега искате ли баничка. Отговори с Y / N");
            String questionAnswer = systemScanner.nextLine();
            String message =  (questionAnswer.equals("Y"))
                    ? "Не може"
                    : "Ами, то и без това няма";

            doesVoterWantsPastry = questionAnswer.equals("Y");
            System.out.println(message);
        }

        boolean isPenaltyApplicableForVoter = isNormal(cardNumber) &&
                !doesVoterWantsPastry &&
                ballotNumber == 27;

        if(isPenaltyApplicableForVoter) {
            System.out.println("Живота е гаден, дължите един банан");
        }

        System.out.println("Поздрав с песента Бедни и Богати на Тони Дачева и оркестър кристал");
    }
}