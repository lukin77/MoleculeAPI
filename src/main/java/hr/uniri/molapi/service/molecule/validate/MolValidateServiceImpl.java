package hr.uniri.molapi.service.molecule.validate;

import hr.uniri.molapi.repository.molecule.validate.MolValidateRepository;
import hr.uniri.molapi.utils.StringFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MolValidateServiceImpl implements MolValidateService {

    private final MolValidateRepository molValidateRepository;

    @Autowired
    public MolValidateServiceImpl(MolValidateRepository molValidateRepository) {
        this.molValidateRepository = molValidateRepository;
    }

    @Override
    public Boolean isValidSmiles(String smiles) {
        return executeInputOutputFunction(smiles, molValidateRepository::isValidSmiles);
    }

    @Override
    public Boolean isValidCtab(String ctab) {
        return executeInputOutputFunction(ctab, molValidateRepository::isValidCtab);
    }

    @Override
    public Boolean isValidSmarts(String smarts) {
        return executeInputOutputFunction(smarts, molValidateRepository::isValidSmarts);

    }

    @Override
    public Boolean isValidMolPk(String molPk) {
        return executeInputOutputFunction(molPk, molValidateRepository::isValidMolPk);
    }

    private Boolean executeInputOutputFunction(String param, StringFunction function) {
        return function.apply(param);
    }
}
