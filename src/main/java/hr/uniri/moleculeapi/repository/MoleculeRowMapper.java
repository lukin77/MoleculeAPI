package hr.uniri.moleculeapi.repository;

import hr.uniri.moleculeapi.model.Mol;
import hr.uniri.moleculeapi.model.Molecule;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MoleculeRowMapper implements RowMapper<Molecule> {
    @Override
    public Molecule mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Molecule(
                rs.getInt("id"),
                (Mol) rs.getObject("m")
        );
    }
}
