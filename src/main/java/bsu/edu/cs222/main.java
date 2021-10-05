package bsu.edu.cs222;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import com.jayway.jsonpath.JsonPath;
public class main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Which article would you like to see the last editors of?");
        String input = reader.next();

        if (input.isEmpty()) {
            System.err.println("error code 1");
            System.exit(0);
        }

        try {
            InputStream jsonData = wikipediaCollect.buildConnection(input);
            wikipediaParser.parse(jsonData);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
