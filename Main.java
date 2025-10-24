// Main.java - Demonstração simples do uso do Adapter
import java.time.Instant;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // APIs externas simuladas
        TwitterAPI twitter = new TwitterAPI();
        InstagramAPI insta = new InstagramAPI();

        // Criação dos adapters
        Plataforma tw = new TwitterAdapter(twitter, new TokenAuth("token123"));
        Plataforma ig = new InstagramAdapter(insta, new OAuthAuth("oauth_abc"));

        // Gerenciador
        GerenciadorMidiaSocial gerente = new GerenciadorMidiaSocial();
        gerente.registrar(tw);
        gerente.registrar(ig);

        Conteudo conteudo = new Conteudo("Lançamento", "Confira nosso novo produto!", List.of("https://img.exemplo.com/1.jpg"));

        var r1 = gerente.publicarEm(List.of("Twitter", "Instagram"), conteudo);
        System.out.println("Publicar => " + r1.mensagem());

        var r2 = gerente.agendarEm(List.of("Twitter"), conteudo, Instant.now().plusSeconds(2));
        System.out.println("Agendar => " + r2.mensagem());

        var r3 = gerente.estatisticasEm(List.of("Twitter", "Instagram"), "id-qualquer");
        System.out.println("Stats => " + r3.mensagem());
    }
}
