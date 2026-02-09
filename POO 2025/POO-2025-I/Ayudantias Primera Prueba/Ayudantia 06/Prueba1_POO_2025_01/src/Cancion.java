public class Cancion {
    private int idCancion;
    private String nombre;
    private String duracion;
    private String genero;
    private int calificacion;
    private Album album;

    public Cancion(int id, String nombre, String duracion, String genero, int calificacion, Album album) {
        this.idCancion = id;
        this.nombre = nombre;
        this.duracion = duracion;
        this.genero = genero;
        this.calificacion = calificacion;
        this.album = album;
    }

    public int getIdCancion() {
        return idCancion;
    }

    public void setIdCancion(int idCancion) {
        this.idCancion = idCancion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public Album getAlbum() {
        return album;
    }

    @Override
    public String toString() {
        return "Id: " + idCancion +
                ", nombre: " + nombre +
                ", duración: " + duracion +
                ", género: " + genero +
                ", calificación: " + calificacion;
    }
}
