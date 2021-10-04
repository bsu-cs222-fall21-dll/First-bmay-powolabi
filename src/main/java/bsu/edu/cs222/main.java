package bsu.edu.cs222;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import com.jayway.jsonpath.JsonPath;
public class main {
    public static void main(String[] args) {

        String input = "soup";

        try {
            InputStream jsonData = wikipediaCollect.buildConnection(input);
            String timeStamp = wikipediaParser.parse(jsonData);
            System.out.println("Time stamp: " + timeStamp);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
