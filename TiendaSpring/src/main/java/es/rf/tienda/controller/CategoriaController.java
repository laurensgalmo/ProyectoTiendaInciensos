package es.rf.tienda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.service.ServicioCategoria;

/**
 * Nombre: CategoriaController
 * 
 * Descripcion: Controller de Categoría
 * 
 * @author laura.galvez.moya
 */

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private ServicioCategoria cDao;

	/**
	 * Lectura de una categoría
	 * 
	 * @param id
	 * @return una categoría según el ID insertado
	 */

	@GetMapping("/{id}")
	public Categoria leerCategoria(@PathVariable("id") int id) {
		return cDao.leerCategoria(id);
	}

	/**
	 * Lectura de la lista de categorías
	 * 
	 * @return la lista entera
	 */

	@GetMapping()
	public List<Categoria> leerTodasCategorias() {
		return cDao.leerTodasCategorias();
	}

	/**
	 * Insertar/Crear una nueva categoría
	 * 
	 * @param c
	 * @return categoría creada
	 */

	@PostMapping
	public String[] crearCategoria(@RequestBody Categoria c) {
		if (c != null) {
			cDao.insert(c);
			return new String[] { "200", "La categoría ha sido creada" };
		} else {
			return new String[] { "400", "La categoría NO ha sido creada" };
		}
	}

	/**
	 * Update/Modificar categoría
	 * 
	 * @param c
	 * @return categoría modificada
	 */

	@PutMapping
	public String[] modificarCategoria(@RequestBody Categoria c) {
		cDao.update(c);
		return new String[] { "200", "La categoría ha sido modificada" };
	}

	/**
	 * Delete/Eliminar una categoría a partir del ID insertado
	 * 
	 * @param id
	 * @return categoría eliminada
	 */

	@DeleteMapping("/{id}")
	public String[] eliminarCategoria(@PathVariable("id") Integer id) {
		cDao.deleteById(id);
		return new String[] { "200", "El registro ha sido eliminado" };
	}
}
