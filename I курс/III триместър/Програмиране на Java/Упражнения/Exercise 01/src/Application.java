public class Application {

    public static void main(String[] args) {

        // Не може да се създават променливи с еднакви имена
        // int numberOfRounds = 4;
        // int numberOfRounds = 10;

        // можем да променяме стойностите на вече дефинирана променлива
        int numberOfRounds = 2;
        numberOfRounds = 4;

        int firstRoundQuestionCount     = 10;
        int secondRoundQuestionCount    = 7;
        int thirdRoundQuestionCount     = 5;
        int fourthRoundQuestionCount    = 1;
        int totalNumberOfQuestions      = 23;
        int totalNumberOfNextWeekQuestions = totalNumberOfQuestions;
        // 1205.75
        // double / float
        double moneyPrice = 1205.75;
        float moneyPriceForNextWeek = 500.50f;
        double moneyPriceForThisYear = 100000;

        int numberOfScoresPerQuestion   = 1;

        String titleOfTheShow = "Quizz Show";
        // извеждане на текст
        // Къде го извеждаме - на конзолата
        System.out.println("It is Show time");
        System.out.println(titleOfTheShow);
        System.out.println(moneyPriceForThisYear);

        int onOrOff = 10;
        String yesOrNo = "Y";

        boolean isTurnOn = true;
        char serialId = 'A';

        int visitorsOnMonday    = 1000;
        int visitorsOnThuesday  = 2000;
        int visitorsOnWednesday = 3000;
        int visitorsOnThursday  = 4000;
        int visitorsOnFriday    = 5000;
        int[] visitorCollection = {
                100, 200, 300, 400, 500
        };

        String dayMonaday = "Monday";
        String dayThueday = "Thueday";
        String[] dayCollection = {
                "Monday",
                "Thuesday",
                "Wednesday",
                "Thursday",
                "Friday"
        };
        // System.out.print(dayMonaday);
        // System.out.print(" - ");
        // System.out.print(visitorsOnMonday);

        int index = 0;
        System.out.print(dayCollection[index]);
        System.out.print(" - ");
        System.out.print(visitorCollection[index]);
    }
}