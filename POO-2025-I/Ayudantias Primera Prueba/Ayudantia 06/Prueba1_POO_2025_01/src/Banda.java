import java.util.ArrayList;

public class Banda {
    private int id;
    private String nombre;
    private int anio;
    private ArrayList<Album> albumes;

    public Banda(int id, String nombre, int anio) {
        this.id = id;
        this.nombre = nombre;
        this.anio = anio;
        albumes = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public boolean agregarAlbum(Album a){
        boolean agregado = false;

        if(albumes.add(a)){
            agregado = true;
        }
        return agregado;
    }

    public boolean eliminarAlbum(int id){
        boolean eliminado = false;
        for(Album a: albumes){
            if(a.getId() == id){
                albumes.remove(a);
                eliminado = true;
            }
        }
        return eliminado;
    }

    public ArrayList<Album> getAlbumes() {
        return albumes;
    }

    @Override
    public String toString() {
        return "id: " + id +
                ", nombre: " + nombre +
                ", año de fundación: " + anio;
    }
}
