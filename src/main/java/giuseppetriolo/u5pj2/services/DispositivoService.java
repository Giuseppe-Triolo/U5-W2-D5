package giuseppetriolo.u5pj2.services;

import giuseppetriolo.u5pj2.data.DipendenteDAO;
import giuseppetriolo.u5pj2.data.DispositivoDAO;
import giuseppetriolo.u5pj2.entities.Dipendente;
import giuseppetriolo.u5pj2.entities.Dispositivo;
import giuseppetriolo.u5pj2.entities.StatoDispositivo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DispositivoService {

    private final DispositivoDAO dispositivoRepository;
    private final DipendenteDAO dipendenteRepository;

    @Autowired
    public DispositivoService(DispositivoDAO dispositivoRepository, DipendenteDAO dipendenteRepository) {
        this.dispositivoRepository = dispositivoRepository;
        this.dipendenteRepository = dipendenteRepository;
    }

    public Dispositivo saveDispositivo(Dispositivo dispositivo) {
        return dispositivoRepository.save(dispositivo);
    }

    public List<Dispositivo> getAllDispositivi() {
        return dispositivoRepository.findAll();
    }

    public Dispositivo getDispositivoByTipo(String tipo) {
        return dispositivoRepository.findByTipo(tipo);
    }

    public Dispositivo updateDispositivo(Long id, Dispositivo dispositivo) {
        Optional<Dispositivo> optionalDispositivo = dispositivoRepository.findById(id);
        return optionalDispositivo.map(existingDispositivo -> {
            existingDispositivo.setTipo(dispositivo.getTipo());
            existingDispositivo.setNumeroSerie(dispositivo.getNumeroSerie());
            existingDispositivo.setStato(dispositivo.getStato());
            return dispositivoRepository.save(existingDispositivo);
        }).orElse(null);
    }

    public Dispositivo getDispositivoById(Long id) {
        return dispositivoRepository.findById(id).orElse(null);
    }

    public void deleteDispositivo(Long id) {
        dispositivoRepository.deleteById(id);
    }

    public Dispositivo assegnaDispositivo(Long idDispositivo, String emailDipendente) {
        Optional<Dispositivo> optionalDispositivo = dispositivoRepository.findById(idDispositivo);
        Optional<Dipendente> optionalDipendente = dipendenteRepository.findByEmail(emailDipendente);

        if (optionalDispositivo.isPresent() && optionalDipendente.isPresent()) {
            Dispositivo dispositivo = optionalDispositivo.get();
            Dipendente dipendente = optionalDipendente.get();

            if (dispositivo.getDipendente() != null || dispositivo.getStato() != StatoDispositivo.DISPONIBILE) {
                throw new RuntimeException("Impossibile assegnare il dispositivo: già assegnato o non disponibile.");
            }

            dispositivo.setStato(StatoDispositivo.ASSEGNATO);
            dispositivo.setDipendente(dipendente);
            return dispositivoRepository.save(dispositivo);
        } else {
            return null;
        }
    }
}

