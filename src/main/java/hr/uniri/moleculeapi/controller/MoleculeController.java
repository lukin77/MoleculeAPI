package hr.uniri.moleculeapi.controller;

import hr.uniri.moleculeapi.model.Molecule;
import hr.uniri.moleculeapi.service.MoleculeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("molecule")
public class MoleculeController {

    private final MoleculeService moleculeService;

    @Autowired
    public MoleculeController(MoleculeService moleculeService) {
        this.moleculeService = moleculeService;
    }

    @GetMapping
    public @ResponseBody ResponseEntity<List<Molecule>> getAllMolecules() {
        return moleculeService.findAll().map(
                molecule -> ResponseEntity.ok().body(molecule))
                .orElseGet(
                        () -> ResponseEntity.notFound().build()
                );
    }

    @GetMapping("/{id}")
    public @ResponseBody ResponseEntity<Molecule> findMoleculeById(@PathVariable final Integer id) {
        return moleculeService.findMoleculeById(id).map(
                molecule -> ResponseEntity.ok().body(molecule))
                .orElseGet(
                        () -> ResponseEntity.notFound().build()
                );
    }

    @DeleteMapping("/{id}")
    public @ResponseBody ResponseEntity<Molecule> deleteMoleculeById(@PathVariable final Integer id) {
        return moleculeService.deleteMoleculeById(id);
    }

    @PostMapping
    public ResponseEntity<Molecule> saveMolecule(@RequestBody final Molecule molecule) {
        return moleculeService.save(molecule).map(
                molecule1 -> ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body(molecule1)
        ).orElseGet(
                () -> ResponseEntity.status(HttpStatus.CONFLICT)
                        .build()
        );
    }

    @GetMapping("/search")
    public ResponseEntity<List<Molecule>> substructureSearchMolecule(@RequestBody final Molecule molecule) {
        return moleculeService.substructureSearch(molecule).map(
                moleculeList -> ResponseEntity.ok()
                        .body(moleculeList))
                .orElse(ResponseEntity.notFound()
                        .build()
                );
    }
}