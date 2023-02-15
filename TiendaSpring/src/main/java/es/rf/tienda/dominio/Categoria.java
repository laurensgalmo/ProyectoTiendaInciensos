package es.rf.tienda.dominio;

import java.io.IOException;
import java.io.Serializable;

import es.rf.tienda.util.CategoriaUtil;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

/**
 * Nombre: Categoria
 * 
 * Descripcion: Dominio Categoría
 * 
 * @author laura.galvez.moya
 */

@SuppressWarnings("serial")
@Entity
@Table(schema = "ALUMNO_LAURA", name = "CATEGORIAS")
public class Categoria implements Serializable {

	/**
	 * Se crea secuencia para que haya un incremento en el número del ID
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CATEGORIA")
	@SequenceGenerator(name = "SEQ_CATEGORIA", sequenceName = "SEQ_CATEGORIA", allocationSize = 1)
	private int id_categoria; // identificador categoría

	@Column(nullable = false)
	private String cat_nombre; // nombre de la categoría

	@Column
	private String cat_descripcion; // descripcion de la categoría

	/**
	 * Constructor sin parámetros
	 */

	public Categoria() {
	}

	/**
	 * Getter ID categoría
	 */

	public int getId_categoria() {
		return id_categoria;
	}

	/**
	 * Setter ID categoría
	 * 
	 */

	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}

	/**
	 * Getter nombre categoría
	 */

	public String getCat_nombre() {
		return cat_nombre;
	}

	/**
	 * Setter nombre categoría
	 */

	public void setCat_nombre(String cat_nombre) {
		this.cat_nombre = cat_nombre;
	}

	/**
	 * Getter descripción categoría
	 */

	public String getCat_descripcion() {
		return cat_descripcion;
	}

	/**
	 * Setter descripción categoría
	 */

	public void setCat_descripcion(String cat_descripcion) {
		this.cat_descripcion = cat_descripcion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cat_descripcion == null) ? 0 : cat_descripcion.hashCode());
		result = prime * result + ((cat_nombre == null) ? 0 : cat_nombre.hashCode());
		result = prime * result + id_categoria;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		if (cat_descripcion == null) {
			if (other.cat_descripcion != null)
				return false;
		} else if (!cat_descripcion.equals(other.cat_descripcion))
			return false;
		if (cat_nombre == null) {
			if (other.cat_nombre != null)
				return false;
		} else if (!cat_nombre.equals(other.cat_nombre))
			return false;
		if (id_categoria != other.id_categoria)
			return false;
		return true;
	}

	/**
	 * Método que hace una validación sobre el ID
	 * 
	 * @return true si el ID es válido / false si el ID no es válido
	 */

	public boolean isValidInsert() throws IOException {

		if (this.id_categoria < 0) {
			System.out.println("El ID no es válido");
			return false;
		} else {
			System.out.println("El ID es válido");
			return true;
		}

	}

	/**
	 * Método que hace una validación sobre la modificación de la categoría
	 * 
	 * @return true si la modificación es válida / false en caso contrario
	 */

	public boolean isValidUpdate() {
		if (this.cat_nombre != null && this.id_categoria > 0) {
			System.out.println("Es válido");
			return true;
		} else {
			System.out.println("NO es válido");
			return false;
		}
	}
}
