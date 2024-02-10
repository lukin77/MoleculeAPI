package hr.uniri.molapi.repository.molecule.connectivityDescriptors;

import hr.uniri.molapi.model.Mol;
import hr.uniri.molapi.utils.SimpleJdbcCallFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MolConDescRepositoryImpl implements MolConDescRepository {

    private final SimpleJdbcCallFactory simpleJdbcCallFactory;

    @Autowired
    public MolConDescRepositoryImpl(SimpleJdbcCallFactory simpleJdbcCallFactory) {
        this.simpleJdbcCallFactory = simpleJdbcCallFactory;
    }

    @Override
    public Float molChi0v(Mol mol) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall("mol_chi0v")
                .executeFunction(Float.class, mol.getSmiles());
    }

    @Override
    public Float molChi1v(Mol mol) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall("mol_chi1v")
                .executeFunction(Float.class, mol.getSmiles());
    }

    @Override
    public Float molChi2v(Mol mol) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall("mol_chi2v")
                .executeFunction(Float.class, mol.getSmiles());
    }

    @Override
    public Float molChi3v(Mol mol) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall("mol_chi3v")
                .executeFunction(Float.class, mol.getSmiles());
    }

    @Override
    public Float molChi4v(Mol mol) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall("mol_chi4v")
                .executeFunction(Float.class, mol.getSmiles());
    }

    @Override
    public Float molChi0n(Mol mol) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall("mol_chi0n")
                .executeFunction(Float.class, mol.getSmiles());
    }

    @Override
    public Float molChi1n(Mol mol) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall("mol_chi1n")
                .executeFunction(Float.class, mol.getSmiles());
    }

    @Override
    public Float molChi2n(Mol mol) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall("mol_chi2n")
                .executeFunction(Float.class, mol.getSmiles());
    }

    @Override
    public Float molChi3n(Mol mol) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall("mol_chi3n")
                .executeFunction(Float.class, mol.getSmiles());
    }

    @Override
    public Float molChi4n(Mol mol) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall("mol_chi4n")
                .executeFunction(Float.class, mol.getSmiles());
    }

    @Override
    public Float molKappa1(Mol mol) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall("mol_kappa1")
                .executeFunction(Float.class, mol.getSmiles());
    }

    @Override
    public Float molKappa2(Mol mol) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall("mol_kappa2")
                .executeFunction(Float.class, mol.getSmiles());
    }

    @Override
    public Float molKappa3(Mol mol) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall("mol_kappa3")
                .executeFunction(Float.class, mol.getSmiles());
    }

    @Override
    public Float molPhi(Mol mol) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall("mol_phi")
                .executeFunction(Float.class, mol.getSmiles());
    }

    @Override
    public Float molHallkieralpha(Mol mol) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall("mol_hallkieralpha")
                .executeFunction(Float.class, mol.getSmiles());
    }
}
