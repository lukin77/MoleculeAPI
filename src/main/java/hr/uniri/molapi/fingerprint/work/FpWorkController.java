package hr.uniri.molapi.fingerprint.work;

import org.postgresql.util.PGobject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("fingerprint")
public class FpWorkController {
    private final FpWorkService fpWorkService;

    @Autowired
    public FpWorkController(FpWorkService fpWorkService) {
        this.fpWorkService = fpWorkService;
    }

    @PostMapping("/similarity")
    public ResponseEntity<Double> similarity(@RequestBody final FpWorkRequest fpWorkRequest) {
        return ResponseEntity.ok().body(fpWorkService.similarity(fpWorkRequest));
    }

    @PostMapping("/size")
    public ResponseEntity<Integer> size(@RequestBody final String fp) {
        return ResponseEntity.ok().body(fpWorkService.size(fp));
    }

    @PostMapping("/operation")
    public ResponseEntity<PGobject> operation(@RequestBody final FpWorkRequest fpWorkRequest) {
        return ResponseEntity.ok().body(fpWorkService.operation(fpWorkRequest));
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
