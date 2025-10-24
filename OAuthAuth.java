public class OAuthAuth implements AuthStrategy {
    private final String accessToken;
    public OAuthAuth(String accessToken) { this.accessToken = accessToken; }
    public String header() { return "OAuth " + accessToken; }
}
