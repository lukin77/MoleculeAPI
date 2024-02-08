package hr.uniri.molapi.utils;

import hr.uniri.molapi.model.Mol;

import java.util.Optional;

@FunctionalInterface
public interface MolFunction {
    Optional<String> apply(Mol mol);

}
