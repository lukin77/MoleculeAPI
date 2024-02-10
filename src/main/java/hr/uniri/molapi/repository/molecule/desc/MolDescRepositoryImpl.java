package hr.uniri.molapi.repository.molecule.desc;

import hr.uniri.molapi.model.Mol;
import hr.uniri.molapi.utils.SimpleJdbcCallFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MolDescRepositoryImpl implements MolDescRepository {

    private final SimpleJdbcCallFactory simpleJdbcCallFactory;

    @Autowired
    public MolDescRepositoryImpl(SimpleJdbcCallFactory simpleJdbcCallFactory) {
        this.simpleJdbcCallFactory = simpleJdbcCallFactory;
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
    public Integer molHba(Mol mol) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall("mol_hba")
                .executeFunction(Integer.class, mol.getSmiles());
    }

    @Override
    public Integer molHbd(Mol mol) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall("mol_hbd")
                .executeFunction(Integer.class, mol.getSmiles());
    }

    @Override
    public Integer molNumAtoms(Mol mol) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall("mol_numatoms")
                .executeFunction(Integer.class, mol.getSmiles());
    }

    @Override
    public Integer molNumHeavyAtoms(Mol mol) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall("mol_numheavyatoms")
                .executeFunction(Integer.class, mol.getSmiles());
    }

    @Override
    public Integer molNumRotatableBonds(Mol mol) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall("mol_numrotatablebonds")
                .executeFunction(Integer.class, mol.getSmiles());
    }

    @Override
    public Integer molNumHeteroatoms(Mol mol) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall("mol_numheteroatoms")
                .executeFunction(Integer.class, mol.getSmiles());
    }

    @Override
    public Integer molNumRings(Mol mol) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall("mol_numrings")
                .executeFunction(Integer.class, mol.getSmiles());
    }

    @Override
    public Integer molNumAromaticRings(Mol mol) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall("mol_numaromaticrings")
                .executeFunction(Integer.class, mol.getSmiles());
    }

    @Override
    public Integer molNumAliphaticRings(Mol mol) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall("mol_numaliphaticrings")
                .executeFunction(Integer.class, mol.getSmiles());
    }

    @Override
    public Integer molNumSaturatedRings(Mol mol) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall("mol_numsaturatedrings")
                .executeFunction(Integer.class, mol.getSmiles());
    }

    @Override
    public Integer molNumAromaticHeterocycles(Mol mol) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall("mol_numaromaticheterocycles")
                .executeFunction(Integer.class, mol.getSmiles());
    }

    @Override
    public Integer molNumAliphaticHeterocycles(Mol mol) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall("mol_numaliphaticheterocycles")
                .executeFunction(Integer.class, mol.getSmiles());
    }

    @Override
    public Integer molNumSaturatedHeterocycles(Mol mol) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall("mol_numsaturatedheterocycles")
                .executeFunction(Integer.class, mol.getSmiles());
    }

    @Override
    public Integer molNumAromaticCarbocycles(Mol mol) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall("mol_numaromaticcarbocycles")
                .executeFunction(Integer.class, mol.getSmiles());
    }

    @Override
    public Integer molNumAliphaticCarbocycles(Mol mol) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall("mol_numaliphaticcarbocycles")
                .executeFunction(Integer.class, mol.getSmiles());
    }

    @Override
    public Integer molNumSaturatedCarbocycles(Mol mol) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall("mol_numsaturatedcarbocycles")
                .executeFunction(Integer.class, mol.getSmiles());
    }

    @Override
    public Integer molNumSpiroAtoms(Mol mol) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall("mol_numspiroatoms")
                .executeFunction(Integer.class, mol.getSmiles());
    }

    @Override
    public Integer molNumBridgeheadAtoms(Mol mol) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall("mol_numbridgeheadatoms")
                .executeFunction(Integer.class, mol.getSmiles());
    }

    // InChI not available
    @Override
    public Integer molInchi(Mol mol) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall("mol_inchi")
                .executeFunction(Integer.class, mol.getSmiles());
    }

    // InChI not available
    @Override
    public Integer molInchikey(Mol mol) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall("mol_inchikey")
                .executeFunction(Integer.class, mol.getSmiles());
    }
}
