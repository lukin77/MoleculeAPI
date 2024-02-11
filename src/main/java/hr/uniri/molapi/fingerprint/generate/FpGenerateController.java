package hr.uniri.molapi.fingerprint.generate;

import org.postgresql.util.PGobject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("fingerprint")
public class FpGenerateController {

    private final FpGenerateService fpGenerateService;

    @Autowired
    public FpGenerateController(FpGenerateService fpGenerateService) {
        this.fpGenerateService = fpGenerateService;
    }

    @PostMapping("/generate")
    public ResponseEntity<PGobject> generate(@RequestBody final FpGenerateRequest request) {
        return ResponseEntity.ok().body(fpGenerateService.generate(request));
    }

}
