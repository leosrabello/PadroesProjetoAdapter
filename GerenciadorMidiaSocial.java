import java.time.Instant;
import java.util.*;
import java.util.concurrent.*;

public class GerenciadorMidiaSocial {
    private final Map<String, Plataforma> plataformas = new ConcurrentHashMap<>();
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

    public void registrar(Plataforma plataforma) {
        plataformas.put(plataforma.nome().toLowerCase(), plataforma);
    }

    public Resultado<List<Publicacao>> publicarEm(Collection<String> nomes, Conteudo conteudo) {
        List<Publicacao> resultados = new CopyOnWriteArrayList<>();
        nomes.parallelStream().forEach(nome -> {
            Plataforma p = plataformas.get(nome.toLowerCase());
            if (p != null) {
                var r = p.publicar(conteudo);
                if (r.ok()) r.dado().ifPresent(resultados::add);
            }
        });
        return new Sucesso<>(resultados, "Publicações concluídas");
    }

    public Resultado<List<Publicacao>> agendarEm(Collection<String> nomes, Conteudo conteudo, Instant quando) {
        long delay = Math.max(0, quando.toEpochMilli() - System.currentTimeMillis());
        scheduler.schedule(() -> publicarEm(nomes, conteudo), delay, TimeUnit.MILLISECONDS);
        return new Sucesso<>(List.of(), "Agendamento concluído");
    }

    public Resultado<Map<String, Estatisticas>> estatisticasEm(Collection<String> nomes, String id) {
        Map<String, Estatisticas> stats = new ConcurrentHashMap<>();
        nomes.parallelStream().forEach(nome -> {
            Plataforma p = plataformas.get(nome.toLowerCase());
            if (p != null) {
                var r = p.estatisticas(id);
                if (r.ok()) r.dado().ifPresent(s -> stats.put(nome, s));
            }
        });
        return new Sucesso<>(stats, "Estatísticas obtidas");
    }
}
