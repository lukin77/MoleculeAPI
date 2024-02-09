package hr.uniri.molapi.repository.molecule.validate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

@Repository
public class MolValidateRepositoryImpl implements MolValidateRepository {
    private static final String IS_VALID_SMILES = "is_valid_smiles";
    private static final String IS_VALID_CTAB = "is_valid_ctab";
    private static final String IS_VALID_SMARTS = "is_valid_smarts";
    private static final String IS_VALID_MOL_PKL = "is_valid_mol_pkl";
    private final SimpleJdbcCall simpleJdbcCall;

    @Autowired
    public MolValidateRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withSchemaName("public");
    }

    @Override
    public Boolean isValidSmiles(String smiles) {
        return simpleJdbcCall.withFunctionName(IS_VALID_SMILES)
                .executeFunction(Boolean.class, smiles);
    }

    @Override
    public Boolean isValidCtab(String ctab) {
        return simpleJdbcCall.withFunctionName(IS_VALID_CTAB)
                .executeFunction(Boolean.class, ctab);
    }

    @Override
    public Boolean isValidSmarts(String smarts) {
        return simpleJdbcCall.withFunctionName(IS_VALID_SMARTS)
                .executeFunction(Boolean.class, smarts);
    }

    @Override
    public Boolean isValidMolPk(String molPk) {
        return simpleJdbcCall.withFunctionName(IS_VALID_MOL_PKL)
                .executeFunction(Boolean.class, molPk);
    }
}
