package hr.uniri.molapi.service.fingerprint.io;

import org.postgresql.util.PGobject;

public interface FpInputOutputService {
    String bfpToBinaryText(String bfp);

    PGobject bfpFromBinaryText(byte[] bytea);
}
