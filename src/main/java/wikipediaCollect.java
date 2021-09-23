import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;
import JsonPath;

public class wikipediaCollect {
    //public String charset = "UTF-8";
    public String url = "https://www.mediawiki.org/w/api.php?";
    public String getRequest = "action=query&prop=";
    public String getRequest2 = "revisions&titles=API|Main%20Page&rvprop=timestamp|user|comment&rvslots=main&formatversion=2";

    public String takeUserInput(){

        Scanner input = new Scanner(System.in);

        return input.toString();
    }

    URLConnection connection;
    {
        String query = String.join(getRequest,takeUserInput(),getRequest2);
        try {
            connection = new URL(url + query).openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public wikipediaCollect(){

    }

}
