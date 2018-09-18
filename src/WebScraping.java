import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WebScraping {

    public static String prince = "and";
    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    public static int countWords(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        String[] words = text.split("\\s+");
        return words.length;
    }

    public static int countPrince(String text) {
        String[] words = text.split("\\s+");

        int numberOfPrinces = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i].toLowerCase().equals(prince)) {
                numberOfPrinces++;
            }
        }
        return numberOfPrinces;
    }

    public static void main(String args[]) {
        String url = urlToString("https://www.bls.gov/tus/charts/chart9.txt");

        System.out.println("word count: " + countWords(url));
        System.out.println("number of princes: " + countPrince(url));
    }

}
