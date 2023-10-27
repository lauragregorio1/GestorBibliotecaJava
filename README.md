# GestorBibliotecaJava
Una aplicación de escritorio orientada a gestionar los libros de una biblioteca (añadir, pedir, devolver) utilizando ficheros para guardar y leer la información.


**Descripción General**


El programa Java es una aplicación de gestión de una biblioteca. Proporciona funcionalidades para buscar libros, añadir nuevos libros, prestar y devolver libros. La aplicación utiliza dos archivos de texto para almacenar información sobre los libros y los préstamos en los cuales los datos están separados con comas.


**Procesos y Servicios Ofrecidos**

1. Buscar Libros [Ver Código](src/Clases/GestorBiblioteca.java#L198)

* Descripción: Este proceso busca libros en la biblioteca según el contenido proporcionado en un campo de texto.
* Funcionamiento:
* Lee el contenido de dos archivos (biblioteca.txt y prestamos.txt).
* Compara el contenido con los datos de los libros.
* Muestra la información del libro si se encuentra, incluyendo título, autor, ISBN y disponibilidad.
* Ofrece la opción de pedir el libro.
* Si no se encuentra en la biblioteca, verifica si está prestado y muestra el estado.

  
2. Añadir Libros [Ver Código](src/Clases/PantallaAñadirLibros.java#L169)
* Descripción: Este servicio permite añadir nuevos libros a la biblioteca.
* Funcionamiento:
* Escribe los detalles del nuevo libro en el archivo biblioteca.txt.
* Verifica que los campos de texto no estén vacíos antes de añadir el libro.
* Muestra un mensaje de confirmación si el libro se añade correctamente.

  
3. Pedir Libros [Ver Código](src/Clases/PantallaPedirLibros.java#L207)
* Descripción: Este servicio permite a un usuario pedir un libro prestado.
* Funcionamiento:
* Lee los archivos biblioteca.txt y prestamos.txt.
* Compara los detalles del libro solicitado con los libros disponibles para préstamo.
* Si el libro está disponible, lo añade al archivo de préstamos y actualiza la disponibilidad.
* Muestra un mensaje de confirmación si el préstamo se realiza correctamente.

  
4. Devolver Libros [Ver Código](src/Clases/PantallaDevolverLibros.java#L199)
* Descripción: Este servicio permite a un usuario devolver un libro prestado.
* Funcionamiento:
* Lee los archivos biblioteca.txt y prestamos.txt.
* Compara los detalles del libro devuelto con los libros en préstamo.
* Si se encuentra el libro prestado, lo añade de nuevo a la biblioteca y actualiza la disponibilidad.
* Muestra un mensaje de confirmación si la devolución se realiza correctamente.

  
**Estructuras de Datos Utilizadas**


  Los datos de los libros se almacenan en archivos de texto (biblioteca.txt y prestamos.txt) donde cada línea representa un libro con sus detalles separados por comas (título, autor, ISBN).
 Para la manipulación de datos, se utilizan FileReader, BufferedReader, FileWriter y BufferedWriter para lectura y escritura en los archivos.

 
  **Datos de Entrada, Internos y de Salida**

  
* Entrada:
 En los métodos buscarLibros, añadirLibros, pedirLibros y devolverLibros, se reciben parámetros como título, autor, ISBN, nombre de usuario, etc., según el proceso que se esté realizando.
* Internos:
 Se utilizan variables internas como archivo, archivoPrestamos, fr, br, linea, writer, etc., para el manejo de archivos y lectura de datos.
* Salida:
 Se muestran mensajes en la interfaz gráfica (JLabels) para indicar el estado del proceso, como si el libro se ha encontrado, añadido, prestado o devuelto correctamente.


**Notas Adicionales**


 La aplicación hace uso de interfaz gráfica Java Swing, utilizando componentes como JLayeredPane, JLabel, JButton, etc., para presentar la información y permitir interacciones con el usuario. He creado 5 clases, cada una representando a una de las pantallas del proyecto.





