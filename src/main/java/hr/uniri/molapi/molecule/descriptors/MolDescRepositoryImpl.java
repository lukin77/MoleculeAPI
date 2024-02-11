package hr.uniri.molapi.molecule.descriptors;

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
    public Float molHba(Mol mol) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall("mol_hba")
                .executeFunction(Float.class, mol.getSmiles());
    }

    @Override
    public Float molHbd(Mol mol) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall("mol_hbd")
                .executeFunction(Float.class, mol.getSmiles());
    }

    @Override
    public Float molNumAtoms(Mol mol) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall("mol_numatoms")
                .executeFunction(Float.class, mol.getSmiles());
    }

    @Override
    public Float molNumHeavyAtoms(Mol mol) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall("mol_numheavyatoms")
                .executeFunction(Float.class, mol.getSmiles());
    }

    @Override
    public Float molNumRotatableBonds(Mol mol) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall("mol_numrotatablebonds")
                .executeFunction(Float.class, mol.getSmiles());
    }

    @Override
    public Float molNumHeteroatoms(Mol mol) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall("mol_numheteroatoms")
                .executeFunction(Float.class, mol.getSmiles());
    }

    @Override
    public Float molNumRings(Mol mol) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall("mol_numrings")
                .executeFunction(Float.class, mol.getSmiles());
    }

    @Override
    public Float molNumAromaticRings(Mol mol) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall("mol_numaromaticrings")
                .executeFunction(Float.class, mol.getSmiles());
    }

    @Override
    public Float molNumAliphaticRings(Mol mol) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall("mol_numaliphaticrings")
                .executeFunction(Float.class, mol.getSmiles());
    }

    @Override
    public Float molNumSaturatedRings(Mol mol) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall("mol_numsaturatedrings")
                .executeFunction(Float.class, mol.getSmiles());
    }

    @Override
    public Float molNumAromaticHeterocycles(Mol mol) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall("mol_numaromaticheterocycles")
                .executeFunction(Float.class, mol.getSmiles());
    }

    @Override
    public Float molNumAliphaticHeterocycles(Mol mol) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall("mol_numaliphaticheterocycles")
                .executeFunction(Float.class, mol.getSmiles());
    }

    @Override
    public Float molNumSaturatedHeterocycles(Mol mol) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall("mol_numsaturatedheterocycles")
                .executeFunction(Float.class, mol.getSmiles());
    }

    @Override
    public Float molNumAromaticCarbocycles(Mol mol) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall("mol_numaromaticcarbocycles")
                .executeFunction(Float.class, mol.getSmiles());
    }

    @Override
    public Float molNumAliphaticCarbocycles(Mol mol) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall("mol_numaliphaticcarbocycles")
                .executeFunction(Float.class, mol.getSmiles());
    }

    @Override
    public Float molNumSaturatedCarbocycles(Mol mol) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall("mol_numsaturatedcarbocycles")
                .executeFunction(Float.class, mol.getSmiles());
    }

    @Override
    public Float molNumSpiroAtoms(Mol mol) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall("mol_numspiroatoms")
                .executeFunction(Float.class, mol.getSmiles());
    }

    @Override
    public Float molNumBridgeheadAtoms(Mol mol) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall("mol_numbridgeheadatoms")
                .executeFunction(Float.class, mol.getSmiles());
    }

    // InChI not available
    @Override
    public Float molInchi(Mol mol) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall("mol_inchi")
                .executeFunction(Float.class, mol.getSmiles());
    }

    // InChI not available
    @Override
    public Float molInchikey(Mol mol) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall("mol_inchikey")
                .executeFunction(Float.class, mol.getSmiles());
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
