package bsu.edu.cs222;

import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.internal.JsonFormatter;
import net.minidev.json.JSONArray;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class wikipediaParser {
    public static void parse(InputStream data) throws IOException{
        try {
            ByteArrayOutputStream input = new ByteArrayOutputStream();
            data.transferTo(input);

            InputStream user = new ByteArrayInputStream(input.toByteArray());
            InputStream time = new ByteArrayInputStream(input.toByteArray());
            System.out.println(time.toString());
            ArrayList<String> userJpath = JsonPath.read(user, "$..user");
            ArrayList<String> timeJpath = JsonPath.read(time, "$..timestamp");
            ArrayList<String> redirect = JsonPath.read(time, "$..timestamp");
            System.out.println(timeJpath);
            if(!timeJpath.isEmpty()) {
                for (int i = 0; i < timeJpath.size(); i++) {
                    System.out.println("Time stamp: " + timeJpath.get(i));
                    System.out.println("User Name: " + userJpath.get(i));
                }
            } else {
                System.err.println("There is no data given for the provided search term: err code 2");
                System.exit(0);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
