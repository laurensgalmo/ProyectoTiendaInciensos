package es.rf.tienda.service;

import java.io.IOException;
import java.util.List;

import es.rf.tienda.dominio.Usuario;

/**
 * Nombre: IServicioUsuarios
 * 
 * Descripcion: Interface
 * 
 * @author laura.galvez.moya
 */

public interface IServicioUsuarios {

	public boolean create(Usuario user) throws IOException;

	public Usuario readUser(int id);

	public List<Usuario> readAllUser();

	public boolean update(Usuario user);

	public boolean deleteById(int id);

}
