package hr.uniri.molapi.other;

import hr.uniri.molapi.model.Mol;
import hr.uniri.molapi.utils.MolRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GeneralMolRepositoryImpl implements GeneralMolRepository {

    public static final String RDKIT_VERSION_FUNCTION = "rdkit_version";
    public static final String RDKIT_TOOLKIT_VERSION_FUNCTION = "rdkit_toolkit_version";
    private final SimpleJdbcInsert simpleJdbcInsert;
    private final JdbcTemplate jdbcTemplate;
    private final SimpleJdbcCall simpleJdbcCall;
    private static final String MOLS_TABLE = "mols";
    private static final String MOL_TYPE = "::mol";

    @Autowired
    public GeneralMolRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName(MOLS_TABLE).usingGeneratedKeyColumns("id");
        this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withSchemaName("emolecules");
    }

    @Override
    public Mol save(Mol Mol) {
        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("m", Mol.getSmiles());
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
                SQL, preparedStatement -> preparedStatement.setObject(1, Mol.getSmiles()),
                new MolRowMapper());
    }

    @Override
    public String rdkitVersion() {
        return simpleJdbcCall.withFunctionName(RDKIT_VERSION_FUNCTION)
                .executeFunction(String.class);
    }

    @Override
    public String rdkitToolkitVersion() {
        return simpleJdbcCall.withFunctionName(RDKIT_TOOLKIT_VERSION_FUNCTION).executeFunction(String.class);
    }

    /*
     * <@ : substructure search operator. Returns whether the mol or qmol on the left is a substructure of the mol on the right.
     * */


    /*
     * @= : returns whether two mols are the same.
     * */
}
