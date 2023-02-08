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

import es.rf.tienda.dao.ICategoriaDao;
import es.rf.tienda.dominio.Categoria;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private ICategoriaDao cDao;

	@GetMapping("/{id}")
	public Categoria leerCategoria(@PathVariable("id") int id) {
		return cDao.findById(id).get();
	}

	@GetMapping()
	public List<Categoria> leerTodasCategorias() {
		return cDao.findAll();
	}

	@SuppressWarnings("unused")
	@PostMapping
	public String[] salvarCategoria(@RequestBody Categoria c) {
		c.setId_categoria(0);
		if (c != null) {
			cDao.save(c);
			return new String[] { "400", "El registro ha sido salvado" };
		} else {
			return new String[] { "400", "El registro NO ha sido salvado" };
		}
	}

	@PutMapping
	public String[] modificarCategoria(@RequestBody Categoria c) {
		cDao.save(c);
		return new String[] { "500", "El registro ha sido modificado" };
	}

	@DeleteMapping("/{id}")
	public String[] eliminarCategoria(@PathVariable("id") Integer id) {
		cDao.deleteById(id);
		return new String[] { "600", "El registro ha sido eliminado" };
	}
}
