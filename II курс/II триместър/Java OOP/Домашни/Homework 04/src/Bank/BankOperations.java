package Bank;

import java.util.Scanner;

public class BankOperations {

   static Scanner scanner= new Scanner(System.in);
    public static void convertCurrency(){
        System.out.println("Choose witch currency you want to convert");
        String currencyOne=convertedCurrencyPicker();

        System.out.println("Choose currency to be converted to");
        String currencyTwo=convertedCurrencyPicker();

        if(currencyOne.equals("USD")){
            convertUSD(currencyTwo,50);
        }
        // if()....
    }
    private static String convertedCurrencyPicker(){
        System.out.println("[1] USD");
        System.out.println("[2] CAD");
        System.out.println("[3] JAP");
        System.out.println("[4] CHF");
        System.out.println("[5] BTC");
        System.out.println("[6] SBB");
        System.out.println("[7] RTA");
        System.out.println("[8] QAQ");
        System.out.println("[9] Gold");
        System.out.println("[10] Apollo");
        System.out.println("[11] Return");

        int command=scanner.nextInt();
        if(command==1){
            return "USD";
        }
        if(command==2){
            return "CAD";
        }
        if(command==3){
            return "JAP";
        }
        if(command==4){
            return "CHF";
        }
        if(command==5){
            return "BTC";
        }
        if(command==6){
            return "SBB";
        }
        if(command==7){
            return "RTA";
        }
        if(command==8){
            return "QTA";
        }
        if(command==9){
            return "Gold";
        }
        if(command==10){
            return "Apollo";
        }
        return null;
    }

    private static void convertUSD(String currency, double amount){
        if(currency.equals("CDA")){
            amount*=2;
        }
        if(currency.equals("JAP")){
            amount*=1.42;
        }
        if(currency.equals("CHF")){
            amount/=2;
        }
        if(currency.equals("BTC")){
            amount/=105.4;
        }
        if(currency.equals("SBB")){
            amount/=105.4;
        }
        if(currency.equals("RTA")){
            amount/=5.5;
        }
        if(currency.equals("QAQ")){
            amount*=20;
        }
        if(currency.equals("Gold")){
            amount/=100;
        }
        if(currency.equals("NFT")){
            //tuka veche slojno
        }
    }
    //трябва да копи пействам за останалите валути затова така го оставам само с USD

    public static void transferCurrency(){

    }
}
