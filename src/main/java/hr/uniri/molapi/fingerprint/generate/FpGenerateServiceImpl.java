package hr.uniri.molapi.fingerprint.generate;

import hr.uniri.molapi.model.Mol;
import org.postgresql.util.PGobject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static hr.uniri.molapi.utils.ExecuteMethod.execute;

@Service
public class FpGenerateServiceImpl implements FpGenerateService {

    private final FpGenerateRepository fpGenerateRepository;

    @Autowired
    public FpGenerateServiceImpl(FpGenerateRepository fpGenerateRepository) {
        this.fpGenerateRepository = fpGenerateRepository;
    }

    @Override
    public PGobject morganFp(Mol mol, String radius) {
        return execute(mol, radius, fpGenerateRepository::morganFp);
    }

    @Override
    public PGobject morganbvFp(Mol mol, String radius) {
        return execute(mol, radius, fpGenerateRepository::morganbvFp);
    }

    @Override
    public PGobject featmorganFp(Mol mol, String radius) {
        return execute(mol, radius, fpGenerateRepository::featmorganFp);
    }

    @Override
    public PGobject featmorganbvFp(Mol mol, String radius) {
        return execute(mol, radius, fpGenerateRepository::featmorganbvFp);
    }

    @Override
    public PGobject rdkitFp(Mol mol) {
        return execute(mol, fpGenerateRepository::rdkitFp);
    }

    @Override
    public PGobject atompairFp(Mol mol) {
        return execute(mol, fpGenerateRepository::atompairFp);
    }

    @Override
    public PGobject atompairbvFp(Mol mol) {
        return execute(mol, fpGenerateRepository::atompairbvFp);
    }

    @Override
    public PGobject torsionFp(Mol mol) {
        return execute(mol, fpGenerateRepository::torsionFp);
    }

    @Override
    public PGobject torsionbvFp(Mol mol) {
        return execute(mol, fpGenerateRepository::torsionbvFp);
    }

    @Override
    public PGobject layeredFp(Mol mol) {
        return execute(mol, fpGenerateRepository::layeredFp);
    }

    @Override
    public PGobject maccsFp(Mol mol) {
        return execute(mol, fpGenerateRepository::maccsFp);
    }
}
