import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.internal.JsonFormatter;

import java.io.IOException;
import java.io.InputStream;

public class wikipediaParser {
    public static String parse(InputStream data){
        try {
            return JsonPath.read(data, "$..timestamp");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
