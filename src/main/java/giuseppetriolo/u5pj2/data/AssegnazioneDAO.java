package giuseppetriolo.u5pj2.data;

import giuseppetriolo.u5pj2.entities.Assegnazioni;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssegnazioneDAO extends JpaRepository<Assegnazioni, Long> {

    List<Assegnazioni> findByDipendenteId(Long dipendenteId);

    List<Assegnazioni> findByDispositivoId(Long dispositivoId);

}
