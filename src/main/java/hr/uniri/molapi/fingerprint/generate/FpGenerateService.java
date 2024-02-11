package hr.uniri.molapi.fingerprint.generate;

import org.postgresql.util.PGobject;

public interface FpGenerateService {

    PGobject generate(FpGenerateRequest request);
}
