package hr.uniri.molapi.repository.fingerprint.io;

import hr.uniri.molapi.utils.SimpleJdbcCallFactory;
import org.postgresql.util.PGobject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FpInputOutputRepositoryImpl implements FpInputOutputRepository {

    private final SimpleJdbcCallFactory simpleJdbcCallFactory;

    @Autowired
    public FpInputOutputRepositoryImpl(SimpleJdbcCallFactory simpleJdbcCallFactory) {
        this.simpleJdbcCallFactory = simpleJdbcCallFactory;
    }

    @Override
    public byte[] bfpToBinaryText(String bfp) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall("bfp_to_binary_text")
                .executeFunction(byte[].class, bfp);
    }

    @Override
    public PGobject bfpFromBinaryText(byte[] bytea) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall("bfp_from_binary_text")
                .executeFunction(PGobject.class, bytea);
    }
}
