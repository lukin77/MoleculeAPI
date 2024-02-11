package hr.uniri.molapi.fingerprint.work;

import hr.uniri.molapi.model.enums.Operation;
import hr.uniri.molapi.model.enums.Similarities;
import org.postgresql.util.PGobject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static hr.uniri.molapi.utils.ExecuteMethod.execute;

@Service
public class FpWorkServiceImpl implements FpWorkService {

    private final FpWorkRepository fpWorkRepository;

    @Autowired
    public FpWorkServiceImpl(FpWorkRepository fpWorkRepository) {
        this.fpWorkRepository = fpWorkRepository;
    }

    @Override
    public Double similarity(FpWorkRequest fpWorkRequest) {
        Similarities similarity = Similarities.valueOf(fpWorkRequest.getSimilarity());
        String fingerprint1 = fpWorkRequest.getFp1();
        String fingerprint2 = fpWorkRequest.getFp2();

        return switch (similarity) {
            case tanimoto_sml -> execute(fingerprint1, fingerprint2, fpWorkRepository::tanimotoSml);
            case dice_sml -> execute(fingerprint1, fingerprint2, fpWorkRepository::diceSml);
        };
    }

    @Override
    public Integer size(String fp) {
        return execute(fp, fpWorkRepository::size);
    }

    @Override
    public PGobject operation(FpWorkRequest fpWorkRequest) {
        Operation operation = Operation.valueOf(fpWorkRequest.getOperation());
        String fingerprint1 = fpWorkRequest.getFp1();
        String fingerprint2 = fpWorkRequest.getFp2();
        return execute(fingerprint1, fingerprint2, operation.name(), fpWorkRepository::operation);
    }

    @Override
    public Boolean allValuesLt(String fp, String lessThan) {
        return execute(fp, Integer.parseInt(lessThan), fpWorkRepository::allValuesLt);
    }

    @Override
    public Boolean allValuesGt(String fp, String greaterThan) {
        return execute(fp, Integer.parseInt(greaterThan), fpWorkRepository::allValuesGt);
    }

}
