package hr.uniri.molapi.fingerprint.generate;

import hr.uniri.molapi.model.FingerprintMethod;
import hr.uniri.molapi.model.Mol;
import org.postgresql.util.PGobject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static hr.uniri.molapi.utils.Const.DEFAULT_RADIUS;
import static hr.uniri.molapi.utils.ExecuteMethod.execute;

@Service
public class FpGenerateServiceImpl implements FpGenerateService {

    private final FpGenerateRepository fpGenerateRepository;

    @Autowired
    public FpGenerateServiceImpl(FpGenerateRepository fpGenerateRepository) {
        this.fpGenerateRepository = fpGenerateRepository;
    }

    @Override
    public PGobject generate(FpGenerateRequest request) {
        FingerprintMethod method = FingerprintMethod.valueOf(request.getMethod());
        Mol mol = new Mol(request.getSmiles());
        Integer radius = request.getRadius() != null ? request.getRadius() : DEFAULT_RADIUS;

        return switch (method) {
            case morgan_fp -> execute(mol, radius, fpGenerateRepository::morganFp);
            case morganbv_fp -> execute(mol, radius, fpGenerateRepository::morganbvFp);
            case featmorgan_fp -> execute(mol, radius, fpGenerateRepository::featmorganFp);
            case featmorganbv_fp -> execute(mol, radius, fpGenerateRepository::featmorganbvFp);
            case rdkit_fp -> execute(mol, fpGenerateRepository::rdkitFp);
            case atompair_fp -> execute(mol, fpGenerateRepository::atompairFp);
            case atompairbv_fp -> execute(mol, fpGenerateRepository::atompairbvFp);
            case torsion_fp -> execute(mol, fpGenerateRepository::torsionFp);
            case torsionbv_fp -> execute(mol, fpGenerateRepository::torsionbvFp);
            case layered_fp -> execute(mol, fpGenerateRepository::layeredFp);
            case maccs_fp -> execute(mol, fpGenerateRepository::maccsFp);
        };
    }
}
