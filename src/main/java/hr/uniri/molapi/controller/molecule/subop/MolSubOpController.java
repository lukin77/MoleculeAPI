package hr.uniri.molapi.controller.molecule.subop;

import hr.uniri.molapi.service.molecule.subop.MolSubOpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("mol/subop")
public class MolSubOpController {

    private final MolSubOpService molSubOpService;

    @Autowired
    public MolSubOpController(MolSubOpService molSubOpService) {
        this.molSubOpService = molSubOpService;
    }
}
