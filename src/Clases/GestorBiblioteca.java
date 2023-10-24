package Clases;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.*;

import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JLayeredPane;

public class GestorBiblioteca extends JFrame {

	private JPanel contentPane;
	private JTextField txtBusqueda;
	private JButton btnBuscar;
	private JLabel lblNewLabel;
	private JButton btnMisLibros;
	private JPanel panel;
	private JPanel panelInfoLibro;
	private JLabel lblNewLabel_3;

	public static void main(String[] args) {

		GestorBiblioteca frame = new GestorBiblioteca();
		frame.setVisible(true);

	}

	public GestorBiblioteca() {
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setBounds(100, 100, 900, 600);  // Define la posición y tamaño de la ventana.
	    contentPane = new JPanel();  // Crea un nuevo panel principal.
	    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));  
	    contentPane.setBackground(Color.WHITE);  // Establece el color de fondo del panel principal.
	    setTitle("Biblioteca");  // Establece el título de la ventana.

	    setContentPane(contentPane);  
	    contentPane.setLayout(null); 

	    panel = new JPanel();  // Crea un nuevo panel.
	    panel.setBackground(new Color(229, 207, 247));  // Establece el color de fondo del panel.
	    panel.setBounds(0, 0, 886, 76);  // Establece posición y tamaño del panel.
	    contentPane.add(panel);  // Añade el panel al panel principal.
	    panel.setLayout(null);  

	    JLabel lblNewLabel_1 = new JLabel("BIBLIOTECA");  // Crea una nueva etiqueta con texto "BIBLIOTECA".
	    lblNewLabel_1.setForeground(new Color(113, 58, 190));  // Establece el color del texto.
	    lblNewLabel_1.setFont(new Font("Segoe Print", Font.BOLD, 24));  // Establece la fuente y tamaño del texto.
	    lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);  // Centra el texto.
	    lblNewLabel_1.setBounds(332, 10, 163, 56);  // Establece posición y tamaño de la etiqueta.
	    panel.add(lblNewLabel_1);  // Añade la etiqueta al panel.
		
	
	    JLabel lblNewLabel = new JLabel("");
	    lblNewLabel.setIcon(new ImageIcon(PantallaAñadirLibros.class.getResource("/imagenes/libro-cubierta-abierta (2).png"))); // Establece una imagen de icono
	    lblNewLabel.setBounds(497, 13, 40, 56); // Establece la posición y tamaño de la etiqueta.
	    panel.add(lblNewLabel); // Añade la etiqueta al panel.

	 
	    JButton btnCerrar = new JButton("");
	    btnCerrar.setBackground(new Color(229, 207, 247)); // Establece el color de fondo del botón.
	    btnCerrar.setIcon(new ImageIcon(GestorBiblioteca.class.getResource("/imagenes/circulo-marca-x.png"))); // Establece una imagen de icono
	    btnCerrar.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            dispose(); // Cierra la ventana actual.
	        }
	    });
	    btnCerrar.setBounds(838, 0, 48, 33); // Establece la posición y tamaño del botón.
	    btnCerrar.setBorder(null); // Elimina el borde del botón.
	    btnCerrar.setFocusPainted(false); // Deshabilita el efecto de enfoque al hacer clic
	    panel.add(btnCerrar); // Añade el botón al panel.

	    txtBusqueda = new JTextField();
	    txtBusqueda.setFont(new Font("Tahoma", Font.PLAIN, 12)); // Establece la fuente del texto.
	    txtBusqueda.setForeground(new Color(128, 128, 128)); // Establece el color del texto.
	    txtBusqueda.setText("Título, autor o isbn"); // Establece un texto por defecto.
	    txtBusqueda.setBounds(226, 209, 369, 37); // Establece la posición y tamaño del campo de texto.
	    txtBusqueda.addMouseListener(new MouseAdapter() {
	        @Override
	        public void mouseClicked(MouseEvent e) {
	            txtBusqueda.setText(""); // Borra el texto al hacer clic en el campo.
	            setForeground(Color.BLACK); // Establece el color del texto a negro.
	        }
	    });
	    contentPane.add(txtBusqueda); // Añade el campo de texto al panel.
	    txtBusqueda.setColumns(10); 


	    btnBuscar = new JButton("");
	    btnBuscar.setBackground(new Color(251, 236, 178)); // Establece el color de fondo del botón.
	    btnBuscar.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            try {
	                // Al hacer clic, llama a la función buscarLibros con el texto del campo de búsqueda.
	                buscarLibros(txtBusqueda.getText());
	            } catch (IOException e1) {
	                e1.printStackTrace();
	            }
	        }
	    });
	    btnBuscar.setIcon(new ImageIcon(GestorBiblioteca.class.getResource("/imagenes/lupa (1).png"))); // Asigna un ícono al botón.
	    btnBuscar.setBounds(595, 209, 66, 36); // Establece la posición y tamaño del botón.
	    btnBuscar.setBorder(null); // Elimina el borde del botón.
	    btnBuscar.setFocusPainted(false); // Deshabilita el efecto de enfoque al hacer clic
	    contentPane.add(btnBuscar); // Añade el botón al panel.

	    // Etiqueta que muestra un mensaje de búsqueda.
	    lblNewLabel_3 = new JLabel("¡Busca en nuestra amplia selección de libros!");
	    lblNewLabel_3.setForeground(new Color(0, 0, 0));
	    lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
	    lblNewLabel_3.setFont(new Font("Nirmala UI", Font.BOLD, 15));
	    lblNewLabel_3.setBounds(226, 152, 451, 37); // Establece la posición y tamaño de la etiqueta.
	    contentPane.add(lblNewLabel_3); // Añade la etiqueta al panel.

	    // Crear un botón para añadir libros.
	    btnMisLibros = new JButton("AÑADIR");
	    btnMisLibros.setBackground(new Color(251, 236, 178)); // Establece el color de fondo del botón.
	    btnMisLibros.setFont(new Font("Tahoma", Font.BOLD, 12)); // Establece la fuente del texto del botón.
	    btnMisLibros.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            dispose(); // Cierra la ventana actual.
	            PantallaAñadirLibros miPantallaLibros = new PantallaAñadirLibros(); // Crea una nueva ventana de añadir libros.
	            miPantallaLibros.setVisible(true); // La hace visible.
	        }
	    });
	    btnMisLibros.setBounds(0, 76, 147, 37); // Establece la posición y tamaño del botón.
	    contentPane.add(btnMisLibros); // Añade el botón al panel.

	    // Crear un botón para pedir libros.
	    JButton btnPrestamos = new JButton("PEDIR");
	    btnPrestamos.setBackground(new Color(251, 236, 178)); // Establece el color de fondo del botón.
	    btnPrestamos.setFont(new Font("Tahoma", Font.BOLD, 12)); // Establece la fuente del texto del botón.
	    btnPrestamos.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            dispose(); // Cierra la ventana actual.
	            PantallaPedirLibros miPantallaPedir = new PantallaPedirLibros(); // Crea una nueva ventana de pedir libros.
	            miPantallaPedir.setVisible(true); // La hace visible.
	        }
	    });
	    btnPrestamos.setBounds(147, 76, 147, 37); // Establece la posición y tamaño del botón.
	    contentPane.add(btnPrestamos); // Añade el botón al panel.

	    // Crear un botón para devolver libros.
	    JButton btnDevolverLibros = new JButton("DEVOLVER");
	    btnDevolverLibros.setBackground(new Color(251, 236, 178)); // Establece el color de fondo del botón.
	    btnDevolverLibros.setFont(new Font("Tahoma", Font.BOLD, 12)); // Establece la fuente del texto del botón.
	    btnDevolverLibros.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            dispose(); // Cierra la ventana actual.
	            PantallaDevolverLibros miPantallaDevolver = new PantallaDevolverLibros(); // Crea una nueva ventana de devolver libros.
	            miPantallaDevolver.setVisible(true); // La hace visible.
	        }
	    });
	    btnDevolverLibros.setBounds(294, 76, 147, 37); // Establece la posición y tamaño del botón.
	    contentPane.add(btnDevolverLibros); // Añade el botón al panel.

	    // Crear un botón para ver el historial.
	    JButton btnHistorial = new JButton("HISTORIAL");
	    btnHistorial.setBackground(new Color(251, 236, 178)); // Establece el color de fondo del botón.
	    btnHistorial.setFont(new Font("Tahoma", Font.BOLD, 12)); // Establece la fuente del texto del botón.
	    btnHistorial.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            dispose(); // Cierra la ventana actual.
	            PantallaHistorial miPantallaHistorial = new PantallaHistorial(); // Crea una nueva ventana de historial.
	            miPantallaHistorial.setVisible(true); // La hace visible.
	        }
	    });
	    btnHistorial.setBounds(440, 76, 147, 37); // Establece la posición y tamaño del botón.
	    contentPane.add(btnHistorial); // Añade el botón al panel.


	}

	public void buscarLibros(String contenido) throws IOException {

		// Crea los ficheros utilizando su ruta
		File archivo = new File("src/biblioteca.txt");
		File archivoPrestamos = new File("src/prestamos.txt");
		// Crea una layeredPPane para superponer varias etiquetas
		
		// Para que no se superpongan las etiquetas que muestran la información, recorro el contenido de mi contentPane y en caso
		// de encontrar un JLayeredPane (donde aparece la info del libro buscado) lo elimina
		for (int i = 0; i < contentPane.getComponentCount(); i++) {
			Component component = contentPane.getComponent(i);

		    if (component instanceof JLayeredPane) {

		        contentPane.remove(component);

		    }
		}
		// Después creo uno nuevo para tener nueva informacióm
		JLayeredPane layeredPane = new JLayeredPane(); // Posición y tamaño
		layeredPane.setBounds(170, 190, 435, 350);
		contentPane.add(layeredPane);
		// Bloque try-catch para manejar excepciones
		try {
			// FileReader y BufferedReader para leer el contenido del fichero biblioteca
			FileReader fr = new FileReader(archivo);
			BufferedReader br = new BufferedReader(fr);
			String linea;
			// Se lee línea a línea hasta que se termine el contenido
			while ((linea = br.readLine()) != null) {
				// Un split para obtener los datos del libro ya que yo los he separado con comas
				String[] datos = linea.split(",");
				String titulo = datos[0];
				String autor = datos[1];
				String isbn = datos[2];
				// Si el texto introducido en el campo de texto coincide con algún título, autor o isbn del fichero, se muestra
				// por pantalla la información de dicho libro y si está o no disponible
				if (contenido.equalsIgnoreCase(titulo) || contenido.equalsIgnoreCase(autor)
						|| contenido.equalsIgnoreCase(isbn)) {

					// Crear etiquetas para mostrar información del libro.
					JLabel lblTituloPrest = new JLabel(titulo); // Crea una etiqueta con el título del libro.
					lblTituloPrest.setFont(new Font("Nirmala UI", Font.BOLD, 13)); // Establece la fuente y estilo del texto.
					lblTituloPrest.setBounds(226, 100, 400, 37); // Establece la posición y tamaño de la etiqueta.

					JLabel lblAutorPrest = new JLabel(autor); // Crea una etiqueta con el autor del libro.
					lblAutorPrest.setFont(new Font("Nirmala UI", Font.BOLD, 13)); // Establece la fuente y estilo del texto.
					lblAutorPrest.setBounds(226, 120, 400, 37); // Establece la posición y tamaño de la etiqueta.

					JLabel lblISBNPrest = new JLabel(isbn); // Crea una etiqueta con el ISBN del libro.
					lblISBNPrest.setFont(new Font("Nirmala UI", Font.BOLD, 13)); // Establece la fuente y estilo del texto.
					lblISBNPrest.setBounds(226, 140, 400, 37); // Establece la posición y tamaño de la etiqueta.

					JLabel lblDisponiblePrest = new JLabel("Disponible"); // Crea una etiqueta indicando que el libro está disponible.
					lblDisponiblePrest.setFont(new Font("Nirmala UI", Font.BOLD, 13)); // Establece la fuente y estilo del texto.
					lblDisponiblePrest.setBounds(226, 160, 400, 37); // Establece la posición y tamaño de la etiqueta.

					// Crear un botón para pedir el libro.
					JButton btnPedir = new JButton("PEDIR"); // Crea un botón con el texto "PEDIR".
					btnPedir.setFont(new Font("Tahoma", Font.PLAIN, 10)); // Establece la fuente y estilo del texto del botón.
					btnPedir.setBounds(226, 200, 80, 25); // Establece la posición y tamaño del botón.
					btnPedir.addActionListener(new ActionListener() {
					    public void actionPerformed(ActionEvent e) {
					        PantallaPedirLibros miPantallaPedir = new PantallaPedirLibros(); // Crea una nueva ventana para pedir libros.
					        miPantallaPedir.setVisible(true); // La hace visible.
					        miPantallaPedir.revalidate(); // Revalida la ventana.
					        miPantallaPedir.repaint(); // Vuelve a pintar la ventana.
					    }
					});

					// Crear una etiqueta de imagen.
					JLabel lblNewLabel_2 = new JLabel(""); // Crea una etiqueta sin texto.
					lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER); // Establece la alineación del contenido.
					lblNewLabel_2.setIcon(new ImageIcon(GestorBiblioteca.class.getResource("/imagenes/libro.png"))); // Asigna una imagen a la etiqueta.
					lblNewLabel_2.setBounds(50, 50, 435, 300); // Establece la posición y tamaño de la etiqueta.

					// Actualizar el contenido del JLayeredPane.

					layeredPane.add(lblNewLabel_2, JLayeredPane.DEFAULT_LAYER); // Añade la etiqueta de imagen al fondo.
					layeredPane.add(lblTituloPrest, JLayeredPane.PALETTE_LAYER); // Añade la etiqueta del título en una capa superior.
					layeredPane.add(lblAutorPrest, JLayeredPane.PALETTE_LAYER); // Añade la etiqueta del autor en una capa superior.
					layeredPane.add(lblISBNPrest, JLayeredPane.PALETTE_LAYER); // Añade la etiqueta del ISBN en una capa superior.
					layeredPane.add(lblDisponiblePrest, JLayeredPane.PALETTE_LAYER); // Añade la etiqueta de disponibilidad en una capa superior.
					layeredPane.add(btnPedir, JLayeredPane.PALETTE_LAYER); // Añade el botón de pedir en una capa superior.
					contentPane.add(layeredPane);

					// Actualizar el contenido del panel principal.
					contentPane.revalidate(); // Revalida el contenido del panel.
					contentPane.repaint(); // Vuelve a pintar el contenido del panel.

				// Si no se encuentra el libro en la bibioteca, puede estar prestado.
				// En ese caso leeremos el archivo de préstamos
				} else {
					// FileReader y BufferedReader para leer el contenido del fichero
					FileReader frPrest = new FileReader(archivoPrestamos);
					BufferedReader brPrest = new BufferedReader(frPrest);
					String lineaPrest;
					// Se lee línea a línea hasta que se termine el contenido
					while ((lineaPrest = brPrest.readLine()) != null) {
						// Un split para obtener los datos del libro
						String[] datosPrest = lineaPrest.split(",");
						String tituloPrest = datosPrest[1];
						String autorPrest = datosPrest[2];
						String isbnPrest = datosPrest[3];
						// Si el texto introducido en el campo de texto coincide con algún título, autor o isbn del fichero, se muestra
						// por pantalla la información de dicho libro y si está o no disponible
						if (contenido.equalsIgnoreCase(tituloPrest) || contenido.equalsIgnoreCase(autorPrest)
								|| contenido.equalsIgnoreCase(isbnPrest)) {

							// Crear etiquetas para mostrar información del libro prestado.
							JLabel lblTituloPrest = new JLabel(tituloPrest); // Crea una etiqueta con el título del libro prestado.
							lblTituloPrest.setFont(new Font("Nirmala UI", Font.BOLD, 13)); // Establece la fuente y estilo del texto.
							lblTituloPrest.setBounds(226, 100, 400, 37); // Establece la posición y tamaño de la etiqueta.

							JLabel lblAutorPrest = new JLabel(autorPrest); // Crea una etiqueta con el autor del libro prestado.
							lblAutorPrest.setFont(new Font("Nirmala UI", Font.BOLD, 13)); // Establece la fuente y estilo del texto.
							lblAutorPrest.setBounds(226, 120, 400, 37); // Establece la posición y tamaño de la etiqueta.

							JLabel lblISBNPrest = new JLabel(isbnPrest); // Crea una etiqueta con el ISBN del libro prestado.
							lblISBNPrest.setFont(new Font("Nirmala UI", Font.BOLD, 13)); // Establece la fuente y estilo del texto.
							lblISBNPrest.setBounds(226, 140, 400, 37); // Establece la posición y tamaño de la etiqueta.

							JLabel lblDisponiblePrest = new JLabel("Prestado"); // Crea una etiqueta indicando que el libro está prestado.
							lblDisponiblePrest.setFont(new Font("Nirmala UI", Font.BOLD, 13)); // Establece la fuente y estilo del texto.
							lblDisponiblePrest.setBounds(226, 160, 400, 37); // Establece la posición y tamaño de la etiqueta.

							// Crear una etiqueta de imagen.
							JLabel lblNewLabel_2 = new JLabel(""); // Crea una etiqueta sin texto.
							lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER); // Establece la alineación del contenido.
							lblNewLabel_2.setIcon(new ImageIcon(GestorBiblioteca.class.getResource("/imagenes/libro.png"))); // Asigna una imagen a la etiqueta.
							lblNewLabel_2.setBounds(50, 50, 435, 300); // Establece la posición y tamaño de la etiqueta.

							// Actualizar el contenido del JLayeredPane.

							layeredPane.add(lblNewLabel_2, JLayeredPane.DEFAULT_LAYER); // Añade la etiqueta de imagen al fondo.
							layeredPane.add(lblTituloPrest, JLayeredPane.PALETTE_LAYER); // Añade la etiqueta del título en una capa superior.
							layeredPane.add(lblAutorPrest, JLayeredPane.PALETTE_LAYER); // Añade la etiqueta del autor en una capa superior.
							layeredPane.add(lblISBNPrest, JLayeredPane.PALETTE_LAYER); // Añade la etiqueta del ISBN en una capa superior.
							layeredPane.add(lblDisponiblePrest, JLayeredPane.PALETTE_LAYER); // Añade la etiqueta de disponibilidad en una capa superior.
							contentPane.add(layeredPane);
							// Actualizar el contenido del panel principal.
							contentPane.revalidate(); // Revalida el contenido del panel.
							contentPane.repaint(); // Vuelve a pintar el contenido del panel.


						}

					}


				}
			}
			// Cierra los FileReader y BufferedReader
			fr.close();
			br.close();
			

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
