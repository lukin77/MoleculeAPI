package hr.uniri.molapi.molecule.substructureSearch;

import hr.uniri.molapi.model.Mol;
import hr.uniri.molapi.utils.MolRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MolSubSearchRepositoryImpl implements MolSubSearchRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MolSubSearchRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Mol> retrieveSubstructures(Mol mol) {
        final String sql = "SELECT * FROM mols WHERE ?@>m";
        return jdbcTemplate.query(sql,
                preparedStatement -> preparedStatement.setString(1, mol.getSmiles()),
                new MolRowMapper());
    }

    @Override
    public List<Mol> retrieveAllMolsWhichContainGivenSubstructure(Mol mol) {
        final String sql = "SELECT * FROM mols WHERE ?<@m";
        return jdbcTemplate.query(sql,
                preparedStatement -> preparedStatement.setString(1, mol.getSmiles()),
                new MolRowMapper());
    }

    @Override
    public Boolean compareIfTwoMolsAreEqual(String smiles1, String smiles2) {
        final String sql = "SELECT mol_from_smiles(?)@=mol_from_smiles(?) from mols limit 1";
        return jdbcTemplate.queryForObject(sql, Boolean.class, smiles1, smiles2);
    }
}
