package hr.uniri.molapi.fingerprint.generate;

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
    public PGobject generate(Mol mol, Integer radius, String methodName) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall(methodName)
                .executeFunction(PGobject.class, mol.getSmiles(), radius);
    }

    @Override
    public PGobject generate(Mol mol, String methodName) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall(methodName)
                .executeFunction(PGobject.class, mol.getSmiles());
    }

}
