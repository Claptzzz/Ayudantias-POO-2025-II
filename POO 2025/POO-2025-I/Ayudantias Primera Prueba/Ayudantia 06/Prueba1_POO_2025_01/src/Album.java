import java.util.ArrayList;

public class Album {
    private int id;
    private String nombre;
    private int id_banda;
    private int anio;
    private int cantCanciones;
    private ArrayList<Cancion> canciones;

    public Album(int id, String nombre, int id_banda, int anio, int cantCanciones) {
        this.id = id;
        this.nombre = nombre;
        this.id_banda = id_banda;
        this.anio = anio;
        this.cantCanciones = cantCanciones;
        canciones = new ArrayList<>();
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

    public int getId_banda() {
        return id_banda;
    }

    public void setId_banda(int id_banda) {
        this.id_banda = id_banda;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getCantCanciones() {
        return cantCanciones;
    }

    public void setCantCanciones(int cantCanciones) {
        this.cantCanciones = cantCanciones;
    }

    public boolean agregarCancion(Cancion c){
        boolean agregado = false;

        if(canciones.add(c)){
            agregado = true;
        }
        return agregado;
    }

    public boolean eliminarCancion(int id){
        boolean eliminado = false;
        for(Cancion c: canciones){
            if(c.getIdCancion() == id){
                canciones.remove(c);
                eliminado = true;
            }
        }
        return eliminado;
    }

    public ArrayList<Cancion> getCanciones() {
        return canciones;
    }

    @Override
    public String toString() {
        return "id: " + id +
                ", nombre: " + nombre +
                ", id banda: " + id_banda +
                ", año de lanzamiento: " + anio +
                ", cantidad de canciones: " + cantCanciones;
    }
}
