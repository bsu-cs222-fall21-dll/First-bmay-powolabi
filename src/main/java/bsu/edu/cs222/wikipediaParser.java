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
    public static String parse(InputStream data) throws IOException{
        try {
            ByteArrayOutputStream input = new ByteArrayOutputStream();
            data.transferTo(input);

            InputStream user = new ByteArrayInputStream(input.toByteArray());
            InputStream time = new ByteArrayInputStream(input.toByteArray());
            System.out.println(time.toString());
            //ArrayList<String> userJpath = JsonPath.read(user, "$..user");
            ArrayList<String> timeJpath = JsonPath.read(time, "$..timestamp");
            String userTime = timeJpath.get(0);
            return userTime;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
