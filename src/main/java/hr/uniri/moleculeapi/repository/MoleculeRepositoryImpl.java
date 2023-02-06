package hr.uniri.moleculeapi.repository;

import hr.uniri.moleculeapi.model.Molecule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class MoleculeRepositoryImpl implements MoleculeRepository{

    private final SimpleJdbcInsert simpleJdbcInsert;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MoleculeRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("mols").usingGeneratedKeyColumns("id");
    }

    @Override
    public Optional<Molecule> save(Molecule molecule) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("m", molecule.getStructure());
        simpleJdbcInsert.execute(parameters);
        return Optional.of(molecule);
    }

    @Override
    public Optional<List<Molecule>> searchBySubstructure(Molecule smilesMol) {
        final String SQL = "SELECT * FROM mols WHERE m@> ?::mol ";
        List <Molecule> details = jdbcTemplate.query(
                SQL, preparedStatement -> preparedStatement.setObject(1, smilesMol.getStructure()),
                new MoleculeRowMapper());
        return Optional.of(details);
    }
}
