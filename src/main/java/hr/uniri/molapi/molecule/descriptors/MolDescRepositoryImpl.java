package hr.uniri.molapi.molecule.descriptors;

import hr.uniri.molapi.model.Mol;
import hr.uniri.molapi.utils.SimpleJdbcCallFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MolDescRepositoryImpl implements MolDescRepository {

    private final SimpleJdbcCallFactory simpleJdbcCallFactory;

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MolDescRepositoryImpl(SimpleJdbcCallFactory simpleJdbcCallFactory, JdbcTemplate jdbcTemplate) {
        this.simpleJdbcCallFactory = simpleJdbcCallFactory;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Float molAmw(Mol mol) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall("mol_amw")
                .executeFunction(Float.class, mol.getSmiles());
    }

    @Override
    public Float molExactMw(Mol mol) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall("mol_exactmw")
                .executeFunction(Float.class, mol.getSmiles());
    }

    @Override
    public Float molLogP(Mol mol) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall("mol_logp")
                .executeFunction(Float.class, mol.getSmiles());
    }

    @Override
    public Float molTpsa(Mol mol) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall("mol_tpsa")
                .executeFunction(Float.class, mol.getSmiles());
    }

    @Override
    public Float molLabuteAsa(Mol mol) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall("mol_labuteasa")
                .executeFunction(Float.class, mol.getSmiles());
    }

    @Override
    public Float molFractionCsp3(Mol mol) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall("mol_fractioncsp3")
                .executeFunction(Float.class, mol.getSmiles());
    }

    @Override
    public Float molHba(Mol mol) {
        Integer integer = simpleJdbcCallFactory
                .getSimpleJdbcCall("mol_hba")
                .executeFunction(Integer.class, mol.getSmiles());
        return integer.floatValue();
    }

    @Override
    public Float molHbd(Mol mol) {
        Integer integer = simpleJdbcCallFactory
                .getSimpleJdbcCall("mol_hbd")
                .executeFunction(Integer.class, mol.getSmiles());
        return integer.floatValue();
    }

    @Override
    public Float molNumAtoms(Mol mol) {
        Integer integer = simpleJdbcCallFactory
                .getSimpleJdbcCall("mol_numatoms")
                .executeFunction(Integer.class, mol.getSmiles());
        return integer.floatValue();
    }

    @Override
    public Float molNumHeavyAtoms(Mol mol) {
        Integer integer = simpleJdbcCallFactory
                .getSimpleJdbcCall("mol_numheavyatoms")
                .executeFunction(Integer.class, mol.getSmiles());
        return integer.floatValue();
    }

    @Override
    public Float molNumRotatableBonds(Mol mol) {
        Integer integer = simpleJdbcCallFactory
                .getSimpleJdbcCall("mol_numrotatablebonds")
                .executeFunction(Integer.class, mol.getSmiles());
        return integer.floatValue();
    }

    @Override
    public Float molNumHeteroatoms(Mol mol) {
        Integer integer = simpleJdbcCallFactory
                .getSimpleJdbcCall("mol_numheteroatoms")
                .executeFunction(Integer.class, mol.getSmiles());
        return integer.floatValue();

    }

    @Override
    public Float molNumRings(Mol mol) {
        Integer integer = simpleJdbcCallFactory
                .getSimpleJdbcCall("mol_numrings")
                .executeFunction(Integer.class, mol.getSmiles());
        return integer.floatValue();

    }

    @Override
    public Float molNumAromaticRings(Mol mol) {
        Integer integer = simpleJdbcCallFactory
                .getSimpleJdbcCall("mol_numaromaticrings")
                .executeFunction(Integer.class, mol.getSmiles());
        return integer.floatValue();

    }

    @Override
    public Float molNumAliphaticRings(Mol mol) {
        Integer integer = simpleJdbcCallFactory
                .getSimpleJdbcCall("mol_numaliphaticrings")
                .executeFunction(Integer.class, mol.getSmiles());
        return integer.floatValue();

    }

    @Override
    public Float molNumSaturatedRings(Mol mol) {
        Integer integer = simpleJdbcCallFactory
                .getSimpleJdbcCall("mol_numsaturatedrings")
                .executeFunction(Integer.class, mol.getSmiles());
        return integer.floatValue();

    }

    @Override
    public Float molNumAromaticHeterocycles(Mol mol) {
        Integer integer = simpleJdbcCallFactory
                .getSimpleJdbcCall("mol_numaromaticheterocycles")
                .executeFunction(Integer.class, mol.getSmiles());
        return integer.floatValue();

    }

    @Override
    public Float molNumAliphaticHeterocycles(Mol mol) {
        Integer integer = simpleJdbcCallFactory
                .getSimpleJdbcCall("mol_numaliphaticheterocycles")
                .executeFunction(Integer.class, mol.getSmiles());
        return integer.floatValue();

    }

    @Override
    public Float molNumSaturatedHeterocycles(Mol mol) {
        Integer integer = simpleJdbcCallFactory
                .getSimpleJdbcCall("mol_numsaturatedheterocycles")
                .executeFunction(Integer.class, mol.getSmiles());
        return integer.floatValue();

    }

    @Override
    public Float molNumAromaticCarbocycles(Mol mol) {
        Integer integer = simpleJdbcCallFactory
                .getSimpleJdbcCall("mol_numaromaticcarbocycles")
                .executeFunction(Integer.class, mol.getSmiles());
        return integer.floatValue();

    }

    @Override
    public Float molNumAliphaticCarbocycles(Mol mol) {
        Integer integer = simpleJdbcCallFactory
                .getSimpleJdbcCall("mol_numaliphaticcarbocycles")
                .executeFunction(Integer.class, mol.getSmiles());
        return integer.floatValue();

    }

    @Override
    public Float molNumSaturatedCarbocycles(Mol mol) {
        Integer integer = simpleJdbcCallFactory
                .getSimpleJdbcCall("mol_numsaturatedcarbocycles")
                .executeFunction(Integer.class, mol.getSmiles());
        return integer.floatValue();

    }

    @Override
    public Float molNumSpiroAtoms(Mol mol) {
        Integer integer = simpleJdbcCallFactory
                .getSimpleJdbcCall("mol_numspiroatoms")
                .executeFunction(Integer.class, mol.getSmiles());
        return integer.floatValue();

    }

    @Override
    public Float molNumBridgeheadAtoms(Mol mol) {
        Integer integer = simpleJdbcCallFactory
                .getSimpleJdbcCall("mol_numbridgeheadatoms")
                .executeFunction(Integer.class, mol.getSmiles());
        return integer.floatValue();

    }

    // InChI not available
    @Override
    public String molInchi(Mol mol) {
        final String SQL = "SELECT mol_inchi(?::mol,'')";
        return jdbcTemplate.query(SQL,
                preparedStatement -> {
                    preparedStatement.setString(1, mol.getSmiles());
                }, resultSet -> {
                    resultSet.next();
                    return resultSet.getString(1);
                });
    }

    // InChI not available
    @Override
    public String molInchikey(Mol mol) {
        final String SQL = "SELECT mol_inchikey(?::mol,'')";
        return jdbcTemplate.query(SQL,
                preparedStatement -> {
                    preparedStatement.setString(1, mol.getSmiles());
                }, resultSet -> {
                    resultSet.next();
                    return resultSet.getString(1);
                });
    }

    @Override
    public Float molFormula(Mol mol) {
        return null;
    }

    @Override
    public Float molNmHash(Mol mol) {
        return null;
    }
}
