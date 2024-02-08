package hr.uniri.molapi.controller.molecule.validate;

import hr.uniri.molapi.service.molecule.validate.MolValidateService;
import hr.uniri.molapi.utils.MolInputOutputFunction;
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
        return executeInputOutputFunction(smiles, molValidateService::isValidSmiles);
    }

    //is_valid_ctab
    @PostMapping("/isValidCtab")
    public ResponseEntity<Boolean> isValidCtab(@RequestBody final String ctab) {
        return executeInputOutputFunction(ctab, molValidateService::isValidCtab);
    }

    //is_valid_smarts
    @PostMapping("/isValidSmarts")
    public ResponseEntity<Boolean> isValidSmarts(@RequestBody final String smarts) {
        return executeInputOutputFunction(smarts, molValidateService::isValidSmarts);
    }

    //is_valid_mol_pkl
    @PostMapping("/isValidMolPkl")
    public ResponseEntity<Boolean> isValidMolPk(@RequestBody final String molPkl) {
        return executeInputOutputFunction(molPkl, molValidateService::isValidMolPk);
    }

    private ResponseEntity<Boolean> executeInputOutputFunction(String param, MolInputOutputFunction function) {
        return ResponseEntity.ok(function.apply(param));
    }
}
