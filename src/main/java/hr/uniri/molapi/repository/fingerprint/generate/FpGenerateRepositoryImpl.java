package hr.uniri.molapi.repository.fingerprint.generate;

import hr.uniri.molapi.model.Mol;
import hr.uniri.molapi.utils.SimpleJdbcCallFactory;
import org.postgresql.util.PGobject;
import org.springframework.stereotype.Repository;

@Repository
public class FpGenerateRepositoryImpl implements FpGenerateRepository {

    private final SimpleJdbcCallFactory simpleJdbcCallFactory;

    public FpGenerateRepositoryImpl(SimpleJdbcCallFactory simpleJdbcCallFactory) {
        this.simpleJdbcCallFactory = simpleJdbcCallFactory;
    }

    @Override
    public PGobject morganFp(Mol mol, String radius) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall("morgan_fp")
                .executeFunction(PGobject.class, mol.getSmiles(), radius);
    }

    @Override
    public PGobject morganbvFp(Mol mol, String radius) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall("morganbv_fp")
                .executeFunction(PGobject.class, mol.getSmiles(), radius);
    }

    @Override
    public PGobject featmorganFp(Mol mol, String radius) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall("featmorgan_fp")
                .executeFunction(PGobject.class, mol.getSmiles(), radius);
    }

    @Override
    public PGobject featmorganbvFp(Mol mol, String radius) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall("featmorganbv_fp")
                .executeFunction(PGobject.class, mol.getSmiles(), radius);
    }

    @Override
    public PGobject rdkitFp(Mol mol) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall("rdkit_fp")
                .executeFunction(PGobject.class, mol.getSmiles());
    }

    @Override
    public PGobject atompairFp(Mol mol) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall("atompair_fp")
                .executeFunction(PGobject.class, mol.getSmiles());
    }

    @Override
    public PGobject atompairbvFp(Mol mol) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall("atompairbv_fp")
                .executeFunction(PGobject.class, mol.getSmiles());
    }

    @Override
    public PGobject torsionFp(Mol mol) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall("torsion_fp")
                .executeFunction(PGobject.class, mol.getSmiles());
    }

    @Override
    public PGobject torsionbvFp(Mol mol) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall("torsionbv_fp")
                .executeFunction(PGobject.class, mol.getSmiles());
    }

    @Override
    public PGobject layeredFp(Mol mol) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall("layered_fp")
                .executeFunction(PGobject.class, mol.getSmiles());
    }

    @Override
    public PGobject maccsFp(Mol mol) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall("maccs_fp")
                .executeFunction(PGobject.class, mol.getSmiles());
    }
}
