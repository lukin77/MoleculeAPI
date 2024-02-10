package hr.uniri.molapi.molecule.validation;

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
    public Boolean isValidSmiles(String smiles) {
        return execute(smiles, molValidateRepository::isValidSmiles);
    }

    @Override
    public Boolean isValidCtab(String ctab) {
        return execute(ctab, molValidateRepository::isValidCtab);
    }

    @Override
    public Boolean isValidSmarts(String smarts) {
        return execute(smarts, molValidateRepository::isValidSmarts);

    }

    @Override
    public Boolean isValidMolPk(String molPk) {
        return execute(molPk, molValidateRepository::isValidMolPk);
    }

}
