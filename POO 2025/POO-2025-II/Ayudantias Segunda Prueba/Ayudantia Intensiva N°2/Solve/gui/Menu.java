package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import dominio.Equipo;
import dominio.Jugador;
import dominio.Sistema;
import dominio.Torneo;
import dominio.OrdenarPorKDA;
import dominio.OrdenarPorKills;
import dominio.RankingVisitor;
import dominio.ReporteDetalladoVisitor;
import logica.OrdenamientoStrategy;
import logica.ReportesVisitor;

public class Menu {
	private Sistema sistema;
	
	public Menu(Sistema sistema) {
		this.sistema = sistema;
	}
	
	public void iniciar() throws FileNotFoundException {
		sistema.cargarDatos();
		JFrame ventanaPrincipal = new JFrame("Sistema LoL");
		ventanaPrincipal.setSize(800, 600);
		ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventanaPrincipal.setLocationRelativeTo(null);
		
		
		//Tabs de pestañas
		JTabbedPane tabs = new JTabbedPane();
		vistaTorneos(tabs);
		vistaEquipos(tabs);
		vistaJugadores(tabs);
		vistaReportes(tabs);
		
		
		
		ventanaPrincipal.add(tabs);
		ventanaPrincipal.setVisible(true);
	}
	
	private void vistaTorneos(JTabbedPane tabs) {
	    String[] infoTorneos = {"ID", "Nombre", "Estado", "Mapa", "Formato"};
	    ArrayList<Torneo> lista = sistema.getTorneos();
	    Object[][] datos = new Object[lista.size()][infoTorneos.length];
	    
	    for (int i = 0; i < lista.size(); i++) {
	        Torneo t = lista.get(i);
	        datos[i][0] = t.getId();
	        datos[i][1] = t.getNombre();
	        datos[i][2] = t.getEstado();
	        datos[i][3] = t.getMapa();
	        datos[i][4] = t.getFormatoPartidas();
	    }

	    JPanel torneos = new JPanel();
	    JTable info = new JTable(datos, infoTorneos);
	    info.setDefaultEditor(Object.class, null); // Hacer tabla no editable
	    info.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Selección simple
	    JScrollPane scroll = new JScrollPane(info);
	    
	    torneos.setLayout(new BorderLayout());
	    torneos.add(scroll, BorderLayout.CENTER);

	    // Panel para los botones
	    JPanel panelBotones = new JPanel();
	    JButton verDetalles = new JButton("Ver Detalles");
	    
	    // ActionListener para el botón Ver Detalles
	    verDetalles.addActionListener(e -> {
	        int filaSeleccionada = info.getSelectedRow();
	        
	        if (filaSeleccionada == -1) {
	            JOptionPane.showMessageDialog(torneos, 
	                "Por favor, selecciona un torneo de la tabla", 
	                "Sin selección", 
	                JOptionPane.WARNING_MESSAGE);
	            return;
	        }
	        
	        // Obtener el ID del torneo seleccionado
	        String idTorneo = (String) info.getValueAt(filaSeleccionada, 0);
	        
	        // Buscar el torneo completo en la lista
	        Torneo torneoSeleccionado = null;
	        for (Torneo t : lista) {
	            if (t.getId().equals(idTorneo)) {
	                torneoSeleccionado = t;
	                break;
	            }
	        }
	        
	        if (torneoSeleccionado != null) {
	            mostrarDetallesTorneo(torneoSeleccionado, torneos);
	        }
	    });
	    
	    panelBotones.add(verDetalles);
	    
	    torneos.add(panelBotones, BorderLayout.SOUTH);

	    tabs.addTab("Torneos", torneos);
	}

