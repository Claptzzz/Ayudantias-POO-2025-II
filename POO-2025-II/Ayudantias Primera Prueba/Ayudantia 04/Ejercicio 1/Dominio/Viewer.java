package Dominio;

import java.util.ArrayList;

public class Viewer {
    private int id;
    private String nombre;
    private ArrayList<Stream> streamsVistos;
    private ArrayList<Comentarios> comentariosRealizados;

    public Viewer(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.streamsVistos = new ArrayList<>();
        this.comentariosRealizados = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void addStream(Stream stream) {
        this.streamsVistos.add(stream);
    }

    public void addComentario(Comentarios comentario) {
        this.comentariosRealizados.add(comentario);
    }

    @Override
    public String toString() {
        return "Viewer{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", cantidad streams vistos= " + streamsVistos.size() +
                ", cantidad comentarios realizados= " + comentariosRealizados.size() +
                '}';
    }
    
}
