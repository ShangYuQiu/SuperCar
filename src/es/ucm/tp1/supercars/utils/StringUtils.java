package es.ucm.tp1.supercars.utils;

public class StringUtils {

	public static String repeat(char c, int length) {
		StringBuilder buffer = new StringBuilder();
		for (int i = 0; i < length; i++) {
		    buffer.append(c);
		}
		return buffer.toString();
	}
	
	public static String repeat(String elmnt, int length) {
		String result = "";
		for (int i = 0; i < length; i++) {
		    result += elmnt;
		}
		return result;
	}

	public static String centre(String text, int length){
		return centre(text, length, ' ');
	}

	public static String centre(String text, int length, char paddingChar){
		if (length < text.length()) {
			throw new IllegalArgumentException(String.format("length must be at least '%d', but is '%d'", text.length(), length));
		}

		int paddingLength = length - text.length();
		int paddingRight = paddingLength / 2;
		int paddingLeft = paddingRight + paddingLength % 2;
		
	    return String.format("%s%s%s", repeat(paddingChar, paddingLeft), text, repeat(paddingChar, paddingRight));
	}
	public static final String LINE_SEPARATOR = System.lineSeparator();
	public static final String TWO_LINE_SEPARATOR_STRING = repeat(LINE_SEPARATOR, 2);

}
