package hr.uniri.molapi.controller.molecule.mcs;

import hr.uniri.molapi.model.Mol;
import hr.uniri.molapi.service.molecule.mcs.MolMcsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("mol/mcs")
public class MolMscController {

    private final MolMcsService molMcsService;

    @Autowired
    public MolMscController(MolMcsService molMcsService) {
        this.molMcsService = molMcsService;
    }

    @PostMapping("/fmcs")
    public ResponseEntity<Double> molAmw(@RequestBody final List<Mol> mols) {
        return ResponseEntity.ok(molMcsService.fmcs(mols));
    }

    @PostMapping("/fmcsSmiles")
    public ResponseEntity<Double> fmcsSmiles(@RequestBody final String mols, @RequestParam final String json) {
        return ResponseEntity.ok(molMcsService.fmcsSmiles(mols, json));
    }
}
