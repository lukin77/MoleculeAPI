package hr.uniri.molapi.controller.molecule.descriptors;

import hr.uniri.molapi.model.Mol;
import hr.uniri.molapi.service.molecule.descriptors.MolDescService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("mol/desc")
public class MolDescController {

    private final MolDescService molDescService;

    @Autowired
    public MolDescController(MolDescService molDescService) {
        this.molDescService = molDescService;
    }

    @PostMapping("/molAmw")
    public ResponseEntity<Float> molAmw(@RequestBody final Mol mol) {
        return ResponseEntity.ok(molDescService.molAmw(mol));
    }

    @PostMapping("/molExactMw")
    public ResponseEntity<Float> molExactMw(@RequestBody final Mol mol) {
        return ResponseEntity.ok(molDescService.molExactMw(mol));
    }

    @PostMapping("/molLogP")
    public ResponseEntity<Float> molLogP(@RequestBody final Mol mol) {
        return ResponseEntity.ok(molDescService.molLogP(mol));
    }

    @PostMapping("/molTpsa")
    public ResponseEntity<Float> molTpsa(@RequestBody final Mol mol) {
        return ResponseEntity.ok(molDescService.molTpsa(mol));
    }

    @PostMapping("/molLabuteAsa")
    public ResponseEntity<Float> molLabuteAsa(@RequestBody final Mol mol) {
        return ResponseEntity.ok(molDescService.molLabuteAsa(mol));
    }

    @PostMapping("/molFractionCsp3")
    public ResponseEntity<Float> molFractionCsp3(@RequestBody final Mol mol) {
        return ResponseEntity.ok(molDescService.molFractionCsp3(mol));
    }

    @PostMapping("/molHba")
    public ResponseEntity<Integer> molHba(@RequestBody final Mol mol) {
        return ResponseEntity.ok(molDescService.molHba(mol));
    }

    @PostMapping("/molHbd")
    public ResponseEntity<Integer> molHbd(@RequestBody final Mol mol) {
        return ResponseEntity.ok(molDescService.molHbd(mol));
    }

    @PostMapping("/molNumAtoms")
    public ResponseEntity<Integer> molNumAtoms(@RequestBody final Mol mol) {
        return ResponseEntity.ok(molDescService.molNumAtoms(mol));
    }

    @PostMapping("/molNumHeavyAtoms")
    public ResponseEntity<Integer> molNumHeavyAtoms(@RequestBody final Mol mol) {
        return ResponseEntity.ok(molDescService.molNumHeavyAtoms(mol));
    }

    @PostMapping("/molNumRotatableBonds")
    public ResponseEntity<Integer> molNumRotatableBonds(@RequestBody final Mol mol) {
        return ResponseEntity.ok(molDescService.molNumRotatableBonds(mol));
    }

    @PostMapping("/molNumHeteroatoms")
    public ResponseEntity<Integer> molNumHeteroatoms(@RequestBody final Mol mol) {
        return ResponseEntity.ok(molDescService.molNumHeteroatoms(mol));
    }

    @PostMapping("/molNumRings")
    public ResponseEntity<Integer> molNumRings(@RequestBody final Mol mol) {
        return ResponseEntity.ok(molDescService.molNumRings(mol));
    }

    @PostMapping("/molNumAromaticRings")
    public ResponseEntity<Integer> molNumAromaticRings(@RequestBody final Mol mol) {
        return ResponseEntity.ok(molDescService.molNumAromaticRings(mol));
    }

    @PostMapping("/molNumAliphaticRings")
    public ResponseEntity<Integer> molNumAliphaticRings(@RequestBody final Mol mol) {
        return ResponseEntity.ok(molDescService.molNumAliphaticRings(mol));
    }

    @PostMapping("/molNumSaturatedRings")
    public ResponseEntity<Integer> molNumSaturatedRings(@RequestBody final Mol mol) {
        return ResponseEntity.ok(molDescService.molNumSaturatedRings(mol));
    }

    @PostMapping("/molNumAromaticHeterocycles")
    public ResponseEntity<Integer> molNumAromaticHeterocycles(@RequestBody final Mol mol) {
        return ResponseEntity.ok(molDescService.molNumAromaticHeterocycles(mol));
    }

    @PostMapping("/molNumAliphaticHeterocycles")
    public ResponseEntity<Integer> molNumAliphaticHeterocycles(@RequestBody final Mol mol) {
        return ResponseEntity.ok(molDescService.molNumAliphaticHeterocycles(mol));
    }

    @PostMapping("/molNumSaturatedHeterocycles")
    public ResponseEntity<Integer> molNumSaturatedHeterocycles(@RequestBody final Mol mol) {
        return ResponseEntity.ok(molDescService.molNumSaturatedHeterocycles(mol));
    }

    @PostMapping("/molNumAromaticCarbocycles")
    public ResponseEntity<Integer> molNumAromaticCarbocycles(@RequestBody final Mol mol) {
        return ResponseEntity.ok(molDescService.molNumAromaticCarbocycles(mol));
    }

    @PostMapping("/molNumAliphaticCarbocycles")
    public ResponseEntity<Integer> molNumAliphaticCarbocycles(@RequestBody final Mol mol) {
        return ResponseEntity.ok(molDescService.molNumAliphaticCarbocycles(mol));
    }

    @PostMapping("/molNumSaturatedCarbocycles")
    public ResponseEntity<Integer> molNumSaturatedCarbocycles(@RequestBody final Mol mol) {
        return ResponseEntity.ok(molDescService.molNumSaturatedCarbocycles(mol));
    }

    @PostMapping("/molNumSpiroAtoms")
    public ResponseEntity<Integer> molNumSpiroAtoms(@RequestBody final Mol mol) {
        return ResponseEntity.ok(molDescService.molNumSpiroAtoms(mol));
    }

    @PostMapping("/molNumBridgeheadAtoms")
    public ResponseEntity<Integer> molNumBridgeheadAtoms(@RequestBody final Mol mol) {
        return ResponseEntity.ok(molDescService.molNumBridgeheadAtoms(mol));
    }

    // InChI not available
    @PostMapping("/molInchi")
    public ResponseEntity<Integer> molInchi(@RequestBody final Mol mol) {
        return ResponseEntity.ok(molDescService.molInchi(mol));
    }

    // InChI not available
    @PostMapping("/molInchikey")
    public ResponseEntity<Integer> molInchikey(@RequestBody final Mol mol) {
        return ResponseEntity.ok(molDescService.molInchikey(mol));
    }

    @PostMapping("/molFormula")
    public ResponseEntity<String> molFormula(@RequestBody final Mol mol,
                                             @RequestParam(value = "bool1", defaultValue = "false") Boolean bool1,
                                             @RequestParam(value = "bool2", defaultValue = "true") Boolean bool2) {
        return ResponseEntity.ok(molDescService.molFormula(mol, bool1, bool2));
    }

    @PostMapping("/molNmHash")
    public ResponseEntity<String> molNmHash(@RequestBody final Mol mol,
                                            @RequestParam(value = "hashType", defaultValue = "") String hashType) {
        return ResponseEntity.ok(molDescService.molNmHash(mol, hashType));
    }
}