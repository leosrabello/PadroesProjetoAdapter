import java.time.Instant;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class TwitterAdapter implements Plataforma {
    private final TwitterAPI api;
    private final AuthStrategy auth;
    private final ReentrantLock lock = new ReentrantLock(true);

    public TwitterAdapter(TwitterAPI api, AuthStrategy auth) {
        this.api = api;
        this.auth = auth;
    }

    public Resultado<Publicacao> publicar(Conteudo conteudo) {
        lock.lock();
        try {
            String id = api.tweet(conteudo.getTexto(), Map.of("Authorization", auth.header()));
            return new Sucesso<>(new Publicacao(id, nome(), Instant.now()), "Tweet publicado");
        } finally {
            lock.unlock();
        }
    }

    public Resultado<Publicacao> agendar(Conteudo conteudo, Instant quando) {
        return new Sucesso<>(new Publicacao("(pending)", nome(), quando), "Agendamento Twitter");
    }

    public Resultado<Estatisticas> estatisticas(String id) {
        long likes = api.likes(id, Map.of("Authorization", auth.header()));
        return new Sucesso<>(new Estatisticas(likes, 0), "OK");
    }

    public String nome() { return "Twitter"; }
}
