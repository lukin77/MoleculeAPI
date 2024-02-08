package hr.uniri.molapi.repository.molecule.validate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MolValidateRepositoryImpl implements MolValidateRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MolValidateRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Boolean isValidSmiles(String smiles) {
        return null;
    }

    @Override
    public Boolean isValidCtab(String ctab) {
        return null;
    }

    @Override
    public Boolean isValidSmarts(String smarts) {
        return null;
    }

    @Override
    public Boolean isValidMolPk(String molPk) {
        return null;
    }
}
