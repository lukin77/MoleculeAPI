package hr.uniri.molapi.molecule.descriptors;

import hr.uniri.molapi.model.Mol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("molecule")
public class MolDescController {

    private final MolDescService molDescService;

    @Autowired
    public MolDescController(MolDescService molDescService) {
        this.molDescService = molDescService;
    }

    @PostMapping("/descriptor")
    public ResponseEntity<Float> description(@RequestBody final MolDescRequest molDescRequest) {
        return ResponseEntity.ok(molDescService.description(molDescRequest));
    }

    @PostMapping("/molFormula")
    public ResponseEntity<String> molFormula(@RequestBody final Mol mol,
                                             @RequestParam(value = "bool1", defaultValue = "false") Boolean bool1,
                                             @RequestParam(value = "bool2", defaultValue = "true") Boolean bool2) {
        return ResponseEntity.ok(molDescService.molFormula(mol, bool1, bool2));
    }

    @PostMapping("/inchi")
    public ResponseEntity<String> inchi(@RequestBody final Mol mol) {
        return ResponseEntity.ok(molDescService.inchi(mol));
    }

    @PostMapping("/inchiKey")
    public ResponseEntity<String> inchiKey(@RequestBody final Mol mol) {
        return ResponseEntity.ok(molDescService.inchiKey(mol));
    }

    @PostMapping("/molNmHash")
    public ResponseEntity<String> molNmHash(@RequestBody final Mol mol,
                                            @RequestParam(value = "hashType", defaultValue = "") String hashType) {
        return ResponseEntity.ok(molDescService.molNmHash(mol, hashType));
    }
}