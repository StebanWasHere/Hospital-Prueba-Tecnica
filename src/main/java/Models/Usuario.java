package Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "especialidad_id", nullable = false)
    @NotNull
    private Especialidad especialidad;

    @ManyToOne
    @JoinColumn(name = "identificacion_usuario_id", nullable = false)
    @NotNull
    private IdentificacionUsuario identificacionUsuario;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @NotNull
    private TipoUsuarioEnum tipoUsuario;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public IdentificacionUsuario getIdentificacionUsuario() {
        return identificacionUsuario;
    }

    public void setIdentificacionUsuario(IdentificacionUsuario identificacionUsuario) {
        this.identificacionUsuario = identificacionUsuario;
    }

    public TipoUsuarioEnum getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuarioEnum tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
