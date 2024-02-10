package hr.uniri.molapi.molecule.io;

import hr.uniri.molapi.model.Mol;
import hr.uniri.molapi.utils.SimpleJdbcCallFactory;
import org.springframework.stereotype.Repository;

@Repository
public class MolIoRepositoryImpl implements MolIoRepository {

    private final SimpleJdbcCallFactory simpleJdbcCallFactory;

    public MolIoRepositoryImpl(SimpleJdbcCallFactory simpleJdbcCallFactory) {
        this.simpleJdbcCallFactory = simpleJdbcCallFactory;
    }

    @Override
    public Mol molFromSmiles(String smiles) {
        return simpleJdbcCallFactory.getSimpleJdbcCall("mol_from_smiles")
                .executeFunction(Mol.class, smiles);
    }

    @Override
    public Mol molFromSmarts(String smarts) {
        return simpleJdbcCallFactory.getSimpleJdbcCall("mol_from_smarts")
                .executeFunction(Mol.class, smarts);
    }

    @Override
    public Mol molFromCtab(String ctab, Boolean bool) {
        return simpleJdbcCallFactory.getSimpleJdbcCall("mol_from_ctab")
                .executeFunction(Mol.class, ctab, bool);
    }

    @Override
    public Mol molFromPkl(String pkl) {
        return simpleJdbcCallFactory.getSimpleJdbcCall("mol_from_pkl")
                .executeFunction(Mol.class, pkl);
    }

    @Override
    public Mol qmolFromSmiles(String smiles) {
        return simpleJdbcCallFactory.getSimpleJdbcCall("qmol_from_smiles")
                .executeFunction(Mol.class, smiles);
    }

    @Override
    public Mol qmolFromCtab(String ctab, Boolean bool) {
        return simpleJdbcCallFactory.getSimpleJdbcCall("qmol_from_ctab")
                .executeFunction(Mol.class, ctab, bool);
    }

    @Override
    public String molToSmiles(Mol mol) {
        return simpleJdbcCallFactory.getSimpleJdbcCall("mol_to_smiles")
                .executeFunction(String.class, mol);
    }

    @Override
    public String molToCxsmiles(Mol mol) {
        return simpleJdbcCallFactory.getSimpleJdbcCall("mol_to_cxsmiles")
                .executeFunction(String.class, mol);
    }

    @Override
    public String molToSmarts(Mol mol) {
        return simpleJdbcCallFactory.getSimpleJdbcCall("mol_to_smarts")
                .executeFunction(String.class, mol);
    }

    @Override
    public String molToCxsmarts(Mol mol) {
        return simpleJdbcCallFactory.getSimpleJdbcCall("mol_to_cxsmarts")
                .executeFunction(String.class, mol);
    }

    @Override
    public String molToPkl(Mol mol) {
        return simpleJdbcCallFactory.getSimpleJdbcCall("mol_to_pkl")
                .executeFunction(String.class, mol);
    }

    @Override
    public String molToCtab(Mol mol) {
        return simpleJdbcCallFactory.getSimpleJdbcCall("mol_to_ctab")
                .executeFunction(String.class, mol);
    }

    @Override
    public String molToV3kctab(Mol mol) {
        return simpleJdbcCallFactory.getSimpleJdbcCall("mol_to_v3kctab")
                .executeFunction(String.class, mol);
    }

    @Override
    public String molToSvg(Mol mol) {
        return simpleJdbcCallFactory.getSimpleJdbcCall("mol_to_svg")
                .executeFunction(String.class, mol);
    }

    @Override
    public String molToJson(Mol mol) {
        return simpleJdbcCallFactory.getSimpleJdbcCall("mol_to_json")
                .executeFunction(String.class, mol);
    }

    @Override
    public String molFromJson(Mol mol) {
        return simpleJdbcCallFactory.getSimpleJdbcCall("mol_from_json")
                .executeFunction(String.class, mol);
    }

}
