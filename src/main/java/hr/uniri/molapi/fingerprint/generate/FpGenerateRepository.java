package hr.uniri.molapi.fingerprint.generate;

import hr.uniri.molapi.model.Mol;
import org.postgresql.util.PGobject;

public interface FpGenerateRepository {

    PGobject generate(Mol mol, Integer integer, String s);

    PGobject generate(Mol mol, String s);
}
