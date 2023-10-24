package Clases;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class PantallaAñadirLibros extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JTextField textFieldTitulo;
	private JTextField textFieldAutor;
	private JTextField textFieldISBN;
	private JButton btnAñadir;
	private JButton btnVolver;
	private JButton btnCerrar;
	private JLabel lblTitulo;
	private JLabel lblAutor;
	private JLabel lblISBN;
	private JLabel lblNewLabel_1;

	public static void main(String[] args) {
		PantallaAñadirLibros frame = new PantallaAñadirLibros();

	}

	public PantallaAñadirLibros() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Establece el comportamiento de cierre de la ventana
		setBounds(100, 100, 900, 600);  // Define las dimensiones y la posición de la ventana
		contentPane = new JPanel();  // Crea un nuevo panel principal
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); 
		setTitle("Mis libros");  // Asigna un título a la ventana
		setContentPane(contentPane);  // Establece el panel principal como el contenido de la ventana
		contentPane.setLayout(null); 

		panel = new JPanel();  // Crea un nuevo panel para el encabezado
		panel.setBackground(new Color(229, 207, 247));  // Establece el color de fondo del panel de encabezado
		panel.setBounds(0, 0, 886, 76);  // Define las dimensiones y la posición del panel de encabezado
		contentPane.add(panel);  // Añade el panel de encabezado al contenido de la ventana
		panel.setLayout(null);  

		lblNewLabel_1 = new JLabel("BIBLIOTECA");  // Crea una etiqueta con el texto "BIBLIOTECA"
		lblNewLabel_1.setForeground(new Color(113, 58, 190));  // Establece el color del texto de la etiqueta
		lblNewLabel_1.setFont(new Font("Segoe Print", Font.BOLD, 24));  // Establece la fuente y el tamaño del texto de la etiqueta
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);  
		lblNewLabel_1.setBounds(332, 10, 163, 56);  // Define las dimensiones y la posición de la etiqueta
		panel.add(lblNewLabel_1);  // Añade la etiqueta al panel de encabezado


		btnVolver = new JButton("");  // Crea un nuevo botón sin texto
		btnVolver.setBackground(new Color(229, 207, 247));  // Establece el color de fondo del botón
		btnVolver.setIcon(new ImageIcon(PantallaAñadirLibros.class.getResource("/imagenes/flecha-circulo-izquierda (1).png")));  // Asigna un ícono al botón
		btnVolver.addActionListener(new ActionListener() {  // Agrega un ActionListener para eventos de clic
		    public void actionPerformed(ActionEvent e) { 
		        dispose();  // Cierra la ventana actual
		        GestorBiblioteca miPrincipal = new GestorBiblioteca();  // Crea una nueva instancia de GestorBiblioteca
		        miPrincipal.setVisible(true);  // Hace visible la nueva instancia
		    }
		});
		btnVolver.setBounds(31, 20, 85, 41);  // Define las dimensiones y la posición del botón
		btnVolver.setBorder(null);  // Establece el borde del botón como nulo
		btnVolver.setFocusPainted(false);  // Deshabilita el efecto de enfoque al hacer clic
		panel.add(btnVolver);  // Añade el botón al panel

		JLabel lblNewLabel = new JLabel("");  // Crea una nueva etiqueta sin texto
		lblNewLabel.setIcon(new ImageIcon(PantallaAñadirLibros.class.getResource("/imagenes/libro-cubierta-abierta (2).png")));  // Asigna un ícono a la etiqueta
		lblNewLabel.setBounds(497, 13, 40, 56);  // Define las dimensiones y la posición de la etiqueta
		panel.add(lblNewLabel);  // Añade la etiqueta al panel

		btnCerrar = new JButton("");  // Crea un nuevo botón 
		btnCerrar.setBackground(new Color(229, 207, 247));  // Establece el color de fondo del botón
		btnCerrar.setIcon(new ImageIcon(GestorBiblioteca.class.getResource("/imagenes/circulo-marca-x.png")));  // Asigna un ícono al botón
		btnCerrar.addActionListener(new ActionListener() {  // Agrega un ActionListener para eventos de clic
		    public void actionPerformed(ActionEvent e) {  
		        dispose();  // Cierra la ventana actual
		    }
		});
		btnCerrar.setBounds(838, 0, 48, 33);  // Define las dimensiones y la posición del botón
		btnCerrar.setBorder(null);  // Establece el borde del botón como nulo
		btnCerrar.setFocusPainted(false);  // Deshabilita el efecto de enfoque al hacer clic
		panel.add(btnCerrar);  // Añade el botón al panel


		lblTitulo = new JLabel("Título:");  // Crea una nueva etiqueta con el texto "Título:"
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 18));  // Establece la fuente y el tamaño del texto
		lblTitulo.setBounds(244, 153, 93, 29);  // Define las dimensiones y la posición de la etiqueta
		contentPane.add(lblTitulo);  // Añade la etiqueta al panel

		lblAutor = new JLabel("Autor:\r\n");  // Crea una nueva etiqueta con el texto "Autor:"
		lblAutor.setFont(new Font("Tahoma", Font.BOLD, 18));  // Establece la fuente y el tamaño del texto
		lblAutor.setBounds(244, 228, 93, 29);  // Define las dimensiones y la posición de la etiqueta
		contentPane.add(lblAutor);  // Añade la etiqueta al panel

		lblISBN = new JLabel("ISBN:");  // Crea una nueva etiqueta con el texto "ISBN:"
		lblISBN.setFont(new Font("Tahoma", Font.BOLD, 18));  // Establece la fuente y el tamaño del texto
		lblISBN.setBounds(244, 309, 93, 29);  // Define las dimensiones y la posición de la etiqueta
		contentPane.add(lblISBN);  // Añade la etiqueta al panel

		textFieldTitulo = new JTextField();  // Crea un nuevo campo de texto
		textFieldTitulo.setBounds(347, 157, 353, 27);  // Define las dimensiones y la posición del campo de texto
		contentPane.add(textFieldTitulo);  // Añade el campo de texto al panel
		textFieldTitulo.setColumns(100);  // Establece el número máximo de caracteres

		textFieldAutor = new JTextField();  // Crea un nuevo campo de texto
		textFieldAutor.setColumns(100);  // Establece el número máximo de caracteres
		textFieldAutor.setBounds(347, 232, 353, 27);  // Define las dimensiones y la posición del campo de texto
		contentPane.add(textFieldAutor);  // Añade el campo de texto al panel

		textFieldISBN = new JTextField();  // Crea un nuevo campo de texto
		textFieldISBN.setColumns(100);  // Establece el número máximo de caracteres
		textFieldISBN.setBounds(347, 313, 353, 27);  // Define las dimensiones y la posición del campo de texto
		contentPane.add(textFieldISBN);  // Añade el campo de texto al panel

		// Agrega un KeyListener para responder a eventos de teclado
		textFieldTitulo.addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyReleased(KeyEvent e) {
		        habilitarBoton();  // Llama a un método para habilitar un botón 
		    }
		});

		textFieldAutor.addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyReleased(KeyEvent e) { // Llama a un método para habilitar un botón 
		        habilitarBoton(); 
		    }
		});

		textFieldISBN.addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyReleased(KeyEvent e) { // Llama a un método para habilitar un botón 
		        habilitarBoton();  
		    }
		});


		btnAñadir = new JButton("AÑADIR");  // Crea un nuevo botón con el texto "AÑADIR"
		btnAñadir.addActionListener(new ActionListener() {  // Agrega un ActionListener al botón
		    public void actionPerformed(ActionEvent e) {  
		        añadirLibros(textFieldTitulo.getText(), textFieldAutor.getText(), textFieldISBN.getText());  // Llama a un método "añadirLibros" con los textos de los campos de texto
		    }
		});
		btnAñadir.setForeground(new Color(255, 255, 255));  // Establece el color del texto del botón
		btnAñadir.setBackground(new Color(113, 58, 190));  // Establece el color de fondo del botón
		btnAñadir.setBounds(615, 443, 85, 46);  // Define las dimensiones y la posición del botón
		btnAñadir.setEnabled(false);  // Deshabilita el botón
		contentPane.add(btnAñadir);  // Añade el botón al panel

	}

	public void añadirLibros(String titulo, String autor, String isbn) {
		// Se crea un fichero con su ruta
		File archivo = new File("src/biblioteca.txt");
		// Bloque try-catch para manejar excepciones
		try {
			// FileWriter y BufferedWriter para escribir en el fichero
			FileWriter fw = new FileWriter(archivo, true);
			BufferedWriter bw = new BufferedWriter(fw);
			// Se comprueba que los campos de texto no estén vacíos 
			if (!(titulo.equals("") && autor.equals("") && isbn.equals(""))) {
				// Escribe en el fichero, separados por comas, el contenido de cada campo de texto
				bw.write(titulo + "," + autor + "," + isbn + "\n");
				bw.flush();
				// Se crea una etiqueta que servirá como aviso de que el libro se ha añadido correctamente
				JLabel lblCorrecto = new JLabel();
				lblCorrecto.setText("Libro añadido correctamente");
				lblCorrecto.setFont(new Font("Nirmala UI", Font.BOLD, 13));
				lblCorrecto.setBounds(240, 455, 400, 37);
				contentPane.add(lblCorrecto); // La añado al panel principal
				contentPane.revalidate();
				contentPane.repaint();
			}

			// Cierra el FileWriter y el BufferedWriter
			fw.close();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	// Este método sirve para habilitar el botón cuando se haya escrito algo en todos los campos de texto
	private void habilitarBoton() {
		// Se comprueba si la longitud del contenido de los campos es 0
		if (textFieldTitulo.getText().length() == 0 || textFieldAutor.getText().length() == 0
				|| textFieldISBN.getText().length() == 0) {
			btnAñadir.setEnabled(false); // Se deshabilita el botón
		} else {
			btnAñadir.setEnabled(true); // Se habilita el botón
		}

	}
}
