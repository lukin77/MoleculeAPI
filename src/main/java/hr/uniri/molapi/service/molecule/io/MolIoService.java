package hr.uniri.molapi.service.molecule.io;

import hr.uniri.molapi.model.Mol;

public interface MolIoService {

    Mol molFromSmiles(String smiles);

    Mol molFromSmarts(String smarts);

    Mol molFromCtab(String ctab, boolean bool);

    Mol molFromPkl(String pkl);

    Mol qmolFromSmiles(String smiles);

    Mol qmolFromCtab(String ctab, boolean bool);

    String molToSmiles(Mol mol);

    String molToCxsmiles(Mol mol);

    String molToSmarts(Mol mol);

    String molToCxsmarts(Mol mol);

    String molToPkl(Mol mol);

    String molToCtab(Mol mol, boolean bool, boolean bool2);

    String molToV3kctab(Mol mol, boolean bool);

    String molToSvg(Mol mol);

    String molToJson(Mol mol);

    String molFromJson(Mol mol);
}
