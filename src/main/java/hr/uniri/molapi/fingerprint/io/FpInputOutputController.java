package hr.uniri.molapi.fingerprint.io;

import org.postgresql.util.PGobject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("fingerprint/io")
public class FpInputOutputController {
    private final FpInputOutputService fpInputOutputService;

    @Autowired
    public FpInputOutputController(FpInputOutputService fpInputOutputService) {
        this.fpInputOutputService = fpInputOutputService;
    }

    @PostMapping("/bfpToBinaryText")
    public ResponseEntity<String> bfpToBinaryText(@RequestBody final String bfp) {
        return ResponseEntity.ok(fpInputOutputService.bfpToBinaryText(bfp));
    }

    @PostMapping("/bfpFromBinaryText")
    public ResponseEntity<PGobject> bfpFromBinaryText(@RequestBody final byte[] bytea) {
        return ResponseEntity.ok(fpInputOutputService.bfpFromBinaryText(bytea));
    }
}
