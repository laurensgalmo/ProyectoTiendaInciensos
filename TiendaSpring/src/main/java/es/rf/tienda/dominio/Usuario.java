package es.rf.tienda.dominio;

import java.io.IOException;
import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
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
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_USUARIO")
	@SequenceGenerator(name = "SEQ_USUARIO", sequenceName = "SEQ_USUARIO", allocationSize = 1)
	private int id_usuario; // identificador de usuarios

	// private int id_tipo;

	@Column
	private String user_nombre; // nombre del usuario
	@Column
	private String user_apellidos; // apellidos del usuario
	@Column
	private String user_email; // email del usuario
	@Column
	private String user_pass; // contraseña del usuario
	@Column
	private String user_dni; // dni del usuario

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
	 * Getter apellidos usuario
	 */

	public String getUser_apellidos() {
		return user_apellidos;
	}

	/**
	 * Setter dni usuario
	 */

	public void setUser_apellidos(String user_apellidos) {
		this.user_apellidos = user_apellidos;
	}

	/**
	 * Método que hace una validación sobre el ID
	 * 
	 * @return true si el ID es válido / false si el ID no es válido
	 */

	public boolean isValidInsert() throws IOException {

		if (this.id_usuario < 0) {
			System.out.println("El ID no es válido");
			return false;
		} else {
			System.out.println("El ID es válido");
			return true;
		}

	}

	/**
	 * Método que hace una validación sobre la modificación del usuario
	 * 
	 * @return true si la modificación es válida / false en caso contrario
	 */

	public boolean isValidUpdate() {
		if (this.user_nombre != null && this.id_usuario > 0) {
			System.out.println("Es válido");
			return true;
		} else {
			System.out.println("NO es válido");
			return false;
		}
	}

}
