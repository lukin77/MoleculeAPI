package hr.uniri.molapi.molecule.validation;

import hr.uniri.molapi.utils.SimpleJdbcCallFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MolValidateRepositoryImpl implements MolValidateRepository {

    private final SimpleJdbcCallFactory simpleJdbcCallFactory;

    @Autowired
    public MolValidateRepositoryImpl(SimpleJdbcCallFactory simpleJdbcCallFactory) {
        this.simpleJdbcCallFactory = simpleJdbcCallFactory;
    }

    @Override
    public Boolean isValidSmiles(String smiles) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall("is_valid_smiles")
                .executeFunction(Boolean.class, smiles);
    }

    @Override
    public Boolean isValidCtab(String ctab) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall("is_valid_ctab")
                .executeFunction(Boolean.class, ctab);
    }

    @Override
    public Boolean isValidSmarts(String smarts) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall("is_valid_smarts")
                .executeFunction(Boolean.class, smarts);
    }

    @Override
    public Boolean isValidMolPk(String molPk) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall("is_valid_mol_pkl")
                .executeFunction(Boolean.class, molPk);
    }
}
