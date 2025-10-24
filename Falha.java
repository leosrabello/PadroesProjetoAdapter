import java.util.Optional;

public class Falha<T> implements Resultado<T> {
    private final String codigo;
    private final String mensagem;

    public Falha(String codigo, String mensagem) {
        this.codigo = codigo;
        this.mensagem = mensagem;
    }

    public boolean ok() { return false; }
    public Optional<T> dado() { return Optional.empty(); }
    public String mensagem() { return mensagem; }
    public String codigo() { return codigo; }
}
