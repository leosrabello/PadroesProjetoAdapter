public class TokenAuth implements AuthStrategy {
    private final String token;
    public TokenAuth(String token) { this.token = token; }
    public String header() { return "Bearer " + token; }
}
