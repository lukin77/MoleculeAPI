package hr.uniri.molapi.repository.molecule.subop;

import hr.uniri.molapi.model.Mol;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

@Repository
public class MolSubOpRepositoryImpl implements MolSubOpRepository {

    private final SimpleJdbcCall simpleJdbcCall;

    public MolSubOpRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
    }

    @Override
    public Boolean substruct(Mol mol, Mol mol1) {
        return null;
    }

    @Override
    public Integer substructCount(Mol mol, Mol mol1, Boolean uniquified) {
        return null;
    }

    @Override
    public Mol molAdjustQueryProperties(Mol mol, String properties) {
        return null;
    }
}
