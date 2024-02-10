package hr.uniri.molapi.fingerprint.io;

import org.postgresql.util.PGobject;

public interface FpInputOutputService {
    String bfpToBinaryText(String bfp);

    PGobject bfpFromBinaryText(byte[] bytea);
}
