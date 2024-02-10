package hr.uniri.molapi.fingerprint.work;

import hr.uniri.molapi.model.FingerprintsRequest;
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
    public Double tanimotoSml(FingerprintsRequest fingerprintsRequest) {
        return execute(fingerprintsRequest.getFp1(), fingerprintsRequest.getFp2(), fpWorkRepository::tanimotoSml);
    }

    @Override
    public Double diceSml(FingerprintsRequest fingerprintsRequest) {
        return execute(fingerprintsRequest.getFp1(), fingerprintsRequest.getFp2(), fpWorkRepository::diceSml);
    }

    @Override
    public Integer size(String fp) {
        return execute(fp, fpWorkRepository::size);
    }

    @Override
    public PGobject add(FingerprintsRequest fingerprintsRequest) {
        return execute(fingerprintsRequest.getFp1(), fingerprintsRequest.getFp2(), fpWorkRepository::add);
    }

    @Override
    public PGobject subtract(FingerprintsRequest fingerprintsRequest) {
        return execute(fingerprintsRequest.getFp1(), fingerprintsRequest.getFp2(), fpWorkRepository::subtract);
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
