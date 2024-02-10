package hr.uniri.molapi.controller.fingerprint.generate;

import hr.uniri.molapi.model.Mol;
import hr.uniri.molapi.service.fingerprint.generate.FpGenerateService;
import org.postgresql.util.PGobject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("fp/generate")
public class FpGenerateController {

    private final FpGenerateService fpGenerateService;

    private static final String DEFAULT_RADIUS = "2";

    @Autowired
    public FpGenerateController(FpGenerateService fpGenerateService) {
        this.fpGenerateService = fpGenerateService;
    }

    @PostMapping("/morganFp")
    public ResponseEntity<PGobject> morganFp(@RequestBody final Mol mol, @RequestParam(defaultValue = DEFAULT_RADIUS, required = false) String radius) {
        return ResponseEntity.ok().body(fpGenerateService.morganFp(mol, radius));
    }

    @PostMapping("/morganbvFp")
    public ResponseEntity<PGobject> morganbvFp(@RequestBody final Mol mol, @RequestParam(defaultValue = DEFAULT_RADIUS, required = false) String radius) {
        return ResponseEntity.ok().body(fpGenerateService.morganbvFp(mol, radius));
    }

    @PostMapping("/featmorgan_fp")
    public ResponseEntity<PGobject> featmorganFp(@RequestBody final Mol mol, @RequestParam(defaultValue = DEFAULT_RADIUS, required = false) String radius) {
        return ResponseEntity.ok().body(fpGenerateService.featmorganFp(mol, radius));
    }

    @PostMapping("/featmorganbv_fp")
    public ResponseEntity<PGobject> featmorganbvFp(@RequestBody final Mol mol, @RequestParam(defaultValue = DEFAULT_RADIUS, required = false) String radius) {
        return ResponseEntity.ok().body(fpGenerateService.featmorganbvFp(mol, radius));
    }

    @PostMapping("/rdkit_fp")
    public ResponseEntity<PGobject> rdkitFp(@RequestBody final Mol mol) {
        return ResponseEntity.ok().body(fpGenerateService.rdkitFp(mol));
    }

    @PostMapping("/atompair_fp")
    public ResponseEntity<PGobject> atompairFp(@RequestBody final Mol mol) {
        return ResponseEntity.ok().body(fpGenerateService.atompairFp(mol));
    }

    @PostMapping("/atompairbv_fp")
    public ResponseEntity<PGobject> atompairbvFp(@RequestBody final Mol mol) {
        return ResponseEntity.ok().body(fpGenerateService.atompairbvFp(mol));
    }

    @PostMapping("/torsion_fp")
    public ResponseEntity<PGobject> torsionFp(@RequestBody final Mol mol) {
        return ResponseEntity.ok().body(fpGenerateService.torsionFp(mol));
    }

    @PostMapping("/torsionbv_fp")
    public ResponseEntity<PGobject> torsionbvFp(@RequestBody final Mol mol) {
        return ResponseEntity.ok().body(fpGenerateService.torsionbvFp(mol));
    }

    @PostMapping("/layered_fp")
    public ResponseEntity<PGobject> layeredFp(@RequestBody final Mol mol) {
        return ResponseEntity.ok().body(fpGenerateService.layeredFp(mol));
    }

    @PostMapping("/maccs_fp")
    public ResponseEntity<PGobject> maccsFp(@RequestBody final Mol mol) {
        return ResponseEntity.ok().body(fpGenerateService.maccsFp(mol));
    }
}
