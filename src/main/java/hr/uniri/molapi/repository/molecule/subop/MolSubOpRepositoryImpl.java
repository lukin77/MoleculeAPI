package hr.uniri.molapi.repository.molecule.subop;

import hr.uniri.molapi.model.Mol;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

@Repository
public class MolSubOpRepositoryImpl implements MolSubOpRepository {

    private final SimpleJdbcCall simpleJdbcCall;

    private final JdbcTemplate jdbcTemplate;

    public MolSubOpRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
    }

    @Override
    public Boolean substruct(Mol mol, Mol mol1) {
        final String SQL = "SELECT substruct(mol_from_smiles(?::cstring), mol_from_smiles(?::cstring))";
        return jdbcTemplate.query(SQL,
                preparedStatement -> {
                    preparedStatement.setString(1, mol.getSmiles());
                    preparedStatement.setString(2, mol1.getSmiles());
                }, resultSet -> {
                    resultSet.next();
                    return resultSet.getBoolean(1);
                });
    }

    @Override
    public Integer substructCount(Mol mol, Mol mol1, Boolean uniquified) {
        final String SQL = "SELECT substruct_count(mol_from_smiles(?::cstring), mol_from_smiles(?::cstring), ?)";
        return jdbcTemplate.query(SQL,
                preparedStatement -> {
                    preparedStatement.setString(1, mol.getSmiles());
                    preparedStatement.setString(2, mol1.getSmiles());
                    preparedStatement.setBoolean(3, uniquified);
                }, resultSet -> {
                    resultSet.next();
                    return resultSet.getInt(1);
                });
    }

    @Override
    public Mol molAdjustQueryProperties(Mol mol, String properties) {
        return null;
    }
}
