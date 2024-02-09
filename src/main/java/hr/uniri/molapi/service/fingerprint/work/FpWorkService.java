package hr.uniri.molapi.service.fingerprint.work;

import hr.uniri.molapi.model.FingerprintsRequest;

public interface FpWorkService {
    Double tanimotoSml(FingerprintsRequest fingerprintsRequest);

    Double diceSml(FingerprintsRequest fingerprintsRequest);

    Integer size(String fp);

    String add(FingerprintsRequest fingerprintsRequest);

    String subtract(FingerprintsRequest fingerprintsRequest);

    Boolean allValuesLt(String fp, String lessThan);

    Boolean allValuesGt(String fp, String greaterThan);
}
