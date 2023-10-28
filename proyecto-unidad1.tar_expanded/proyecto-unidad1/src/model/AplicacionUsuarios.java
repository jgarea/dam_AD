package model;

import org.json.JSONArray;
import org.json.JSONObject;

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
	

	}

	private JSONArray obtenerUsuariosJson() {
		return null;

	}

	private int obtenerPosicionUsuario(String nombreUsuario, JSONArray usuarios) {
		return 0;//sddsadsdas
	}

	private JSONObject obtenerUsuarioJson(String nombreUsuario) {
		return null;//ggdfgdfdgf

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

	}

	public void crearUsuario(String nombre, String contraseña, String edad, String correo) {

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
