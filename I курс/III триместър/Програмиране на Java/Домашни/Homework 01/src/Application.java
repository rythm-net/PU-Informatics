public class Application {

    public static void main(String[] args) {

        String facultyNumber    = "1101261005";
        String firstName        = "Mihail";
        String lastName         = "Petrov";

        String studentSignature         = facultyNumber + " " + firstName + " " + lastName;
        System.out.println(studentSignature);
        System.out.println(facultyNumber + " " + firstName + " " + lastName);

        int metalSwordCount = 15;
        int aluminiumArmorCount = 10;
        int gasPistolCount = 1;
        int woodenTankCount = 1;
        int plasticBarrelCount = 1;
        double letherSakMoneyAmount = 169.77;

        String metalSwordId = "s6";
        String aluminiumArmorId = "a5";
        String gasPistolId = "p8";
        String woodenTankId = "t4";
        String plasticBarrelId = "b5";
        String letherSakMoneyAmountId = "s3";

        String[] itemPropertyCollection = {
                "метални", "алуминиеви", "газов", "дървен", "пластмасов", "кожен"
        };

        String[] itemIdentificatorCollection = {
                "мечове", "брони", "пистолет", "танк", "бидон", "сак"
        };

        System.out.println(itemPropertyCollection[0] + " " +itemIdentificatorCollection[0]);
        System.out.println(itemPropertyCollection[1] + " " +itemIdentificatorCollection[1]);
        System.out.println(itemPropertyCollection[2] + " " +itemIdentificatorCollection[2]);
        System.out.println(itemPropertyCollection[3] + " " +itemIdentificatorCollection[3]);
        System.out.println(itemPropertyCollection[4] + " " +itemIdentificatorCollection[4]);
        System.out.println(itemPropertyCollection[5] + " " +itemIdentificatorCollection[5]);

        boolean doYouWantToCompleatTheAcademy = true;
    }
}