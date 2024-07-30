package Service;

import Models.Especialidad;
import Repo.EspecialidadRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class EspecialidadService {
    private EspecialidadRepository especialidadRepository;

    @Autowired
    public EspecialidadService(EspecialidadRepository especialidadRepository){
        this.especialidadRepository = especialidadRepository;
    }

    public void createEspecialidad(Especialidad especialidad){
        especialidadRepository.save(especialidad);
    }

    public List<Especialidad> getAllEspecialidades(){
        return especialidadRepository.findAll();
    }

    public Especialidad getEspecialidadById(Long id){
        Optional<Especialidad> especialidad = especialidadRepository.findById(id);
        if (especialidad.isPresent()){
            return especialidad.get();
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Especialidad no encontrada");
        }
    }
    public void deleteEspecialidad(Long id){
        if (especialidadRepository.existsById(id)){
            especialidadRepository.deleteById(id);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Especialidad no encontrada");
        }
    }
}