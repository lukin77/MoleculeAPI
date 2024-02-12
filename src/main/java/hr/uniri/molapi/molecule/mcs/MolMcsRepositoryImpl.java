package hr.uniri.molapi.molecule.mcs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MolMcsRepositoryImpl implements MolMcsRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MolMcsRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public String fmcs(String mols) {
        return jdbcTemplate.queryForObject("SELECT emolecules.fmcs(?::text)", String.class, mols);
    }

    @Override
    public String fmcsSmiles(String mols, String json) {
        return jdbcTemplate.queryForObject("SELECT emolecules.fmcs_smiles(?::text, ?)", String.class, mols, json);
    }
}
