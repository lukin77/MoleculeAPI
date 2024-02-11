package hr.uniri.molapi.molecule.io;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("molecule")
public class MolInputOutputController {
    private final MolIoService molIoService;

    @Autowired
    public MolInputOutputController(MolIoService molIoService) {
        this.molIoService = molIoService;
    }

    @PostMapping("/molFrom")
    public ResponseEntity<String> molFrom(@RequestBody final MolInputOutputRequest molInputOutputRequest) {
        return ResponseEntity.ok(molIoService.molFrom(molInputOutputRequest));
    }

    @PostMapping("/molTo")
    public ResponseEntity<String> molTo(@RequestBody final MolInputOutputRequest molInputOutputRequest) {
        return ResponseEntity.ok(molIoService.molTo(molInputOutputRequest));
    }

}
