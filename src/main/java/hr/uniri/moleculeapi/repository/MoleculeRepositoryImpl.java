package hr.uniri.moleculeapi.repository;

import hr.uniri.moleculeapi.model.Molecule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MoleculeRepositoryImpl implements MoleculeRepository {

    private final SimpleJdbcInsert simpleJdbcInsert;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MoleculeRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("mols").usingGeneratedKeyColumns("id");
    }

    @Override
    public Molecule save(Molecule molecule) {
        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("m", molecule.getStructure());
        Number id = simpleJdbcInsert.executeAndReturnKey(parameters);
        molecule.setId(id.intValue());
        return molecule;
    }

    @Override
    public List<Molecule> searchBySubstructure(Molecule molecule) {
        final String SQL = "SELECT * FROM mols WHERE m@> ?::mol ";
        return jdbcTemplate.query(
                SQL, preparedStatement -> preparedStatement.setObject(1, molecule.getStructure()),
                new MoleculeRowMapper());
    }
}
