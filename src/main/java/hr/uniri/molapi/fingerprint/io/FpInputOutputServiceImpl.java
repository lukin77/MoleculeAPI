package hr.uniri.molapi.fingerprint.io;

import org.postgresql.util.PGobject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class FpInputOutputServiceImpl implements FpInputOutputService {

    private final FpInputOutputRepository fpInputOutputRepository;

    @Autowired
    public FpInputOutputServiceImpl(FpInputOutputRepository fpInputOutputRepository) {
        this.fpInputOutputRepository = fpInputOutputRepository;
    }

    @Override
    public String bfpToBinaryText(String bfp) {
        byte[] byteArray = fpInputOutputRepository.bfpToBinaryText(bfp);
        return Base64.getEncoder().encodeToString(byteArray);
    }

    @Override
    public PGobject bfpFromBinaryText(byte[] bytea) {
        return fpInputOutputRepository.bfpFromBinaryText(bytea);
    }
}
