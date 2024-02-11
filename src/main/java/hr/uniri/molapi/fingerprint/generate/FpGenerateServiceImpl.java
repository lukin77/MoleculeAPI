package hr.uniri.molapi.fingerprint.generate;

import hr.uniri.molapi.model.enums.FingerprintMethod;
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
            case morgan_fp, morganbv_fp, featmorgan_fp, featmorganbv_fp ->
                    execute(mol, radius, method.name(), fpGenerateRepository::generate);
            case rdkit_fp, atompair_fp, atompairbv_fp, torsion_fp, torsionbv_fp, layered_fp, maccs_fp ->
                    execute(mol, method.name(), fpGenerateRepository::generate);
        };
    }
}
