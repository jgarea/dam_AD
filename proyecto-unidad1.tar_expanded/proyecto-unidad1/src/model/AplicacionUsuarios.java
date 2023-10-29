package model;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.json.JSONWriter;

import gui.VentanaBorrarUsuario;
import gui.VentanaCambiarContraseña;
import gui.VentanaCrearUsuario;
import gui.VentanaInicioSesion;
import gui.VentanaMenuUsuario;
import gui.VentanaVerUsuario;

public class AplicacionUsuarios {

	private final String RUTA_FICHERO = "";
	private VentanaInicioSesion ventanaInicioSesion;

	private VentanaCrearUsuario ventanaCrearUsuario;
	private VentanaMenuUsuario ventanaMenuUsuario;
	private VentanaVerUsuario ventanaVerUsuario;
	private VentanaCambiarContraseña ventanaCambiarContraseña;
	private VentanaBorrarUsuario ventanaBorrarUsuario;

	/**
	 * @param ventanaInicioSesion
	 * @param ventanaCrearUsuario
	 * @param ventanaMenuUsuario
	 * @param ventanaVerUsuario
	 * @param ventanaCambiarContraseña
	 * @param ventanaBorrarUsuario
	 */
	public AplicacionUsuarios() {
		// super();
		this.ventanaInicioSesion = new VentanaInicioSesion(this);
		this.ventanaCrearUsuario = new VentanaCrearUsuario(this);
		// this.ventanaMenuUsuario = new VentanaMenuUsuario(null, RUTA_FICHERO);
		// this.ventanaVerUsuario = new VentanaVerUsuario();
		// this.ventanaCambiarContraseña = ventanaCambiarContraseña;
		// this.ventanaBorrarUsuario = ventanaBorrarUsuario;
	}

