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
                .executeFunction(PGobject.class, mol.getSmiles(), radius);
    }

    @Override
    public PGobject morganbvFp(Mol mol, String radius) {
        return simpleJdbcCall.withFunctionName("morganbv_fp")
                .executeFunction(PGobject.class, mol.getSmiles(), radius);
    }

    @Override
    public PGobject featmorganFp(Mol mol, String radius) {
        return simpleJdbcCall.withFunctionName("featmorgan_fp")
                .executeFunction(PGobject.class, mol.getSmiles(), radius);
    }

    @Override
    public PGobject featmorganbvFp(Mol mol, String radius) {
        return simpleJdbcCall.withFunctionName("featmorganbv_fp")
                .executeFunction(PGobject.class, mol.getSmiles(), radius);
    }

    @Override
    public PGobject rdkitFp(Mol mol) {
        return simpleJdbcCall.withFunctionName("rdkit_fp")
                .executeFunction(PGobject.class, mol.getSmiles());
    }

    @Override
    public PGobject atompairFp(Mol mol) {
        return simpleJdbcCall.withFunctionName("atompair_fp")
                .executeFunction(PGobject.class, mol.getSmiles());
    }

    @Override
    public PGobject torsionFp(Mol mol) {
        return simpleJdbcCall.withFunctionName("torsion_fp")
                .executeFunction(PGobject.class, mol.getSmiles());
    }

    @Override
    public PGobject layeredFp(Mol mol) {
        return simpleJdbcCall.withFunctionName("layered_fp")
                .executeFunction(PGobject.class, mol.getSmiles());
    }

    @Override
    public PGobject maccsFp(Mol mol) {
        return simpleJdbcCall.withFunctionName("maccs_fp")
                .executeFunction(PGobject.class, mol.getSmiles());
    }
}
