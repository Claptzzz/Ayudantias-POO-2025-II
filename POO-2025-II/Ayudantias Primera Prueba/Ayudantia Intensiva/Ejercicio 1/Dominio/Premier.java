package Dominio;

import java.util.ArrayList;

public class Premier {

    private String id;
    private String mapa;
    private ArrayList<Equipo> equipos;

    public Premier(String id, String mapa) {
        this.id = id;
        this.mapa = mapa;
        this.equipos = new ArrayList<>();
    }

    public void addEquipo(Equipo e) {
        this.equipos.add(e);
    }

    public String getId() {
        return id;
    }

    public ArrayList<Equipo> getEquipos() {
        return equipos;
    }

    @Override
    public String toString() {
        return id + " - " + mapa;
    }
    
}
