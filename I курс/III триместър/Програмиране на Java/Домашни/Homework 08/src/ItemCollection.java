public class ItemCollection {

    private String itemName;
    private int quantity;

    private double sellPrice;
    private double buyPrice;

    private String category;
    private String barcode;

    private static char latinLetter     = 65;
    private static int nextSimpleNumber = 2;
    private static int neverEndingIndex = 0;

    public ItemCollection(String name, int quantity, double buyPrice, double sellPrice, String category) {

        this.itemName  = name;
        this.quantity  = quantity;
        this.buyPrice  = buyPrice;
        this.sellPrice = sellPrice;
        this.category  = category;
        this.barcode   = Code(itemName);
    }

    public static void getAllItems() {
        for (ItemCollection item : Display.collectionList) {
            System.out.println("Име на продукт     Количество        Покупна цена       Продажна цена        Категоряи           Баркод  ");
            System.out.println(item.itemName + "               " + item.quantity + "                   " + item.buyPrice + "             " + item.sellPrice + "            " + item.category + "         " + item.barcode);
        }
    }

    public String Category() {
        return category;
    }

    public String ItemName() {
        return itemName;
    }

    public void Quantity(int quantity) {
        this.quantity = quantity;
    }

    public double SellPrice() {
        return sellPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public String Barcode() {
        return barcode;
    }

    private static String Code(String name) {
        int nameLength = name.length();

        String barcode = "{" + latinLetter + "}@{" + nameLength + "}%{" + nextSimpleNumber + "}^{" + neverEndingIndex + "}";
        nextSimpleNumber++;
        neverEndingIndex++;
        latinLetter++;

        if (latinLetter == 91) {
            latinLetter = 97;
        }
        return barcode;
    }
}