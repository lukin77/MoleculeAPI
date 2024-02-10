package hr.uniri.molapi.controller.other;

import hr.uniri.molapi.service.other.GeneralMolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionRDKitController {

    private final GeneralMolService generalMolService;

    @Autowired
    public VersionRDKitController(GeneralMolService generalMolService) {
        this.generalMolService = generalMolService;
    }

    @GetMapping("/rdkitVersion")
    public @ResponseBody ResponseEntity<String> rdkitVersion() {
        return ResponseEntity.ok().body(generalMolService.rdkitVersion());
    }

    @GetMapping("/rdkitToolkitVersion")
    public @ResponseBody ResponseEntity<String> rdkitToolkitVersion() {
        return ResponseEntity.ok().body(generalMolService.rdkitToolkitVersion());
    }
}
