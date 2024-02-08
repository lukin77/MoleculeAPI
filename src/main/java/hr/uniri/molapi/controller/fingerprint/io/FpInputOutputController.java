package hr.uniri.molapi.controller.fingerprint.io;

import hr.uniri.molapi.service.fingerprint.io.FpInputOutputService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
