package hr.uniri.molapi.molecule.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("molecule")
public class MolValidateController {

    private final MolValidateService molValidateService;

    @Autowired
    public MolValidateController(MolValidateService molValidateService) {
        this.molValidateService = molValidateService;
    }

    @PostMapping("/validate")
    public ResponseEntity<Boolean> validate(@RequestBody final MolValidateRequest molValidateRequest) {
        return ResponseEntity.ok(molValidateService.validate(molValidateRequest));
    }

}
