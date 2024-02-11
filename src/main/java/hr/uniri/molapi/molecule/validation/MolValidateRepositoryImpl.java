package hr.uniri.molapi.molecule.validation;

import hr.uniri.molapi.utils.SimpleJdbcCallFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MolValidateRepositoryImpl implements MolValidateRepository {

    private final SimpleJdbcCallFactory simpleJdbcCallFactory;

    @Autowired
    public MolValidateRepositoryImpl(SimpleJdbcCallFactory simpleJdbcCallFactory) {
        this.simpleJdbcCallFactory = simpleJdbcCallFactory;
    }

    @Override
    public Boolean validate(String molecule, String methodName) {
        return simpleJdbcCallFactory
                .getSimpleJdbcCall(methodName)
                .executeFunction(Boolean.class, molecule, methodName);
    }

}
