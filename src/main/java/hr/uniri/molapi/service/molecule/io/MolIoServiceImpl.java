package hr.uniri.molapi.service.molecule.io;

import hr.uniri.molapi.model.Mol;
import hr.uniri.molapi.repository.molecule.io.MolIoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.BiFunction;
import java.util.function.Function;

@Service
public class MolIoServiceImpl implements MolIoService {

    private final MolIoRepository molIoRepository;

    @Autowired
    public MolIoServiceImpl(MolIoRepository molIoRepository) {
        this.molIoRepository = molIoRepository;
    }

    @Override
    public Mol molFromSmiles(String smiles) {
        return executeInputOutputFunction(smiles, molIoRepository::molFromSmiles);
    }

    @Override
    public Mol molFromSmarts(String smarts) {
        return executeInputOutputFunction(smarts, molIoRepository::molFromSmarts);
    }

    @Override
    public Mol molFromCtab(String ctab, Boolean bool) {
        return executeInputOutputFunction(ctab, bool, molIoRepository::molFromCtab);
    }

    @Override
    public Mol molFromPkl(String pkl) {
        return executeInputOutputFunction(pkl, molIoRepository::molFromPkl);
    }

    @Override
    public Mol qmolFromSmiles(String smiles) {
        return executeInputOutputFunction(smiles, molIoRepository::qmolFromSmiles);
    }

    @Override
    public Mol qmolFromCtab(String ctab, Boolean bool) {
        return executeInputOutputFunction(ctab, bool, molIoRepository::qmolFromCtab);
    }

    @Override
    public String molToSmiles(Mol mol) {
        return executeInputOutputFunction(mol, molIoRepository::molToSmiles);
    }

    @Override
    public String molToCxsmiles(Mol mol) {
        return executeInputOutputFunction(mol, molIoRepository::molToCxsmiles);
    }

    @Override
    public String molToSmarts(Mol mol) {
        return executeInputOutputFunction(mol, molIoRepository::molToSmarts);
    }

    @Override
    public String molToCxsmarts(Mol mol) {
        return executeInputOutputFunction(mol, molIoRepository::molToCxsmarts);
    }

    @Override
    public String molToPkl(Mol mol) {
        return executeInputOutputFunction(mol, molIoRepository::molToPkl);
    }

    @Override
    public String molToCtab(Mol mol, Boolean bool, Boolean bool2) {
        return executeInputOutputFunction(mol, molIoRepository::molToCtab);
    }

    @Override
    public String molToV3kctab(Mol mol, Boolean bool) {
        return executeInputOutputFunction(mol, molIoRepository::molToV3kctab);
    }

    @Override
    public String molToSvg(Mol mol) {
        return executeInputOutputFunction(mol, molIoRepository::molToSvg);
    }

    @Override
    public String molToJson(Mol mol) {
        return executeInputOutputFunction(mol, molIoRepository::molToJson);
    }

    @Override
    public String molFromJson(Mol mol) {
        return executeInputOutputFunction(mol, molIoRepository::molFromJson);
    }

    private Mol executeInputOutputFunction(String param, Function<String, Mol> function) {
        return function.apply(param);
    }

    private Mol executeInputOutputFunction(String param, Boolean bool, BiFunction<String, Boolean, Mol> function) {
        return function.apply(param, bool);
    }

    private String executeInputOutputFunction(Mol param, Function<Mol, String> function) {
        return function.apply(param);
    }
}
