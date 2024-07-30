package Service;

import Models.IdentificacionUsuario;
import Repo.IdentificacionUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class IdentificacionUsuarioService {

    private final IdentificacionUsuarioRepository identificacionUsuarioRepository;

    @Autowired
    public IdentificacionUsuarioService(IdentificacionUsuarioRepository identificacionUsuarioRepository){
        this.identificacionUsuarioRepository = identificacionUsuarioRepository;
    }

    public void createIdentificacionUsuario(IdentificacionUsuario identificacionUsuario) {
        identificacionUsuarioRepository.save(identificacionUsuario);
    }

    public List<IdentificacionUsuario> getAllIdentificacionUsuarios() {
        return identificacionUsuarioRepository.findAll();
    }

    public IdentificacionUsuario getIdentificacionUsuarioById(Long id) {
        Optional<IdentificacionUsuario> identificacionUsuario = identificacionUsuarioRepository.findById(id);
        if (identificacionUsuario.isPresent()){
            return identificacionUsuario.get();
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Identificación de usuario no encontrada");
        }
    }

    public void deleteIdentificacionUsuario(Long id){
        if (identificacionUsuarioRepository.existsById(id)) {
            identificacionUsuarioRepository.deleteById(id);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Identificación de usuario no encontrada");
        }
    }
}