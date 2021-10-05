package bsu.edu.cs222;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import com.jayway.jsonpath.JsonPath;
public class main {
    public static void main(String[] args) {

        String input = "rabbit";

        try {
            InputStream jsonData = wikipediaCollect.buildConnection(input);
            wikipediaParser.parse(jsonData);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
