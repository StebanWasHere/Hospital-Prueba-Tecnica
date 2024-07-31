package Service;

import Models.CitaMedica;
import Models.TipoUsuarioEnum;
import Repo.CitaMedicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class CitaMedicaService {

    @Autowired
    private CitaMedicaRepository citaMedicaRepository;

    public CitaMedica agendarCita(CitaMedica citaMedica) {
        String identificacion = citaMedica.getUsuario().getIdentificacionUsuario().getIdentificacion();
        TipoUsuarioEnum tipoUsuario = citaMedica.getUsuario().getTipoUsuario();

        // Verifica cita
        if (tipoUsuario == TipoUsuarioEnum.PARTICULAR) {
            Optional<CitaMedica> existingCita = citaMedicaRepository.findByUsuarioIdentificacionUsuarioIdentificacion(identificacion);
            if (existingCita.isPresent()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        String.format("{ \"mensaje\" : \"El usuario con identificación %s ya tiene una cita agendada, por lo cual no podrá realizar más agendamientos.\" }", identificacion));
            }
        }
        //fecha proxima cita
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaCita;

        switch(tipoUsuario) {
            case EPS:
                fechaCita = calcularFechaConDiasHabiles(fechaActual, 10);
                break;
            case POLIZA:
                fechaCita = fechaActual.plusDays(8);
                break;
            case PARTICULAR:
                fechaCita = calcularFechaConDiasHabiles(fechaActual, 7);
                break;
            default:
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        "{ \"mensaje\" : \"Tipo de usuario no permitido en el hospital\" }");
        }
        citaMedica.setFechaCita(fechaCita);

        return citaMedicaRepository.save(citaMedica);
    }

    private LocalDate calcularFechaConDiasHabiles(LocalDate fechaInicial, int diasHabiles) {
        LocalDate fecha = fechaInicial;
        int diasAgregados = 0;

        while (diasAgregados < diasHabiles) {
            fecha = fecha.plusDays(1);
            if (!(fecha.getDayOfWeek() == java.time.DayOfWeek.SATURDAY || fecha.getDayOfWeek() == java.time.DayOfWeek.SUNDAY)) {
                diasAgregados++;
            }
        }
        return fecha;
    }
}
