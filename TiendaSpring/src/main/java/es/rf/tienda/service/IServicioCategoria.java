package es.rf.tienda.service;

import java.io.IOException;
import java.util.List;

import es.rf.tienda.dominio.Categoria;

/**
 * Nombre: IServicioCategoría
 * 
 * Descripcion: Interface
 * 
 * @author laura.galvez.moya
 */

public interface IServicioCategoria {

	public boolean insert(Categoria t) throws IOException;

	public boolean update(Categoria t);

	public boolean deleteById(int s);

	public List<Categoria> leerTodasCategorias();

	public Categoria leerCategoria(int d);

}
