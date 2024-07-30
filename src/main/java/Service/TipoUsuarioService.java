package Service;

import Models.TipoUsuario;
import Repo.TipoUsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class TipoUsuarioService {
    private final TipoUsuarioRepository tipoUsuarioRepository;

    @Autowired
    public TipoUsuarioService(TipoUsuarioRepository tipoUsuarioRepository) {
        this.tipoUsuarioRepository = tipoUsuarioRepository;
    }

    public void createTipoUsuario(TipoUsuario tipoUsuario) {
        tipoUsuarioRepository.save(tipoUsuario);
    }

    public List<TipoUsuario> getAllTipoUsuarios() {
        return tipoUsuarioRepository.findAll();
    }

    public TipoUsuario getTipoUsuarioById(Long id) {
        Optional<TipoUsuario> tipoUsuarioEntity = tipoUsuarioRepository.findById(id);
        if (tipoUsuarioEntity.isPresent()) {
            return tipoUsuarioEntity.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tipo de usuario no encontrado");
        }
    }

    public void updateTipoUsuario(Long id, TipoUsuario updatedTipoUsuario) {
        Optional<TipoUsuario> existingTipoUsuario = tipoUsuarioRepository.findById(id);
        if (existingTipoUsuario.isPresent()) {
            TipoUsuario tipoUsuario = existingTipoUsuario.get();
            tipoUsuario.setTipoUsuario(updatedTipoUsuario.getTipoUsuario());

            tipoUsuarioRepository.save(tipoUsuario);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tipo de usuario no encontrado");
        }
    }

    public void deleteTipoUsuario(Long id) {
        if (tipoUsuarioRepository.existsById(id)) {
            tipoUsuarioRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tipo de usuario no encontrado");
        }
    }
}
