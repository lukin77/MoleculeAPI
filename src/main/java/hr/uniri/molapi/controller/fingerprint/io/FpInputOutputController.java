package hr.uniri.molapi.controller.fingerprint.io;

import hr.uniri.molapi.service.fingerprint.io.FpInputOutputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("fp/io")
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
    public ResponseEntity<String> bfpFromBinaryText(@RequestBody final String bytea) {
        return ResponseEntity.ok(fpInputOutputService.bfpFromBinaryText(bytea));
    }
}
