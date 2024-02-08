package hr.uniri.molapi.controller;

import hr.uniri.molapi.model.Mol;
import hr.uniri.molapi.service.molService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("general-mol")
public class GeneralMolController {

    private final molService molService;

    @Autowired
    public GeneralMolController(molService molService) {
        this.molService = molService;
    }

    @GetMapping
    public @ResponseBody ResponseEntity<List<Mol>> getAllMols() {
        return molService.findAll().map(
                        Mol -> ResponseEntity.ok().body(Mol))
                .orElseGet(
                        () -> ResponseEntity.notFound().build()
                );
    }

    @GetMapping("/{id}")
    public @ResponseBody ResponseEntity<Mol> findMolById(@PathVariable final Integer id) {
        return molService.findMolById(id).map(
                        Mol -> ResponseEntity.ok().body(Mol))
                .orElseGet(
                        () -> ResponseEntity.notFound().build()
                );
    }

    @DeleteMapping("/{id}")
    public @ResponseBody ResponseEntity<Mol> deleteMolById(@PathVariable final Integer id) {
        return molService.deleteMolById(id);
    }

    @PostMapping
    public ResponseEntity<Mol> saveMol(@RequestBody final Mol Mol) {
        return molService.save(Mol).map(
                mol1 -> ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body(mol1)
        ).orElseGet(
                () -> ResponseEntity.status(HttpStatus.CONFLICT)
                        .build()
        );
    }

}