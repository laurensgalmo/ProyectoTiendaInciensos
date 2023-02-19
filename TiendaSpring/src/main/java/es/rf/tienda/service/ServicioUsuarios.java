package es.rf.tienda.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	@Override
	public boolean create(Usuario user) {
		uRepo.save(user);
		return true;
	}

	@Override
	public Usuario readUser(int id) {
		try {
			Usuario u = uRepo.findById(id).get();
			return u;
		} catch (NoSuchElementException e) {
			return new Usuario();
		}
	}

	@Override
	public List<Usuario> readAllUser() {
		return uRepo.findAll();
	}

	@Override
	public boolean update(Usuario user) {
		return false;
	}

	@Override
	public boolean deleteById(int id) {
		uRepo.deleteById(id);
		return true;

	}
}