	private void crearFicheroJson() {
		try {
			// COMPROBAR

			// Especificar la ubicación del archivo JSON que deseas crear
			String filePath = "src/usuarios.json";

			// Verificar si el archivo ya existe
			File file = new File(filePath);

			if (file.exists()) {
				System.out.println("El archivo JSON ya existe.");
				return; // No es necesario crearlo de nuevo
			}
			file.createNewFile(); // sino lo crea

			// Crear un objeto JSON
			JSONObject jsonObject1 = new JSONObject();

			// Crear un arreglo JSON y agregar los objetos JSON al arreglo
			JSONArray jsonArray = new JSONArray();
			jsonArray.put(jsonObject1);

			// Escribir el contenido del arreglo JSON en el archivo
			FileWriter fileWriter = new FileWriter(filePath);
			jsonArray.write(fileWriter);

			// Cerrar el escritor de archivos
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private JSONArray obtenerUsuariosJson() {
		try {
			// Especificamos el archivo JSON
			String filePath = "src/usuarios.json";

			// Leemos el archivo JSON
			FileReader reader = new FileReader(filePath);

			// Creamos un JSONTokener para tokenizar el archivo
			JSONTokener tokener = new JSONTokener(reader);

			// Creamos un JSONArray a partir del archivo anterior
			JSONArray jsonArray = new JSONArray(tokener);

			reader.close(); // Cerramos
			return jsonArray; // devolvemos el array

		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	private int obtenerPosicionUsuario(String nombreUsuario, JSONArray usuarios) {
		for (int i = 0; i < usuarios.length(); i++) {
			JSONObject jsonObject = usuarios.getJSONObject(i);

			String nombre = jsonObject.getString("nombre");

			if (nombre.equals(nombreUsuario))
				return i;
//            System.out.println("Nombre: " + nombre);
//            System.out.println("Contraseña: " + contraseña);
//            System.out.println("Edad: " + edad);
//            System.out.println("Correo: " + correo);
//            System.out.println();
		}
		return -1;// sddsadsdas
	}

	private JSONObject obtenerUsuarioJson(String nombreUsuario) {
		JSONArray usuarios = obtenerUsuariosJson();
		for (int i = 0; i < usuarios.length(); i++) {
			JSONObject jsonObject = usuarios.getJSONObject(i);

			String nombre = jsonObject.getString("nombre");

			if (nombre.equals(nombreUsuario))
				return jsonObject;
//            System.out.println("Nombre: " + nombre);
//            System.out.println("Contraseña: " + contraseña);
//            System.out.println("Edad: " + edad);
//            System.out.println("Correo: " + correo);
//            System.out.println();
		}
		return null;// sddsadsdas

	}

	public void ejecutar() {
		crearFicheroJson();// llamamos al método
		// ventanaMenuUsuario = new VentanaMenuUsuario(this, "RUTA_FICHERO");
		// ventanaMenuUsuario.setVisible(true);
		// ventanaInicioSesion = new VentanaInicioSesion(this);
		ventanaCrearUsuario.setVisible(false);// ocultamos la ventana de crear usuario

		ventanaInicioSesion.setVisible(true);
		

	}

	public void iniciarSesion(String nombreUsuario, String contraseñaUsuario) {
		JSONArray usus = obtenerUsuariosJson(); // llamamos a la función
		// Iteramos el json con los usuarios
		for (int i = 0; i < usus.length(); i++) {
			JSONObject jsonObject = usus.getJSONObject(i);
			// cogemos nombre y contraseña
			String nombre = jsonObject.getString("nombre");
			String contraseña = jsonObject.getString("contraseña");

			if (nombre.equals(nombreUsuario) && contraseña.equals(contraseñaUsuario)) {
				mostrarVentanaMenuUsuario(nombreUsuario);
				return;
			} else if (nombre.equals(nombreUsuario) && !contraseña.equals(contraseñaUsuario)) {
				System.out.println("¡¡La contraseña es incorrecta!!");
				return;
			}

		}
		System.out.println("¡¡El usuario no existe!!");

	}

	public void cerrarSesion() {
//		JSONArray usus = obtenerUsuariosJson(); // llamamos a la función
//		// Iteramos el json con los usuarios
//		for (int i = 0; i < usus.length(); i++) {
//			JSONObject jsonObject = usus.getJSONObject(i);
//
//			String nombre = jsonObject.getString("nombre");
//			String contraseña = jsonObject.getString("contraseña");
//			int edad = jsonObject.getInt("edad");
//			String correo = jsonObject.getString("correo");
//
//			System.out.println("Nombre: " + nombre);
//			System.out.println("Contraseña: " + contraseña);
//			System.out.println("Edad: " + edad);
//			System.out.println("Correo: " + correo);
//			System.out.println();
//		}
//		JSONObject newUser = new JSONObject();
//		newUser.put("nombre", "nuevoUsuario");
//		newUser.put("contraseña", "nuevaContraseña");
//		newUser.put("edad", 25);
//		newUser.put("correo", "nuevoUsuario@correo.com");
//
//		usus.put(newUser);
//		try {
//
//			String filePath = "src/usuarios.json";
//			// Abre el archivo JSON para escritura
//			FileWriter writer = new FileWriter(filePath);
//
//			// Escribe el contenido actualizado en el archivo
//			// JSONWriter jsonWriter = new JSONWriter(writer);
//			usus.write(writer);
//
//			// Cierra el escritor de archivos
//			writer.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		ventanaMenuUsuario.setVisible(false);// ocultamos la ventana de menú usuario
	}

	public void crearUsuario(String nombre, String contraseña, String edad, String correo) {
		JSONArray usus = obtenerUsuariosJson(); // llamamos a la función
		// Iteramos el json con los usuarios
//		for (int i = 0; i < usus.length(); i++) {
//			JSONObject jsonObject = usus.getJSONObject(i);
//
//			String nombre = jsonObject.getString("nombre");
//			String contraseña = jsonObject.getString("contraseña");
//			int edad = jsonObject.getInt("edad");
//			String correo = jsonObject.getString("correo");
//
//			System.out.println("Nombre: " + nombre);
//			System.out.println("Contraseña: " + contraseña);
//			System.out.println("Edad: " + edad);
//			System.out.println("Correo: " + correo);
//			System.out.println();
//		}
		JSONObject newUser = new JSONObject();
		newUser.put("nombre", nombre);
		newUser.put("contraseña", contraseña);
		newUser.put("edad", edad);
		newUser.put("correo", correo);

		usus.put(newUser);
		try {

			String filePath = "src/usuarios.json";
			// Abre el archivo JSON para escritura
			FileWriter writer = new FileWriter(filePath);

			// Escribe el contenido actualizado en el archivo
			// JSONWriter jsonWriter = new JSONWriter(writer);
			usus.write(writer);

			// Cierra el escritor de archivos
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void cambiarContraseña(String nombreUsuario, String nuevaContraseña) {
		JSONObject usu = obtenerUsuarioJson(nombreUsuario);
		borrarUsuario(nombreUsuario);
		usu.put("contraseña", nuevaContraseña);
		crearUsuario(nombreUsuario, nuevaContraseña, usu.getString("edad"), usu.getString("correo"));
		System.out.println("Cambio correcto");

	}

	public void borrarUsuario(String nombreUsuario) {
		JSONArray usus = obtenerUsuariosJson(); // obtenemos los usuarios
		JSONArray ususGuardados = new JSONArray(); // meteremos los usuarios que vamos a guardar
		// Iteramos el json con los usuarios
		for (int i = 0; i < usus.length(); i++) {

			JSONObject jsonObject = usus.getJSONObject(i);

			String nombre = jsonObject.getString("nombre");
			String contraseña = jsonObject.getString("contraseña");
			int edad = jsonObject.getInt("edad");
			String correo = jsonObject.getString("correo");
			if (!nombre.equals(nombreUsuario)) {
				ususGuardados.put(jsonObject);
			}
		}

		try {

			String filePath = "src/usuarios.json";
			// Abre el archivo JSON para escritura
			FileWriter writer = new FileWriter(filePath);

			// Escribe el contenido actualizado en el archivo

			ususGuardados.write(writer);

			// Cierra el escritor de archivos
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void mostrarVentanaCrearUsuario() {
		ventanaInicioSesion.setVisible(false);
		ventanaCrearUsuario.setVisible(true);

	}

	// método creado para mostrar la ventana del menú. CREADO A MAYORES
	public void mostrarVentanaMenuUsuario(String nombreUsuario) {
		ventanaInicioSesion.setVisible(false);
		ventanaMenuUsuario = new VentanaMenuUsuario(this, nombreUsuario);
		ventanaMenuUsuario.setVisible(true);// visualizamos la ventana del usuario

	}

	// método para mostrar la ventana de datos
	public void mostrarVentanaVerUsuario(String nombreUsuario) {
		// ventanaInicioSesion.setVisible(false);
		JSONObject usuario = obtenerUsuarioJson(nombreUsuario);
		ventanaVerUsuario = new VentanaVerUsuario(this, nombreUsuario, usuario.getString("edad"),
				usuario.getString("correo"));
		ventanaVerUsuario.setVisible(true);// visualizamos la ventana del usuario

	}

	public void mostrarVentanaCambiarContraseña(String nombreUsuario) {
		ventanaCambiarContraseña = new VentanaCambiarContraseña(this, nombreUsuario);
		ventanaCambiarContraseña.setVisible(true);

	}

	public void mostrarVentanaBorrarUsuario(String nombreUsuario) {
		ventanaBorrarUsuario = new VentanaBorrarUsuario(this, nombreUsuario);
		ventanaBorrarUsuario.setVisible(true);

	}

	// método para cerrar la ventana de usuario. CREADO NUEVO
	public void cerrarVerUsuario() {
		ventanaVerUsuario.setVisible(false);// cierra la ventana

	}

	// método que cuando le damos a "Cancelar" cierra la ventana de cambiar contraseña. CREADO NUEVO
	public void cerrarVentanaCambiarContraseña() {
		ventanaCambiarContraseña.setVisible(false);// cerramos la ventana de cambiar contraseña
	}

	//método que cierra la ventana de borrar Usuario
	public void cerrarVentanaBorrarUsuario() {
		ventanaBorrarUsuario.setVisible(false);
		
	}
}
