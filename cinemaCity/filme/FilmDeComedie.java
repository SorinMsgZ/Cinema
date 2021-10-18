package cinemaCity.filme;

import java.util.List;

public class FilmDeComedie extends Film {
    public FilmDeComedie(String titluFilm, List<String> listaSubtitrari, EfecteSpecialeFilm efecteSpeciale) {
        super(titluFilm, listaSubtitrari, efecteSpeciale);
    }

    @Override
    public int calculeazaPretBilet() {
        int pret = super.calculeazaPretBilet();
        if (EfecteSpecialeFilm.efect4DX.equals(efecteSpeciale) || EfecteSpecialeFilm.efect7D.equals(efecteSpeciale)) {
            pret += 3; //(echivalent pret=pret+3)

        }
        return pret;
    }
}
