package hr.uniri.molapi.repository.fingerprint.generate;

import hr.uniri.molapi.model.Mol;
import org.postgresql.util.PGobject;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

@Repository
public class FpGenerateRepositoryImpl implements FpGenerateRepository {

    private final SimpleJdbcCall simpleJdbcCall;

    public FpGenerateRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withSchemaName("public");
    }

    @Override
    public PGobject morganFp(Mol mol, String radius) {
        return simpleJdbcCall.withFunctionName("morgan_fp")
                .executeFunction(PGobject.class, mol.getStructure(), radius);
    }

    @Override
    public String morganbvFp(Mol mol, String radius) {
        return null;
    }

    @Override
    public String featmorganFp(Mol mol, String radius) {
        return null;
    }

    @Override
    public String featmorganbvFp(Mol mol, String radius) {
        return null;
    }

    @Override
    public String rdkitFp(Mol mol) {
        return null;
    }

    @Override
    public String atompairFp(Mol mol) {
        return null;
    }

    @Override
    public String torsionFp(Mol mol) {
        return null;
    }

    @Override
    public String layeredFp(Mol mol) {
        return null;
    }

    @Override
    public String maccsFp(Mol mol) {
        return null;
    }
}
