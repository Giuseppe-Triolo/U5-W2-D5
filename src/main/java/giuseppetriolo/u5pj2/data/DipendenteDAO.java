package giuseppetriolo.u5pj2.data;

import giuseppetriolo.u5pj2.entities.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DipendenteDAO extends JpaRepository<Dipendente, Long> {

    Dipendente findByUsername(String username);

    List<Dipendente> findByNomeAndCognome(String nome, String cognome);

    Optional<Dipendente> findByEmail(String email);


    List<Dipendente> findByEmailContaining(String parteEmail);

}

