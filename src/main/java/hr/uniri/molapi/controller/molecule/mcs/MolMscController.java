package hr.uniri.molapi.controller.molecule.mcs;

import hr.uniri.molapi.service.molecule.mcs.MolMcsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("mol/mcs")
public class MolMscController {

    private final MolMcsService molMcsService;

    @Autowired
    public MolMscController(MolMcsService molMcsService) {
        this.molMcsService = molMcsService;
    }
}
