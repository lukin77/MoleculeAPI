package hr.uniri.molapi.service.fingerprint.generate;

import hr.uniri.molapi.model.Mol;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FpGenerateServiceImpl implements FpGenerateService {
    @Override
    public Optional<String> morganFp(Mol mol, Integer radius) {
        return Optional.empty();
    }

    @Override
    public Optional<String> morganbvFp(Mol mol, Integer radius) {
        return Optional.empty();
    }

    @Override
    public Optional<String> featmorganFp(Mol mol, Integer radius) {
        return Optional.empty();
    }

    @Override
    public Optional<String> featmorganbvFp(Mol mol, Integer radius) {
        return Optional.empty();
    }

    @Override
    public Optional<String> rdkitFp(Mol mol) {
        return Optional.empty();
    }

    @Override
    public Optional<String> atompairFp(Mol mol) {
        return Optional.empty();
    }

    @Override
    public Optional<String> torsionFp(Mol mol) {
        return Optional.empty();
    }

    @Override
    public Optional<String> layeredFp(Mol mol) {
        return Optional.empty();
    }

    @Override
    public Optional<String> maccsFp(Mol mol) {
        return Optional.empty();
    }
}
