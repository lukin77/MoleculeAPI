package hr.uniri.molapi.fingerprint.work;

import org.postgresql.util.PGobject;

public interface FpWorkService {
    Double similarity(FpWorkRequest fpWorkRequest);

    Integer size(String fp);

    PGobject operation(FpWorkRequest fpWorkRequest);

    Boolean allValuesLt(String fp, String lessThan);

    Boolean allValuesGt(String fp, String greaterThan);

}
