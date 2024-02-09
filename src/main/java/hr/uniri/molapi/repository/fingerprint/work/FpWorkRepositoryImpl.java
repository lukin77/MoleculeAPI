package hr.uniri.molapi.repository.fingerprint.work;

import org.springframework.stereotype.Repository;

@Repository
public class FpWorkRepositoryImpl implements FpWorkRepository {
    @Override
    public Double tanimotoSml(String fp1, String fp2) {
        return null;
    }

    @Override
    public Double diceSml(String fp1, String fp2) {
        return null;
    }

    @Override
    public Integer size(String fp) {
        return null;
    }

    @Override
    public String add(String fp1, String fp2) {
        return null;
    }

    @Override
    public String subtract(String fp1, String fp2) {
        return null;
    }

    @Override
    public Boolean allValuesLt(String fp1, Integer lessThan) {
        return null;
    }

    @Override
    public Boolean allValuesGt(String fp1, Integer greaterThan) {
        return null;
    }

}
