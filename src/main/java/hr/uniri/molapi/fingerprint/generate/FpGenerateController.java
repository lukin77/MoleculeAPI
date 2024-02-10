package hr.uniri.molapi.fingerprint.generate;

import hr.uniri.molapi.model.Mol;
import org.postgresql.util.PGobject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static hr.uniri.molapi.utils.Const.DEFAULT_RADIUS;

@RestController
@RequestMapping("fp/generate")
public class FpGenerateController {

    private final FpGenerateService fpGenerateService;

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

    @PostMapping("/featmorganFp")
    public ResponseEntity<PGobject> featmorganFp(@RequestBody final Mol mol, @RequestParam(defaultValue = DEFAULT_RADIUS, required = false) String radius) {
        return ResponseEntity.ok().body(fpGenerateService.featmorganFp(mol, radius));
    }

    @PostMapping("/featmorganbvFp")
    public ResponseEntity<PGobject> featmorganbvFp(@RequestBody final Mol mol, @RequestParam(defaultValue = DEFAULT_RADIUS, required = false) String radius) {
        return ResponseEntity.ok().body(fpGenerateService.featmorganbvFp(mol, radius));
    }

    @PostMapping("/rdkitFp")
    public ResponseEntity<PGobject> rdkitFp(@RequestBody final Mol mol) {
        return ResponseEntity.ok().body(fpGenerateService.rdkitFp(mol));
    }

    @PostMapping("/atompairFp")
    public ResponseEntity<PGobject> atompairFp(@RequestBody final Mol mol) {
        return ResponseEntity.ok().body(fpGenerateService.atompairFp(mol));
    }

    @PostMapping("/atompairbvFp")
    public ResponseEntity<PGobject> atompairbvFp(@RequestBody final Mol mol) {
        return ResponseEntity.ok().body(fpGenerateService.atompairbvFp(mol));
    }

    @PostMapping("/torsionFp")
    public ResponseEntity<PGobject> torsionFp(@RequestBody final Mol mol) {
        return ResponseEntity.ok().body(fpGenerateService.torsionFp(mol));
    }

    @PostMapping("/torsionbvFp")
    public ResponseEntity<PGobject> torsionbvFp(@RequestBody final Mol mol) {
        return ResponseEntity.ok().body(fpGenerateService.torsionbvFp(mol));
    }

    @PostMapping("/layeredFp")
    public ResponseEntity<PGobject> layeredFp(@RequestBody final Mol mol) {
        return ResponseEntity.ok().body(fpGenerateService.layeredFp(mol));
    }

    @PostMapping("/maccsFp")
    public ResponseEntity<PGobject> maccsFp(@RequestBody final Mol mol) {
        return ResponseEntity.ok().body(fpGenerateService.maccsFp(mol));
    }
}
