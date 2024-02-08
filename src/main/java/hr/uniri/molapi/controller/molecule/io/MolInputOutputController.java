package hr.uniri.molapi.controller.molecule.io;

import hr.uniri.molapi.service.molecule.io.MolIoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("mol/io")
public class MolInputOutputController {

    private final MolIoService molIoService;

    @Autowired
    public MolInputOutputController(MolIoService molIoService) {
        this.molIoService = molIoService;
    }


}
