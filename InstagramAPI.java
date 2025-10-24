import java.util.Map;

public class InstagramAPI {
    public String post(String legenda, String midia, Map<String,String> headers) {
        return "ig-" + System.currentTimeMillis();
    }
    public long hearts(String id, Map<String,String> headers) {
        return 99;
    }
}
