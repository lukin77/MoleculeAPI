package hr.uniri.molapi.repository.fingerprint.io;

public interface FpInputOutputRepository {
    String bfpToBinaryText(String bfp);

    String bfpFromBinaryText(String bytea);
}
