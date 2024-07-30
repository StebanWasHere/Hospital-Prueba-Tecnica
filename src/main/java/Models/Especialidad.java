package Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "especialidad")
public class Especialidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 10, nullable = false) //verifica que el numero maximo sea 10 y no se pueda poner un campo en blanco
    @NotBlank(message = "No puede estar en blanco.")
    @Size(max = 10, message = "El tipo de cita no puede contener mas de 10 caracteres.")
    private String tipoCita;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTipoCita() {
        return tipoCita;
    }

    public void setTipoCita(String tipoCita) {
        this.tipoCita = tipoCita;
    }
}