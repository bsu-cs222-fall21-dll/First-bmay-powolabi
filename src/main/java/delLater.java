import java.net.URLConnection;
import java.util.*;

public class delLater() {
    public String  website = "https://www.mediawiki.org/w/api.php?";
    public String getRequest = "api.php?action=query&prop=";

    public String getRequest2 = "revisions&titles=API|Main%20Page&rvprop=timestamp|user|comment&rvslots=main&formatversion=2";

    Scanner input = new Scanner(System.in);

    public String finalFormRequest = getRequest + input.toString() + getRequest;



}
