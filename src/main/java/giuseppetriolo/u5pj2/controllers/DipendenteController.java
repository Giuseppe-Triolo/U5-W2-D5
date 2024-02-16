import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import giuseppetriolo.u5pj2.entities.Dipendente;
import giuseppetriolo.u5pj2.services.DipendenteService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/dipendenti")
public class DipendenteController {

    private final DipendenteService dipendenteService;

    public DipendenteController(DipendenteService dipendenteService) {
        this.dipendenteService = dipendenteService;
    }

    @PostMapping
    public ResponseEntity<?> createDipendente(@RequestBody Dipendente dipendente) {

        Map<String, String> errors = validateDipendente(dipendente);
        if (!errors.isEmpty()) {
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }

        Dipendente createdDipendente = dipendenteService.saveDipendente(dipendente);
        return new ResponseEntity<>(createdDipendente, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Dipendente>> getAllDipendenti() {
        List<Dipendente> dipendenti = dipendenteService.getAllDipendenti();
        return new ResponseEntity<>(dipendenti, HttpStatus.OK);
    }

    @GetMapping("/{email}")
    public ResponseEntity<Dipendente> getDipendenteByEmail(@PathVariable String email) {
        Dipendente dipendente = dipendenteService.getDipendenteByEmail(email);
        return new ResponseEntity<>(dipendente, HttpStatus.OK);
    }


    private Map<String, String> validateDipendente(Dipendente dipendente) {
        Map<String, String> errors = new HashMap<>();
        if (dipendente.getUsername() == null || dipendente.getUsername().isEmpty()) {
            errors.put("username", "Il campo username è richiesto");
        }
        if (dipendente.getNome() == null || dipendente.getNome().isEmpty()) {
            errors.put("nome", "Il campo nome è richiesto");
        }

        return errors;
    }
}

