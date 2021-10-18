package cinemaCity;

import cinemaCity.filme.*;
import cinemaCity.sali.SalaCinema;
import cinemaCity.spectatori.Spectatorul;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestCinema {
    private int numarSpectatori;
    private List<Spectatorul> spectatoriLaRand;
    private List<String> subtitrariFilm1, subtitrariFilm2, subtitrariFilm3;
    private Film filmInDerulare, filmInAsteptare1, filmInAsteptare2;
    private SalaCinema salaDeFilm;

    public TestCinema(int numarSpectatori, int discount) throws IOException {
        System.out.println("La ghiseu sunt " + numarSpectatori + " cinefili interesati pentru filmul actual");
        System.out.println("Posibilul discount al biletului este: " + discount);
        //Citeste spectatori la rand din consola:
        int numarMaximSala = SalaCinema.getNrMaxLocuri();
        if (numarSpectatori <= numarMaximSala) {
            this.numarSpectatori = numarSpectatori;
            spectatoriLaRand = new ArrayList<>();
            for (int i = 0; i < numarSpectatori; i++) {
                System.out.println("Scrie numele sau prenumele, banii si subtitrarea preferata, despartite de un spatiu apoi ENTER: ");
                BufferedReader inregistreazaSpectatori = new BufferedReader(new InputStreamReader(System.in));
                String argumenteSpectator[] = inregistreazaSpectatori.readLine().split(" ");
                String numeSauPrenume = argumenteSpectator[0];
                String baniSpectator = argumenteSpectator[1];
                String subtitrarePreferata = argumenteSpectator[2];
                spectatoriLaRand.add(new Spectatorul(numeSauPrenume, Integer.parseInt(baniSpectator), subtitrarePreferata));
            }
        } else {
            System.out.println("Capacitatea salii de cinema  (maxim " + numarMaximSala + " )  e mai mica fata de numarul de spectatori interesati sa vada filmul!");
        }
        adaugaSubtitrariFilm();
       /* adaugaSubtitrariFilm(subtitrariFilm1, new String[]{"Engleza", "Germana", "Romana"});
        adaugaSubtitrariFilm(subtitrariFilm2, new String[]{"Chineza", "Germana"});
        adaugaSubtitrariFilm(subtitrariFilm3, new String[]{"Engleza"});*/
        pregatesteFilmePtSala();
        //pregatesteFilmePtSala(filmInDerulare,"actiune","Terminator1", subtitrariFilm1, EfecteSpecialeFilm.efect4DX);
        //pregatesteFilmePtSala(filmInAsteptare1,"comedie","Terminator2", subtitrariFilm2,EfecteSpecialeFilm.efect7D);
        //pregatesteFilmePtSala(filmInAsteptare2,"groaza","Terminator3", subtitrariFilm3,EfecteSpecialeFilm.efectIMAX);
        pregatesteSala();
        completareSalaCinema(discount);
    }

    //creeaza subtitrarile disponibile pt fiecare film in parte
    public void adaugaSubtitrariFilm() {
        subtitrariFilm1 = new ArrayList<>();
        subtitrariFilm1.add("Engleza");
        subtitrariFilm1.add("Germana");
        subtitrariFilm1.add("Romana");
        subtitrariFilm2 = new ArrayList<>();
        subtitrariFilm2.add("Chineza");
        subtitrariFilm2.add("Germana");
        subtitrariFilm2.add("Romana");
        subtitrariFilm3 = new ArrayList<>();
        subtitrariFilm3.add("Engleza");
    }
   /* public void adaugaSubtitrariFilm(List<String> listaSubtitrare, String[] limbiListaSubtitrare) {
        listaSubtitrare = new ArrayList<>();
        for (int limba = 0; limba < limbiListaSubtitrare.length; limba++) {
            listaSubtitrare.add(limbiListaSubtitrare[limba]);
        }

    }*/

    //creeaza filme  cu subtitrarile aferente
    public void pregatesteFilmePtSala() {
        filmInDerulare = new FilmDeActiune("Terminator1", subtitrariFilm1, EfecteSpecialeFilm.efect4DX);
        filmInAsteptare1 = new FilmDeComedie("Terminator2", subtitrariFilm2, EfecteSpecialeFilm.efect7D);
        filmInAsteptare2 = new FilmDeGroaza("Terminator3", subtitrariFilm3, EfecteSpecialeFilm.efectIMAX);
    }

  /*  public void pregatesteFilmePtSala(Film film, String genFilm, String titluFilm, List<String> subtitrare, EfecteSpecialeFilm efect) {
        if (genFilm == "actiune") {
            film = new FilmDeActiune(titluFilm, subtitrare, efect);
        } else if (genFilm == "comedie") {
            film = new FilmDeComedie(titluFilm, subtitrare, efect);
        } else if (genFilm == "groaza") {
            film = new FilmDeGroaza(titluFilm, subtitrare, efect);
        } else {
            System.out.println("Gen Film incorect");

        }

    }*/


    //creeaza sala de cinema,  setare film curent si adaugare la lista de filma a salii
    //adaugare alte filme la lista de filme a salii
    public void pregatesteSala() {
        salaDeFilm = new SalaCinema(filmInDerulare);
        salaDeFilm.adaugaFilm(filmInDerulare);
        salaDeFilm.adaugaFilm(filmInAsteptare1);
        salaDeFilm.adaugaFilm(filmInAsteptare2);
    }

    //creeaza lista de spectatori potriviti pentru sala
    public void completareSalaCinema(int discount) {
        for (int i = 0; i < numarSpectatori; i++) {
            System.out.println("##################### " + (i + 1) + " este numarul de ordine al spectatorului: " + spectatoriLaRand.get(i));

            Spectatorul spectatorLaGhiseu = spectatoriLaRand.get(i);
            List<String> listSubtitrariFilmActual = filmInDerulare.getListaSubtitrari();
            String subtitrarePreferataSpectator = spectatorLaGhiseu.getSubtitrarePreferata();

            //memoreaza bani spectator si pretul filmului
            int baniSpectator = spectatorLaGhiseu.getSumaDeBaniSpectator();
            int pretBilet = filmInDerulare.calculeazaPretBilet();

            //compara banii disponibili ai spectatorului cu pretul actualului film
            if (baniSpectator >= pretBilet) {
                //cumpara bilet daca corespunde criteriu 1: subtitrare preferata este inclusa in lista de subtitrari a filmului
                if (listSubtitrariFilmActual.contains(subtitrarePreferataSpectator)) {
                    //cumpara bilet si implicit adauga spectatorul in lista salii
                    salaDeFilm.cumparaBilet(spectatorLaGhiseu);
                    spectatorLaGhiseu.setActualizareSumaDeBaniSpectator(pretBilet);
                    System.out.println("1.Pt " + spectatorLaGhiseu.getNumeSpectator() + " se indeplineste criteriul <1> de cumparare a biletului: isi permite biletul si subtitrarea lui preferata coincide cu lista filmului difuzat");
                }
                //cumpara bilet daca corespunde criteriu 2: subtitrarea preferata nu se potriveste dar Spectatorul isi permite banii
                // respectiv exista sau nu discount
                else {
                    System.out.println("Pt " + spectatorLaGhiseu.getNumeSpectator() + " - Nu exista subtitrare potrivita...dar poate intra la film cu un discount = " + discount);
                    //cumpara bilet cu discount si implicit adauga spectatorul in lista salii
                    int pretCuDiscount = pretBilet - discount;
                    salaDeFilm.cumparaBilet(spectatorLaGhiseu, pretCuDiscount);

                    //spectatoriLaRand.get(i).setActualizareSumaDeBaniSpectator(pretBilet);
                    System.out.println("1.Pt " + spectatorLaGhiseu.getNumeSpectator() + " se indeplineste criteriul <2> de cumparare a biletului: isi permite biletul si se aplica discountul de pe bilet");
                }
            }
            //daca Spectatorul nu are suficienti bani
            else {
                System.out.println("ATENTIE ! Bani insuficienti!!!!!!!!!! " + spectatorLaGhiseu.getNumeSpectator() + " nu isi permite sa cumpere  biletul");
            }
            System.out.println("2.Spectatorul <" + spectatorLaGhiseu.getNumeSpectator() + "> are suma : " + baniSpectator);
            System.out.println("3.Pretul filmului pentru <" + spectatorLaGhiseu.getNumeSpectator() + "> este: " + pretBilet);
            System.out.println("4.Suma de bani actualizata pt <" + spectatorLaGhiseu.getNumeSpectator() + " > este: " + spectatorLaGhiseu.getSumaDeBaniSpectator());

        }
        // System.out.println("Spectatorii din sala sunt :" + salaDeFilm.getListaSpectatori());
        Iterator it = salaDeFilm.getListaSpectatori().iterator();
        while (it.hasNext()) {
            System.out.println("Spectatorii din sala sunt :");
            System.out.println(it.next());
        }
        System.out.println("Filmele disponibile in limba Engleza sunt : ");
        salaDeFilm.returneazaFilmeCuSubtitrareSpecifica("Engleza");

    }

    public static void main(String[] args) throws IOException {
        //discount prin consola (nr de spectatori in functie de cati sunt introdusi de la consola)
        new TestCinema(3, 1);
    }
}

