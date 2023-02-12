package es.rf.tienda.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<?> crearCategoria(@RequestBody Categoria c) {

		Map<String, Object> response = new HashMap<>();

		if (cDao.insert(c)) {
			response.put("Mensaje", "La categoría ha sido creada");
		} else {
			response.put("Mensaje", "No se ha podido crear la categoría");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	/**
	 * Update/Modificar categoría
	 * 
	 * @param c
	 * @return categoría modificada
	 */

	@PutMapping
	public ResponseEntity<?> modificarCategoria(@RequestBody Categoria c) {

		Map<String, Object> response = new HashMap<>();

		try {
			cDao.update(c);
			response.put("Mensaje", "La categoría ha sido modificada");
		} catch (Exception e) {
			response.put("Mensaje", "No se ha podido modificar la categoría");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	/**
	 * Delete/Eliminar una categoría a partir del ID insertado
	 * 
	 * @param id
	 * @return categoría eliminada
	 */

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminarCategoria(@PathVariable("id") Integer id) {

		Map<String, Object> response = new HashMap<>();

		try {
			cDao.deleteById(id);
			response.put("Mensaje", "La categoría ha sido eliminada, id " + id);

		} catch (DataAccessException e) {
			response.put("Mensaje", "No se ha podido eliminar la categoría con id " + id);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}
