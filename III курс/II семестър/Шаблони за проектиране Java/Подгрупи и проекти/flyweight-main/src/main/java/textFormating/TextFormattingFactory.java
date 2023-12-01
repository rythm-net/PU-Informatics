package textFormating;

import java.util.HashMap;
import java.util.Map;

class TextFormattingFactory {
    private static final Map<String, TextFormatting> formatMap = new HashMap<>();
    public static TextFormatting getFormatting(String font, int size) {
        String key = font + size;
        TextFormatting format = formatMap.get(key);
        if (format == null) {
            format = new TextFormattingImpl(font, size);
            formatMap.put(key, format);
            System.out.println("Creating text formatting: " + font + " (" + size + "pt).");
        }
        return format;
    }
}

