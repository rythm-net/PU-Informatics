import Bank.BankOperations;
import Currencies.Crypto;
import Currencies.Fiat;
import Currencies.Gold;
import Currencies.NFT;
import Enums.CryptoCurrencyEnum;
import Enums.FiatValueEnums;
import Wallet.DigitalWallet;

import java.util.ArrayList;
import java.util.Scanner;

import static Bank.BankOperations.convertCurrency;

public class WalletControl {
    static ArrayList<DigitalWallet> walletsContainer= new ArrayList<>();
    static Scanner scanner= new Scanner(System.in);
    public static void MainMenu(){
        System.out.println("[1] Create Wallet");
        System.out.println("[2] View wallet");
        System.out.println("[3] exit");
        int command = scanner.nextInt();
        if(command==1){
            createWallet();
        }
        if(command==2){
            viewWallet();
        }
        if(command==3){
            return;
        }
    }

   private static void viewWallet(){
       System.out.println("Choose a wallet to manage");
        int i=0;
        for(DigitalWallet wallet : walletsContainer){
            System.out.println("["+i+1+"] "+wallet.getWalletID());
        }
        int command=scanner.nextInt();
        DigitalWallet tempWallet = walletsContainer.get(command-1);

        manageWallet(tempWallet);
   }

   private static void manageWallet(DigitalWallet wallet){
       System.out.println("WalletID: " +wallet.getWalletID());
       System.out.println("         [1] Add Funds");
       System.out.println("         [2] Convert Currency");
       System.out.println("         [3] Transfer Currency");
       System.out.println("         [4] Delete Wallet");
       System.out.println("[5] Return");
       int command=scanner.nextInt();

       if(command==1){
           addFunds(wallet);
       }
       if(command==2){
           convertCurrency();
       }
       if(command==3){
            BankOperations.transferCurrency();
       }
       if(command==4){
           walletsContainer.remove(wallet);
       }
   }

    private static void createWallet(){
        DigitalWallet newWallet = new DigitalWallet();
        System.out.println("Input your wallet ID:");
        newWallet.setWalletID(scanner.nextLine());
        System.out.println("Your digital wallet is created!");
        System.out.println("Do you want to add funds ? (Y/N)");
        String command= scanner.nextLine();
        if(command.equals("Y")){
            addFunds(newWallet);
        }
        walletsContainer.add(newWallet);
    }


    private static void addFunds(DigitalWallet wallet){
        System.out.println("[1]   Fiat");
        System.out.println("[2]   Crypto");
        System.out.println("[3]   Gold");
        System.out.println("[4]   NFT");
        System.out.println("[5]             Return");

        int command= scanner.nextInt();

        if(command==1){
            addFiat(wallet);
        }
        if(command==2){
            addCrypto(wallet);
        }
        if(command==3){
            addGold(wallet);
        }
        if(command==4){
            addNFT(wallet);
        }
        MainMenu();
    }


    private static void  addFiat(DigitalWallet wallet){
        System.out.println("[1]   USD");
        System.out.println("[2]   CAD");
        System.out.println("[1]   JAP");
        System.out.println("[1]   CHF");
        int command= scanner.nextInt();
        System.out.println("Insert the amount you wish to add: ");
        double value= scanner.nextDouble();
        if(command==1){
            createAndAddFiatCurrency(wallet,FiatValueEnums.USD,value);
        }
        if(command==2){
            createAndAddFiatCurrency(wallet,FiatValueEnums.CAD,value);
        }
        if(command==3){
            createAndAddFiatCurrency(wallet,FiatValueEnums.JAP,value);
        }
        if(command==4){
            createAndAddFiatCurrency(wallet,FiatValueEnums.CHF,value);
        }
    }
    private static void  addCrypto(DigitalWallet wallet){
        System.out.println("[1]   BTC");
        System.out.println("[2]   SBB");
        System.out.println("[1]   RTA");
        System.out.println("[1]   QAQ");
        int command= scanner.nextInt();
        System.out.println("Insert the amount you wish to add: ");
        double value= scanner.nextDouble();
        if(command==1){
            createAndAddCryptoCurrency(wallet,CryptoCurrencyEnum.BTC,value);
        }
        if(command==2){
            createAndAddCryptoCurrency(wallet,CryptoCurrencyEnum.SBB,value);
        }
        if(command==3){
            createAndAddCryptoCurrency(wallet,CryptoCurrencyEnum.RTA,value);
        }
        if(command==4){
            createAndAddCryptoCurrency(wallet,CryptoCurrencyEnum.QAQ,value);
        }
    }
    private static void addGold(DigitalWallet wallet){
        System.out.println("Insert the amount of GLD you want to add to your wallet (1 GLD = 1000 APL");
        double amount = scanner.nextDouble();
        Gold gold = new Gold(amount);
        wallet.addGoldToContainer(gold);
    }
    private static void addNFT(DigitalWallet wallet){
        System.out.println("Input the amount in APL of your NFT");
        double value=scanner.nextDouble();
        System.out.println("Name your new NFT");
        NFT nft = new NFT(scanner.nextLine(),value);
        wallet.addNftToContainer(nft);
    }
    private static void createAndAddFiatCurrency(DigitalWallet wallet, FiatValueEnums enums, double value){
        Fiat temp= new Fiat(enums,value);
        wallet.addFiatToContainer(temp);
    }
    private static void createAndAddCryptoCurrency(DigitalWallet wallet, CryptoCurrencyEnum enums, double value){
        Crypto temp= new Crypto(enums,value);
        wallet.addCryptoToContainer(temp);
    }
}