	private void mostrarDetallesTorneo(Torneo torneo, JPanel parent) {
	    JDialog dialog = new JDialog();
	    dialog.setTitle("Detalles del Torneo");
	    dialog.setSize(500, 400);
	    dialog.setLocationRelativeTo(parent);
	    dialog.setModal(true);
	    
	    JPanel panel = new JPanel();
	    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
	    panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
	    
	    // Agregar información del torneo
	    panel.add(crearEtiquetaInfo("ID:", String.valueOf(torneo.getId())));
	    panel.add(Box.createVerticalStrut(10));
	    
	    panel.add(crearEtiquetaInfo("Nombre:", torneo.getNombre()));
	    panel.add(Box.createVerticalStrut(10));
	    
	    panel.add(crearEtiquetaInfo("Estado:", torneo.getEstado()));
	    panel.add(Box.createVerticalStrut(10));
	    
	    panel.add(crearEtiquetaInfo("Mapa:", torneo.getMapa()));
	    panel.add(Box.createVerticalStrut(10));
	    
	    panel.add(crearEtiquetaInfo("Formato:", torneo.getFormatoPartidas()));
	    panel.add(Box.createVerticalStrut(20));
	    
	    // Equipos Participantes - mejor formato
	    JLabel lblEquipos = new JLabel("Equipos Participantes:");
	    lblEquipos.setFont(new Font("Arial", Font.BOLD, 12));
	    lblEquipos.setAlignmentX(JPanel.LEFT_ALIGNMENT);
	    panel.add(lblEquipos);
	    panel.add(Box.createVerticalStrut(5));

	    ArrayList<Equipo> participantes = torneo.getParticipantes();
	    if (participantes.isEmpty()) {
	        JLabel sinEquipos = new JLabel("  No hay equipos registrados");
	        sinEquipos.setFont(new Font("Arial", Font.ITALIC, 11));
	        sinEquipos.setAlignmentX(JPanel.LEFT_ALIGNMENT);
	        panel.add(sinEquipos);
	    } else {
	        for (Equipo equipo : participantes) {
	            JLabel lblEquipo = new JLabel("  • " + equipo.getNombre());
	            lblEquipo.setFont(new Font("Arial", Font.PLAIN, 11));
	            lblEquipo.setAlignmentX(JPanel.LEFT_ALIGNMENT);
	            panel.add(lblEquipo);
	            panel.add(Box.createVerticalStrut(3));
	        }
	    }
	    
	    panel.add(Box.createVerticalStrut(15));
	    
	    // Botón para cerrar
	    JButton cerrar = new JButton("Cerrar");
	    cerrar.setAlignmentX(JPanel.CENTER_ALIGNMENT);
	    cerrar.addActionListener(e -> dialog.dispose());
	    panel.add(cerrar);
	    
	    dialog.add(panel);
	    dialog.setVisible(true);
	}

	private JPanel crearEtiquetaInfo(String etiqueta, String valor) {
	    JPanel panelFila = new JPanel();
	    panelFila.setLayout(new FlowLayout(FlowLayout.LEFT));
	    
	    JLabel lblEtiqueta = new JLabel(etiqueta);
	    lblEtiqueta.setFont(new Font("Arial", Font.BOLD, 12));
	    
	    JLabel lblValor = new JLabel(valor);
	    lblValor.setFont(new Font("Arial", Font.PLAIN, 12));
	    
	    panelFila.add(lblEtiqueta);
	    panelFila.add(lblValor);
	    
	    return panelFila;
	}
	
	private void vistaEquipos(JTabbedPane tabs) {
	    String[] infoEquipo = {"Nombre", "Entrenador", "Experiencia Entrenador", "Cantidad Jugadores", "Torneos jugados"};
	    ArrayList<Equipo> listaEquipos = sistema.getEquipos();
	    Object[][] datos = new Object[listaEquipos.size()][infoEquipo.length];
	    
	    for (int i = 0; i < listaEquipos.size(); i++) {
	        Equipo e = listaEquipos.get(i);
	        datos[i][0] = e.getNombre();
	        datos[i][1] = e.getNombreEntrenador();
	        datos[i][2] = e.getExperienciaEntrenador();
	        datos[i][3] = e.getJugadores().size();
	        datos[i][4] = e.getNombreTorneos();
	    }

	    JPanel equipos = new JPanel();
	    JTable info = new JTable(datos, infoEquipo);
	    info.setDefaultEditor(Object.class, null); // Hacer tabla no editable
	    JScrollPane scroll = new JScrollPane(info);

	    equipos.setLayout(new BorderLayout());
	    equipos.add(scroll, BorderLayout.CENTER);

	    JPanel panelBotones = new JPanel();
	    JTextField buscarEquipo = new JTextField(15); // Ancho del campo de texto
	    JButton verRoaster = new JButton("Ver Roster");

	    verRoaster.addActionListener(e -> {
	        if (buscarEquipo.getText().trim().isEmpty()) {
	            JOptionPane.showMessageDialog(equipos, 
	                "Por favor, ingresa el nombre de un equipo", 
	                "Campo vacío", 
	                JOptionPane.WARNING_MESSAGE);
	            return;
	        }

	        Equipo equipo = sistema.buscarEquipoPorNombre(buscarEquipo.getText().trim());
	        
	        if (equipo == null) {
	            JOptionPane.showMessageDialog(equipos, 
	                "No se encontró el equipo: " + buscarEquipo.getText(), 
	                "Equipo no encontrado", 
	                JOptionPane.ERROR_MESSAGE);
	            return;
	        }

	        mostrarRosterEquipo(equipo, equipos);
	    });

	    panelBotones.add(new JLabel("Buscar equipo:"));
	    panelBotones.add(buscarEquipo);
	    panelBotones.add(verRoaster);

	    equipos.add(panelBotones, BorderLayout.SOUTH);

	    tabs.addTab("Equipos", equipos);
	}

