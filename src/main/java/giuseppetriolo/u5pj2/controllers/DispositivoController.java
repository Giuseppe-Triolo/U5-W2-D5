package giuseppetriolo.u5pj2.controllers;

import giuseppetriolo.u5pj2.entities.Dispositivo;
import giuseppetriolo.u5pj2.services.DispositivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dispositivi")
public class DispositivoController {

    private final DispositivoService dispositivoService;

    @Autowired
    public DispositivoController(DispositivoService dispositivoService) {
        this.dispositivoService = dispositivoService;
    }

    @PostMapping
    public ResponseEntity<Dispositivo> createDispositivo(@RequestBody Dispositivo dispositivo) {
        Dispositivo createdDispositivo = dispositivoService.saveDispositivo(dispositivo);
        return new ResponseEntity<>(createdDispositivo, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Dispositivo>> getAllDispositivi() {
        List<Dispositivo> dispositivi = dispositivoService.getAllDispositivi();
        return new ResponseEntity<>(dispositivi, HttpStatus.OK);
    }

    @GetMapping("/{tipo}")
    public ResponseEntity<Dispositivo> getDispositivoByTipo(@PathVariable String tipo) {
        Dispositivo dispositivo = dispositivoService.getDispositivoByTipo(tipo);
        return new ResponseEntity<>(dispositivo, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dispositivo> getDispositivoById(@PathVariable Long id) {
        Dispositivo dispositivo = dispositivoService.getDispositivoById(id);
        return dispositivo != null ? ResponseEntity.ok(dispositivo) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dispositivo> updateDispositivo(@PathVariable Long id, @RequestBody Dispositivo dispositivo) {
        Dispositivo updatedDispositivo = dispositivoService.updateDispositivo(id, dispositivo);
        return updatedDispositivo != null ? ResponseEntity.ok(updatedDispositivo) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDispositivo(@PathVariable Long id) {
        dispositivoService.deleteDispositivo(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{idDispositivo}/assegna/{emailDipendente}")
    public ResponseEntity<Void> assegnaDispositivo(@PathVariable Long idDispositivo, @PathVariable String emailDipendente) {
        dispositivoService.assegnaDispositivo(idDispositivo, emailDipendente);
        return ResponseEntity.ok().build();
    }
}
