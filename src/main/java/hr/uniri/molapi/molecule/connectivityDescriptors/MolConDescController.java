package hr.uniri.molapi.molecule.connectivityDescriptors;

import hr.uniri.molapi.model.Mol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("molecule")
public class MolConDescController {

    private final MolConDescService molConDescService;

    @Autowired
    public MolConDescController(MolConDescService molConDescService) {
        this.molConDescService = molConDescService;
    }

    @PostMapping("/connectivityDescription")
    public ResponseEntity<Float> connectivityDescription(@RequestBody final MolConDescRequest molConDescRequest) {
        return ResponseEntity.ok(molConDescService.connectivityDescription(molConDescRequest));
    }
}
