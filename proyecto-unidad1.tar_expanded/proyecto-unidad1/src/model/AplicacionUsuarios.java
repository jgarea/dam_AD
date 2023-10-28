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
		//super();
		this.ventanaInicioSesion = new VentanaInicioSesion(this);
		this.ventanaCrearUsuario = new VentanaCrearUsuario(this);
		//this.ventanaMenuUsuario = new VentanaMenuUsuario(null, RUTA_FICHERO);
		//this.ventanaVerUsuario = new VentanaVerUsuario();
		//this.ventanaCambiarContraseña = ventanaCambiarContraseña;
		//this.ventanaBorrarUsuario = ventanaBorrarUsuario;
	}

	private void crearFicheroJson() {
		try {
			//COMPROBAR
			
			
	        // Especificar la ubicación del archivo JSON que deseas crear
	        String filePath = "src/usuarios.json";

	        // Verificar si el archivo ya existe
	        File file = new File(filePath);

	        if (file.exists()) {
	            System.out.println("El archivo JSON ya existe.");
	            return; // No es necesario crearlo de nuevo
	        }
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
            return jsonArray; //devolvemos el array
        
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		return null;
	}

	private int obtenerPosicionUsuario(String nombreUsuario, JSONArray usuarios) {
		for (int i = 0; i < usuarios.length(); i++) {
            JSONObject jsonObject = usuarios.getJSONObject(i);

           
            String nombre = jsonObject.getString("nombre");
            
            if(nombre.equals(nombreUsuario))
            	return i;
//            System.out.println("Nombre: " + nombre);
//            System.out.println("Contraseña: " + contraseña);
//            System.out.println("Edad: " + edad);
//            System.out.println("Correo: " + correo);
//            System.out.println();
        }
		return -1;//sddsadsdas
	}

	private JSONObject obtenerUsuarioJson(String nombreUsuario) {
		JSONArray usuarios =obtenerUsuariosJson();
		for (int i = 0; i < usuarios.length(); i++) {
            JSONObject jsonObject = usuarios.getJSONObject(i);

           
            String nombre = jsonObject.getString("nombre");
            
            if(nombre.equals(nombreUsuario))
            	return jsonObject;
//            System.out.println("Nombre: " + nombre);
//            System.out.println("Contraseña: " + contraseña);
//            System.out.println("Edad: " + edad);
//            System.out.println("Correo: " + correo);
//            System.out.println();
        }
		return null;//sddsadsdas

	}

	public void ejecutar() {
		//ventanaMenuUsuario = new VentanaMenuUsuario(this, "RUTA_FICHERO");
		//ventanaMenuUsuario.setVisible(true);
		//ventanaInicioSesion = new VentanaInicioSesion(this);
		ventanaCrearUsuario.setVisible(false);
		ventanaInicioSesion.setVisible(true);
		
		

	}

	public void iniciarSesion(String nombreUsuario, String contraseñaUsuario) {

	}

	public void cerrarSesion() {    
		JSONArray usus = obtenerUsuariosJson(); //llamamos a la función
	            // Iteramos el json con los usuarios
	            for (int i = 0; i < usus.length(); i++) {
	                JSONObject jsonObject = usus.getJSONObject(i);

	               
	                String nombre = jsonObject.getString("nombre");
	                String contraseña = jsonObject.getString("contraseña");
	                int edad = jsonObject.getInt("edad");
	                String correo = jsonObject.getString("correo");

	                System.out.println("Nombre: " + nombre);
	                System.out.println("Contraseña: " + contraseña);
	                System.out.println("Edad: " + edad);
	                System.out.println("Correo: " + correo);
	                System.out.println();
	            }
	            JSONObject newUser = new JSONObject();
	            newUser.put("nombre", "nuevoUsuario");
	            newUser.put("contraseña", "nuevaContraseña");
	            newUser.put("edad", 25);
	            newUser.put("correo", "nuevoUsuario@correo.com");
	            
	            usus.put(newUser);
	            try {
	            	
	            String filePath = "src/usuarios.json";
	         // Abre el archivo JSON para escritura
	            FileWriter writer = new FileWriter(filePath);

	         // Escribe el contenido actualizado en el archivo
	            //JSONWriter jsonWriter = new JSONWriter(writer);
	            usus.write(writer);

	            // Cierra el escritor de archivos
	            writer.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }

	}

	public void crearUsuario(String nombre, String contraseña, String edad, String correo) {
		JSONArray usus = obtenerUsuariosJson(); //llamamos a la función
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
        //JSONWriter jsonWriter = new JSONWriter(writer);
        usus.write(writer);

        // Cierra el escritor de archivos
        writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	public void cambiarContraseña(String nombreUsuario, String nuevaContraseña) {

	}

	public void borrarUsuario(String nombreUsuario) {

	}

	public void mostrarVentanaCrearUsuario() {
		ventanaInicioSesion.setVisible(false);
		ventanaCrearUsuario.setVisible(true);

	}

	public void mostrarVentanaVerUsuario(String nombreUsuario) {

	}

	public void mostrarVentanaCambiarContraseña(String nombreUsuario) {

	}

	public void mostrarVentanaBorrarUsuario(String nombreUsuario) {

	}
}
