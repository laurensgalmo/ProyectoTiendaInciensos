package es.rf.tienda.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.dominio.Usuario;
import es.rf.tienda.repository.IUsuariosRepository;

/**
 * Nombre: ServicioUsuarios
 * 
 * Descripcion: Servicio de Usuarios
 * 
 * @author laura.galvez.moya
 */

@Service
public class ServicioUsuarios implements IServicioUsuarios {

	@Autowired
	private IUsuariosRepository uRepo;

	// TODO

	@Override
	public Usuario create(Usuario user) {
		return uRepo.save(user);
	}

	@Override
	public Usuario readUser(int id) {
		Usuario u = null;
		try {
			System.out.println("Usuario encontrado");
			return uRepo.findById(id).get();
		} catch (NoSuchElementException e) {
			System.out.println("Usuario NO encontrado");
		}
		return u;
	}

	@Override
	public List<Usuario> readAllUser() {
		return uRepo.findAll();
	}

	@Override
	public Usuario update(Usuario u) {
		Optional<Usuario> usuario = uRepo.findById(u.getId_usuario());
		Usuario user = usuario.get();
		if (user.isValidUpdate() && usuario != null) {
			user.setId_usuario(u.getId_usuario());
			user.setUser_nombre(u.getUser_nombre());
			user.setUser_apellidos(u.getUser_apellidos());
			user.setUser_dni(u.getUser_dni());
			user.setUser_email(u.getUser_email());
			user.setUser_pass(u.getUser_pass());
			System.out.println("El usuario se ha modificado");
			return uRepo.save(user);
		} else {
			System.out.println("El usuario NO se ha modificado");
			return null;
		}
	}

	@Override
	public boolean deleteById(int id) {
		Optional<Usuario> us = uRepo.findById(id);
		if (!us.isEmpty()) {
			uRepo.deleteById(id);
			System.out.println("El usuario ha sido eliminado");
			return true;
		} else {
			System.out.println("No se ha podido eliminar. Id de usuario: " + id + " no encontrado");
			return false;
		}
	}
}
