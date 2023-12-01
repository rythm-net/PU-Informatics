package textFormating;

class TextFormattingImpl implements TextFormatting {
    private final String font;
    private final int size;

    public TextFormattingImpl(String font, int size) {
        this.font = font;
        this.size = size;
    }
    public void format(String text) {
        System.out.println("Formatting text: " + text
                + " with " + font + " (" + size + "pt).");
    }
}
