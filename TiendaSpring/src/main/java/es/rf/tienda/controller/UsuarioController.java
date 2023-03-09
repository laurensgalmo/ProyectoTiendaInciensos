package es.rf.tienda.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.rf.tienda.dominio.Usuario;
import es.rf.tienda.service.ServicioUsuarios;

/**
 * Nombre: UsuarioController
 * 
 * Descripcion: Controller de Usuario
 * 
 * @author laura.galvez.moya
 */

@RestController
@RequestMapping("/usuarios") // La ruta con el frontend
@CrossOrigin(origins = "*") // Autorizo que contestes a cualquiera que te invoque; autoriza ruta
public class UsuarioController {

	@Autowired
	private ServicioUsuarios uRepo;

	/**
	 * Lectura de un usuario buscado por ID
	 * 
	 * @return usuario por id
	 * 
	 */

	@GetMapping("/{id}")
	public ResponseEntity<Usuario> readUserById(@PathVariable("id") int id) {
		Usuario user = uRepo.readUser(id);
		return ResponseEntity.ok(user);
	}

	/**
	 * Lectura de una lista de usuarios
	 * 
	 * @return la lista con todos los usuarios
	 */

	@GetMapping()
	public List<Usuario> readAllUsers() {
		return uRepo.readAllUser();
	}

	/**
	 * Crear un nuevo usuario
	 * 
	 * @return usuario creado
	 */

	@PostMapping
	public Usuario create(@RequestBody Usuario user) {
		return uRepo.create(user);
	}

	/**
	 * Modificar un usuario
	 * 
	 * @return actualiza un usuario
	 */

	@PutMapping("/{id}")
	public ResponseEntity<Usuario> updateUser(@PathVariable("id") int id, Usuario u) {
		Usuario user = uRepo.update(u);
		return ResponseEntity.ok(user);
	}

	/**
	 * Eliminar un usuario a partir del ID insertado
	 */

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable("id") Integer id) {

		Map<String, Object> response = new HashMap<>();

		if (!uRepo.deleteById(id)) {
			response.put("" + HttpStatus.NOT_FOUND, "ID no encontrado, no se ha podido eliminar el usuario");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		response.put("" + HttpStatus.OK, "El usuario ha sido eliminado");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

}
