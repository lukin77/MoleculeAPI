package hr.uniri.molapi.fingerprint.work;

import org.postgresql.util.PGobject;

public interface FpWorkRepository {
    Double tanimotoSml(String fp1, String fp2);

    Double diceSml(String fp1, String fp2);

    Integer size(String fp);

    PGobject add(String fp1, String fp2);

    PGobject subtract(String fp1, String fp2);

    Boolean allValuesLt(String fp1, Integer lessThan);

    Boolean allValuesGt(String fp1, Integer greaterThan);
}
