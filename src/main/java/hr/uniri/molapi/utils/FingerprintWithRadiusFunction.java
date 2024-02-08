package hr.uniri.molapi.utils;

import hr.uniri.molapi.model.Mol;

import java.util.List;
import java.util.Optional;

@FunctionalInterface
public interface FingerprintWithRadiusFunction {
    Optional<String> apply(Mol mol, Integer radius);
}
