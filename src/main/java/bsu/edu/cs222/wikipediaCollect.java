package bsu.edu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Scanner;

public class wikipediaCollect {

    public static String formatSearch(String input) {
        return String.format("https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=%s&rvprop=timestamp|user&rvlimit=30", URLEncoder.encode(input, Charset.defaultCharset()));
    }

    public static InputStream buildConnection(String input) throws Exception{
        try {
            URLConnection connection = new URL(formatSearch(input)).openConnection();
            connection.setRequestProperty("User-Agent", "CS222FirstProject/0.1 (brmay@bsu.edu)");
            return connection.getInputStream();
        } catch (MalformedURLException malformedURLException) {
            System.err.print("URL could not be reached: error code 3");
            throw new Exception(malformedURLException);
        }
    }

}
