package cinemaCity.sali;

import cinemaCity.filme.Film;
import cinemaCity.spectatori.Spectatorul;

import java.util.ArrayList;
import java.util.List;

public class SalaCinema {
    private static final int NR_MAX_LOCURI = 10;
    private List<Spectatorul> listaSpectatori;
    private List<Film> listaFilme;
    private Film filmCurent;

    public SalaCinema(Film filmCurent) {
        this.listaSpectatori = new ArrayList<>();
        this.filmCurent = filmCurent;
        this.listaFilme = new ArrayList<>();

    }

    public void cumparaBilet(Spectatorul spectatorul) {
        listaSpectatori.add(spectatorul);
    }

    public void cumparaBilet(Spectatorul spectatorul, int discount) {
        cumparaBilet(spectatorul);
        spectatorul.setActualizareSumaDeBaniSpectator(discount);
    }

    public void returneazaFilmeCuSubtitrareSpecifica(String subtitrare) {
        for (Film film : this.listaFilme) {
            if (film.getListaSubtitrari().contains(subtitrare)) {
                System.out.println(film.getTitluFilm() + " are subtirarea in " + subtitrare);
            }
        }
    }

    public static int getNrMaxLocuri() {
        return NR_MAX_LOCURI;
    }

    public List<Spectatorul> getListaSpectatori() {
        return listaSpectatori;
    }

    public void adaugaFilm(Film filmNou) {
        listaFilme.add(filmNou);
    }

}
