package hr.uniri.molapi.repository.fingerprint.io;

import org.postgresql.util.PGobject;

public interface FpInputOutputRepository {
    byte[] bfpToBinaryText(String bfp);

    PGobject bfpFromBinaryText(byte[] bytea);
}
