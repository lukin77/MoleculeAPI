package hr.uniri.molapi.repository.molecule.validate;

public interface MolValidateRepository {
    Boolean isValidSmiles(String smiles);

    Boolean isValidCtab(String ctab);

    Boolean isValidSmarts(String smarts);

    Boolean isValidMolPk(String molPk);
}
