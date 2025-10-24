import java.util.Optional;

public interface Resultado<T> {
    boolean ok();
    Optional<T> dado();
    String mensagem();
    String codigo();
}
