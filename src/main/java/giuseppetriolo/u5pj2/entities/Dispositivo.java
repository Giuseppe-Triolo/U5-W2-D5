package giuseppetriolo.u5pj2.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "dispositivi")
public class Dispositivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    private String numeroSerie;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatoDispositivo stato;

    @ManyToOne
    @JoinColumn(name = "id_dipendente")
    private Dipendente dipendente;

    @OneToMany(mappedBy = "dispositivo")
    private List<Assegnazioni> assegnazioni;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public StatoDispositivo getStato() {
        return stato;
    }

    public void setStato(StatoDispositivo stato) {
        this.stato = stato;
    }

    public Dipendente getDipendente() {
        return dipendente;
    }

    public void setDipendente(Dipendente dipendente) {
        this.dipendente = dipendente;
    }

    public List<Assegnazioni> getAssegnazioni() {
        return assegnazioni;
    }

    public void setAssegnazioni(List<Assegnazioni> assegnazioni) {
        this.assegnazioni = assegnazioni;
    }
}
