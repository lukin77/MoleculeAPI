package hr.uniri.molapi.controller.molecule.io;

import hr.uniri.molapi.model.Mol;
import hr.uniri.molapi.service.molecule.io.MolIoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("mol/io")
public class MolInputOutputController {
    private final MolIoService molIoService;

    @Autowired
    public MolInputOutputController(MolIoService molIoService) {
        this.molIoService = molIoService;
    }

    @PostMapping("/molFromSmiles")
    public ResponseEntity<Mol> molFromSmiles(@RequestBody final String smiles) {
        return ResponseEntity.ok(molIoService.molFromSmiles(smiles));
    }

    @PostMapping("/molFromSmarts")
    public ResponseEntity<Mol> molFromSmarts(@RequestBody final String smarts) {
        return ResponseEntity.ok(molIoService.molFromSmarts(smarts));
    }

    @PostMapping("/molFromCtab")
    public ResponseEntity<Mol> molFromCtab(@RequestBody final String ctab, @RequestParam final Boolean bool) {
        return ResponseEntity.ok(molIoService.molFromCtab(ctab, bool));
    }

    @PostMapping("/molFromPkl")
    public ResponseEntity<Mol> molFromPkl(@RequestBody final String pkl) {
        return ResponseEntity.ok(molIoService.molFromPkl(pkl));
    }

    @PostMapping("/qmolFromSmiles")
    public ResponseEntity<Mol> qmolFromSmiles(@RequestBody final String smiles) {
        return ResponseEntity.ok(molIoService.qmolFromSmiles(smiles));
    }

    @PostMapping("/qmolFromCtab")
    public ResponseEntity<Mol> qmolFromCtab(@RequestBody final String ctab, @RequestParam final Boolean bool) {
        return ResponseEntity.ok(molIoService.qmolFromCtab(ctab, bool));
    }

    @PostMapping("/molToSmiles")
    public ResponseEntity<String> molToSmiles(@RequestBody final Mol mol) {
        return ResponseEntity.ok(molIoService.molToSmiles(mol));
    }

    @PostMapping("/molToCxsmiles")
    public ResponseEntity<String> molToCxsmiles(@RequestBody final Mol mol) {
        return ResponseEntity.ok(molIoService.molToCxsmiles(mol));
    }

    @PostMapping("/molToSmarts")
    public ResponseEntity<String> molToSmarts(@RequestBody final Mol mol) {
        return ResponseEntity.ok(molIoService.molToSmarts(mol));
    }

    @PostMapping("/molToCxsmarts")
    public ResponseEntity<String> molToCxsmarts(@RequestBody final Mol mol) {
        return ResponseEntity.ok(molIoService.molToCxsmarts(mol));
    }

    @PostMapping("/molToPkl")
    public ResponseEntity<String> molToPkl(@RequestBody final Mol mol) {
        return ResponseEntity.ok(molIoService.molToPkl(mol));
    }

    @PostMapping("/molToCtab")
    public ResponseEntity<String> molToCtab(@RequestBody final Mol mol, @RequestParam final Boolean bool, @RequestParam final Boolean bool2) {
        return ResponseEntity.ok(molIoService.molToCtab(mol, bool, bool2));
    }

    @PostMapping("/molToV3kctab")
    public ResponseEntity<String> molToV3kctab(@RequestBody final Mol mol, @RequestParam final Boolean bool) {
        return ResponseEntity.ok(molIoService.molToV3kctab(mol, bool));
    }

    @PostMapping("/molToSvg")
    public ResponseEntity<String> molToSvg(@RequestBody final Mol mol) {
        return ResponseEntity.ok(molIoService.molToSvg(mol));
    }

    @PostMapping("/molToJson")
    public ResponseEntity<String> molToJson(@RequestBody final Mol mol) {
        return ResponseEntity.ok(molIoService.molToJson(mol));
    }

    @PostMapping("/molFromJson")
    public ResponseEntity<String> molFromJson(@RequestBody final Mol mol) {
        return ResponseEntity.ok(molIoService.molFromJson(mol));
    }
}
