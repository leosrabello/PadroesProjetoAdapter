import java.util.Optional;

public class Sucesso<T> implements Resultado<T> {
    private final T dado;
    private final String mensagem;

    public Sucesso(T dado, String mensagem) {
        this.dado = dado;
        this.mensagem = mensagem;
    }

    public boolean ok() { return true; }
    public Optional<T> dado() { return Optional.ofNullable(dado); }
    public String mensagem() { return mensagem; }
    public String codigo() { return "OK"; }
}
