package hr.uniri.molapi.repository.molecule.io;

import hr.uniri.molapi.model.Mol;

public interface MolIoRepository {
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

    String molToCtab(Mol mol);

    String molToV3kctab(Mol mol);

    String molToSvg(Mol mol);

    String molToJson(Mol mol);

    String molFromJson(Mol mol);
}
