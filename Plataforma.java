import java.time.Instant;

public interface Plataforma {
    Resultado<Publicacao> publicar(Conteudo conteudo);
    Resultado<Publicacao> agendar(Conteudo conteudo, Instant quando);
    Resultado<Estatisticas> estatisticas(String idPublicacao);
    String nome();
}
