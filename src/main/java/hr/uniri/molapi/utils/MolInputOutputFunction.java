package hr.uniri.molapi.utils;

@FunctionalInterface
public interface MolInputOutputFunction {
    Boolean apply(String smiles);
}
