package giuseppetriolo.u5pj2.controllers;

import giuseppetriolo.u5pj2.entities.Assegnazioni;
import giuseppetriolo.u5pj2.services.AssegnazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assegnazioni")
public class AssegnazioneController {

    @Autowired
    private AssegnazioneService assegnazioneService;

    @PostMapping
    public Assegnazioni createAssegnazione(@RequestBody Assegnazioni assegnazione) {
        return assegnazioneService.saveAssegnazione(assegnazione);
    }

    @GetMapping
    public List<Assegnazioni> getAllAssegnazioni() {
        return assegnazioneService.getAllAssegnazioni();
    }
}
