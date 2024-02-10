package hr.uniri.molapi.molecule.validation;

public interface MolValidateService {
    Boolean isValidSmiles(String smiles);

    Boolean isValidCtab(String ctab);

    Boolean isValidSmarts(String smarts);

    Boolean isValidMolPk(String molPk);
}
