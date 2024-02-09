package hr.uniri.molapi.service.fingerprint.io;

public interface FpInputOutputService {
    String bfpToBinaryText(String bfp);

    String bfpFromBinaryText(String bytea);
}
