package Controller;

import Models.CitaMedica;
import Service.CitaMedicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/agendar")
public class CitaMedicaController {

    @Autowired
    private CitaMedicaService citaMedicaService;

    @PostMapping
    public ResponseEntity<?> agendarCita(@RequestBody CitaMedica nuevaCita) {
        try {
            CitaMedica citaAgendada = citaMedicaService.agendarCita(nuevaCita);
            return ResponseEntity.status(HttpStatus.CREATED).body(citaAgendada);
        } catch (ResponseStatusException e) {
            // Aquí usamos getRawStatusCode() y getReason() de ResponseStatusException
            return ResponseEntity.status(e.getStatusCode().value()).body(e.getReason());
        } catch (Exception e) {
            // Manejo general de excepciones
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error, intente nuevamente.");
        }
    }
}
