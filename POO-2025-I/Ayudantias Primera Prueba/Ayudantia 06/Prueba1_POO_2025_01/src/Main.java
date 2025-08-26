import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Cancion> canciones = new ArrayList<>();
    private static ArrayList<Album> albumes = new ArrayList<>();
    private static ArrayList<PlayList> playists = new ArrayList<>();
    private static ArrayList<Banda> bandas = new ArrayList<>();

    private static Scanner tecladoInt = new Scanner(System.in);

    public static void leerBandas() throws FileNotFoundException {
        Scanner scan = new Scanner(new File("bandas.txt"));
        while(scan.hasNextLine()){
            String[] partes = scan.nextLine().split(",");
            int id = Integer.parseInt(partes[0]);
            String nombre = partes[1];
            int fundacion = Integer.parseInt(partes[2]);

            Banda banda = new Banda(id, nombre, fundacion);
            bandas.add(banda);
        }
    }

    public static void leerMusica() throws FileNotFoundException {
        Scanner scan = new Scanner(new File("musica.txt"));

        while(scan.hasNextLine()) {

            String[] partes = scan.nextLine().split(",");
            int id = Integer.parseInt(partes[0]);
            String nombre = partes[1];
            int id_banda = Integer.parseInt(partes[2]);
            int anio_lanzamiento = Integer.parseInt(partes[3]);
            int cant_canciones = Integer.parseInt(partes[4]);

            Album album = new Album(id, nombre, id_banda, anio_lanzamiento, cant_canciones);
            albumes.add(album);

            for(int i = 0; i < cant_canciones; i++){
                String[] datosCancion = scan.nextLine().split(",");
                int id_cancion = Integer.parseInt(datosCancion[0]);
                String nombre_Cancion = datosCancion[1];
                String duracion = datosCancion[2];
                String genero = datosCancion[3];
                int calificacion = Integer.parseInt(datosCancion[4]);

                Cancion cancion = new Cancion(id_cancion, nombre_Cancion, duracion, genero, calificacion, album);
                canciones.add(cancion);
                album.agregarCancion(cancion);
            }

            for(Banda b: bandas){
                if(b.getId() == id_banda){
                    b.agregarAlbum(album);
                    break;
                }
            }

        }

    }

    public static void leerPlayLists() throws FileNotFoundException {
        Scanner scan = new Scanner(new File("playlists.txt"));
        while(scan.hasNextLine()){
            String[] partes = scan.nextLine().split(",");
            String nombre = partes[0];
            int cant_Canciones = Integer.parseInt(partes[1]);

            PlayList pl = new PlayList(nombre);
            playists.add(pl);

            String[] ids = scan.nextLine().split(",");

            for (String idStr : ids) {
                int id_cancion = Integer.parseInt(idStr.trim());
                for (Cancion c : canciones) {
                    if (c.getIdCancion() == id_cancion) {
                        pl.agregarCancion(c);
                        break;
                    }
                }
            }

        }
    }

    public static void menu(){
        int opcion = 0;

        do{
            System.out.println("Menú de opciones:");
            System.out.println("1. Composición de estilos de las bandas");
            System.out.println("2. Composición de álbumes de las playlists");
            System.out.println("3. Mostrar álbumes por década");
            System.out.println("4. Mostrar el rating de todas las bandas");
            System.out.println("-1. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = tecladoInt.nextInt();

            if(opcion == 1){
                System.out.println("");
                for(Banda b: bandas){
                    ArrayList<String> generos = new ArrayList<>();
                    ArrayList<Integer> conteos = new ArrayList<>();
                    int cantCanciones = 0;

                    for(Album al: b.getAlbumes()){
                        for(Cancion c: al.getCanciones()){
                            String genero = c.getGenero();
                            if(generos.contains(genero)){
                                int index = generos.indexOf(genero);
                                conteos.set(index, conteos.get(index)+1);
                            } else{
                                generos.add(genero);
                                conteos.add(1);
                            }
                            cantCanciones++;
                        }
                    }


                    if(cantCanciones > 0){
                        System.out.println(b.getNombre());
                        System.out.println("Composición de estilos:");
                        for(int i = 0; i < generos.size(); i++){
                            double porcentaje = (conteos.get(i) * 100.0) / cantCanciones;
                            System.out.println(generos.get(i) + ": " + porcentaje + "%");
                        }
                        System.out.println("");
                    } else{
                        System.out.println("La banda no tiene canciones");
                    }

                }


            } else if (opcion == 2) {
                for (PlayList pl : playists) {
                    System.out.println();
                    System.out.println(pl.getNombre());
                    System.out.println("Composición de álbumes:");

                    ArrayList<Album> albumes = new ArrayList<>();
                    ArrayList<Integer> conteos = new ArrayList<>();
                    int totalCanciones = 0;

                    for (Cancion c : pl.getCanciones()) {
                        Album a = c.getAlbum();
                        if (a == null) continue;  // Verifica si el álbum es null y salta esa canción

                        if (albumes.contains(a)) {
                            int index = albumes.indexOf(a);
                            conteos.set(index, conteos.get(index) + 1);
                        } else {
                            albumes.add(a);
                            conteos.add(1);
                        }
                        totalCanciones++;
                    }

                    for (int i = 0; i < albumes.size(); i++) {
                        Album a = albumes.get(i);
                        int cantidad = conteos.get(i);
                        double porcentaje = (cantidad * 100.0) / totalCanciones;

                        Banda banda = null;
                        for (Banda b : bandas) {
                            if (b.getId() == a.getId_banda()) {
                                banda = b;
                                break;
                            }
                        }

                        if (banda != null) {
                            System.out.printf("- %s (%s): %.2f%%\n", a.getNombre(), banda.getNombre(), porcentaje);
                        }
                    }
                    System.out.println("");
                }
            } else if (opcion == 3) {
                int inicio = 1950;
                int fin = 2029;

                for (int dec = inicio; dec <= fin; dec += 10) {
                    System.out.printf("%d - %d:%n", dec, dec + 9);
                    boolean encontrado = false;

                    for (Banda b : bandas) {
                        for (Album a : b.getAlbumes()) {
                            int anio = a.getAnio();
                            if (anio >= dec && anio <= dec + 9) {
                                System.out.printf("- %s (%d) - %s%n", a.getNombre(), anio, b.getNombre());
                                encontrado = true;
                            }
                        }
                    }

                    if (!encontrado) {
                        // Si quieres dejar vacío, puedes omitir esto.
                        // System.out.println("  (Sin álbumes)");
                    }
                }
                System.out.println("");

            } else if (opcion == 4) {
                System.out.println("\nRating de bandas:");
                for (Banda b : bandas) {

                    // Variables para calcular el rating
                    int totalCalificaciones = 0;
                    int totalCanciones = 0;

                    // Iterar sobre los álbumes de la banda
                    for (Album a : b.getAlbumes()) {
                        // Iterar sobre las canciones del álbum
                        for (Cancion c : a.getCanciones()) {
                            totalCalificaciones += c.getCalificacion();  // Sumar la calificación de cada canción
                            totalCanciones++;  // Contar cuántas canciones hay en total
                        }
                    }

                    // Calcular el rating promedio
                    if (totalCanciones > 0) {
                        double ratingPromedio = (double) totalCalificaciones / totalCanciones;
                        System.out.println("-" + b.getNombre() + ": " + ratingPromedio);
                    } else {
                        System.out.println(b.getNombre() +  " no tiene canciones para calcular el rating.");
                    }
                }
                System.out.println("");
            } else if (opcion == -1) {
                System.out.println("Hasta luego :D");
            }

        } while(opcion != -1);

    }

    public static void main(String[] args) throws FileNotFoundException {
        leerBandas();
        leerMusica();
        leerPlayLists();

        menu();
    }
}