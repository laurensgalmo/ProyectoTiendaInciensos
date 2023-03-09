package es.rf.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.rf.tienda.dominio.Usuario;

public interface IUsuariosRepository extends JpaRepository<Usuario, Integer> {

}
