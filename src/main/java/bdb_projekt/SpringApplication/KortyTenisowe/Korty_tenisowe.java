package bdb_projekt.SpringApplication.KortyTenisowe;

import bdb_projekt.SpringApplication.Adresy.Adresy;
import bdb_projekt.SpringApplication.Adresy.Adresy_DAO;

import javax.persistence.criteria.CriteriaBuilder;

public class Korty_tenisowe {

    private int id_kortu;
    private String nawierzchnia;
    private Integer numer_kortu;
    private String oswietlenie;
    private Integer pojemnosc;
    private Integer dlugosc;
    private Integer szerokosc;
    private int id_klubu;
    private int id_adresu;
    private Adresy adresy;

    public Korty_tenisowe(int id_kortu, String nawierzchnia, Integer numer_kortu, String oswietlenie, Integer pojemnosc, Integer dlugosc, Integer szerokosc, int id_klubu, int id_adresu) {
        this.id_kortu = id_kortu;
        this.nawierzchnia = nawierzchnia;
        this.numer_kortu = numer_kortu;
        this.oswietlenie = oswietlenie;
        this.pojemnosc = pojemnosc;
        this.dlugosc = dlugosc;
        this.szerokosc = szerokosc;
        this.id_klubu = id_klubu;
        this.id_adresu = id_adresu;
    }

    public Korty_tenisowe(){

    }

    public int getId_kortu() {
        return id_kortu;
    }

    public void setId_kortu(int id_kortu) {
        this.id_kortu = id_kortu;
    }

    public String getNawierzchnia() {
        return nawierzchnia;
    }

    public void setNawierzchnia(String nawierzchnia) {
        this.nawierzchnia = nawierzchnia;
    }

    public Integer getNumer_kortu() {
        return numer_kortu;
    }

    public void setNumer_kortu(Integer numer_kortu) {
        this.numer_kortu = numer_kortu;
    }

    public String getOswietlenie() {
        return oswietlenie;
    }

    public void setOswietlenie(String oswietlenie) {
        this.oswietlenie = oswietlenie;
    }

    public Integer getPojemnosc() {
        return pojemnosc;
    }

    public void setPojemnosc(Integer pojemnosc) {
        this.pojemnosc = pojemnosc;
    }

    public Integer getDlugosc() {
        return dlugosc;
    }

    public void setDlugosc(Integer dlugosc) {
        this.dlugosc = dlugosc;
    }

    public Integer getSzerokosc() {
        return szerokosc;
    }

    public void setSzerokosc(Integer szerokosc) {
        this.szerokosc = szerokosc;
    }

    public int getId_klubu() {
        return id_klubu;
    }

    public void setId_klubu(int id_klubu) {
        this.id_klubu = id_klubu;
    }

    public int getId_adresu() {
        return id_adresu;
    }

    public void setId_adresu(int id_adresu) {
        this.id_adresu = id_adresu;
    }

    public Adresy getAdresy(){
        return adresy;
    }

    public void setAdresy(Adresy adresy){
        this.adresy = adresy;
    }

    @Override
    public String toString() {
        return "Korty_tenisowe{" +
                "id_kortu=" + id_kortu +
                ", nawierzchnia='" + nawierzchnia + '\'' +
                ", numer_kortu=" + numer_kortu +
                ", oswietlenie='" + oswietlenie + '\'' +
                ", pojemnosc='" + pojemnosc + '\'' +
                ", dlugosc='" + dlugosc + '\'' +
                ", szerokosc='" + szerokosc + '\'' +
                ", id_klubu=" + id_klubu +
                ", id_adresu=" + id_adresu +
                '}';
    }
}
