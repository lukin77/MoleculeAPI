package hr.uniri.molapi.molecule.validation;

import hr.uniri.molapi.model.enums.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static hr.uniri.molapi.utils.ExecuteMethod.execute;

@Service
public class MolValidateServiceImpl implements MolValidateService {

    private final MolValidateRepository molValidateRepository;

    @Autowired
    public MolValidateServiceImpl(MolValidateRepository molValidateRepository) {
        this.molValidateRepository = molValidateRepository;
    }

    @Override
    public Boolean validate(MolValidateRequest molValidateRequest) {
        Validation validationMethod = Validation.valueOf(molValidateRequest.getValidationMethod());
        String molecule = molValidateRequest.getMolecule();
        return execute(molecule, validationMethod.name(), molValidateRepository::validate);
    }
}
