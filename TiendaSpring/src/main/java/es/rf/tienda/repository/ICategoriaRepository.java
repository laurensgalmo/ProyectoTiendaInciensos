package es.rf.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.rf.tienda.dominio.Categoria;

public interface ICategoriaRepository extends JpaRepository<Categoria, Integer> {

}
