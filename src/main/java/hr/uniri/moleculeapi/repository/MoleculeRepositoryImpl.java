package hr.uniri.moleculeapi.repository;

import hr.uniri.moleculeapi.model.Molecule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
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
        parameters.put("m", molecule.getMol().getM());
        simpleJdbcInsert.execute(parameters);
        return Optional.of(molecule);
    }
}
