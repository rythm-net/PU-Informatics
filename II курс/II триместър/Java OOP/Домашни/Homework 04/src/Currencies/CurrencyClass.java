package Currencies;

import Enums.CryptoCurrencyEnum;
import Enums.FiatValueEnums;

public abstract class CurrencyClass {
    FiatValueEnums fiatValue;
    CryptoCurrencyEnum cryptoValue;
    double  value;
    double  weight;
    boolean canSend;

    String displayValue;
    String NFT_Name;
    String displayValueInApollo;
    double valueInApollo;

    public CurrencyClass(FiatValueEnums fiatValue, double value){
        this.fiatValue=fiatValue;
        this.value=value;
    }
    public CurrencyClass(double weight){
        this.weight=weight;
    }
    public CurrencyClass(CryptoCurrencyEnum cryptoValue, double value){
        this.cryptoValue=cryptoValue;
        this.value=value;
        checkCryptoPath();
    }

    public CurrencyClass(String NFT_Name , double value){
        this.NFT_Name=NFT_Name;
        this.valueInApollo=value;
    }



    private void checkCryptoPath(){
        this.canSend= this.cryptoValue.equals(CryptoCurrencyEnum.BTC) || this.cryptoValue.equals(CryptoCurrencyEnum.SBB);
    }

    public FiatValueEnums getFiatValue(){
        return fiatValue;
    }

    public double getValue() {
        return value;
    }

    public abstract void setApolloValue();

}
