package Wallet;

import Currencies.Crypto;
import Currencies.Fiat;
import Currencies.Gold;
import Currencies.NFT;
import Enums.CryptoCurrencyEnum;
import Enums.FiatValueEnums;

import java.util.ArrayList;

public class DigitalWallet {
    String walletID;

    ArrayList<Fiat> allFiatCurrenciesContainer= new ArrayList<>();
    ArrayList<Crypto> allCryptoCurrenciesContainer= new ArrayList<>();
    ArrayList<NFT> NFTsContainer= new ArrayList<>();
    ArrayList<Gold> goldContainer= new ArrayList<>();

    double amountInUSD=0;
    double amountInCAD=0;
    double amountInJAP=0;
    double amountInCHF=0;
    double amountInBTC=0;
    double amountInSBB=0;
    double amountInRTA=0;
    double amountInQAQ=0;


    public void addFiatToContainer(Fiat fiat){
        this.allFiatCurrenciesContainer.add(fiat);
    }
    public void addCryptoToContainer(Crypto crypto){
        this.allCryptoCurrenciesContainer.add(crypto);
    }

    public void addGoldToContainer(Gold gold){
        this.goldContainer.add(gold);
    }
    public void addNftToContainer(NFT nft){
        this.NFTsContainer.add(nft);
    }

    public void setWalletID(String walletID) {
        this.walletID = walletID;
    }
    public String getWalletID(){
        return walletID;
    }

    public void setAmounts(){
        this.amountInUSD=renderFiatAmount(FiatValueEnums.USD);
        this.amountInCAD=renderFiatAmount(FiatValueEnums.CAD);
        this.amountInJAP=renderFiatAmount(FiatValueEnums.JAP);
        this.amountInCHF=renderFiatAmount(FiatValueEnums.CHF);

        this.amountInBTC=renderCryptoAmount(CryptoCurrencyEnum.BTC);
        this.amountInSBB=renderCryptoAmount(CryptoCurrencyEnum.SBB);
        this.amountInRTA=renderCryptoAmount(CryptoCurrencyEnum.RTA);
        this.amountInQAQ=renderCryptoAmount(CryptoCurrencyEnum.QAQ);

    }

    private double  renderFiatAmount(FiatValueEnums enums){
        double sum=0;
        for (Fiat fiat : allFiatCurrenciesContainer){
            if(fiat.getFiatValue().equals(enums)){
                sum+=fiat.getValue();
            }
        }
        return sum;
    }
    private double  renderCryptoAmount(CryptoCurrencyEnum enums){
        double sum=0;
        for (Crypto crypto : allCryptoCurrenciesContainer){
            if(crypto.getFiatValue().equals(enums)){
                sum+=crypto.getValue();
            }
        }
        return sum;
    }
    private double  renderNFTAmount(){
        double sum=0;
        for (Crypto crypto : allCryptoCurrenciesContainer){
            sum += crypto.getValue();
        }
        return sum;
    }
    private double  renderGoldAmount(){
        double sum=0;
        for (Crypto crypto : allCryptoCurrenciesContainer){
            sum+=crypto.getValue();
        }
        return sum;
    }
}
