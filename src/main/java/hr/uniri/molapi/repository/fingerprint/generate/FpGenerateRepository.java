package hr.uniri.molapi.repository.fingerprint.generate;

import hr.uniri.molapi.model.Mol;
import org.postgresql.util.PGobject;

public interface FpGenerateRepository {
    PGobject morganFp(Mol mol, String radius);

    String morganbvFp(Mol mol, String radius);

    String featmorganFp(Mol mol, String radius);

    String featmorganbvFp(Mol mol, String radius);

    String rdkitFp(Mol mol);

    String atompairFp(Mol mol);

    String torsionFp(Mol mol);

    String layeredFp(Mol mol);

    String maccsFp(Mol mol);
}
