package hr.uniri.molapi.controller.fingerprint.work;

import hr.uniri.molapi.model.FingerprintsRequest;
import hr.uniri.molapi.service.fingerprint.work.FpWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("fingerprint/work")
public class FpWorkController {
    private final FpWorkService fpWorkService;

    @Autowired
    public FpWorkController(FpWorkService fpWorkService) {
        this.fpWorkService = fpWorkService;
    }

    @PostMapping("/tanimotoSml")
    public ResponseEntity<Double> tanimotoSml(@RequestBody final FingerprintsRequest fingerprintsRequest) {
        return ResponseEntity.ok().body(fpWorkService.tanimotoSml(fingerprintsRequest));
    }

    @PostMapping("/diceSml")
    public ResponseEntity<Double> diceSml(@RequestBody final FingerprintsRequest fingerprintsRequest) {
        return ResponseEntity.ok().body(fpWorkService.diceSml(fingerprintsRequest));
    }

    @PostMapping("/size")
    public ResponseEntity<Integer> size(@RequestBody final String fp) {
        return ResponseEntity.ok().body(fpWorkService.size(fp));
    }

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody final FingerprintsRequest fingerprintsRequest) {
        return ResponseEntity.ok().body(fpWorkService.add(fingerprintsRequest));
    }

    @PostMapping("/subtract")
    public ResponseEntity<String> subtract(@RequestBody final FingerprintsRequest fingerprintsRequest) {
        return ResponseEntity.ok().body(fpWorkService.subtract(fingerprintsRequest));
    }

    @PostMapping("/allValuesLt")
    public ResponseEntity<Boolean> allValuesLt(@RequestBody final String fp, @RequestParam(name = "lessThan") final String lessThan) {
        return ResponseEntity.ok().body(fpWorkService.allValuesLt(fp, lessThan));
    }

    @PostMapping("/allValuesGt")
    public ResponseEntity<Boolean> allValuesGt(@RequestBody final String fp, @RequestParam(name = "greaterThan") final String greaterThan) {
        return ResponseEntity.ok().body(fpWorkService.allValuesGt(fp, greaterThan));
    }
}
