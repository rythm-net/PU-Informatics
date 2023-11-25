package Currencies;

public class Gold extends CurrencyClass {

    public Gold(double weight){
        super(weight);
    }

    @Override
    public void setApolloValue() {

    }

    public void setDisplayValue(){
        this.displayValue=String.valueOf(value)+"GLD";
    }
}
