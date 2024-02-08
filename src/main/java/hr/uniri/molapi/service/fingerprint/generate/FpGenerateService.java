package hr.uniri.molapi.service.fingerprint.generate;

import hr.uniri.molapi.model.Mol;

import java.util.Optional;

public interface FpGenerateService {

    Optional<String> morganFp(Mol mol, Integer radius);

    Optional<String> morganbvFp(Mol mol, Integer radius);

    Optional<String> featmorganFp(Mol mol, Integer radius);

    Optional<String> featmorganbvFp(Mol mol, Integer radius);

    Optional<String> rdkitFp(Mol mol);

    Optional<String> atompairFp(Mol mol);

    Optional<String> torsionFp(Mol mol);

    Optional<String> layeredFp(Mol mol);

    Optional<String> maccsFp(Mol mol);
}
