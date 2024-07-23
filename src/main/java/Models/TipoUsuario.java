package Models;
import jakarta.persistence.*;

@Entity
@Table
public class TipoUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String EPS;

    @Column
    private String POLIZA;

    @Column
    private String PARTICULAR;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEPS() {
        return EPS;
    }

    public void setEPS(String EPS) {
        this.EPS = EPS;
    }

    public String getPOLIZA() {
        return POLIZA;
    }

    public void setPOLIZA(String POLIZA) {
        this.POLIZA = POLIZA;
    }

    public String getPARTICULAR() {
        return PARTICULAR;
    }

    public void setPARTICULAR(String PARTICULAR) {
        this.PARTICULAR = PARTICULAR;
    }
}
