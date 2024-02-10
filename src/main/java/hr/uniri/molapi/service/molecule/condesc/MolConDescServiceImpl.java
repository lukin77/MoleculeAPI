package hr.uniri.molapi.service.molecule.condesc;

import hr.uniri.molapi.model.Mol;
import hr.uniri.molapi.repository.molecule.condesc.MolConDescRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class MolConDescServiceImpl implements MolConDescService {

    private final MolConDescRepository molConDescRepository;

    @Autowired
    public MolConDescServiceImpl(MolConDescRepository molConDescRepository) {
        this.molConDescRepository = molConDescRepository;
    }

    @Override
    public Float molChiXv(Mol mol, int x) {
        return switch (x) {
            case 0 -> executeDescFunction(mol, molConDescRepository::molChi0v);
            case 1 -> executeDescFunction(mol, molConDescRepository::molChi1v);
            case 2 -> executeDescFunction(mol, molConDescRepository::molChi2v);
            case 3 -> executeDescFunction(mol, molConDescRepository::molChi3v);
            case 4 -> executeDescFunction(mol, molConDescRepository::molChi4v);
            default -> throw new IllegalStateException("Unexpected value: " + x);
        };

    }

    @Override
    public Float MolChiXn(Mol mol, int x) {
        return switch (x) {
            case 0 -> executeDescFunction(mol, molConDescRepository::molChi0n);
            case 1 -> executeDescFunction(mol, molConDescRepository::molChi1n);
            case 2 -> executeDescFunction(mol, molConDescRepository::molChi2n);
            case 3 -> executeDescFunction(mol, molConDescRepository::molChi3n);
            case 4 -> executeDescFunction(mol, molConDescRepository::molChi4n);
            default -> throw new IllegalStateException("Unexpected value: " + x);
        };
    }

    @Override
    public Float molKappaX(Mol mol, int x) {
        return switch (x) {
            case 1 -> executeDescFunction(mol, molConDescRepository::molKappa1);
            case 2 -> executeDescFunction(mol, molConDescRepository::molKappa2);
            case 3 -> executeDescFunction(mol, molConDescRepository::molKappa3);
            default -> throw new IllegalStateException("Unexpected value: " + x);
        };
    }

    @Override
    public Float molPhi(Mol mol) {
        return executeDescFunction(mol, molConDescRepository::molPhi);
    }

    @Override
    public Float molHallkieralpha(Mol mol) {
        return executeDescFunction(mol, molConDescRepository::molHallkieralpha);
    }

    private <T> T executeDescFunction(Mol mol, Function<Mol, T> function) {
        return function.apply(mol);
    }
}
