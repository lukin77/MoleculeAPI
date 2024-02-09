package hr.uniri.molapi.controller.molecule.subop;

import hr.uniri.molapi.model.Mol;
import hr.uniri.molapi.service.molecule.subop.MolSubOpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @PostMapping("/substruct")
    public ResponseEntity<Boolean> substruct(@RequestBody List<Mol> mols) {
        return ResponseEntity.ok(molSubOpService.substruct(mols));
    }

    @PostMapping("/substructCount")
    public ResponseEntity<Integer> substructCount(@RequestBody List<Mol> mols, @RequestParam(required = false) final Boolean uniquified) {
        return ResponseEntity.ok(molSubOpService.substructCount(mols, uniquified));
    }

    @PostMapping("/molAdjustQueryProperties")
    public ResponseEntity<Mol> molAdjustQueryProperties(@RequestBody Mol mol, @RequestParam final String properties) {
        return ResponseEntity.ok(molSubOpService.molAdjustQueryProperties(mol, properties));
    }
}
