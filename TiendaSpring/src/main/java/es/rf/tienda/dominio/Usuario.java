package es.rf.tienda.dominio;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Nombre: Usuario
 * 
 * Descripcion: Dominio Usuario
 * 
 * @author laura.galvez.moya
 */

@Entity
@Table(schema = "ALUMNO_LAURA", name = "USUARIOS")
public class Usuario implements Serializable {

	// Atributos

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_usuario; // identificador de usuarios

	// private int id_tipo;

	@Column
	private String user_nombre; // nombre del usuario
	@Column
	private String user_email; // email del usuario
	@Column
	private String user_pass; // contraseña del usuario
	@Column
	private String user_dni; // dni del usuario
	@Column
	private LocalDate user_fecAlta; // fecha creación del usuario
	@Column
	private LocalDate user_fecConfirmacion; // fecha de confirmación del usuario

	/**
	 * Constructor sin parámetros
	 */

	public Usuario() {
	}

	/**
	 * Getter ID usuario
	 */

	public int getId_usuario() {
		return id_usuario;
	}

	/**
	 * Setter ID usuario
	 * 
	 */

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	/**
	 * Getter nombre usuario
	 */

	public String getUser_nombre() {
		return user_nombre;
	}

	/**
	 * Setter nombre usuario
	 * 
	 */

	public void setUser_nombre(String user_nombre) {
		this.user_nombre = user_nombre;
	}

	/**
	 * Getter email usuario
	 */

	public String getUser_email() {
		return user_email;
	}

	/**
	 * Setter email usuario
	 * 
	 */

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	/**
	 * Getter contraseña usuario
	 */

	public String getUser_pass() {
		return user_pass;
	}

	/**
	 * Setter contraseña usuario
	 * 
	 */

	public void setUser_pass(String user_pass) {
		this.user_pass = user_pass;
	}

	/**
	 * Getter dni usuario
	 */

	public String getUser_dni() {
		return user_dni;
	}

	/**
	 * Setter dni usuario
	 * 
	 */

	public void setUser_dni(String user_dni) {
		this.user_dni = user_dni;
	}

	/**
	 * Getter fecha alta usuario
	 */

	public LocalDate getUser_fecAlta() {
		return user_fecAlta;
	}

	/**
	 * Setter fecha alta usuario
	 * 
	 */

	public void setUser_fecAlta(LocalDate user_fecAlta) {
		this.user_fecAlta = user_fecAlta;
	}

	/**
	 * Getter fecha confirmación usuario
	 */

	public LocalDate getUser_fecConfirmacion() {
		return user_fecConfirmacion;
	}

	/**
	 * Setter fecha confimación usuario
	 * 
	 */

	public void setUser_fecConfirmacion(LocalDate user_fecConfirmacion) {
		this.user_fecConfirmacion = user_fecConfirmacion;
	}

}
