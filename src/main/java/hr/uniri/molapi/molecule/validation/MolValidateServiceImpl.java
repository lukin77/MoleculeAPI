package hr.uniri.molapi.molecule.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class MolValidateServiceImpl implements MolValidateService {

    private final MolValidateRepository molValidateRepository;

    @Autowired
    public MolValidateServiceImpl(MolValidateRepository molValidateRepository) {
        this.molValidateRepository = molValidateRepository;
    }

    @Override
    public Boolean isValidSmiles(String smiles) {
        return executeValidateFunction(smiles, molValidateRepository::isValidSmiles);
    }

    @Override
    public Boolean isValidCtab(String ctab) {
        return executeValidateFunction(ctab, molValidateRepository::isValidCtab);
    }

    @Override
    public Boolean isValidSmarts(String smarts) {
        return executeValidateFunction(smarts, molValidateRepository::isValidSmarts);

    }

    @Override
    public Boolean isValidMolPk(String molPk) {
        return executeValidateFunction(molPk, molValidateRepository::isValidMolPk);
    }

    private Boolean executeValidateFunction(String param, Function<String, Boolean> validate) {
        return validate.apply(param);
    }
}
