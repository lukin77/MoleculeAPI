package hr.uniri.molapi.service.fingerprint.generate;

import hr.uniri.molapi.model.Mol;
import hr.uniri.molapi.repository.fingerprint.generate.FpGenerateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;

@Service
public class FpGenerateServiceImpl implements FpGenerateService {

    private final FpGenerateRepository fpGenerateRepository;

    @Autowired
    public FpGenerateServiceImpl(FpGenerateRepository fpGenerateRepository) {
        this.fpGenerateRepository = fpGenerateRepository;
    }

    @Override
    public String morganFp(Mol mol, String radius) {
        return executeGenerateFunction(mol, radius, fpGenerateRepository::morganFp);
    }

    @Override
    public String morganbvFp(Mol mol, String radius) {
        return executeGenerateFunction(mol, radius, fpGenerateRepository::morganbvFp);
    }

    @Override
    public String featmorganFp(Mol mol, String radius) {
        return executeGenerateFunction(mol, radius, fpGenerateRepository::featmorganFp);
    }

    @Override
    public String featmorganbvFp(Mol mol, String radius) {
        return executeGenerateFunction(mol, radius, fpGenerateRepository::featmorganbvFp);
    }

    @Override
    public String rdkitFp(Mol mol) {
        return executeGenerateFunction(mol, fpGenerateRepository::rdkitFp);
    }

    @Override
    public String atompairFp(Mol mol) {
        return executeGenerateFunction(mol, fpGenerateRepository::atompairFp);
    }

    @Override
    public String torsionFp(Mol mol) {
        return executeGenerateFunction(mol, fpGenerateRepository::torsionFp);
    }

    @Override
    public String layeredFp(Mol mol) {
        return executeGenerateFunction(mol, fpGenerateRepository::layeredFp);
    }

    @Override
    public String maccsFp(Mol mol) {
        return executeGenerateFunction(mol, fpGenerateRepository::maccsFp);
    }

    private String executeGenerateFunction(Mol mol, Function<Mol, String> function) {
        return function.apply(mol);
    }

    private String executeGenerateFunction(Mol mol, String radius, BiFunction<Mol, String, String> function) {
        return function.apply(mol, radius);
    }
}
