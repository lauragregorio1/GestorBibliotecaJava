package Clases;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class PantallaDevolverLibros extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblNombre;
	private JLabel lblTitulo;
	private JLabel lblAutor;
	private JLabel lblIsbn;
	private JTextField textFieldNombre;
	private JTextField textFieldTitulo;
	private JTextField textFieldAutor;
	private JTextField textFieldIsbn;
	private JButton btnDevolver;
	private JButton btnVolver;
	private boolean estaDisponible = false;
	private JLabel lblExiste;
	private JLabel lblNoExiste;
	private JButton btnCerrar;

	public static void main(String[] args) {

	}

	public PantallaDevolverLibros() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Cierra la aplicación cuando se presiona el botón X
		setBounds(100, 100, 900, 600);  // Establece las dimensiones y la posición de la ventana
		contentPane = new JPanel();  // Crea un nuevo panel de contenido
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));  // Establece los márgenes del panel de contenido
		setTitle("Devolver libros");  // Establece el título de la ventana
		setContentPane(contentPane);  // Establece el panel de contenido como el contenido de la ventana
		contentPane.setLayout(null);  

		panel = new JPanel();  // Crea un nuevo panel
		panel.setBackground(new Color(229, 207, 247));  // Establece el color de fondo del panel
		panel.setBounds(0, 0, 886, 76);  // Establece las dimensiones y la posición del panel
		contentPane.add(panel);  // Añade el panel al panel de contenido
		panel.setLayout(null);  // Desactiva el layout manager para poder posicionar los elementos manualmente

		JLabel lblNewLabel_1 = new JLabel("BIBLIOTECA");  // Crea una nueva etiqueta con el texto "BIBLIOTECA"
		lblNewLabel_1.setForeground(new Color(113, 58, 190));  // Establece el color del texto de la etiqueta
		lblNewLabel_1.setFont(new Font("Segoe Print", Font.BOLD, 24));  // Establece el tipo, estilo y tamaño de fuente de la etiqueta
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);  // Establece la alineación horizontal del texto en la etiqueta
		lblNewLabel_1.setBounds(332, 10, 163, 56);  // Establece las dimensiones y la posición de la etiqueta
		panel.add(lblNewLabel_1);  // Añade la etiqueta al panel

		
		btnVolver = new JButton("");  // Crea un nuevo botón sin texto
		btnVolver.setBackground(new Color(229, 207, 247));  // Establece el color de fondo del botón
		btnVolver.setIcon(new ImageIcon(PantallaAñadirLibros.class.getResource("/imagenes/flecha-circulo-izquierda (1).png")));  // Establece un ícono al botón
		btnVolver.addActionListener(new ActionListener() {  // Agrega un ActionListener para eventos del clic
		    public void actionPerformed(ActionEvent e) { 
		        dispose();  // Cierra la ventana actual
		        GestorBiblioteca miPrincipal = new GestorBiblioteca();  // Crea una nueva instancia de GestorBiblioteca
		        miPrincipal.setVisible(true);  // Hace visible la nueva instancia de GestorBiblioteca
		    }
		});
		btnVolver.setBounds(31, 20, 85, 41);  // Establece las dimensiones y la posición del botón
		btnVolver.setBorder(null);  // Elimina el borde del botón
		btnVolver.setFocusPainted(false);  // Desactiva el efecto de enfoque al seleccionar el botón
		panel.add(btnVolver);  // Añade el botón al panel

		JLabel lblNewLabel = new JLabel("");  // Crea una nueva etiqueta sin texto
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
		btnCerrar.setFocusPainted(false);  // Desactiva el efecto de enfoque al seleccionar el botón
		panel.add(btnCerrar);  // Añade el botón al panel


		lblNombre = new JLabel("NOMBRE:");  // Crea una nueva etiqueta con el texto "NOMBRE:"
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));  // Establece la fuente y el tamaño de la etiqueta
		lblNombre.setBounds(235, 148, 86, 28);  // Establece las dimensiones y la posición de la etiqueta
		contentPane.add(lblNombre);  // Añade la etiqueta al panel

		lblTitulo = new JLabel("TÍTULO:");  // Crea una nueva etiqueta con el texto "TÍTULO:"
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 18));  // Establece la fuente y el tamaño de la etiqueta
		lblTitulo.setBounds(235, 224, 86, 28);  // Establece las dimensiones y la posición de la etiqueta
		contentPane.add(lblTitulo);  // Añade la etiqueta al panel

		lblAutor = new JLabel("AUTOR:");  // Crea una nueva etiqueta con el texto "AUTOR:"
		lblAutor.setFont(new Font("Tahoma", Font.PLAIN, 18));  // Establece la fuente y el tamaño de la etiqueta
		lblAutor.setBounds(235, 309, 86, 28);  // Establece las dimensiones y la posición de la etiqueta
		contentPane.add(lblAutor);  // Añade la etiqueta al panel

		lblIsbn = new JLabel("ISBN:");  // Crea una nueva etiqueta con el texto "ISBN:"
		lblIsbn.setFont(new Font("Tahoma", Font.PLAIN, 18));  // Establece la fuente y el tamaño de la etiqueta
		lblIsbn.setBounds(235, 395, 86, 28);  // Establece las dimensiones y la posición de la etiqueta
		contentPane.add(lblIsbn);  // Añade la etiqueta al panel

		textFieldNombre = new JTextField();  // Crea un nuevo campo de texto para el nombre
		textFieldNombre.setBounds(343, 148, 319, 27);  // Establece las dimensiones y la posición del campo de texto
		textFieldNombre.setColumns(100);  // Establece el número máximo de caracteres visibles
		textFieldNombre.addKeyListener(new KeyAdapter() {  
		    @Override
		    public void keyReleased(KeyEvent e) {
		        habilitarBoton();  
		    }
		});
		contentPane.add(textFieldNombre);  // Añade el campo de texto al panel

		textFieldTitulo = new JTextField();  // Crea un nuevo campo de texto
		textFieldTitulo.setColumns(100); // Establece el número máximo de caracteres visibles
		textFieldTitulo.setBounds(343, 225, 319, 27);  // Establece las dimensiones y la posición del campo de texto
		textFieldTitulo.addKeyListener(new KeyAdapter() {  // Agrega un KeyListener para escuchar eventos de teclado en el campo de texto
		    @Override
		    public void keyReleased(KeyEvent e) {
		        habilitarBoton();  // Llama a un método habilitarBoton cuando se libera una tecla
		    }
		});
		contentPane.add(textFieldTitulo);  // Añade el campo de texto al panel

		textFieldAutor = new JTextField();  // Crea otro nuevo campo de texto
		textFieldAutor.setColumns(100);  // Establece el ancho de la columna del campo de texto a 100
		textFieldAutor.setBounds(343, 309, 319, 27);  // Establece las dimensiones y la posición del campo de texto
		textFieldAutor.addKeyListener(new KeyAdapter() {  
		    @Override
		    public void keyReleased(KeyEvent e) {
		        habilitarBoton();  
		    }
		});
		contentPane.add(textFieldAutor);  // Añade el campo de texto al panel

		textFieldIsbn = new JTextField();  // Crea otro nuevo campo de texto
		textFieldIsbn.setColumns(100);  
		textFieldIsbn.setBounds(343, 399, 319, 27);  // Establece las dimensiones y la posición del campo de texto
		textFieldIsbn.addKeyListener(new KeyAdapter() {  
		    @Override
		    public void keyReleased(KeyEvent e) {
		        habilitarBoton(); 
		    }
		});
		contentPane.add(textFieldIsbn);  // Añade el campo de texto al panel

		
		lblExiste = new JLabel("");  // Crea una nueva etiqueta vacía
		lblExiste.setFont(new Font("Nirmala UI", Font.BOLD, 13));  // Establece la fuente y el estilo de la etiqueta
		lblExiste.setBounds(230, 475, 400, 37);  // Establece las dimensiones y la posición de la etiqueta
		contentPane.add(lblExiste);  // Añade la etiqueta al panel

		lblNoExiste = new JLabel("");  // Crea otra nueva etiqueta vacía
		lblNoExiste.setFont(new Font("Nirmala UI", Font.BOLD, 13));  // Establece la fuente y el estilo de la etiqueta
		lblNoExiste.setBounds(230, 475, 400, 37);  // Establece las dimensiones y la posición de la etiqueta
		contentPane.add(lblNoExiste);  // Añade la etiqueta al panel

		btnDevolver = new JButton("DEVOLVER");  // Crea un nuevo botón con el texto "DEVOLVER"
		btnDevolver.addActionListener(new ActionListener() {  // Agrega un ActionListener para eventos de clic 
		    public void actionPerformed(ActionEvent e) {
		        lblExiste.setText("");  // Establece el texto de la etiqueta lblExiste como vacío
		        lblNoExiste.setText("");  // Establece el texto de la etiqueta lblNoExiste como vacío
		        devolverLibros(textFieldNombre.getText(), textFieldTitulo.getText(), textFieldAutor.getText(),
		                textFieldIsbn.getText());  // Llama a un método devolverLibros
		    }
		});
		btnDevolver.setForeground(new Color(229, 207, 247));  // Establece el color del texto del botón
		btnDevolver.setBackground(new Color(113, 58, 190));  // Establece el color de fondo del botón
		btnDevolver.setBounds(550, 477, 112, 39);  // Establece las dimensiones y la posición del botón
		btnDevolver.setEnabled(false);  // Deshabilita el botón
		contentPane.add(btnDevolver);  // Añade el botón al panel


	}

	public void devolverLibros(String nombre, String titulo, String autor, String isbn) {

		File archivoLibros = new File("src/biblioteca.txt");  // Fichero que contiene los libros de la biblioteca
		File archivoPrestamos = new File("src/prestamos.txt"); // Fichero que contiene los libros prestados
		File tempFile2 = new File("src/temp2.txt"); // Fichero temporal que nos servirá de auxiliar
		
		// Bloque try-catch para manejar excepciones
		try {
			// FileReader y BufferedReader para leer el contenido del fichero de préstamos
			FileReader fr = new FileReader(archivoPrestamos);
			BufferedReader br = new BufferedReader(fr);
			String linea;
			// Este BufferedWriter escribirá en el fichero temporal
			BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile2));
			// Se lee línea a línea hasta que se termine el contenido
			while ((linea = br.readLine()) != null) {
				// Un split para obtener los datos del libro ya que yo los he separado con comas
				String[] datos = linea.split(",");
				String nombreUsuario = datos[0];
				String tituloLibro = datos[1];
				String autorLibro = datos[2];
				String isbnLibro = datos[3];
				// Se comprueba si el texto introducido en los campos de texto coincide con algún nombre,título, autor e isbn del fichero
				if (nombre.equalsIgnoreCase(nombreUsuario) && titulo.equalsIgnoreCase(tituloLibro)
						&& autor.equalsIgnoreCase(autorLibro) && isbn.equalsIgnoreCase(isbnLibro)) {
					// En tal caso, se escribe la información del libro en el fichero de prestamos, separada por comas
					FileWriter fw = new FileWriter(archivoLibros, true);
					BufferedWriter bw = new BufferedWriter(fw);
					bw.write(titulo + "," + autor + "," + isbn+"\n");
					bw.flush();
					estaDisponible = true; // Esta variable la utilizo para el texto de una etiqueta que avisa al usuario si los datos son correctos
					// Cierro el FileWriter y BufferedWriter
					fw.close();
					bw.close();
				} else {
					writer.write(linea + "\n"); //Escribe en el fichero temporal todos los libros menos el que coincide con los datos 
					// introducidos, ya que ese no lo queremos conservar en el fichero de los prestamos (los que se pueden devolver)

				}

			}
			// Cierro el FileReader y BufferedReader
			fr.close();
			br.close();
			writer.close();
			archivoPrestamos.delete();// Se elimina el fichero original
			tempFile2.renameTo(archivoPrestamos); // Se renombra el fichero temporal ya que es el que no contiene el libro devuelto
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Este condicional determinará el mensaje de aviso de si los datos son correctos en una etiqueta
		if (estaDisponible == true) {
			lblExiste.setText("Libro devuelto correctamente");
			contentPane.revalidate();
			contentPane.repaint();
		} else {
			lblNoExiste.setText("Lo sentimos, no se encuentra este libro");
			contentPane.revalidate();
			contentPane.repaint();

		}

	}
	
	// Este método sirve para habilitar el botón cuando se haya escrito algo en todos los campos de texto
	private void habilitarBoton() {
		// Se comprueba si la longitud del contenido de los campos es 0
		if (textFieldTitulo.getText().length() == 0 || textFieldAutor.getText().length() == 0
				|| textFieldIsbn.getText().length() == 0 || textFieldNombre.getText().length() == 0) {
			btnDevolver.setEnabled(false);  // Se deshabilita el botón
		} else {
			btnDevolver.setEnabled(true);  // Se habilita el botón
		}

	}

}
