package hr.uniri.molapi.other;

import hr.uniri.molapi.model.Mol;
import hr.uniri.molapi.utils.SimpleJdbcCallFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import static hr.uniri.molapi.utils.Const.*;

@Repository
public class GeneralMolRepositoryImpl implements GeneralMolRepository {

    private final SimpleJdbcInsert simpleJdbcInsert;

    private final SimpleJdbcCallFactory simpleJdbcCallFactory;

    @Autowired
    public GeneralMolRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.simpleJdbcCallFactory = new SimpleJdbcCallFactory(jdbcTemplate);
        this.simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName(MOLS_TABLE)
                .usingGeneratedKeyColumns("id");
    }

    @Override
    public Mol save(Mol Mol) {
        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("m", Mol.getSmiles());
        Number id = simpleJdbcInsert.executeAndReturnKey(parameters);
        Mol.setId(id.intValue());
        return Mol;
    }

    @Override
    public String rdkitVersion() {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall(RDKIT_VERSION_FUNCTION)
                .executeFunction(String.class);
    }

    @Override
    public String rdkitToolkitVersion() {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall(RDKIT_TOOLKIT_VERSION_FUNCTION)
                .executeFunction(String.class);
    }


}
