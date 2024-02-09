package hr.uniri.molapi.repository.fingerprint.work;

public interface FpWorkRepository {
    Double tanimotoSml(String fp1, String fp2);

    Double diceSml(String fp1, String fp2);

    Integer size(String fp);

    String add(String fp1, String fp2);

    String subtract(String fp1, String fp2);

    Boolean allValuesLt(String fp1, Integer lessThan);

    Boolean allValuesGt(String fp1, Integer greaterThan);
}
