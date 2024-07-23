package Repo;

import Models.IdentificacionUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface IdentificacionUsuarioRepository extends JpaRepository<IdentificacionUsuario, Long> {

}
