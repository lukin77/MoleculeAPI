package hr.uniri.molapi.repository.other;

import hr.uniri.molapi.model.Mol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GeneralMolRepositoryImpl implements GeneralMolRepository {

    private final SimpleJdbcInsert simpleJdbcInsert;
    private final JdbcTemplate jdbcTemplate;

    private static final String MOLS_TABLE = "mols";
    private static final String MOL_TYPE = "::mol";

    @Autowired
    public GeneralMolRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName(MOLS_TABLE).usingGeneratedKeyColumns("id");
    }

    @Override
    public Mol save(Mol Mol) {
        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("m", Mol.getStructure());
        Number id = simpleJdbcInsert.executeAndReturnKey(parameters);
        Mol.setId(id.intValue());
        return Mol;
    }

    /*
     * @> : substructure search operator. Returns whether the mol or qmol on the right is a substructure of the mol on the left.
     * */
    @Override
    public List<Mol> searchBySubstructure(Mol Mol) {
        final String SQL = "SELECT * FROM " + MOLS_TABLE + " WHERE m@> ?::mol ";
        return jdbcTemplate.query(
                SQL, preparedStatement -> preparedStatement.setObject(1, Mol.getStructure()),
                new MolRowMapper());
    }

    /*
     * <@ : substructure search operator. Returns whether the mol or qmol on the left is a substructure of the mol on the right.
     * */


    /*
     * @= : returns whether two mols are the same.
     * */
}
