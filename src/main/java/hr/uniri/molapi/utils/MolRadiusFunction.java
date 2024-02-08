package hr.uniri.molapi.utils;

import hr.uniri.molapi.model.Mol;

import java.util.Optional;

@FunctionalInterface
public interface MolRadiusFunction {
    Optional<String> apply(Mol mol, Integer radius);
}
