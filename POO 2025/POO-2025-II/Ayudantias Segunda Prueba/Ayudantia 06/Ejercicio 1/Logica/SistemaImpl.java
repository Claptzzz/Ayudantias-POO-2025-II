package Logica;

import java.lang.reflect.Array;
import java.util.ArrayList;
import Dominio.Cobayas;
import Dominio.Erizos;
import Dominio.Gatos;
import Dominio.Perro;
import Dominio.Hurones;

public class SistemaImpl implements Sistema {
    
    private static ArrayList<Perro> perros = new ArrayList<>();
    private static ArrayList<Gatos> gatos = new ArrayList<>();
    private static ArrayList<Hurones> hurones = new ArrayList<>();
    private static ArrayList<Erizos> erizos = new ArrayList<>();
    private static ArrayList<Cobayas> cobayas = new ArrayList<>();

    @Override
    public void agregarAnimal(int id, String nombre, String especie, int edad, double peso, int diasHospedaje, String frecuente) {
        switch (especie.toLowerCase()) {
            case "perro":
                perros.add(new Perro(id, nombre, especie, edad, peso, diasHospedaje, frecuente));
                break;
            case "gato":
                gatos.add(new Gatos(id, nombre, especie, edad, peso, diasHospedaje, frecuente));
                break;
            case "hurón":
                hurones.add(new Hurones(id, nombre, especie, edad, peso, diasHospedaje, frecuente));
                break;
            case "erizo":
                erizos.add(new Erizos(id, nombre, especie, edad, peso, diasHospedaje, frecuente));
                break;
            case "cobaya":
                cobayas.add(new Cobayas(id, nombre, especie, edad, peso, diasHospedaje, frecuente));
                break;
            default:
                System.out.println("Especie no reconocida: " + especie);
        }
    }

    @Override
    public String infoAnimales() {
        String aux = "";
        for (Perro p : perros) {
            aux += p + "\n";
        }
        for (Gatos g : gatos) {
            aux += g + "\n";
        }
        for (Hurones h : hurones) {
            aux += h + "\n";
        }
        for (Erizos e : erizos) {
            aux += e + "\n";
        }
        for (Cobayas c : cobayas) {
            aux += c + "\n";
        }
        return aux;
    }

    @Override
    public String calcularPrecioHospitalizacionPorID(int id) {
        for (Perro p : perros) {
            if (p.getId() == id) {
                return "Precio hospitalizacion Perro ID " + id + ", nombre: " + p.getNombre() + ": " + p.calcularPrecio();
            }
        }
        for (Gatos g : gatos) {
            if (g.getId() == id) {
                return "Precio hospitalizacion Gato ID " + id + ", nombre: " + g.getNombre() + ": " + g.calcularPrecio();
            }
        }
        for (Hurones h : hurones) {
            if (h.getId() == id) {
                return "Precio hospitalizacion Huron ID " + id + ", nombre: " + h.getNombre() + ": " + h.calcularPrecio();
            }
        }
        for (Erizos e : erizos) {
            if (e.getId() == id) {
                return "Precio hospitalizacion Erizo ID " + id + ", nombre: " + e.getNombre() + ": " + e.calcularPrecio();
            }
        }
        for (Cobayas c : cobayas) {
            if (c.getId() == id) {
                return "Precio hospitalizacion Cobaya ID " + id + ", nombre: " + c.getNombre() + ": " + c.calcularPrecio();
            }
        }
        return "Animal con ID " + id + " no encontrado.";
    }

    @Override
    public String encontrarMenorYMayorPrecio() {

        double menorPrecio = Double.MAX_VALUE;
        double mayorPrecio = Double.MIN_VALUE;
        String infoMenor = "";
        String infoMayor = "";

        for (Perro p : perros) {
            if (p.calcularPrecio() < menorPrecio) {
                menorPrecio = p.calcularPrecio();
                infoMenor = "Perro ID " + p.getId() + " con precio: " + menorPrecio;
            }
            if (p.calcularPrecio() > mayorPrecio) {
                mayorPrecio = p.calcularPrecio();
                infoMayor = "Perro ID " + p.getId() + " con precio: " + mayorPrecio;
            }
        }
        for (Gatos g : gatos) {
            if (g.calcularPrecio() < menorPrecio) {
                menorPrecio = g.calcularPrecio();
                infoMenor = "Gato ID " + g.getId() + " con precio: " + menorPrecio;
            }
            if (g.calcularPrecio() > mayorPrecio) {
                mayorPrecio = g.calcularPrecio();
                infoMayor = "Gato ID " + g.getId() + " con precio: " + mayorPrecio;
            }
        }
        for (Hurones h : hurones) {
            if (h.calcularPrecio() < menorPrecio) {
                menorPrecio = h.calcularPrecio();
                infoMenor = "Huron ID " + h.getId() + " con precio: " + menorPrecio;
            }
            if (h.calcularPrecio() > mayorPrecio) {
                mayorPrecio = h.calcularPrecio();
                infoMayor = "Huron ID " + h.getId() + " con precio: " + mayorPrecio;
            }
        }
        for (Erizos e : erizos) {
            if (e.calcularPrecio() < menorPrecio) {
                menorPrecio = e.calcularPrecio();
                infoMenor = "Erizo ID " + e.getId() + " con precio: " + menorPrecio;
            }
            if (e.calcularPrecio() > mayorPrecio) {
                mayorPrecio = e.calcularPrecio();
                infoMayor = "Erizo ID " + e.getId() + " con precio: " + mayorPrecio;
            }
        }
        for (Cobayas c : cobayas) {
            if (c.calcularPrecio() < menorPrecio) {
                menorPrecio = c.calcularPrecio();
                infoMenor = "Cobaya ID " + c.getId() + " con precio: " + menorPrecio;
            }
            if (c.calcularPrecio() > mayorPrecio) {
                mayorPrecio = c.calcularPrecio();
                infoMayor = "Cobaya ID " + c.getId() + " con precio: " + mayorPrecio;
            }
        }
        return "Menor precio: " + infoMenor + "\nMayor precio: " + infoMayor;
    }
}