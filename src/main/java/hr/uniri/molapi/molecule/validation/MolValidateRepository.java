package hr.uniri.molapi.molecule.validation;

public interface MolValidateRepository {
    Boolean validate(String molecule, String methodName);
}
