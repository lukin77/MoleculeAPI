package hr.uniri.molapi.service.molecule.io;

import hr.uniri.molapi.model.Mol;

public interface MolIoService {

    Mol molFromSmiles(String smiles);

    Mol molFromSmarts(String smarts);

    Mol molFromCtab(String ctab, Boolean bool);

    Mol molFromPkl(String pkl);

    Mol qmolFromSmiles(String smiles);

    Mol qmolFromCtab(String ctab, Boolean bool);

    String molToSmiles(Mol mol);

    String molToCxsmiles(Mol mol);

    String molToSmarts(Mol mol);

    String molToCxsmarts(Mol mol);

    String molToPkl(Mol mol);

    String molToCtab(Mol mol, Boolean bool, Boolean bool2);

    String molToV3kctab(Mol mol, Boolean bool);

    String molToSvg(Mol mol);

    String molToJson(Mol mol);

    String molFromJson(Mol mol);
}
