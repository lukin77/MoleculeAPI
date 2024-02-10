package hr.uniri.molapi.fingerprint.work;

import hr.uniri.molapi.model.FingerprintsRequest;
import org.postgresql.util.PGobject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.BiFunction;
import java.util.function.Function;

@Service
public class FpWorkServiceImpl implements FpWorkService {

    private final FpWorkRepository fpWorkRepository;

    @Autowired
    public FpWorkServiceImpl(FpWorkRepository fpWorkRepository) {
        this.fpWorkRepository = fpWorkRepository;
    }

    @Override
    public Double tanimotoSml(FingerprintsRequest fingerprintsRequest) {
        return executeWorkFunction(fingerprintsRequest.getFp1(), fingerprintsRequest.getFp2(), fpWorkRepository::tanimotoSml);
    }

    @Override
    public Double diceSml(FingerprintsRequest fingerprintsRequest) {
        return executeWorkFunction(fingerprintsRequest.getFp1(), fingerprintsRequest.getFp2(), fpWorkRepository::diceSml);
    }

    @Override
    public Integer size(String fp) {
        return executeWorkFunction(fp, fpWorkRepository::size);
    }

    @Override
    public PGobject add(FingerprintsRequest fingerprintsRequest) {
        return executeWorkFunction(fingerprintsRequest.getFp1(), fingerprintsRequest.getFp2(), fpWorkRepository::add);
    }

    @Override
    public PGobject subtract(FingerprintsRequest fingerprintsRequest) {
        return executeWorkFunction(fingerprintsRequest.getFp1(), fingerprintsRequest.getFp2(), fpWorkRepository::subtract);
    }

    @Override
    public Boolean allValuesLt(String fp, String lessThan) {
        return executeWorkFunction(fp, Integer.parseInt(lessThan), fpWorkRepository::allValuesLt);
    }

    @Override
    public Boolean allValuesGt(String fp, String greaterThan) {
        return executeWorkFunction(fp, Integer.parseInt(greaterThan), fpWorkRepository::allValuesGt);
    }

    private Integer executeWorkFunction(String fp, Function<String, Integer> function) {
        return function.apply(fp);
    }

    private <T> T executeWorkFunction(String fp, String fp2, BiFunction<String, String, T> function) {
        return function.apply(fp, fp2);
    }

    private Boolean executeWorkFunction(String fp, Integer greaterOrLessThan, BiFunction<String, Integer, Boolean> function) {
        return function.apply(fp, greaterOrLessThan);
    }

}
