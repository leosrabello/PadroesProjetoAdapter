import java.util.Map;

public class TwitterAPI {
    public String tweet(String texto, Map<String,String> headers) {
        return "tw-" + System.currentTimeMillis();
    }
    public long likes(String id, Map<String,String> headers) {
        return 42;
    }
}
