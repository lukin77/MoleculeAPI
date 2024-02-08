package hr.uniri.molapi.controller.fingerprint.generate;

import hr.uniri.molapi.model.Mol;
import hr.uniri.molapi.service.fingerprint.generate.FpGenerateService;
import hr.uniri.molapi.utils.FingerprintFunction;
import hr.uniri.molapi.utils.FingerprintWithRadiusFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("fp/generate")
public class FpGenerateController {

    private final FpGenerateService fpGenerateService;

    @Autowired
    public FpGenerateController(FpGenerateService fpGenerateService) {
        this.fpGenerateService = fpGenerateService;
    }

        /*
    morgan_fp, 
    morganbv_fp, 
    featmorgan_fp,
    featmorganbv_fp,
    rdkit_fp, 
    atompair_fp, 
    atompairbv_fp, 
    torsion_fp, 
    torsionbv_fp, 
    layered_fp
    maccs_fp
     */

    @PostMapping("/morganFp")
    public ResponseEntity<String> morganFp(@RequestBody final Mol mol, @RequestParam int radius) {
        return executeGenerateFP(mol, radius, fpGenerateService::morganFp);
    }

    @PostMapping("/morganbvFp")
    public ResponseEntity<String> morganbvFp(@RequestBody final Mol mol, @RequestParam int radius) {
        return executeGenerateFP(mol, radius, fpGenerateService::morganbvFp);
    }


    @PostMapping("/featmorgan_fp")
    public ResponseEntity<String> featmorganFp(@RequestBody final Mol mol, @RequestParam int radius) {
        return executeGenerateFP(mol, radius, fpGenerateService::featmorganFp);
    }

    @PostMapping("/featmorganbv_fp")
    public ResponseEntity<String> featmorganbvFp(@RequestBody final Mol mol, @RequestParam int radius) {
        return executeGenerateFP(mol, radius, fpGenerateService::featmorganbvFp);
    }

    @PostMapping("/rdkit_fp")
    public ResponseEntity<String> rdkitFp(@RequestBody final Mol mol) {
        return executeGenerateFP(mol, fpGenerateService::rdkitFp);
    }

    @PostMapping("/atompair_fp")
    public ResponseEntity<String> atompairFp(@RequestBody final Mol mol) {
        return executeGenerateFP(mol, fpGenerateService::atompairFp);
    }

    @PostMapping("/torsion_fp")
    public ResponseEntity<String> torsionFp(@RequestBody final Mol mol) {
        return executeGenerateFP(mol, fpGenerateService::torsionFp);
    }

    @PostMapping("/layered_fp")
    public ResponseEntity<String> layeredFp(@RequestBody final Mol mol) {
        return executeGenerateFP(mol, fpGenerateService::layeredFp);
    }

    @PostMapping("/maccs_fp")
    public ResponseEntity<String> maccsFp(@RequestBody final Mol mol) {
        return executeGenerateFP(mol, fpGenerateService::maccsFp);
    }

    private ResponseEntity<String> executeGenerateFP(Mol mol, FingerprintFunction function) {
        return function.apply(mol)
                .map(fingerprint -> ResponseEntity.ok().body(fingerprint))
                .orElse(ResponseEntity.noContent().build());
    }

    private ResponseEntity<String> executeGenerateFP(Mol mol, Integer radius, FingerprintWithRadiusFunction function) {
        return function.apply(mol, radius)
                .map(molList -> ResponseEntity.ok().body(molList))
                .orElse(ResponseEntity.noContent().build());
    }
}
