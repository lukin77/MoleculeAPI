package hr.uniri.molapi.controller.fingerprint.work;

import hr.uniri.molapi.service.fingerprint.work.FpWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("fingerprint/work")
public class FpWorkController {
    private final FpWorkService fpWorkService;

    @Autowired
    public FpWorkController(FpWorkService fpWorkService) {
        this.fpWorkService = fpWorkService;
    }
/*
    @PostMapping("/tanimotoSml")
    public ResponseEntity<Double> tanimotoSml(@RequestBody final String fp) {
        return ResponseEntity.ok(fpWorkService.tanimotoSml(fp, fp2));
    }

    @PostMapping("/diceSml")
    public ResponseEntity<String> diceSml(@RequestBody final String fp) {
        return ResponseEntity.ok(fpWorkService.diceSml(fp, fp));
    }

    @PostMapping("/size")
    public ResponseEntity<Integer> size(@RequestBody final String fp) {
        return ResponseEntity.ok(fpWorkService.size(fp));
    }

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody final String fp) {
        return ResponseEntity.ok(fpWorkService.add(fp, fp2));
    }

    @PostMapping("/subtract")
    public ResponseEntity<String> subtract(@RequestBody final String fp) {
        return ResponseEntity.ok(fpWorkService.subtract(fp, fp));
    }

    @PostMapping("/allValuesLt")
    public ResponseEntity<String> allValuesLt(@RequestBody final String fp) {
        return ResponseEntity.ok(fpWorkService.allValuesLt(fp, fp));
    }

    @PostMapping("/allValuesGt")
    public ResponseEntity<String> allValuesGt(@RequestBody final String fp) {
        return ResponseEntity.ok(fpWorkService.allValuesGt(fp, fp));
    }

 */
}
