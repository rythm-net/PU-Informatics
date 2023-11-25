package Currencies;

import Enums.FiatValueEnums;

public class Fiat extends CurrencyClass {
    public Fiat(FiatValueEnums fiatValue, double value){
        super(fiatValue,value);
    }

    @Override
    public void setApolloValue() {

    }
}
