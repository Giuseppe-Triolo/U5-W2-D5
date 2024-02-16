package giuseppetriolo.u5pj2.services;

import giuseppetriolo.u5pj2.data.DipendenteDAO;
import giuseppetriolo.u5pj2.entities.Dipendente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DipendenteService {

    @Autowired
    private DipendenteDAO dipendenteRepository;

    public Dipendente saveDipendente(Dipendente dipendente) {
        return dipendenteRepository.save(dipendente);
    }

    public List<Dipendente> getAllDipendenti() {
        return dipendenteRepository.findAll();
    }

    public Dipendente getDipendenteByUsername(String username) {
        return dipendenteRepository.findByUsername(username);
    }
    public Dipendente getDipendenteByEmail(String email) {
        Optional<Dipendente> optionalDipendente = dipendenteRepository.findByEmail(email);
        return optionalDipendente.orElse(null);
    }

}
