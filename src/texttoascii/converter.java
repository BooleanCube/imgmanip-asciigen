package texttoascii;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class converter {

    private final static String[] top = new String[]{" ____ ", " ____ ", " ____ ", " ____ ", " _____", " _____", " _____", " _    ", " _ ", "    _ ", " _  __", " _    ", " _     ", " _     ", " ____ ", " ____ ", " ____ ", " ____ ", " ____ ", " _____ ", " _    ", " _    ", " _    ", " ___  _", "___  _", " ____ "};
    private final static String[] mi1 = new String[]{"/  _ \\", "/  _ \\", "/   _\\", "/  _ \\", "/  __/", "/    /", "/  __/", "/ \\ /|", "/ \\", "   / |", "/ |/ /", "/ \\   ", "/ \\__/|", "/ \\  /|", "/  _ \\", "/  __\\", "/  _ \\", "/  __\\", "/ ___\\", "/__ __\\", "/ \\ /\\", "/ \\ |\\", "/ \\  /|", "\\  \\//", "\\  \\//", "/_   \\"};
    private final static String[] mi2 = new String[]{"| / \\|", "| | //", "|  /  ", "| | \\|", "|  \\  ", "|  __\\", "| |  _", "| |_||", "| |", "   | |", "|   / ", "| |   ", "| |\\/||", "| |\\ ||", "| / \\|", "|  \\/|", "| / \\|", "|  \\/|", "|    \\", "  / \\  ", "| | ||", "| | //", "| |  ||", " \\  / ", " \\  / ", " /   /"};
    private final static String[] mi3 = new String[]{"| |-||", "| |_\\\\", "|  \\_ ", "| |_/|", "|  /_ ", "| |   ", "| |_//", "| | ||", "| |", "/\\_| |", "|   \\ ", "| |_/\\", "| |  ||", "| | \\||", "| \\_/|", "|  __/", "| \\_\\|", "|    /", "\\___ |", "  | |  ", "| \\_/|", "| \\// ", "| |/\\||", " /  \\ ", " / /  ", "/   /_"};
    private final static String[] bot = new String[]{"\\_/ \\|", "\\____/", "\\____/", "\\____/", "\\____\\", "\\_/   ", "\\____\\", "\\_/ \\|", "\\_/", "\\____/", "\\_|\\_\\", "\\____/", "\\_/  \\|", "\\_/  \\|", "\\____/", "\\_/   ", "\\____\\", "\\_/\\_\\", "\\____/", "  \\_/  ", "\\____/", "\\__/  ", "\\_/  \\|", "/__/\\\\", "/_/   ", "\\____/"};

    private final static String[][] asciiMap = new String[][]{top, mi1, mi2, mi3, bot};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Provide some text to be converted into ascii: ");
        String text = bf.readLine().toUpperCase();

        StringBuilder ascii = new StringBuilder();

        for(String[] strs : asciiMap) {
            for (int j=0; j<text.length(); j++) ascii.append(strs[text.charAt(j) - 65]);
            ascii.append("\n");
        }

        System.out.println(ascii);
    }

}
