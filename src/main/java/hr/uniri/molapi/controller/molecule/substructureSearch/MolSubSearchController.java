package hr.uniri.molapi.controller.molecule.substructureSearch;

import hr.uniri.molapi.model.Mol;
import hr.uniri.molapi.service.molecule.substructureSearch.MolSubSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("mol/")
public class MolSubSearchController {

    private final MolSubSearchService molSubSearchService;

    @Autowired
    public MolSubSearchController(MolSubSearchService molSubSearchService) {
        this.molSubSearchService = molSubSearchService;
    }

    @PostMapping("/retrieveSubstructuresOfGivenMol")
    public ResponseEntity<List<Mol>> retrieveSubstructures(@RequestBody Mol mol) {
        return ResponseEntity.ok(molSubSearchService.retrieveSubstructures(mol));
    }

    @PostMapping("/retrieveAllMolsWhichContainGivenSubstructure")
    public ResponseEntity<List<Mol>> retrieveAllMolsWhichContainGivenSubstructure(@RequestBody Mol mol) {
        return ResponseEntity.ok(molSubSearchService.retrieveAllMolsWhichContainGivenSubstructure(mol));
    }

    @PostMapping("/compareIfTwoMolsAreEqual")
    public ResponseEntity<Boolean> compareIfTwoMolsAreEqual(@RequestBody List<Mol> mols) {
        if (mols.size() != 2) return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(molSubSearchService.compareIfTwoMolsAreEqual(mols));
    }

}
