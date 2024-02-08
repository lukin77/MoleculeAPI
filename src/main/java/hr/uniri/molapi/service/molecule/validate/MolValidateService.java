package hr.uniri.molapi.service.molecule.validate;

public interface MolValidateService {
    Boolean isValidSmiles(String smiles);

    Boolean isValidCtab(String ctab);

    Boolean isValidSmarts(String smarts);

    Boolean isValidMolPk(String molPk);
}
