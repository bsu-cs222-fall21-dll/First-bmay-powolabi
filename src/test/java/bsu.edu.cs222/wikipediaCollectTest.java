package bsu.edu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;

class wikipediaCollectTestJson {
    @Test
    public void wikipediaCollectTest() {
        InputStream testData = Thread.currentThread().getContextClassLoader().getResourceAsStream("file.json");
        String timeStamp = null;
        try {
            timeStamp = wikipediaParser.parse(testData);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assertions.assertEquals("2021-09-20T01:32:48Z", timeStamp);
    }

    @Test
    public void urlBuilderTest(){
        String formatedString = wikipediaCollect.formatSearch("soup");
        String searchString = "https://en.wikipedia.org/w/api.php?action=query&prop=revisions&titles=soup&rvprop=timestamp&rvlimit=1";
        Assertions.assertEquals(searchString, formatedString);
    }
}
