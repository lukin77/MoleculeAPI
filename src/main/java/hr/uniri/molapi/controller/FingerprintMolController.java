package hr.uniri.molapi.controller;

import hr.uniri.molapi.model.Mol;
import hr.uniri.molapi.service.molService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("fingerprint-mol")
public class FingerprintMolController {

    private final molService molService;

    @Autowired
    public FingerprintMolController(molService molService) {
        this.molService = molService;
    }

    @GetMapping("/search")
    public ResponseEntity<List<Mol>> substructureSearchMol(@RequestBody final Mol Mol) {
        return molService.substructureSearch(Mol).map(
                        molList -> ResponseEntity.ok()
                                .body(molList))
                .orElse(ResponseEntity.notFound()
                        .build()
                );
    }

}
