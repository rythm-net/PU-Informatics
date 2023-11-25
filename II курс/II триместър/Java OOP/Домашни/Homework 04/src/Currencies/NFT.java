package Currencies;

public class NFT extends CurrencyClass {
    public NFT(String NFT_Name, double value){
        super(NFT_Name,value);
    }

    public void setNFT_Name(String word){
        this.NFT_Name=word;
    }
    @Override
    public void setApolloValue() {

    }
}
