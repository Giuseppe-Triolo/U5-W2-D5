package giuseppetriolo.u5pj2.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "assegnazioni")
public class Assegnazioni {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_dipendente", nullable = false)
    private Dipendente dipendente;

    @ManyToOne
    @JoinColumn(name = "id_dispositivo", nullable = false)
    private Dispositivo dispositivo;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Dipendente getDipendente() {
        return dipendente;
    }

    public void setDipendente(Dipendente dipendente) {
        this.dipendente = dipendente;
    }

    public Dispositivo getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(Dispositivo dispositivo) {
        this.dispositivo = dispositivo;
    }
}
