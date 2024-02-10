package hr.uniri.molapi.molecule.substructureOperations;

import hr.uniri.molapi.model.Mol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("mol/subop")
public class MolSubOpController {

    private final MolSubOpService molSubOpService;

    @Autowired
    public MolSubOpController(MolSubOpService molSubOpService) {
        this.molSubOpService = molSubOpService;
    }

    @PostMapping("/substructure")
    public ResponseEntity<Boolean> substruct(@RequestBody List<Mol> mols) {
        return ResponseEntity.ok(molSubOpService.substruct(mols));
    }

    @PostMapping("/substructureCount")
    public ResponseEntity<Integer> substructCount(@RequestBody List<Mol> mols, @RequestParam(required = false) final Boolean uniquified) {
        return ResponseEntity.ok(molSubOpService.substructCount(mols, uniquified));
    }

    @PostMapping("/molAdjustQueryProperties")
    public ResponseEntity<Mol> molAdjustQueryProperties(@RequestBody Mol mol, @RequestParam final String properties) {
        return ResponseEntity.ok(molSubOpService.molAdjustQueryProperties(mol, properties));
    }
}
