package hr.uniri.molapi.molecule.io;

import hr.uniri.molapi.model.Mol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static hr.uniri.molapi.utils.ExecuteMethod.execute;

@Service
public class MolIoServiceImpl implements MolIoService {

    private final MolIoRepository molIoRepository;

    @Autowired
    public MolIoServiceImpl(MolIoRepository molIoRepository) {
        this.molIoRepository = molIoRepository;
    }

    @Override
    public Mol molFromSmiles(String smiles) {
        return execute(smiles, molIoRepository::molFromSmiles);
    }

    @Override
    public Mol molFromSmarts(String smarts) {
        return execute(smarts, molIoRepository::molFromSmarts);
    }

    @Override
    public Mol molFromCtab(String ctab, Boolean bool) {
        return execute(ctab, bool, molIoRepository::molFromCtab);
    }

    @Override
    public Mol molFromPkl(String pkl) {
        return execute(pkl, molIoRepository::molFromPkl);
    }

    @Override
    public Mol qmolFromSmiles(String smiles) {
        return execute(smiles, molIoRepository::qmolFromSmiles);
    }

    @Override
    public Mol qmolFromCtab(String ctab, Boolean bool) {
        return execute(ctab, bool, molIoRepository::qmolFromCtab);
    }

    @Override
    public String molToSmiles(Mol mol) {
        return execute(mol, molIoRepository::molToSmiles);
    }

    @Override
    public String molToCxsmiles(Mol mol) {
        return execute(mol, molIoRepository::molToCxsmiles);
    }

    @Override
    public String molToSmarts(Mol mol) {
        return execute(mol, molIoRepository::molToSmarts);
    }

    @Override
    public String molToCxsmarts(Mol mol) {
        return execute(mol, molIoRepository::molToCxsmarts);
    }

    @Override
    public String molToPkl(Mol mol) {
        return execute(mol, molIoRepository::molToPkl);
    }

    @Override
    public String molToCtab(Mol mol, Boolean bool, Boolean bool2) {
        return execute(mol, molIoRepository::molToCtab);
    }

    @Override
    public String molToV3kctab(Mol mol, Boolean bool) {
        return execute(mol, molIoRepository::molToV3kctab);
    }

    @Override
    public String molToSvg(Mol mol) {
        return execute(mol, molIoRepository::molToSvg);
    }

    @Override
    public String molToJson(Mol mol) {
        return execute(mol, molIoRepository::molToJson);
    }

    @Override
    public String molFromJson(Mol mol) {
        return execute(mol, molIoRepository::molFromJson);
    }

}
