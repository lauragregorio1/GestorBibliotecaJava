package Clases;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class PantallaPedirLibros extends JFrame {

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
	private JButton btnPedir;
	private JButton btnVolver;
	private boolean estaDisponible = false;
	private JLabel lblNewLabel;
	private Date fechaHoraActual = new Date();
	private JLabel lblExiste;
	private JLabel lblNoExiste;
	private JButton btnCerrar;

	public static void main(String[] args) {

	}

	public PantallaPedirLibros() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Establece el cierre de la ventana al hacer clic en la "X" de la esquina
		setBounds(100, 100, 900, 600);  // Establece el tamaño y la posición de la ventana
		contentPane = new JPanel();  // Crea un nuevo panel
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));  
		setTitle("Pedir libros");  // Establece el título de la ventana
		setContentPane(contentPane);  
		contentPane.setLayout(null); 

		panel = new JPanel();  // Crea un nuevo panel
		panel.setBackground(new Color(229, 207, 247));  // Establece el color de fondo del panel
		panel.setBounds(0, 0, 886, 76);  // Establece las dimensiones y la posición del panel
		contentPane.add(panel);  // Añade el panel al contenido del panel principal
		panel.setLayout(null);  

		JLabel lblNewLabel_1 = new JLabel("BIBLIOTECA");  // Crea una nueva etiqueta con el texto "BIBLIOTECA"
		lblNewLabel_1.setForeground(new Color(113, 58, 190));  // Establece el color del texto
		lblNewLabel_1.setFont(new Font("Segoe Print", Font.BOLD, 24));  // Establece la fuente y el estilo del texto
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);  // Establece la alineación del texto
		lblNewLabel_1.setBounds(332, 10, 163, 56);  // Establece las dimensiones y la posición de la etiqueta
		panel.add(lblNewLabel_1);  // Añade la etiqueta al panel

		btnVolver = new JButton("");  // Crea un nuevo botón sin texto
		btnVolver.setBackground(new Color(229, 207, 247));  // Establece el color de fondo del botón
		btnVolver.setIcon(new ImageIcon(PantallaAñadirLibros.class.getResource("/imagenes/flecha-circulo-izquierda (1).png")));  // Asigna un ícono al botón
		btnVolver.addActionListener(new ActionListener() {  // Agrega un ActionListener al botón para eventos de clic
		    public void actionPerformed(ActionEvent e) { 
		        dispose();  // Cierra la ventana actual
		        GestorBiblioteca miPrincipal = new GestorBiblioteca();  // Crea una nueva instancia de la clase GestorBiblioteca
		        miPrincipal.setVisible(true);  // Hace visible la nueva instancia
		    }
		});
		btnVolver.setBounds(31, 20, 85, 41);  // Establece las dimensiones y la posición del botón
		btnVolver.setBorder(null);  // Elimina el borde del botón
		btnVolver.setFocusPainted(false);  // Deshabilita el efecto de enfoque al hacer clic
		panel.add(btnVolver);  // Añade el botón al panel

		JLabel lblNewLabel = new JLabel("");  // Crea una nueva etiqueta sin texto
		lblNewLabel.setIcon(new ImageIcon(PantallaAñadirLibros.class.getResource("/imagenes/libro-cubierta-abierta (2).png")));  // Asigna un ícono a la etiqueta
		lblNewLabel.setBounds(497, 13, 40, 56);  // Establece las dimensiones y la posición de la etiqueta
		panel.add(lblNewLabel);  // Añade la etiqueta al panel

		btnCerrar = new JButton("");  // Crea un nuevo botón sin texto
		btnCerrar.setBackground(new Color(229, 207, 247));  // Establece el color de fondo del botón
		btnCerrar.setIcon(new ImageIcon(GestorBiblioteca.class.getResource("/imagenes/circulo-marca-x.png")));  // Asigna un ícono al botón
		btnCerrar.addActionListener(new ActionListener() {  // Agrega un ActionListener al botón para eventos de clic
		    public void actionPerformed(ActionEvent e) {  
		        dispose();  // Cierra la ventana actual
		    }
		});
		btnCerrar.setBounds(838, 0, 48, 33);  // Establece las dimensiones y la posición del botón
		btnCerrar.setBorder(null);  // Elimina el borde del botón
		btnCerrar.setFocusPainted(false); // Deshabilita el efecto de enfoque al hacer clic
		panel.add(btnCerrar);  // Añade el botón al panel


		lblNombre = new JLabel("NOMBRE:");  // Crea una nueva etiqueta con el texto "NOMBRE:"
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));  // Establece el tamaño y estilo de fuente de la etiqueta
		lblNombre.setBounds(235, 148, 86, 28);  // Establece las dimensiones y la posición de la etiqueta
		contentPane.add(lblNombre);  // Añade la etiqueta al panel de contenido

		lblTitulo = new JLabel("TÍTULO:");  // Crea una nueva etiqueta con el texto "TÍTULO:"
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 18));  // Establece el tamaño y estilo de fuente de la etiqueta
		lblTitulo.setBounds(235, 224, 86, 28);  // Establece las dimensiones y la posición de la etiqueta
		contentPane.add(lblTitulo);  // Añade la etiqueta al panel de contenido

		lblAutor = new JLabel("AUTOR:");  // Crea una nueva etiqueta con el texto "AUTOR:"
		lblAutor.setFont(new Font("Tahoma", Font.PLAIN, 18));  // Establece el tamaño y estilo de fuente de la etiqueta
		lblAutor.setBounds(235, 309, 86, 28);  // Establece las dimensiones y la posición de la etiqueta
		contentPane.add(lblAutor);  // Añade la etiqueta al panel de contenido

		lblIsbn = new JLabel("ISBN:");  // Crea una nueva etiqueta con el texto "ISBN:"
		lblIsbn.setFont(new Font("Tahoma", Font.PLAIN, 18));  // Establece el tamaño y estilo de fuente de la etiqueta
		lblIsbn.setBounds(235, 395, 86, 28);  // Establece las dimensiones y la posición de la etiqueta
		contentPane.add(lblIsbn);  // Añade la etiqueta al panel de contenido

		textFieldNombre = new JTextField();  // Crea un nuevo campo de texto para el nombre
		textFieldNombre.setBounds(343, 148, 319, 27);  // Establece las dimensiones y la posición del campo de texto
		textFieldNombre.setColumns(100);  // Establece el número de columnas del campo de texto
		textFieldNombre.addKeyListener(new KeyAdapter() {  
		    @Override
		    public void keyReleased(KeyEvent e) {  // Define el comportamiento cuando se libera una tecla
		        habilitarBoton();  // Llama a un método para habilitar un botón 
		    }
		});
		contentPane.add(textFieldNombre);  // Añade el campo de texto al panel de contenido


		textFieldTitulo = new JTextField();  // Crea un nuevo campo de texto para el título
		textFieldTitulo.setColumns(100);  // Establece el número de columnas del campo de texto
		textFieldTitulo.setBounds(343, 225, 319, 27);  // Establece las dimensiones y la posición del campo de texto
		textFieldTitulo.addKeyListener(new KeyAdapter() {  
		    @Override
		    public void keyReleased(KeyEvent e) {  
		        habilitarBoton();  
		    }
		});
		contentPane.add(textFieldTitulo);  // Añade el campo de texto al panel de contenido

		textFieldAutor = new JTextField();  // Crea un nuevo campo de texto para el autor
		textFieldAutor.setColumns(100);  // Establece el número de columnas del campo de texto
		textFieldAutor.setBounds(343, 309, 319, 27);  // Establece las dimensiones y la posición del campo de texto
		textFieldAutor.addKeyListener(new KeyAdapter() {  
		    @Override
		    public void keyReleased(KeyEvent e) {  
		        habilitarBoton(); 
		    }
		});
		contentPane.add(textFieldAutor);  // Añade el campo de texto al panel de contenido

		textFieldIsbn = new JTextField();  // Crea un nuevo campo de texto para el ISBN
		textFieldIsbn.setColumns(010);  // Establece el número de columnas del campo de texto
		textFieldIsbn.setBounds(343, 399, 319, 27);  // Establece las dimensiones y la posición del campo de texto
		textFieldIsbn.addKeyListener(new KeyAdapter() {  
		    @Override
		    public void keyReleased(KeyEvent e) {  
		        habilitarBoton();  
		    }
		});
		contentPane.add(textFieldIsbn);  // Añade el campo de texto al panel de contenido

		lblExiste = new JLabel("");  // Crea una nueva etiqueta sin texto
		lblExiste.setFont(new Font("Nirmala UI", Font.BOLD, 13));  // Establece el tamaño y estilo de fuente de la etiqueta
		lblExiste.setBounds(230, 475, 400, 37);  // Establece las dimensiones y la posición de la etiqueta
		contentPane.add(lblExiste);  // Añade la etiqueta al panel de contenido

		lblNoExiste = new JLabel("");  // Crea una nueva etiqueta sin texto
		lblNoExiste.setFont(new Font("Nirmala UI", Font.BOLD, 13));  // Establece el tamaño y estilo de fuente de la etiqueta
		lblNoExiste.setBounds(230, 475, 400, 37);  // Establece las dimensiones y la posición de la etiqueta
		contentPane.add(lblNoExiste);  // Añade la etiqueta al panel de contenido

		btnPedir = new JButton("PEDIR");  // Crea un nuevo botón con el texto "PEDIR"
		btnPedir.addActionListener(new ActionListener() {  // Agrega un ActionListener para manejar eventos de clic
		    public void actionPerformed(ActionEvent e) {  // Define el comportamiento cuando se hace clic en el botón
		        lblExiste.setText("");  
		        lblNoExiste.setText(""); 

		        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yy");  // Crea un nuevo formato de fecha
		        String fechaFormateada = formato.format(fechaHoraActual);  // Formatea la fecha actual

		        pedirLibros(textFieldNombre.getText(), textFieldTitulo.getText(), textFieldAutor.getText(),
		                    textFieldIsbn.getText(), fechaFormateada);  // Llama a un método para pedir libros 
		    }
		});
		btnPedir.setForeground(new Color(229, 207, 247));  // Establece el color del texto del botón
		btnPedir.setBackground(new Color(113, 58, 190));  // Establece el color de fondo del botón
		btnPedir.setBounds(577, 477, 85, 39);  // Establece las dimensiones y la posición del botón
		btnPedir.setEnabled(false);  // Deshabilita el botón
		contentPane.add(btnPedir);  // Añade el botón al panel de contenido


	}

	public void pedirLibros(String nombre, String titulo, String autor, String isbn, String fecha) {
		 
		File archivoLibros = new File("src/biblioteca.txt"); // Fichero que contiene los libros de la biblioteca
		File archivoPrestamos = new File("src/prestamos.txt"); // Fichero que contiene los libros prestados
		File tempFile = new File("src/temp.txt"); // Fichero temporal que nos servirá de auxiliar
		
		// Bloque try-catch para manejar excepciones
		try {
			// FileReader y BufferedReader para leer el contenido del fichero de la biblioteca
			FileReader fr = new FileReader(archivoLibros);
			BufferedReader br = new BufferedReader(fr);
			String linea;
			// Este BufferedWriter escribirá en el fichero temporal
			BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
			// Se lee línea a línea hasta que se termine el contenido
			while ((linea = br.readLine()) != null) {
				// Un split para obtener los datos del libro ya que yo los he separado con comas
				String[] datos = linea.split(",");
				String tituloLibro = datos[0];
				String autorLibro = datos[1];
				String isbnLibro = datos[2];
				// Se comprueba si el texto introducido en los campos de texto coincide con algún título, autor e isbn del fichero
				if (titulo.equalsIgnoreCase(tituloLibro) && autor.equalsIgnoreCase(autorLibro)
						&& isbn.equalsIgnoreCase(isbnLibro)) {
					// En tal caso, se escribe la información del libro en el fichero de prestamos, separada por comas
					FileWriter fw = new FileWriter(archivoPrestamos, true);
					BufferedWriter bw = new BufferedWriter(fw);
					bw.write(nombre + "," + tituloLibro + "," + autorLibro + "," + isbnLibro + ","+ fecha + "\n");
					bw.flush();
					estaDisponible = true; // Esta variable la utilizo para el texto de una etiqueta que avisa al usuario si los datos son correctos
					// Cierro el FileWriter y BufferedWriter
					fw.close();
					bw.close();
				} else {
					writer.write(linea + "\n"); //Escribe en el fichero temporal todos los libros menos el que coincide con los datos 
					// introducidos, ya que ese no lo queremos conservar en el fichero de los libros (los que se pueden prestar)

				}

			}
			// Cierro el FileReader y BufferedReader
			fr.close();
			br.close();
			writer.close();
			archivoLibros.delete(); // Se elimina el fichero original
			tempFile.renameTo(archivoLibros); // Se renombra el fichero temporal ya que es el que no contiene el libro prestado

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Este condicional determinará el mensaje de aviso de si los datos son correctos en una etiqueta
		if (estaDisponible == true) {
			lblExiste.setText("Libro prestado correctamente");
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
			btnPedir.setEnabled(false); // Se deshabilita el botón
		} else {
			btnPedir.setEnabled(true); // Se habilita el botón
		}

	}

}
