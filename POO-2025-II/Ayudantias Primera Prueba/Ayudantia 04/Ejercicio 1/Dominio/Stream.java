package Dominio;

import java.util.ArrayList;

public class Stream {
    private int id;
    private String nombre;
    private String fecha;
    private String categoria;
    private String duracion;
    private ArrayList<Comentarios> comentarios;

    public Stream(int id, String nombre, String fecha, String categoria, String duracion) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.categoria = categoria;
        this.duracion = duracion;
        this.comentarios = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void addComentario(Comentarios comentario) {
        this.comentarios.add(comentario);
    }

    public Comentarios getComentario(int index) {
        if (index >= 0 && index < comentarios.size()) {
            return comentarios.get(index);
        }
        return null;
    }

    public int getComentariosSize() {
        return comentarios.size();
    }



    @Override
    public String toString() {
        return "Stream{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", fecha='" + fecha + '\'' +
                ", categoria='" + categoria + '\'' +
                ", duracion='" + duracion + '\'' +
                ", Cantcomentarios= " + comentarios.size() +
                '}';
    }



}
