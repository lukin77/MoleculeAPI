package hr.uniri.molapi.controller.molecule.desc;

import hr.uniri.molapi.service.molecule.desc.MolDescService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("mol/desc")
public class MolDescController {

    private final MolDescService molDescService;

    @Autowired
    public MolDescController(MolDescService molDescService) {
        this.molDescService = molDescService;
    }
}
