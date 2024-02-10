package hr.uniri.molapi.controller.other;

import hr.uniri.molapi.model.Mol;
import hr.uniri.molapi.service.other.GeneralMolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("crud")
public class GeneralMolController {

    private final GeneralMolService generalMolService;

    @Autowired
    public GeneralMolController(GeneralMolService generalMolService) {
        this.generalMolService = generalMolService;
    }

    @GetMapping
    public @ResponseBody ResponseEntity<List<Mol>> getAllMols() {
        return generalMolService.findAll().map(
                        Mol -> ResponseEntity.ok().body(Mol))
                .orElseGet(
                        () -> ResponseEntity.notFound().build()
                );
    }

    @GetMapping("/{id}")
    public @ResponseBody ResponseEntity<Mol> findMolById(@PathVariable final Integer id) {
        return generalMolService.findMolById(id).map(
                        Mol -> ResponseEntity.ok().body(Mol))
                .orElseGet(
                        () -> ResponseEntity.notFound().build()
                );
    }

    @DeleteMapping("/{id}")
    public @ResponseBody ResponseEntity<Mol> deleteMolById(@PathVariable final Integer id) {
        return generalMolService.deleteMolById(id);
    }

    @PostMapping
    public ResponseEntity<Mol> saveMol(@RequestBody final Mol mol) {
        return generalMolService.save(mol).map(
                mol1 -> ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body(mol1)
        ).orElseGet(
                () -> ResponseEntity.status(HttpStatus.CONFLICT)
                        .build()
        );
    }

    /*
    @PostMapping("/search")
    public ResponseEntity<List<Mol>> substructureSearchMol(@RequestBody final Mol mol) {
        return executeSubstrutureSearch(mol, molService::substructureSearch);
    }
     */

}