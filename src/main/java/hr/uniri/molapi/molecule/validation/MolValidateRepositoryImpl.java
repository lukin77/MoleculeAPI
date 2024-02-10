package hr.uniri.molapi.molecule.validation;

import hr.uniri.molapi.utils.SimpleJdbcCallFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MolValidateRepositoryImpl implements MolValidateRepository {
    private static final String IS_VALID_SMILES = "is_valid_smiles";
    private static final String IS_VALID_CTAB = "is_valid_ctab";
    private static final String IS_VALID_SMARTS = "is_valid_smarts";
    private static final String IS_VALID_MOL_PKL = "is_valid_mol_pkl";
    private final SimpleJdbcCallFactory simpleJdbcCallFactory;

    @Autowired
    public MolValidateRepositoryImpl(SimpleJdbcCallFactory simpleJdbcCallFactory) {
        this.simpleJdbcCallFactory = simpleJdbcCallFactory;
    }

    @Override
    public Boolean isValidSmiles(String smiles) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall(IS_VALID_SMILES)
                .executeFunction(Boolean.class, smiles);
    }

    @Override
    public Boolean isValidCtab(String ctab) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall(IS_VALID_CTAB)
                .executeFunction(Boolean.class, ctab);
    }

    @Override
    public Boolean isValidSmarts(String smarts) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall(IS_VALID_SMARTS)
                .executeFunction(Boolean.class, smarts);
    }

    @Override
    public Boolean isValidMolPk(String molPk) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall(IS_VALID_MOL_PKL)
                .executeFunction(Boolean.class, molPk);
    }
}
