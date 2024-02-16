package giuseppetriolo.u5pj2.data;
import giuseppetriolo.u5pj2.entities.Dispositivo;
import giuseppetriolo.u5pj2.entities.StatoDispositivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DispositivoDAO extends JpaRepository<Dispositivo, Long> {


    Dispositivo findByTipo(String tipo);


    List<Dispositivo> findByStato(StatoDispositivo stato);

}
