package hr.uniri.molapi.molecule.connectivityDescriptors;

import hr.uniri.molapi.model.Mol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("mol/condesc")
public class MolConDescController {

    private final MolConDescService molConDescService;

    @Autowired
    public MolConDescController(MolConDescService molConDescService) {
        this.molConDescService = molConDescService;
    }

    @PostMapping("/molChiXv")
    public ResponseEntity<Float> molChiXv(@RequestBody final Mol mol, @RequestParam(name = "X") final int x) {
        if (x < 0 || x > 4) return ResponseEntity.badRequest().build();

        return ResponseEntity.ok(molConDescService.molChiXv(mol, x));
    }

    @PostMapping("/molChiXn")
    public ResponseEntity<Float> molChiXn(@RequestBody final Mol mol, @RequestParam(name = "X") final int x) {
        if (x < 0 || x > 4) return ResponseEntity.badRequest().build();

        return ResponseEntity.ok(molConDescService.MolChiXn(mol, x));
    }


    @PostMapping("/molKappaX")
    public ResponseEntity<Float> molKappaX(@RequestBody final Mol mol, @RequestParam(name = "X") final int x) {
        if (x < 0 || x > 3) return ResponseEntity.badRequest().build();

        return ResponseEntity.ok(molConDescService.molKappaX(mol, x));
    }

    @PostMapping("/molPhi")
    public ResponseEntity<Float> molPhi(@RequestBody final Mol mol) {
        return ResponseEntity.ok(molConDescService.molPhi(mol));
    }

    @PostMapping("/molHallkieralpha")
    public ResponseEntity<Float> molHallkieralpha(@RequestBody final Mol mol) {
        return ResponseEntity.ok(molConDescService.molHallkieralpha(mol));
    }

}
