package hr.uniri.molapi.fingerprint.work;

import org.postgresql.util.PGobject;

public interface FpWorkRepository {
    Double tanimotoSml(String fp1, String fp2);

    Double diceSml(String fp1, String fp2);

    PGobject operation(String fp1, String fp2, String methodName);

    Integer size(String fp);

    Boolean allValuesLt(String fp1, Integer lessThan);

    Boolean allValuesGt(String fp1, Integer greaterThan);
}
