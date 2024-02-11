package hr.uniri.molapi.fingerprint.work;

import hr.uniri.molapi.utils.SimpleJdbcCallFactory;
import org.postgresql.util.PGobject;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class FpWorkRepositoryImpl implements FpWorkRepository {

    private final SimpleJdbcCallFactory simpleJdbcCallFactory;

    private final JdbcTemplate jdbcTemplate;

    public FpWorkRepositoryImpl(SimpleJdbcCallFactory simpleJdbcCallFactory, JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.simpleJdbcCallFactory = simpleJdbcCallFactory;
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
        return simpleJdbcCallFactory
                .getSimpleJdbcCall("size")
                .executeFunction(Integer.class, fp);
    }

    @Override
    public PGobject operation(String fp1, String fp2, String methodName) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall(methodName)
                .executeFunction(PGobject.class, fp1, fp2);
    }

    @Override
    public Boolean allValuesLt(String fp1, Integer lessThan) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall("all_values_lt")
                .executeFunction(Boolean.class, fp1, lessThan);
    }

    @Override
    public Boolean allValuesGt(String fp1, Integer greaterThan) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall("all_values_gt")
                .executeFunction(Boolean.class, fp1, greaterThan);
    }

}
