package Logica;

import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import Dominio.Stream;
import Dominio.Viewer;
import Dominio.Comentarios;

public class App {

    private static Scanner s = new Scanner(System.in);
    private static ArrayList<Stream> streams = new ArrayList<>();
    private static ArrayList<Viewer> viewers = new ArrayList<>();
    private static ArrayList<Comentarios> comentarios = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {

        leerStreams();
        leerViewers();
        leerComentarios();

        int opcion = 0;
        s = new Scanner(System.in);
        do {
            System.out.println("1) Ver info Streams");
            System.out.println("2) Ver info Viewers");
            System.out.println("3) Mostrar comentarios por Stream");
            System.out.println("4) Agregar comentario a un Stream");
            System.out.println("5) Salir");
            System.out.print("Ingrese una opcion: ");
            opcion = s.nextInt();
            s.nextLine(); // Limpiar el buffer
            switch (opcion) {
                case 1:
                    mostrarInfoStreams();
                    break;
                case 2:
                    mostrarInfoViewers();
                    break;
                case 3:
                    mostarComentarios();
                    break;
                case 4:
                    agregarComentario();
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opcion no valida. Intente nuevamente.");
            }
        } while (opcion != 5);
    }

    private static void leerComentarios() throws FileNotFoundException {
        File arch = new File("Comentarios.txt");
        s = new Scanner(arch);
        while (s.hasNextLine()) {
            String linea = s.nextLine();
            String[] partes = linea.split(";");
            int idStream = Integer.parseInt(partes[0]);
            int idViewer = Integer.parseInt(partes[1]);
            int minuto = Integer.parseInt(partes[2]);
            String comentario = partes[3];
            Comentarios c = new Comentarios(idStream, idViewer, minuto, comentario);
            comentarios.add(c);
            // Asociar comentario a Stream
            for (Stream st : streams) {
                if (st.getId() == idStream) {
                    st.addComentario(c);
                    break;
                }
            }
            // Asociar comentario a Viewer
            for (Viewer v : viewers) {
                if (v.getId() == idViewer) {
                    v.addComentario(c);
                    break;
                }
            }
        }
    }

    private static void leerStreams() throws FileNotFoundException {
        File arch = new File("Streams.txt");
        s = new Scanner(arch);
        while (s.hasNextLine()) {
            String linea = s.nextLine();
            String[] partes = linea.split(";");
            int id = Integer.parseInt(partes[0]);
            String nombre = partes[1];
            String fecha = partes[2];
            String categoria = partes[3];
            String duracion = partes[4];
            Stream st = new Stream(id, nombre, fecha, categoria, duracion);
            streams.add(st);
        }
    }

    private static void leerViewers() throws FileNotFoundException {
        File arch = new File("Viewers.txt");
        s = new Scanner(arch);
        while (s.hasNextLine()) {
            String linea = s.nextLine();
            String[] partes = linea.split(";");
            int id = Integer.parseInt(partes[0]);
            String nombre = partes[1];
            Viewer v = new Viewer(id, nombre);
            viewers.add(v);
            // Asociar streams vistos
            for (int i = 2; i < partes.length; i++) {
                int idStreamVisto = Integer.parseInt(partes[i]);
                for (Stream st : streams) {
                    if (st.getId() == idStreamVisto) {
                        v.addStream(st);
                        break;
                    }
                }
            }
        }
    }

    private static void mostrarInfoStreams() {
        for (Stream st : streams) {
            System.out.println(st);
        }
    }

    private static void mostrarInfoViewers() {
        for (Viewer v : viewers) {
            System.out.println(v);
        }
    }

    private static void mostarComentarios() {
        for (Stream st : streams) {
            System.out.println("Comentarios para el Stream: " + st.getId() + " - " + st);
            for (int i = 0; i < st.getComentariosSize(); i++) {
                System.out.println(st.getComentario(i));
            }
        }
    }

    private static void agregarComentario() {
        System.out.print("Ingrese ID del Stream: ");
        int idStream = s.nextInt();
        s.nextLine(); // Limpiar buffer
        System.out.print("Ingrese ID del Viewer: ");
        int idViewer = s.nextInt();
        s.nextLine(); // Limpiar buffer
        System.out.print("Ingrese minuto del comentario: ");
        int minuto = s.nextInt();
        s.nextLine(); // Limpiar buffer
        System.out.print("Ingrese el comentario: ");
        String comentarioTexto = s.nextLine();

        Comentarios nuevoComentario = new Comentarios(idStream, idViewer, minuto, comentarioTexto);
        comentarios.add(nuevoComentario);

        // Asociar comentario a Stream
        for (Stream st : streams) {
            if (st.getId() == idStream) {
                st.addComentario(nuevoComentario);
                break;
            }
        }
        // Asociar comentario a Viewer
        for (Viewer v : viewers) {
            if (v.getId() == idViewer) {
                v.addComentario(nuevoComentario);
                break;
            }
        }

        System.out.println("Comentario agregado exitosamente.");
    }
}