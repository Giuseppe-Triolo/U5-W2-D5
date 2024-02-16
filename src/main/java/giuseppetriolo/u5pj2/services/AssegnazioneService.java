package giuseppetriolo.u5pj2.services;

import giuseppetriolo.u5pj2.data.AssegnazioneDAO;
import giuseppetriolo.u5pj2.entities.Assegnazioni;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssegnazioneService {

    @Autowired
    private AssegnazioneDAO assegnazioneRepository;

    public Assegnazioni saveAssegnazione(Assegnazioni assegnazione) {
        return assegnazioneRepository.save(assegnazione);
    }

    public List<Assegnazioni> getAllAssegnazioni() {
        return assegnazioneRepository.findAll();
    }

}
