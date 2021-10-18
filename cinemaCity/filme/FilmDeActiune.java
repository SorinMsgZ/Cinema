package cinemaCity.filme;

import java.util.List;

public class FilmDeActiune extends Film {


    public FilmDeActiune(String titluFilm, List<String> listaSubtitrari, EfecteSpecialeFilm efecteSpeciale) {
        super(titluFilm,listaSubtitrari,efecteSpeciale);

    }

    @Override
    public int calculeazaPretBilet() {
        return super.calculeazaPretBilet();
    }
}
