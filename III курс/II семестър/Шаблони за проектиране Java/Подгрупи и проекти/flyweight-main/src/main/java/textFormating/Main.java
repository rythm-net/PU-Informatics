package textFormating;

public class Main {
    public static void main(String[] args) {
        String text1 = "Hello, world!";
        String text2 = "A fly weights around 1gram or less.";

        TextFormatting formatting1 = TextFormattingFactory.getFormatting("Arial", 12);
        formatting1.format(text1);

        TextFormatting formatting2 = TextFormattingFactory.getFormatting("Times New Roman", 14);
        formatting2.format(text2);

        TextFormatting formatting3 = TextFormattingFactory.getFormatting("Arial", 12);
        formatting3.format(text2);
    }
}