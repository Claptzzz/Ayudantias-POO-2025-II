package gui;

import dominio.Estudiante;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Menu {
	private List<Estudiante> estudiantes;
	
	public Menu(List<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}
	
	public void iniciar() {
		JFrame principal = new JFrame("Sistema");
		principal.setSize(500, 350);
		principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		principal.setResizable(false);
		principal.setLocationRelativeTo(null);
		
		// Crear botones
		JButton addStudent = new JButton("Agregar nuevo estudiante");
		JButton showStats = new JButton("Mostrar estadísticas básicas");
		JButton nameFilter = new JButton("Filtrar por nombre");
		JButton leave = new JButton("Salir");
		
		// Crear y configurar el label
		JLabel titulo = new JLabel("SISTEMA");
	    titulo.setFont(new Font("Arial", Font.BOLD, 24));
	    titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
	    
	    // Panel principal con BoxLayout
	    JPanel panelPrincipal = new JPanel();
	    panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
	    panelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
	    
	    // Centrar botones
		//Recordar que se pueden centrar usando el metodo setBounds o setAlignmentX
		//Ejemplo:
		/**
		JButton button = new JButton("Transformar");
        button.setBounds(80, 100, 300, 30);
		 */
	    addStudent.setAlignmentX(Component.CENTER_ALIGNMENT);
	    showStats.setAlignmentX(Component.CENTER_ALIGNMENT);
	    nameFilter.setAlignmentX(Component.CENTER_ALIGNMENT);
	    
	    // Agregar componentes con espaciado
	    panelPrincipal.add(titulo);
	    panelPrincipal.add(Box.createVerticalStrut(30)); // Espacio después del título
	    panelPrincipal.add(addStudent);
	    panelPrincipal.add(Box.createVerticalStrut(10)); // Espacio entre botones
	    panelPrincipal.add(showStats);
	    panelPrincipal.add(Box.createVerticalStrut(10));
	    panelPrincipal.add(nameFilter);
	    panelPrincipal.add(Box.createVerticalGlue()); // Empuja el botón salir hacia abajo
	    
	    // Panel para el botón salir (alineado a la derecha)
	    JPanel panelSalir = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	    panelSalir.add(leave);
	    panelPrincipal.add(panelSalir);

		
		addStudent.addActionListener(e -> {
			desplegarFormularioRegistro(principal);
		});
		
		showStats.addActionListener(e -> {
			desplegarEstadisticas(principal);
		});
		
		nameFilter.addActionListener(e -> {
			desplegarFiltro(principal);
		});
		
		leave.addActionListener(e -> {
			System.exit(0);
		});
		
		principal.add(panelPrincipal);
		principal.setVisible(true);
	}
	
	public void desplegarFormularioRegistro(JFrame principal) {
		// Crear el JDialog (Ventana Secundaria)
	    JDialog dialogoRegister = new JDialog(principal, "Registrar estudiante", true);
	    dialogoRegister.setSize(350, 300);
	    dialogoRegister.setLocationRelativeTo(principal);

	    // Panel principal con GridLayout (5 filas x 2 columnas para labels y campos)
	    JPanel panelFormulario = new JPanel(new GridLayout(5, 2, 10, 10));
	    panelFormulario.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

	    // Componentes del formulario
	    JLabel labelRun = new JLabel("RUN:");
	    JTextField run = new JTextField(10);

	    JLabel labelNombre = new JLabel("Nombre:");
	    JTextField nombre = new JTextField(10);

	    JLabel labelCarrera = new JLabel("Carrera:");
	    JTextField carrera = new JTextField(10);

	    JLabel labelSemestre = new JLabel("Semestre:");
	    JTextField semestre = new JTextField(10);

	    JLabel labelPromedio = new JLabel("Promedio:");
	    JTextField promedio = new JTextField(10);

	    // Agregar componentes al panel
	    panelFormulario.add(labelRun);
	    panelFormulario.add(run);
	    panelFormulario.add(labelNombre);
	    panelFormulario.add(nombre);
	    panelFormulario.add(labelCarrera);
	    panelFormulario.add(carrera);
	    panelFormulario.add(labelSemestre);
	    panelFormulario.add(semestre);
	    panelFormulario.add(labelPromedio);
	    panelFormulario.add(promedio);
	    
	    // Panel de botones
	    JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
	    JButton botonRegistrar = new JButton("Registrar");
	    JButton botonLimpiar = new JButton("Limpiar");
	    panelBotones.add(botonRegistrar);
	    panelBotones.add(botonLimpiar);
	    
	    // Agregar paneles al diálogo
	    dialogoRegister.setLayout(new BorderLayout());
	    dialogoRegister.add(panelFormulario, BorderLayout.CENTER);
	    dialogoRegister.add(panelBotones, BorderLayout.SOUTH);
        
        
	    botonRegistrar.addActionListener(e -> {
	        if (!run.getText().trim().isEmpty() && 
	            !nombre.getText().trim().isEmpty() && 
	            !carrera.getText().trim().isEmpty() &&
	            !semestre.getText().trim().isEmpty() && 
	            !promedio.getText().trim().isEmpty()) {
	            
	            try {
	                int semestreNum = Integer.parseInt(semestre.getText().trim());
	                double promedioNum = Double.parseDouble(promedio.getText().trim());
	                
	                estudiantes.add(new Estudiante(
	                    run.getText().trim(), 
	                    nombre.getText().trim(), 
	                    carrera.getText().trim(), 
	                    semestreNum,
	                    promedioNum
	                ));
	                
	                JOptionPane.showMessageDialog(dialogoRegister, 
	                    "Estudiante registrado exitosamente", 
	                    "Éxito", 
	                    JOptionPane.INFORMATION_MESSAGE);
	                
	                dialogoRegister.dispose();
	                
	            } catch (NumberFormatException ex) {
	                JOptionPane.showMessageDialog(dialogoRegister, 
	                    "Error: Semestre y Promedio deben ser números válidos", 
	                    "Error de validación", 
	                    JOptionPane.ERROR_MESSAGE);
	            }
	        } else {
	            JOptionPane.showMessageDialog(dialogoRegister, 
	                "Por favor complete todos los campos", 
	                "Campos vacíos", 
	                JOptionPane.WARNING_MESSAGE);
	        }
	    });
        
        botonLimpiar.addActionListener(e -> {
        	run.setText("");
        	nombre.setText("");
        	carrera.setText("");
        	semestre.setText("");
        	promedio.setText("");
		});
        
        
        dialogoRegister.setVisible(true);
	}
	
	public void desplegarEstadisticas(JFrame principal) {
		if (estudiantes.isEmpty()) {
	        JOptionPane.showMessageDialog(principal, 
	            "No hay estudiantes registrados", 
	            "Sin datos", 
	            JOptionPane.INFORMATION_MESSAGE);
	        return;
	    }
		
		double mejorPromedioo = -1;
		Estudiante mejorPromedio = null;
		double peorPromedioo = Double.MAX_VALUE;
		Estudiante peorPromedio = null;
		
		for(Estudiante e: estudiantes) {
			if(e.getPromedio() > mejorPromedioo) {
				mejorPromedioo = e.getPromedio();
				mejorPromedio = e;
			}
			
			if(e.getPromedio() < peorPromedioo) {
				peorPromedioo = e.getPromedio();
				peorPromedio = e;
			}
		}
		
		JDialog dialogoEstadisticas = new JDialog(principal, "Estadísticas básicas", true);
		dialogoEstadisticas.setSize(400, 350);
		dialogoEstadisticas.setLocationRelativeTo(principal);
	    
	    // Panel principal con BoxLayout
	    JPanel panelEstadisticas = new JPanel();
	    panelEstadisticas.setLayout(new BoxLayout(panelEstadisticas, BoxLayout.Y_AXIS));
	    panelEstadisticas.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
	    
	    // Convertir toString a HTML para que se vean los saltos de línea
	    String htmlMejor = "<html>" + mejorPromedio.toString().replace("\n", "<br>") + "</html>";
	    String htmlPeor = "<html>" + peorPromedio.toString().replace("\n", "<br>") + "</html>";

	    // Componentes
	    JLabel tituloMejor = new JLabel("Mejor Promedio:");
	    tituloMejor.setFont(new Font("Arial", Font.BOLD, 14));
	    JLabel estudianteMP = new JLabel(htmlMejor);

	    JLabel tituloPeor = new JLabel("Peor Promedio:");
	    tituloPeor.setFont(new Font("Arial", Font.BOLD, 14));
	    JLabel estudiantePP = new JLabel(htmlPeor);
	    
	    // Agregar componentes con espaciado
	    panelEstadisticas.add(tituloMejor);
	    panelEstadisticas.add(Box.createVerticalStrut(5));
	    panelEstadisticas.add(estudianteMP);
	    panelEstadisticas.add(Box.createVerticalStrut(20));
	    panelEstadisticas.add(tituloPeor);
	    panelEstadisticas.add(Box.createVerticalStrut(5));
	    panelEstadisticas.add(estudiantePP);
	    
	    // Botón cerrar
	    JButton botonCerrar = new JButton("Cerrar");
	    botonCerrar.addActionListener(e -> dialogoEstadisticas.dispose());
	    
	    JPanel panelBoton = new JPanel();
	    panelBoton.add(botonCerrar);
		
	    // Agregar paneles al diálogo
	    dialogoEstadisticas.setLayout(new BorderLayout());
	    dialogoEstadisticas.add(panelEstadisticas, BorderLayout.CENTER);
	    dialogoEstadisticas.add(panelBoton, BorderLayout.SOUTH);

	    dialogoEstadisticas.setVisible(true);
	}
	
	public void desplegarFiltro(JFrame principal) {
	    // Validar que hay estudiantes
	    if (estudiantes.isEmpty()) {
	        JOptionPane.showMessageDialog(principal, 
	            "No hay estudiantes registrados", 
	            "Sin datos", 
	            JOptionPane.INFORMATION_MESSAGE);
	        return;
	    }

	    JDialog dialogoFiltro = new JDialog(principal, "Filtrar por nombre", true);
	    dialogoFiltro.setSize(450, 400);
	    dialogoFiltro.setLocationRelativeTo(principal);
	    dialogoFiltro.setLayout(new BorderLayout(10, 10));

	    // Panel superior para búsqueda
	    JPanel panelBusqueda = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
	    panelBusqueda.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	    
	    JLabel labelNombre = new JLabel("Nombre:");
	    JTextField campoNombre = new JTextField(20);
	    JButton botonBuscar = new JButton("Buscar");
	    
	    panelBusqueda.add(labelNombre);
	    panelBusqueda.add(campoNombre);
	    panelBusqueda.add(botonBuscar);

	    // TextArea para mostrar resultados
	    JTextArea areaResultados = new JTextArea();
	    areaResultados.setEditable(false);
	    areaResultados.setFont(new Font("Monospaced", Font.PLAIN, 12));
	    areaResultados.setText("Ingrese un nombre y presione 'Buscar'");
	    
	    JScrollPane scrollResultados = new JScrollPane(areaResultados);
	    scrollResultados.setBorder(BorderFactory.createTitledBorder("Resultados"));

	    // Panel inferior con botón cerrar
	    JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));
	    JButton botonCerrar = new JButton("Cerrar");
	    botonCerrar.addActionListener(e -> dialogoFiltro.dispose());
	    panelBotones.add(botonCerrar);

	    // Acción del botón buscar
	    botonBuscar.addActionListener(e -> {
	        String nombreBuscar = campoNombre.getText().trim().toLowerCase();
	        
	        if (nombreBuscar.isEmpty()) {
	            areaResultados.setText("Por favor ingrese un nombre para buscar.");
	            return;
	        }

	        // Buscar estudiantes que coincidan
	        String resultados = "";
	        int contador = 0;
	        
	        for (Estudiante estudiante : estudiantes) {
	            if (estudiante.getNombre().toLowerCase().contains(nombreBuscar)) {
	                if (contador > 0) {
	                    resultados += "\n==================================================\n\n";
	                }
	                resultados += estudiante.toString() + "\n";
	                contador++;
	            }
	        }

	        // Mostrar resultados
	        if (contador == 0) {
	            areaResultados.setText("No se encontraron estudiantes con el nombre: " + nombreBuscar);
	        } else {
	            areaResultados.setText("Se encontraron " + contador + " estudiante(s):\n\n" + resultados);
	        }
	        
	        // Volver al inicio del texto
	        areaResultados.setCaretPosition(0);
	    });

	    // Permitir buscar con Enter
	    campoNombre.addActionListener(e -> botonBuscar.doClick());

	    // Agregar componentes al diálogo
	    dialogoFiltro.add(panelBusqueda, BorderLayout.NORTH);
	    dialogoFiltro.add(scrollResultados, BorderLayout.CENTER);
	    dialogoFiltro.add(panelBotones, BorderLayout.SOUTH);

	    dialogoFiltro.setVisible(true);
	}
	
	
}
