package hr.uniri.molapi.fingerprint.generate;

import hr.uniri.molapi.model.Mol;
import org.postgresql.util.PGobject;

public interface FpGenerateRepository {
    PGobject morganFp(Mol mol, Integer radius);

    PGobject morganbvFp(Mol mol, Integer radius);

    PGobject featmorganFp(Mol mol, Integer radius);

    PGobject featmorganbvFp(Mol mol, Integer radius);

    PGobject rdkitFp(Mol mol);

    PGobject atompairFp(Mol mol);

    PGobject torsionFp(Mol mol);

    PGobject torsionbvFp(Mol mol);

    PGobject layeredFp(Mol mol);

    PGobject maccsFp(Mol mol);

    PGobject atompairbvFp(Mol mol);
}
