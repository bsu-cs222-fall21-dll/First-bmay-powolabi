import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Scanner;

public class wikipediaCollect {
    public String takeUserInput() {
        Scanner input = new Scanner(System.in);

        return input.toString();
    }

    public String input = takeUserInput();

    URLConnection connection;
    {
        String searchString = String.format("https://en.wikipedia.org/w/api.php?action=query&prop=revisions&titles=%s&rvprop=timestamp&rvlimit=1", URLEncoder.encode(input, Charset.defaultCharset()));
        try {
            connection = new URL(searchString).openConnection();

            System.out.println("url searched");
        } catch (IOException e) {
            System.err.println("System err 1");
            e.printStackTrace();
        }
    }

    public InputStream getWikipedia() throws Exception {
        try {
            connection.setRequestProperty("User-Agent", "CS222FirstProject/0.1 (brmay@bsu.edu)");
            return connection.getInputStream();
        } catch (MalformedURLException malformedURLException) {
            throw new Exception(malformedURLException);
        }
    }

    public void main(String[] args) {

        try {
            InputStream jsonData = getWikipedia();
            String timeStamp = wikipediaParser.parse(jsonData);
            System.out.println("Time stamp: " + timeStamp);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
