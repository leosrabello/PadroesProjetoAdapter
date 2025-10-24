import java.util.List;

public class Conteudo {
    private final String titulo;
    private final String texto;
    private final List<String> midias;

    public Conteudo(String titulo, String texto, List<String> midias) {
        this.titulo = titulo;
        this.texto = texto;
        this.midias = midias;
    }

    public String getTitulo() { return titulo; }
    public String getTexto() { return texto; }
    public List<String> getMidias() { return midias; }
}
