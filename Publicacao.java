import java.time.Instant;

public class Publicacao {
    private final String id;
    private final String plataforma;
    private final Instant data;

    public Publicacao(String id, String plataforma, Instant data) {
        this.id = id;
        this.plataforma = plataforma;
        this.data = data;
    }

    public String getId() { return id; }
    public String getPlataforma() { return plataforma; }
    public Instant getData() { return data; }
}
