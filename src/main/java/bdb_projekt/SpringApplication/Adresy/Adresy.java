package bdb_projekt.SpringApplication.Adresy;

public class Adresy {

    private int id_adresu;
    private String miasto;
    private String ulica;
    private String numer_budynku;
    private Integer numer_lokalu;
    private String kod_pocztowy;

    public Adresy(int id_adresu, String miasto, String ulica, String numer_budynku, Integer numer_lokalu, String kod_pocztowy) {
        this.id_adresu = id_adresu;
        this.miasto = miasto;
        this.ulica = ulica;
        this.numer_budynku = numer_budynku;
        this.numer_lokalu = numer_lokalu;
        this.kod_pocztowy = kod_pocztowy;
    }

    public Adresy(){

    }

    public int getId_adresu() {
        return id_adresu;
    }

    public void setId_adresu(int id_adresu) {
        this.id_adresu = id_adresu;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getNumer_budynku() {
        return numer_budynku;
    }

    public void setNumer_budynku(String numer_budynku) {
        this.numer_budynku = numer_budynku;
    }

    public Integer getNumer_lokalu() {
        return numer_lokalu;
    }

    public void setNumer_lokalu(Integer numer_lokalu) {
        this.numer_lokalu = numer_lokalu;
    }

    public String getKod_pocztowy() {
        return kod_pocztowy;
    }

    public void setKod_pocztowy(String kod_pocztowy) {
        this.kod_pocztowy = kod_pocztowy;
    }

    @Override
    public String toString() {
        return "Adresy{" +
                "id_adresu=" + id_adresu +
                ", miasto='" + miasto + '\'' +
                ", ulica='" + ulica + '\'' +
                ", numer_budynku=" + numer_budynku +
                ", numer_lokalu=" + numer_lokalu +
                ", kod_pocztowy=" + kod_pocztowy +
                '}';
    }

    public int getId_kortu() {
        return id_adresu;
    }
}
