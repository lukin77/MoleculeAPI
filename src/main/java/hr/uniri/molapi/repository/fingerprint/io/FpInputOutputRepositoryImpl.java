package hr.uniri.molapi.repository.fingerprint.io;

import org.postgresql.util.PGobject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

@Repository
public class FpInputOutputRepositoryImpl implements FpInputOutputRepository {

    private SimpleJdbcCall simpleJdbcCall;

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public FpInputOutputRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
    }

    @Override
    public byte[] bfpToBinaryText(String bfp) {
        return simpleJdbcCall.withFunctionName("bfp_to_binary_text")
                .executeFunction(byte[].class, bfp);
    }

    @Override
    public PGobject bfpFromBinaryText(byte[] bytea) {
        return simpleJdbcCall.withFunctionName("bfp_from_binary_text")
                .executeFunction(PGobject.class, bytea);
    }
}
