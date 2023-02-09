package es.rf.tienda.service;

import java.util.List;
import java.util.NoSuchElementException;

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
	 */

	public boolean insert(Categoria t) {
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
		Categoria ca = new Categoria();
		if (t.isValidUpdate()) {
			ca.setCat_nombre(t.getCat_nombre());
			ca.setCat_descripcion(t.getCat_descripcion());
			ca.setId_categoria(t.getId_categoria());
			System.out.println("La categoría se ha modificado");
			cDao.save(ca);
			return true;
		} else {
			System.out.println("La categoría NO se ha modificado");
			return false;
		}
	}

	/**
	 * Método para eliminar categorías según el ID insertado
	 */

	public boolean deleteById(int s) {
		cDao.deleteById(s);
		System.out.println("La categoría ha sido eliminada");
		return true;
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