	private void mostrarRosterEquipo(Equipo equipo, JPanel parent) {
	    JDialog dialog = new JDialog();
	    dialog.setTitle("Roster - " + equipo.getNombre());
	    dialog.setSize(700, 400);
	    dialog.setLocationRelativeTo(parent);
	    dialog.setModal(true);

	    String[] infoRoaster = {"Nickname", "Rol", "Kills", "KDA", "Muertes por Partida", "Estilo Juego"};
	    ArrayList<Jugador> listaMiembros = equipo.getJugadores();
	    Object[][] datosJugadores = new Object[listaMiembros.size()][infoRoaster.length];

	    for (int i = 0; i < listaMiembros.size(); i++) {
	        Jugador j = listaMiembros.get(i);
	        datosJugadores[i][0] = j.getNickname();
	        datosJugadores[i][1] = j.getRol();
	        datosJugadores[i][2] = j.getKills();
	        datosJugadores[i][3] = j.getKda();
	        datosJugadores[i][4] = j.getMuertesPorPartida();
	        datosJugadores[i][5] = j.getEstiloJuego();
	    }

	    JPanel miembros = new JPanel();
	    miembros.setLayout(new BorderLayout());
	    miembros.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	    
	    // Título
	    JLabel titulo = new JLabel("Jugadores del equipo " + equipo.getNombre());
	    titulo.setFont(new Font("Arial", Font.BOLD, 14));
	    titulo.setHorizontalAlignment(JLabel.CENTER);
	    miembros.add(titulo, BorderLayout.NORTH);
	    
	    // Tabla con los jugadores
	    JTable infoMiembros = new JTable(datosJugadores, infoRoaster);
	    infoMiembros.setDefaultEditor(Object.class, null); // No editable
	    JScrollPane scrollMiembros = new JScrollPane(infoMiembros);
	    miembros.add(scrollMiembros, BorderLayout.CENTER);
	    
	    // Botón cerrar
	    JPanel panelBoton = new JPanel();
	    JButton cerrar = new JButton("Cerrar");
	    cerrar.addActionListener(ev -> dialog.dispose());
	    panelBoton.add(cerrar);
	    miembros.add(panelBoton, BorderLayout.SOUTH);

	    dialog.add(miembros);
	    dialog.setVisible(true);
	}
	
	private void vistaJugadores(JTabbedPane tabs) {
	    String[] infoJugadores = {"Nickname", "Equipo", "Rol", "Kills", "KDA", "Muertes por Partida", "Estilo de Juego"};
	    ArrayList<Jugador> listaJugadores = sistema.getJugadores();
	    Object[][] datosJugadores = new Object[listaJugadores.size()][infoJugadores.length];

	    for (int i = 0; i < listaJugadores.size(); i++) {
	        Jugador j = listaJugadores.get(i);
	        datosJugadores[i][0] = j.getNickname();
	        datosJugadores[i][1] = j.getEquipo();
	        datosJugadores[i][2] = j.getRol();
	        datosJugadores[i][3] = j.getKills();
	        datosJugadores[i][4] = j.getKda();
	        datosJugadores[i][5] = j.getMuertesPorPartida();
	        datosJugadores[i][6] = j.getEstiloJuego();
	    }

	    JPanel jugadores = new JPanel();
	    JTable info = new JTable(datosJugadores, infoJugadores);
	    info.setDefaultEditor(Object.class, null); // Hacer tabla no editable
	    JScrollPane scroll = new JScrollPane(info);

	    jugadores.setLayout(new BorderLayout());
	    jugadores.add(scroll, BorderLayout.CENTER);

	    JPanel ordenamiento = new JPanel();
	    JLabel modoOrdenamiento = new JLabel("Ordenar Por:");
	    String[] opciones = {"KDA", "Kills"};
	    JComboBox<String> opcionesOrdenamiento = new JComboBox<>(opciones);
	    JButton aplicar = new JButton("Aplicar");
	    JButton restablecer = new JButton("Restablecer");

	    aplicar.addActionListener(e -> {
	        String seleccion = (String) opcionesOrdenamiento.getSelectedItem();
	        OrdenamientoStrategy estrategia = null;
	        
	        if (seleccion.equals("KDA")) {
	            estrategia = new OrdenarPorKDA();
	        } else if (seleccion.equals("Kills")) {
	            estrategia = new OrdenarPorKills();
	        }
	        
	        if (estrategia != null) {
	            ArrayList<Jugador> listaOrdenada = sistema.aplicarOrdenamiento(estrategia);
	            actualizarTablaJugadores(info, listaOrdenada, infoJugadores);
	        }
	    });

	    restablecer.addActionListener(e -> {
	        ArrayList<Jugador> listaOriginal = sistema.getJugadores();
	        actualizarTablaJugadores(info, listaOriginal, infoJugadores);
	    });

	    ordenamiento.add(modoOrdenamiento);
	    ordenamiento.add(opcionesOrdenamiento);
	    ordenamiento.add(aplicar);
	    ordenamiento.add(restablecer);

	    jugadores.add(ordenamiento, BorderLayout.SOUTH);

	    tabs.addTab("Jugadores", jugadores);
	}

