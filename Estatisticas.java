public class Estatisticas {
    private final long curtidas;
    private final long comentarios;

    public Estatisticas(long curtidas, long comentarios) {
        this.curtidas = curtidas;
        this.comentarios = comentarios;
    }

    public long getCurtidas() { return curtidas; }
    public long getComentarios() { return comentarios; }

    @Override
    public String toString() {
        return "Estatisticas{curtidas=" + curtidas + ", comentarios=" + comentarios + "}";
    }
}
