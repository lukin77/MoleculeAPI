package hr.uniri.molapi.repository.molecule.desc;

import hr.uniri.molapi.model.Mol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

@Repository
public class MolDescRepositoryImpl implements MolDescRepository {

    private final SimpleJdbcCall simpleJdbcCall;

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MolDescRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withSchemaName("public");
    }

    @Override
    public Float molAmw(Mol mol) {
        return simpleJdbcCall.withFunctionName("mol_amw")
                .executeFunction(Float.class, mol.getSmiles());
    }

    @Override
    public Float molExactMw(Mol mol) {
        return simpleJdbcCall.withFunctionName("mol_exactmw")
                .executeFunction(Float.class, mol.getSmiles());
    }

    @Override
    public Float molLogP(Mol mol) {
        return simpleJdbcCall.withFunctionName("mol_logp")
                .executeFunction(Float.class, mol.getSmiles());
    }

    @Override
    public Float molTpsa(Mol mol) {
        return simpleJdbcCall.withFunctionName("mol_tpsa")
                .executeFunction(Float.class, mol.getSmiles());
    }

    @Override
    public Float molLabuteAsa(Mol mol) {
        return simpleJdbcCall.withFunctionName("mol_labuteasa")
                .executeFunction(Float.class, mol.getSmiles());
    }

    @Override
    public Float molFractionCsp3(Mol mol) {
        return simpleJdbcCall.withFunctionName("mol_fractioncsp3")
                .executeFunction(Float.class, mol.getSmiles());
    }

    @Override
    public Integer molHba(Mol mol) {
        return simpleJdbcCall.withFunctionName("mol_hba")
                .executeFunction(Integer.class, mol.getSmiles());
    }

    @Override
    public Integer molHbd(Mol mol) {
        return simpleJdbcCall.withFunctionName("mol_hbd")
                .executeFunction(Integer.class, mol.getSmiles());
    }

    @Override
    public Integer molNumAtoms(Mol mol) {
        return simpleJdbcCall.withFunctionName("mol_numatoms")
                .executeFunction(Integer.class, mol.getSmiles());
    }

    @Override
    public Integer molNumHeavyAtoms(Mol mol) {
        return simpleJdbcCall.withFunctionName("mol_numheavyatoms")
                .executeFunction(Integer.class, mol.getSmiles());
    }

    @Override
    public Integer molNumRotatableBonds(Mol mol) {
        return simpleJdbcCall.withFunctionName("mol_numrotatablebonds")
                .executeFunction(Integer.class, mol.getSmiles());
    }

    @Override
    public Integer molNumHeteroatoms(Mol mol) {
        return simpleJdbcCall.withFunctionName("mol_numheteroatoms")
                .executeFunction(Integer.class, mol.getSmiles());
    }

    @Override
    public Integer molNumRings(Mol mol) {
        return simpleJdbcCall.withFunctionName("mol_numrings")
                .executeFunction(Integer.class, mol.getSmiles());
    }

    @Override
    public Integer molNumAromaticRings(Mol mol) {
        return simpleJdbcCall.withFunctionName("mol_numaromaticrings")
                .executeFunction(Integer.class, mol.getSmiles());
    }

    @Override
    public Integer molNumAliphaticRings(Mol mol) {
        return simpleJdbcCall.withFunctionName("mol_numaliphaticrings")
                .executeFunction(Integer.class, mol.getSmiles());
    }

    @Override
    public Integer molNumSaturatedRings(Mol mol) {
        return simpleJdbcCall.withFunctionName("mol_numsaturatedrings")
                .executeFunction(Integer.class, mol.getSmiles());
    }

    @Override
    public Integer molNumAromaticHeterocycles(Mol mol) {
        return simpleJdbcCall.withFunctionName("mol_numaromaticheterocycles")
                .executeFunction(Integer.class, mol.getSmiles());
    }

    @Override
    public Integer molNumAliphaticHeterocycles(Mol mol) {
        return simpleJdbcCall.withFunctionName("mol_numaliphaticheterocycles")
                .executeFunction(Integer.class, mol.getSmiles());
    }

    @Override
    public Integer molNumSaturatedHeterocycles(Mol mol) {
        return simpleJdbcCall.withFunctionName("mol_numsaturatedheterocycles")
                .executeFunction(Integer.class, mol.getSmiles());
    }

    @Override
    public Integer molNumAromaticCarbocycles(Mol mol) {
        return simpleJdbcCall.withFunctionName("mol_numaromaticcarbocycles")
                .executeFunction(Integer.class, mol.getSmiles());
    }

    @Override
    public Integer molNumAliphaticCarbocycles(Mol mol) {
        return simpleJdbcCall.withFunctionName("mol_numaliphaticcarbocycles")
                .executeFunction(Integer.class, mol.getSmiles());
    }

    @Override
    public Integer molNumSaturatedCarbocycles(Mol mol) {
        return simpleJdbcCall.withFunctionName("mol_numsaturatedcarbocycles")
                .executeFunction(Integer.class, mol.getSmiles());
    }

    @Override
    public Integer molNumSpiroAtoms(Mol mol) {
        return simpleJdbcCall.withFunctionName("mol_numspiroatoms")
                .executeFunction(Integer.class, mol.getSmiles());
    }

    @Override
    public Integer molNumBridgeheadAtoms(Mol mol) {
        return simpleJdbcCall.withFunctionName("mol_numbridgeheadatoms")
                .executeFunction(Integer.class, mol.getSmiles());
    }

    // InChI not available
    @Override
    public Integer molInchi(Mol mol) {
        return simpleJdbcCall.withFunctionName("mol_inchi")
                .executeFunction(Integer.class, mol.getSmiles());
    }

    // InChI not available
    @Override
    public Integer molInchikey(Mol mol) {
        return simpleJdbcCall.withFunctionName("mol_inchikey")
                .executeFunction(Integer.class, mol.getSmiles());
    }
}
