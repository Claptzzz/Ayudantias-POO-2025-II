import java.util.ArrayList;

public class PlayList {
    private String nombre;
    private ArrayList<Cancion> canciones;

    public PlayList(String nombre) {
        this.nombre = nombre;
        canciones = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

}
