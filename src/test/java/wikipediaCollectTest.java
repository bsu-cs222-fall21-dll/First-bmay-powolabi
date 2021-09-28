
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.net.URLConnection;

public class wikipediaCollectTest {
    @Test
    public void wikipediaCollectTest(URLConnection connection) {
        wikipediaCollect wikiCollect = new wikipediaCollect();
        InputStream testData = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        String timeStamp = wikipediaParser.parse(testData);
        Assertions.assertEquals("2021-09-20T01:32:48Z", timeStamp);
    }
}
