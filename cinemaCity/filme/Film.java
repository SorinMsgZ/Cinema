package cinemaCity.filme;

import java.util.List;

public abstract class Film {
    protected String titluFilm;
    protected List<String> listaSubtitrari;
    protected EfecteSpecialeFilm efecteSpeciale;

    public Film(String titluFilm, List<String> listaSubtitrari, EfecteSpecialeFilm efecteSpeciale) {
        this.titluFilm = titluFilm;
        this.listaSubtitrari = listaSubtitrari;
        this.efecteSpeciale = efecteSpeciale;
    }

    public String getTitluFilm() {
        return titluFilm;
    }

    public List<String> getListaSubtitrari() {
        return listaSubtitrari;
    }

    public int calculeazaPretBilet() {

        return (int) ((Math.random() * (25 - 10)) + 10);
    }

}