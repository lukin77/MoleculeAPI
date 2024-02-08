package hr.uniri.molapi.service.molecule.validate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class MolValidateServiceImpl implements MolValidateService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MolValidateServiceImpl(JdbcTemplate jdbcTemplate) {
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
