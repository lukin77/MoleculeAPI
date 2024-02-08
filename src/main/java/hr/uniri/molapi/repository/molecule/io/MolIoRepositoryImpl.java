package hr.uniri.molapi.repository.molecule.io;

import hr.uniri.molapi.model.Mol;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

@Repository
public class MolIoRepositoryImpl implements MolIoRepository {

    private final SimpleJdbcCall simpleJdbcCall;

    public MolIoRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withSchemaName("public");
    }

    @Override
    public Mol molFromSmiles(String smiles) {
        return simpleJdbcCall.withFunctionName("mol_from_smiles")
                .executeFunction(Mol.class, smiles);
    }

    @Override
    public Mol molFromSmarts(String smarts) {
        return simpleJdbcCall.withFunctionName("mol_from_smarts")
                .executeFunction(Mol.class, smarts);
    }

    @Override
    public Mol molFromCtab(String ctab, boolean bool) {
        return simpleJdbcCall.withFunctionName("mol_from_ctab")
                .executeFunction(Mol.class, ctab, bool);
    }

    @Override
    public Mol molFromPkl(String pkl) {
        return simpleJdbcCall.withFunctionName("mol_from_pkl")
                .executeFunction(Mol.class, pkl);
    }

    @Override
    public Mol qmolFromSmiles(String smiles) {
        return simpleJdbcCall.withFunctionName("qmol_from_smiles")
                .executeFunction(Mol.class, smiles);
    }

    @Override
    public Mol qmolFromCtab(String ctab, boolean bool) {
        return simpleJdbcCall.withFunctionName("qmol_from_ctab")
                .executeFunction(Mol.class, ctab, bool);
    }

    @Override
    public String molToSmiles(Mol mol) {
        return simpleJdbcCall.withFunctionName("mol_to_smiles")
                .executeFunction(String.class, mol);
    }

    @Override
    public String molToCxsmiles(Mol mol) {
        return simpleJdbcCall.withFunctionName("mol_to_cxsmiles")
                .executeFunction(String.class, mol);
    }

    @Override
    public String molToSmarts(Mol mol) {
        return simpleJdbcCall.withFunctionName("mol_to_smarts")
                .executeFunction(String.class, mol);
    }

    @Override
    public String molToCxsmarts(Mol mol) {
        return simpleJdbcCall.withFunctionName("mol_to_cxsmarts")
                .executeFunction(String.class, mol);
    }

    @Override
    public String molToPkl(Mol mol) {
        return simpleJdbcCall.withFunctionName("mol_to_pkl")
                .executeFunction(String.class, mol);
    }

    @Override
    public String molToCtab(Mol mol) {
        return simpleJdbcCall.withFunctionName("mol_to_ctab")
                .executeFunction(String.class, mol);
    }

    @Override
    public String molToV3kctab(Mol mol) {
        return simpleJdbcCall.withFunctionName("mol_to_v3kctab")
                .executeFunction(String.class, mol);
    }

    @Override
    public String molToSvg(Mol mol) {
        return simpleJdbcCall.withFunctionName("mol_to_svg")
                .executeFunction(String.class, mol);
    }

    @Override
    public String molToJson(Mol mol) {
        return simpleJdbcCall.withFunctionName("mol_to_json")
                .executeFunction(String.class, mol);
    }

    @Override
    public String molFromJson(Mol mol) {
        return simpleJdbcCall.withFunctionName("mol_from_json")
                .executeFunction(String.class, mol);
    }

}
