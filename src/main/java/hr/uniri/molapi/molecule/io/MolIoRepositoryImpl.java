package hr.uniri.molapi.molecule.io;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MolIoRepositoryImpl implements MolIoRepository {

    private final JdbcTemplate jdbcTemplate;

    public MolIoRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public String molFrom(String molecule, String format) {
        final String sql = "SELECT mol_from_" + format + "(?::cstring)";
        return jdbcTemplate.queryForObject(sql, String.class, molecule);
    }

    @Override
    public String qmolFrom(String molecule, String format) {
        final String sql = "SELECT qmol_from_" + format + "(?::cstring)";
        return jdbcTemplate.queryForObject(sql, String.class, molecule);
    }

    @Override
    public String molFrom(byte[] molecule, String format) {
        final String sql = "SELECT mol_from_" + format + "(?::bytea)";
        return jdbcTemplate.queryForObject(sql, String.class, molecule);
    }

    @Override
    public String molTo(String molecule, String format) {
        final String sql = "SELECT mol_to_" + format + "(?::mol)";
        return jdbcTemplate.queryForObject(sql, String.class, molecule);
    }
}
