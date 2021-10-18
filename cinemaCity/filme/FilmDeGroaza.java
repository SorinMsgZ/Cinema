package cinemaCity.filme;

import java.util.List;

public class FilmDeGroaza extends Film {
    public FilmDeGroaza(String titluFilm, List<String> listaSubtitrari, EfecteSpecialeFilm efecteSpeciale) {
        super(titluFilm, listaSubtitrari, efecteSpeciale);
    }

    @Override
    public int calculeazaPretBilet() {
        int pret = super.calculeazaPretBilet();
        if (EfecteSpecialeFilm.efectIMAX.equals(efecteSpeciale) && listaSubtitrari.contains("Engleza")) {
            pret += 5;

        }
        return pret;
    }
}
