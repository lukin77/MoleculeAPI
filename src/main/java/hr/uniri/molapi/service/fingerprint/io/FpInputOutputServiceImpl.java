package hr.uniri.molapi.service.fingerprint.io;

import hr.uniri.molapi.repository.fingerprint.io.FpInputOutputRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FpInputOutputServiceImpl implements FpInputOutputService {

    private final FpInputOutputRepository fpInputOutputRepository;

    @Autowired
    public FpInputOutputServiceImpl(FpInputOutputRepository fpInputOutputRepository) {
        this.fpInputOutputRepository = fpInputOutputRepository;
    }

    @Override
    public String bfpToBinaryText(String bfp) {
        return fpInputOutputRepository.bfpToBinaryText(bfp);
    }

    @Override
    public String bfpFromBinaryText(String bytea) {
        return fpInputOutputRepository.bfpFromBinaryText(bytea);
    }
}
