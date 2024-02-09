package hr.uniri.molapi.repository.fingerprint.generate;

import hr.uniri.molapi.model.Mol;
import org.postgresql.util.PGobject;

public interface FpGenerateRepository {
    PGobject morganFp(Mol mol, String radius);

    PGobject morganbvFp(Mol mol, String radius);

    PGobject featmorganFp(Mol mol, String radius);

    PGobject featmorganbvFp(Mol mol, String radius);

    PGobject rdkitFp(Mol mol);

    PGobject atompairFp(Mol mol);

    PGobject torsionFp(Mol mol);

    PGobject layeredFp(Mol mol);

    PGobject maccsFp(Mol mol);
}
