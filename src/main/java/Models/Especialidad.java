package Models;

import jakarta.persistence.*;


@Entity
@Table

public class Especialidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 10, nullable = false) //verifica que el numero maximo sea 10 y no se pueda poner un campo en blanco
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



