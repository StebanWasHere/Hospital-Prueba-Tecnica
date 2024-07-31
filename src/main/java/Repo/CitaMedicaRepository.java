package Repo;

import Models.CitaMedica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CitaMedicaRepository extends JpaRepository<CitaMedica, Long> {
    Optional<CitaMedica> findByUsuarioIdentificacionUsuarioIdentificacion(String identificacion);
}