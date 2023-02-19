package es.rf.tienda.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.rf.tienda.dominio.Categoria;
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
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*") // Autorizo que contestes a cualquiera que te invoque; autoriza ruta
public class UsuarioController {

	@Autowired
	private ServicioUsuarios uRepo;

	/**
	 * Lectura de un usuario
	 */

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
	 */

	@PostMapping
	public void create(Usuario user) {

	}

	/**
	 * Modificar un usuario
	 */

	/**
	 * Eliminar un usuario a partir del ID insertado
	 */

}
