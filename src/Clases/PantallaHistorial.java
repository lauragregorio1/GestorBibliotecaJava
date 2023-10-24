package Clases;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JTextField;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;

public class PantallaHistorial extends JFrame {

	private JPanel contentPane;
	private JPanel panel;

	private static DefaultTableModel modelo;
	private static JTable tableHistorial;
	private JScrollPane scrollPane;
	private JButton btnCerrar;
	private JButton btnVolver;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel;

	public static void main(String[] args) {

	}

	public PantallaHistorial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Cierra la aplicación cuando se presiona el botón de cerrar ventana
		setBounds(100, 100, 900, 600);  // Establece las dimensiones y la posición de la ventana
		contentPane = new JPanel();  // Crea un nuevo panel
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));  
		setTitle("Historial");  // Establece el título de la ventana
		setContentPane(contentPane);  
		contentPane.setLayout(null);  

		panel = new JPanel();  // Crea un nuevo panel
		panel.setBackground(new Color(229, 207, 247));  // Establece el color de fondo del panel
		panel.setBounds(0, 0, 886, 76);  // Establece las dimensiones y la posición del panel
		contentPane.add(panel);  // Añade el panel al contenido del panel principal
		panel.setLayout(null);  

		lblNewLabel_1 = new JLabel("BIBLIOTECA");  // Crea una nueva etiqueta con el texto "BIBLIOTECA"
		lblNewLabel_1.setForeground(new Color(113, 58, 190));  // Establece el color del texto de la etiqueta
		lblNewLabel_1.setFont(new Font("Segoe Print", Font.BOLD, 24));  // Establece la fuente y el tamaño del texto de la etiqueta
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);  // Establece la alineación horizontal del texto
		lblNewLabel_1.setBounds(332, 10, 163, 56);  // Establece las dimensiones y la posición de la etiqueta
		panel.add(lblNewLabel_1);  // Añade la etiqueta al panel

		btnVolver = new JButton("");  // Crea un nuevo botón sin texto
		btnVolver.setBackground(new Color(229, 207, 247));  // Establece el color de fondo del botón
		btnVolver.setIcon(new ImageIcon(PantallaAñadirLibros.class.getResource("/imagenes/flecha-circulo-izquierda (1).png")));  // Establece un ícono al botón
		btnVolver.addActionListener(new ActionListener() {  // Agrega un ActionListener para eventos de clic 
		    public void actionPerformed(ActionEvent e) {  
		        dispose();  // Cierra la ventana actual
		        GestorBiblioteca miPrincipal = new GestorBiblioteca();  // Crea una nueva instancia de GestorBiblioteca
		        miPrincipal.setVisible(true);  // Hace visible la nueva instancia de GestorBiblioteca
		    }
		});
		btnVolver.setBounds(31, 20, 85, 41);  // Establece las dimensiones y la posición del botón
		btnVolver.setBorder(null);  // Elimina el borde del botón
		btnVolver.setFocusPainted(false); 
		panel.add(btnVolver);  // Añade el botón al panel

		lblNewLabel = new JLabel("");  // Crea una nueva etiqueta sin texto
		lblNewLabel.setIcon(new ImageIcon(PantallaAñadirLibros.class.getResource("/imagenes/libro-cubierta-abierta (2).png")));  // Establece un ícono a la etiqueta
		lblNewLabel.setBounds(497, 13, 40, 56);  // Establece las dimensiones y la posición de la etiqueta
		panel.add(lblNewLabel);  // Añade la etiqueta al panel

		btnCerrar = new JButton("");  // Crea un nuevo botón sin texto
		btnCerrar.setBackground(new Color(229, 207, 247));  // Establece el color de fondo del botón
		btnCerrar.setIcon(new ImageIcon(GestorBiblioteca.class.getResource("/imagenes/circulo-marca-x.png")));  // Establece un ícono al botón
		btnCerrar.addActionListener(new ActionListener() {  
		    public void actionPerformed(ActionEvent e) {  
		        dispose();  // Cierra la ventana actual
		    }
		});
		btnCerrar.setBounds(838, 0, 48, 33);  // Establece las dimensiones y la posición del botón
		btnCerrar.setBorder(null);  // Elimina el borde del botón
		btnCerrar.setFocusPainted(false);  
		panel.add(btnCerrar);  // Añade el botón al panel

		scrollPane = new JScrollPane();  // Crea un nuevo panel con barra de desplazamiento
		scrollPane.setBounds(49, 100, 792, 440);  // Establece las dimensiones y la posición del panel con barra de desplazamiento
		contentPane.add(scrollPane);  // Añade el panel con barra de desplazamiento al contenido del panel principal
		
		tableHistorial = new JTable(); // Crea una tabla
		scrollPane.setViewportView(tableHistorial); // La añado al scrollPane
		tableHistorial.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));

		// Creo el modelo de mi tabla, el cuál tiene 6 columnas de tipo Object
		modelo = new DefaultTableModel(new Object[][] {},
				new String[] { "TÍTULO", "AUTOR", "ISBN", "PRESTADO A", "FECHA", "DEVOLVER" }) {
			Class[] columnTypes = new Class[] { Object.class, Object.class, Object.class, Object.class, Object.class,
					Object.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

		};
		tableHistorial.setModel(modelo);
		// Establezco el ancho de las columnas
		tableHistorial.getColumnModel().getColumn(0).setPreferredWidth(130);
		tableHistorial.getColumnModel().getColumn(1).setPreferredWidth(120);
		tableHistorial.getColumnModel().getColumn(2).setPreferredWidth(90);
		tableHistorial.getColumnModel().getColumn(3).setPreferredWidth(120);
		tableHistorial.getColumnModel().getColumn(4).setPreferredWidth(120);

		TableColumn columnaBoton = tableHistorial.getColumnModel().getColumn(5); // Última columna para los botones
		columnaBoton.setCellRenderer(new BotonRenderer()); // Creo un objeto de BotonRenderer
		columnaBoton.setCellEditor(new BotonEditor(tableHistorial, modelo)); // Creo un objeto de BotonEditor
		BotonEditor botonEditor = new BotonEditor(tableHistorial, modelo);
		// Fichero donde se encuentran los libros prestados
		File archivo = new File("src/prestamos.txt");
		// Bloque try-catch para manejar excepciones
		try {
			// FileReader y BufferedReader para leer el contenido del fichero
			FileReader fr = new FileReader(archivo);
			BufferedReader br = new BufferedReader(fr);
			String linea;
			// Se lee linea a linea hasta que se termina el contenido
			while ((linea = br.readLine()) != null) {
				// Con el split separo los datos
				String[] datos = linea.split(",");
				// Añado el titulo, autor, isbn, a quién se prestó y la fecha del préstamo como una fila nueva a la tabla
				if (datos.length > 3) {
					modelo.addRow(new Object[] { datos[1], datos[2], datos[3], datos[0], datos[4] });

				} 

			}

			fr.close();
			br.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
// Esta clase renderiza los botones y es necesaria 
class BotonRenderer extends DefaultTableCellRenderer {
	private JButton boton = new JButton("Devolver");

	public BotonRenderer() {
		boton.setOpaque(true);
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		return boton;
	}
}
// Esta clase crea el propio botón
class BotonEditor extends DefaultCellEditor {
	private JButton boton = new JButton("Devolver");
	private JTable miTabla; // Atributo tabla ya que como está en otra clase se la pasaré por constructor
	private DefaultTableModel modelo; // Atributo modelo ya que como está en otra clase se lo pasaré por constructor

	public BotonEditor(JTable tableHistorial, DefaultTableModel modelo) {
		super(new JCheckBox());
		this.miTabla = tableHistorial;
		this.modelo = modelo;
		boton.addActionListener(new ActionListener() { // ActionListener para eventos de clic
			@Override
			public void actionPerformed(ActionEvent e) {
				File archivoLibros = new File("src/biblioteca.txt"); // Fichero que contiene los libros de la biblioteca
				File archivoPrestamos = new File("src/prestamos.txt"); // Fichero que contiene los libros prestados
				File tempFile = new File("src/temp2.txt"); // Fichero temporal que nos servirá de auxiliar
				// Bloque try-catch para manejar excepciones
				try {
					// FileReader y BufferedReader para leer el contenido del fichero de préstamos
					FileReader fr = new FileReader(archivoPrestamos);
					BufferedReader br = new BufferedReader(fr);
					String linea;
					// Este BufferedWriter escribirá en el fichero temporal
					BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
					int selectedRow = miTabla.getSelectedRow(); // Guardo el numero de la fila de la cual pulsas el botón
					// De cada columna almaceno su contenido en estas variables
					String nombreCol = ((String) miTabla.getValueAt(selectedRow, 3));
					String tituloCol = ((String) miTabla.getValueAt(selectedRow, 0));
					String autorCol = ((String) miTabla.getValueAt(selectedRow, 1));
					String isbnCol = ((String) miTabla.getValueAt(selectedRow, 2));
					// Se lee línea a línea hasta que se termine el contenido
					while ((linea = br.readLine()) != null) {
						// Un split para obtener los datos del libro ya que yo los he separado con comas
						String[] datos = linea.split(",");
						String nombreUsuario = datos[0];
						String tituloLibro = datos[1];
						String autorLibro = datos[2];
						String isbnLibro = datos[3];
						// Se comprueba si el texto de las columnas coincide con algún nombre,título, autor e isbn del fichero
						if (nombreCol.equalsIgnoreCase(nombreUsuario) && tituloCol.equalsIgnoreCase(tituloLibro)
								&& autorCol.equalsIgnoreCase(autorLibro) && isbnCol.equalsIgnoreCase(isbnLibro)) {
							// En tal caso, se escribe la información del libro en el fichero de prestamos, separada por comas
							FileWriter fw = new FileWriter(archivoLibros, true);
							BufferedWriter bw = new BufferedWriter(fw);
							bw.write(tituloCol + "," + autorCol + "," + isbnCol + "\n");
							bw.flush();

							modelo.removeRow(selectedRow); // Elimino esa fila de la tabla
							// Cierro el FileWriter y BufferedWriter
							fw.close();
							bw.close();
						} else {
							writer.write(linea + System.getProperty("line.separator"));//Escribe en el fichero temporal todos los libros menos el que coincide con los datos 
							// introducidos, ya que ese no lo queremos conservar en el fichero de los prestamos (los que se pueden devolver)

						}

					}
					// Cierro el FileReader y BufferedReader
					fr.close();
					br.close();
					writer.close();
					archivoPrestamos.delete(); // Se elimina el fichero original
					tempFile.renameTo(archivoPrestamos); // Se renombra el fichero temporal ya que es el que no contiene el libro devuelto

				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
		});
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		return boton;
	}

	@Override
	public Object getCellEditorValue() {
		return "Devolver";
	}
}
