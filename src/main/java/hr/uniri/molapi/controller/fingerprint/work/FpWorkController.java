package hr.uniri.molapi.controller.fingerprint.work;

import hr.uniri.molapi.service.fingerprint.work.FpWorkService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