	private void actualizarTablaJugadores(JTable tabla, ArrayList<Jugador> listaJugadores, String[] columnas) {
	    Object[][] datosActualizados = new Object[listaJugadores.size()][columnas.length];
	    
	    for (int i = 0; i < listaJugadores.size(); i++) {
	        Jugador j = listaJugadores.get(i);
	        datosActualizados[i][0] = j.getNickname();
	        datosActualizados[i][1] = j.getEquipo();
	        datosActualizados[i][2] = j.getRol();
	        datosActualizados[i][3] = j.getKills();
	        datosActualizados[i][4] = j.getKda();
	        datosActualizados[i][5] = j.getMuertesPorPartida();
	        datosActualizados[i][6] = j.getEstiloJuego();
	    }
	    
	    tabla.setModel(new javax.swing.table.DefaultTableModel(datosActualizados, columnas) {
	        @Override
	        public boolean isCellEditable(int row, int column) {
	            return false; // Mantener tabla no editable
	        }
	    });
	}
	
	private void vistaReportes(JTabbedPane tabs) {
		JPanel reportes = new JPanel();
	    reportes.setLayout(new BorderLayout(10, 10));
	    reportes.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

	    // Panel superior para la selección
	    JPanel panelSeleccion = new JPanel();
	    panelSeleccion.setLayout(new BoxLayout(panelSeleccion, BoxLayout.Y_AXIS));
	    panelSeleccion.setBorder(BorderFactory.createTitledBorder("Tipo de Reporte"));

	    // RadioButtons
	    JRadioButton rbRanking = new JRadioButton("Ranking de Jugadores");
	    JRadioButton rbDetallado = new JRadioButton("Reporte Detallado de Jugadores");
	    
	    // ButtonGroup para que solo uno esté seleccionado
	    ButtonGroup grupoReportes = new ButtonGroup();
	    grupoReportes.add(rbRanking);
	    grupoReportes.add(rbDetallado);
	    
	    // Seleccionar el primero por defecto
	    rbRanking.setSelected(true);

	    // Agregar componentes al panel de selección
	    panelSeleccion.add(rbRanking);
	    panelSeleccion.add(Box.createVerticalStrut(5));
	    panelSeleccion.add(Box.createVerticalStrut(10));
	    panelSeleccion.add(rbDetallado);;

	    // Panel central con JTextArea
	    JTextArea areaReporte = new JTextArea(20, 50);
	    areaReporte.setEditable(false);
	    areaReporte.setFont(new Font("Monospaced", Font.PLAIN, 12));
	    JScrollPane scrollReporte = new JScrollPane(areaReporte);
	    scrollReporte.setBorder(BorderFactory.createTitledBorder("Resultado del Reporte"));

	    // Panel inferior con botones
	    JPanel panelBotones = new JPanel();
	    JButton btnGenerar = new JButton("Generar Reporte");
	    JButton btnLimpiar = new JButton("Limpiar");

	    // ActionListener para Generar Reporte
	    btnGenerar.addActionListener(e -> {
	        try {
	            String resultado = "";
	            
	            if (rbRanking.isSelected()) {
	                // Generar ranking Top 10
	                
                    ReportesVisitor visitor = new RankingVisitor();
                    resultado = sistema.aplicarVisitor(visitor);
	                
	            } else if (rbDetallado.isSelected()) {
	                // Generar reporte detallado
	            	ReportesVisitor visitor = new ReporteDetalladoVisitor();
	                resultado = sistema.aplicarVisitor(visitor);
	            }
	            
	            areaReporte.setText(resultado);
	            
	        } catch (Exception ex) {
	            JOptionPane.showMessageDialog(reportes,
	                "Error al generar el reporte: " + ex.getMessage(),
	                "Error",
	                JOptionPane.ERROR_MESSAGE);
	        }
	    });

	    // ActionListener para Limpiar
	    btnLimpiar.addActionListener(e -> {
	        areaReporte.setText("");
	    });

	    panelBotones.add(btnGenerar);
	    panelBotones.add(btnLimpiar);

	    // Agregar todo al panel principal
	    reportes.add(panelSeleccion, BorderLayout.NORTH);
	    reportes.add(scrollReporte, BorderLayout.CENTER);
	    reportes.add(panelBotones, BorderLayout.SOUTH);

	    tabs.addTab("Reportes", reportes);
	}
	
	
}