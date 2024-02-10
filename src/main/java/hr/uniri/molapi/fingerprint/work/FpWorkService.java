package hr.uniri.molapi.fingerprint.work;

import hr.uniri.molapi.model.FingerprintsRequest;
import org.postgresql.util.PGobject;

public interface FpWorkService {
    Double tanimotoSml(FingerprintsRequest fingerprintsRequest);

    Double diceSml(FingerprintsRequest fingerprintsRequest);

    Integer size(String fp);

    PGobject add(FingerprintsRequest fingerprintsRequest);

    PGobject subtract(FingerprintsRequest fingerprintsRequest);

    Boolean allValuesLt(String fp, String lessThan);

    Boolean allValuesGt(String fp, String greaterThan);
}
