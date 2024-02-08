package hr.uniri.molapi.controller.molecule.validate;

import hr.uniri.molapi.service.molecule.validate.MolValidateService;
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

    //is_valid_ctab
    @PostMapping("/isValidCtab")
    public ResponseEntity<Boolean> isValidCtab(@RequestBody final String ctab) {
        return ResponseEntity.ok(molValidateService.isValidCtab(ctab));
    }

    //is_valid_smarts
    @PostMapping("/isValidSmarts")
    public ResponseEntity<Boolean> isValidSmarts(@RequestBody final String smarts) {
        return ResponseEntity.ok(molValidateService.isValidSmarts(smarts));
    }

    //is_valid_mol_pkl
    @PostMapping("/isValidMolPkl")
    public ResponseEntity<Boolean> isValidMolPk(@RequestBody final String molPkl) {
        return ResponseEntity.ok(molValidateService.isValidMolPk(molPkl));
    }


}
