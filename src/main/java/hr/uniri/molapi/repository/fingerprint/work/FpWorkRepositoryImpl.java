package hr.uniri.molapi.repository.fingerprint.work;

import org.postgresql.util.PGobject;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

@Repository
public class FpWorkRepositoryImpl implements FpWorkRepository {

    private SimpleJdbcCall simpleJdbcCall;

    private final JdbcTemplate jdbcTemplate;

    public FpWorkRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withSchemaName("emolecules");
    }

    // Note that there are two types of fingerprints types: sfp and bfp
    // ToDo - add support for bfp
    @Override
    public Double tanimotoSml(String fp1, String fp2) {
        final String SQL = "SELECT tanimoto_sml(?::sfp, ?::sfp)";
        return jdbcTemplate.query(SQL,
                preparedStatement -> {
                    preparedStatement.setString(1, fp1);
                    preparedStatement.setString(2, fp2);
                }, resultSet -> {
                    resultSet.next();
                    return resultSet.getDouble(1);
                });
    }

    // Note that there are two types of fingerprints types: sfp and bfp
    // ToDo - add support for bfp
    @Override
    public Double diceSml(String fp1, String fp2) {
        final String SQL = "SELECT dice_sml(?::sfp, ?::sfp)";
        return jdbcTemplate.query(SQL,
                preparedStatement -> {
                    preparedStatement.setString(1, fp1);
                    preparedStatement.setString(2, fp2);
                }, resultSet -> {
                    resultSet.next();
                    return resultSet.getDouble(1);
                });
    }

    @Override
    public Integer size(String fp) {
        return simpleJdbcCall.withFunctionName("size")
                .executeFunction(Integer.class, fp);
    }

    @Override
    public PGobject add(String fp1, String fp2) {
        return simpleJdbcCall.withFunctionName("add")
                .executeFunction(PGobject.class, fp1, fp2);
    }

    @Override
    public PGobject subtract(String fp1, String fp2) {
        return simpleJdbcCall.withFunctionName("subtract")
                .executeFunction(PGobject.class, fp1, fp2);
    }

    @Override
    public Boolean allValuesLt(String fp1, Integer lessThan) {
        return simpleJdbcCall.withFunctionName("all_values_lt")
                .executeFunction(Boolean.class, fp1, lessThan);
    }

    @Override
    public Boolean allValuesGt(String fp1, Integer greaterThan) {
        return simpleJdbcCall.withFunctionName("all_values_gt")
                .executeFunction(Boolean.class, fp1, greaterThan);
    }

}
