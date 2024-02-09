package hr.uniri.molapi.controller.molecule.condesc;

import hr.uniri.molapi.service.molecule.condesc.MolConDescService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("mol/condesc")
public class MolConDescController {

    private final MolConDescService molConDescService;

    @Autowired
    public MolConDescController(MolConDescService molConDescService) {
        this.molConDescService = molConDescService;
    }
}
