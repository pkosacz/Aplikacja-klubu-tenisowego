package bdb_projekt.SpringApplication.Aktywnosci;

public class Aktywnosci {

    private int numer_aktywnosci;
    private String data;
    private String liczba_zawodnikow;
    private String poziom;
    private String opis;
    private int id_klubu;
    private int id_pracownika;
    private int id_adresu;
    private int id_kortu;

    public Aktywnosci(int numer_aktywnosci, String data, String liczba_zawodnikow, String poziom, String opis, int id_klubu, int id_pracownika, int id_adresu, int id_kortu) {
        this.numer_aktywnosci = numer_aktywnosci;
        this.data = data;
        this.liczba_zawodnikow = liczba_zawodnikow;
        this.poziom = poziom;
        this.opis = opis;
        this.id_klubu = id_klubu;
        this.id_pracownika = id_pracownika;
        this.id_adresu = id_adresu;
        this.id_kortu = id_kortu;
    }

    public Aktywnosci(){

    }

    public int getNumer_aktywnosci() {
        return numer_aktywnosci;
    }

    public void setNumer_aktywnosci(int numer_aktywnosci) {
        this.numer_aktywnosci = numer_aktywnosci;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getLiczba_zawodnikow() {
        return liczba_zawodnikow;
    }

    public void setLiczba_zawodnikow(String liczba_zawodnikow) {
        this.liczba_zawodnikow = liczba_zawodnikow;
    }

    public String getPoziom() {
        return poziom;
    }

    public void setPoziom(String poziom) {
        this.poziom = poziom;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public int getId_klubu() {
        return id_klubu;
    }

    public void setId_klubu(int id_klubu) {
        this.id_klubu = id_klubu;
    }

    public int getId_pracownika() {
        return id_pracownika;
    }

    public void setId_pracownika(int id_pracownika) {
        this.id_pracownika = id_pracownika;
    }

    public int getId_adresu() {
        return id_adresu;
    }

    public void setId_adresu(int id_adresu) {
        this.id_adresu = id_adresu;
    }

    public int getId_kortu(){
        return id_kortu;
    }

    public void setId_kortu(int id_kortu){
        this.id_kortu = id_kortu;
    }

    @Override
    public String toString() {
        return "Aktywnosci{" +
                "numer_aktywnosci=" + numer_aktywnosci +
                ", data='" + data + '\'' +
                ", liczba_zawodnikow='" + liczba_zawodnikow + '\'' +
                ", poziom='" + poziom + '\'' +
                ", opis='" + opis + '\'' +
                ", id_klubu=" + id_klubu +
                ", id_pracownika=" + id_pracownika +
                ", id_adresu=" + id_adresu +
                ", id_kortu=" +
                '}';
    }
}

