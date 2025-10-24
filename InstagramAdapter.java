import java.time.Instant;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class InstagramAdapter implements Plataforma {
    private final InstagramAPI api;
    private final AuthStrategy auth;
    private final ReentrantLock lock = new ReentrantLock(true);

    public InstagramAdapter(InstagramAPI api, AuthStrategy auth) {
        this.api = api;
        this.auth = auth;
    }

    public Resultado<Publicacao> publicar(Conteudo conteudo) {
        lock.lock();
        try {
            String midia = conteudo.getMidias().isEmpty()? "" : conteudo.getMidias().get(0);
            String id = api.post(conteudo.getTexto(), midia, Map.of("Authorization", auth.header()));
            return new Sucesso<>(new Publicacao(id, nome(), Instant.now()), "Post publicado");
        } finally {
            lock.unlock();
        }
    }

    public Resultado<Publicacao> agendar(Conteudo conteudo, Instant quando) {
        return new Sucesso<>(new Publicacao("(pending)", nome(), quando), "Agendamento Instagram");
    }

    public Resultado<Estatisticas> estatisticas(String id) {
        long likes = api.hearts(id, Map.of("Authorization", auth.header()));
        return new Sucesso<>(new Estatisticas(likes, 0), "OK");
    }

    public String nome() { return "Instagram"; }
}
