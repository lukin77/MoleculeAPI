package hr.uniri.molapi.molecule.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("mol/validate")
public class MolValidateController {

    private final MolValidateService molValidateService;

    @Autowired
    public MolValidateController(MolValidateService molValidateService) {
        this.molValidateService = molValidateService;
    }

    @PostMapping("/isValidSmiles")
    public ResponseEntity<Boolean> isValidSmiles(@RequestBody final String smiles) {
        return ResponseEntity.ok(molValidateService.isValidSmiles(smiles));
    }

    @PostMapping("/isValidCtab")
    public ResponseEntity<Boolean> isValidCtab(@RequestBody final String ctab) {
        return ResponseEntity.ok(molValidateService.isValidCtab(ctab));
    }

    @PostMapping("/isValidSmarts")
    public ResponseEntity<Boolean> isValidSmarts(@RequestBody final String smarts) {
        return ResponseEntity.ok(molValidateService.isValidSmarts(smarts));
    }

    @PostMapping("/isValidMolPk")
    public ResponseEntity<Boolean> isValidMolPk(@RequestBody final String molPk) {
        return ResponseEntity.ok(molValidateService.isValidMolPk(molPk));
    }

}
