package hr.uniri.molapi.service.fingerprint.generate;

import hr.uniri.molapi.model.Mol;
import hr.uniri.molapi.repository.fingerprint.generate.FpGenerateRepository;
import org.postgresql.util.PGobject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public PGobject morganFp(Mol mol, String radius) {
        return executeGenerateFunction(mol, radius, fpGenerateRepository::morganFp);
    }

    @Override
    public PGobject morganbvFp(Mol mol, String radius) {
        return executeGenerateFunction(mol, radius, fpGenerateRepository::morganbvFp);
    }

    @Override
    public PGobject featmorganFp(Mol mol, String radius) {
        return executeGenerateFunction(mol, radius, fpGenerateRepository::featmorganFp);
    }

    @Override
    public PGobject featmorganbvFp(Mol mol, String radius) {
        return executeGenerateFunction(mol, radius, fpGenerateRepository::featmorganbvFp);
    }

    @Override
    public PGobject rdkitFp(Mol mol) {
        return executeGenerateFunction(mol, fpGenerateRepository::rdkitFp);
    }

    @Override
    public PGobject atompairFp(Mol mol) {
        return executeGenerateFunction(mol, fpGenerateRepository::atompairFp);
    }

    @Override
    public PGobject torsionFp(Mol mol) {
        return executeGenerateFunction(mol, fpGenerateRepository::torsionFp);
    }

    @Override
    public PGobject layeredFp(Mol mol) {
        return executeGenerateFunction(mol, fpGenerateRepository::layeredFp);
    }

    @Override
    public PGobject maccsFp(Mol mol) {
        return executeGenerateFunction(mol, fpGenerateRepository::maccsFp);
    }

    private <T> T executeGenerateFunction(Mol mol, Function<Mol, T> function) {
        return function.apply(mol);
    }

    private PGobject executeGenerateFunction(Mol mol, String radius, BiFunction<Mol, String, PGobject> function) {
        return function.apply(mol, radius);
    }
}
