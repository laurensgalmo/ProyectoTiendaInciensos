package es.rf.tienda.controller;

import java.io.IOException;
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
import es.rf.tienda.util.Validator;

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
	 * @throws
	 */

	@PostMapping
	public ResponseEntity<?> create(@RequestBody Usuario user) throws IOException {
		Map<String, Object> response = new HashMap<>();
		if (Validator.isAlfanumeric(user.getUser_nombre()) && Validator.isAlfanumeric(user.getUser_apellidos())) {
			response.put("MENSAJE NOMBRE", "Nombre correcto");
			if (Validator.isEmailValido(user.getUser_email())) {
				response.put("MENSAJE EMAIL", "Email correcto");
				if (Validator.cumpleDNI(user.getUser_dni())) {
					response.put("MENSAJE DNI", "DNI correcto");
					if (Validator.esPasswordValida(user.getUser_pass())) {
						response.put("MENSAJE CONTRASEÑA", "Contraseña correcta");
						if (!uRepo.create(user)) {
							response.put("MENSAJE", "No se ha podido crear el usuario");
							return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
						}
					} else {
						response.put("" + HttpStatus.BAD_REQUEST, "Contraseña incorrecta");
						return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
					}
				} else {
					response.put("" + HttpStatus.BAD_REQUEST, "DNI incorrecto");
					return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
				}
			} else {
				response.put("" + HttpStatus.BAD_REQUEST, "Email incorrecto");
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
			}
		} else {
			response.put("" + HttpStatus.BAD_REQUEST, "Nombre o apellidos incorrectos");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		response.put("" + HttpStatus.OK, "El usuario ha sido creado");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	/**
	 * Modificar un usuario
	 * 
	 * @return actualiza un usuario
	 */

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Usuario user) throws IOException {
		Map<String, Object> response = new HashMap<>();
		if (Validator.isAlfanumeric(user.getUser_nombre()) && Validator.isAlfanumeric(user.getUser_apellidos())) {
			response.put("MENSAJE NOMBRE", "Nombre correcto");
			if (Validator.isEmailValido(user.getUser_email())) {
				response.put("MENSAJE EMAIL", "Email correcto");
				if (Validator.cumpleDNI(user.getUser_dni())) {
					response.put("MENSAJE DNI", "DNI correcto");
					if (Validator.esPasswordValida(user.getUser_pass())) {
						response.put("MENSAJE CONTRASEÑA", "Contraseña correcta");
						if (!uRepo.update(user)) {
							response.put("MENSAJE", "No se ha podido modificar el usuario");
							return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
						}
					} else {
						response.put("" + HttpStatus.BAD_REQUEST, "Contraseña incorrecta");
						return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
					}
				} else {
					response.put("" + HttpStatus.BAD_REQUEST, "DNI incorrecto");
					return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
				}
			} else {
				response.put("" + HttpStatus.BAD_REQUEST, "Email incorrecto");
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
			}
		} else {
			response.put("" + HttpStatus.BAD_REQUEST, "Nombre o apellidos incorrectos");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		response.put("" + HttpStatus.OK, "El usuario ha sido modificado");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
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
