package es.rf.tienda.service;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.repository.ICategoriaRepository;

/**
 * Nombre: ServicioCategoría
 * 
 * Descripcion: Servicio de Categoría
 * 
 * @author laura.galvez.moya
 */

@Service
public class ServicioCategoria implements IServicioCategoria {

	@Autowired
	private ICategoriaRepository cDao;

	/**
	 * Método para insertar/crear categorías
	 * 
	 * @throws IOException
	 */

	public boolean insert(Categoria t) throws IOException {
		if (t.isValidInsert()) {
			cDao.save(t);
			System.out.println("La categoría se ha insertado");
			return true;
		} else {
			System.out.println("La categoría NO se ha insertado");
			return false;
		}
	}

	/**
	 * Método para actualizar/modificar categorías
	 */

	public boolean update(Categoria t) {
		Optional<Categoria> ca = cDao.findById(t.getId_categoria());
		Categoria c = ca.get();
		if (c.isValidUpdate() && ca != null) {
			c.setCat_nombre(t.getCat_nombre());
			c.setCat_descripcion(t.getCat_descripcion());
			c.setId_categoria(t.getId_categoria());
			System.out.println("La categoría se ha modificado");
			cDao.save(c);
			return true;
		} else {
			System.out.println("La categoría NO se ha modificado");
			return false;
		}
	}

	/**
	 * Método para eliminar categorías según el ID insertado
	 */

	public boolean deleteById(int id) {
		Optional<Categoria> ca = cDao.findById(id);
		if (!ca.isEmpty()) {
			cDao.deleteById(id);
			System.out.println("La categoría ha sido eliminada");
			return true;
		}
		System.out.println("No se ha podido eliminar. Id de categoria: " + id + " no encontrada");

		return false;
	}

	/**
	 * Método para lectura de las categorías
	 */

	public List<Categoria> leerTodasCategorias() {
		return cDao.findAll();
	}

	/**
	 * Método para lectura de una categoría según el ID insertado
	 */

	public Categoria leerCategoria(int d) {
		try {
			Categoria c = cDao.findById(d).get();
			return c;
		} catch (NoSuchElementException e) {
			return new Categoria();
		}
	}
}
