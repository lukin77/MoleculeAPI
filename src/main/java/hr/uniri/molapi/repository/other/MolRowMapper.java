package hr.uniri.molapi.repository.other;

import hr.uniri.molapi.model.Mol;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MolRowMapper implements RowMapper<Mol> {
    @Override
    public Mol mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Mol(
                rs.getInt("id"),
                rs.getString("m")
        );
    }
}
