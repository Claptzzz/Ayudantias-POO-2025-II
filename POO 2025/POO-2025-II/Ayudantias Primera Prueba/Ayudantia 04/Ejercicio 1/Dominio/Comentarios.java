package Dominio;

public class Comentarios {
    private int idStream;
    private int idViewer;
    private int minuto;
    private String comentario;

    public Comentarios(int idStream, int idViewer, int minuto, String comentario) {
        this.idStream = idStream;
        this.idViewer = idViewer;
        this.minuto = minuto;
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return "Comentarios{" +
                "idStream=" + idStream +
                ", idViewer=" + idViewer +
                ", minuto=" + minuto +
                ", comentario='" + comentario + '\'' +
                '}';
    }
}
