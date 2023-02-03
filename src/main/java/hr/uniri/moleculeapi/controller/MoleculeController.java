package hr.uniri.moleculeapi.controller;

import hr.uniri.moleculeapi.model.Molecule;
import hr.uniri.moleculeapi.service.MoleculeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("molecule")
public class MoleculeController {

    private final MoleculeService moleculeService;

    @Autowired
    public MoleculeController(MoleculeService moleculeService) {
        this.moleculeService = moleculeService;
    }

    @GetMapping
    public @ResponseBody List<Molecule> getAllMolecules() {
        return moleculeService.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody ResponseEntity<Molecule> findMoleculeById(@PathVariable final Integer id) {
        return moleculeService.findMoleculeById(id);
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
                () -> ResponseEntity
                        .status(HttpStatus.CONFLICT)
                        .build()
        );
    }

    @GetMapping("/search")
    public ResponseEntity<List<Molecule>> substructureSearchMolecule(@RequestBody final Molecule molecule) {
        return moleculeService.substructureSearch(molecule);
    }
}