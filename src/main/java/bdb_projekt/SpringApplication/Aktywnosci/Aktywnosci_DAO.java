package bdb_projekt.SpringApplication.Aktywnosci;

import bdb_projekt.SpringApplication.Adresy.Adresy;
import bdb_projekt.SpringApplication.KortyTenisowe.Korty_tenisowe;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Aktywnosci_DAO {

    private JdbcTemplate jdbcTemplate;

    public Aktywnosci_DAO(JdbcTemplate jdbcTemplate){
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Aktywnosci> list() {
        String sql = "SELECT * FROM AKTYWNOSCI";
        List<Aktywnosci> listAktywnosci = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Aktywnosci.class));
        return listAktywnosci;
    }
    public void save(Aktywnosci aktywnosci){
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("aktywnosci").usingColumns("data", "liczba_zawodnikow",
                "poziom", "opis", "id_klubu", "id_pracownika", "id_adresu", "id_kortu");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(aktywnosci);
        aktywnosci.setId_klubu(1);
        aktywnosci.setId_adresu(1);
        aktywnosci.setId_pracownika(1);

        insertActor.execute(param);

        System.out.println(aktywnosci);
    }

    public Aktywnosci get(int numer_aktywnosci){
        String sql = "SELECT * FROM AKTYWNOSCI WHERE NUMER_AKTYWNOSCI = ?";
        Object[] args = {numer_aktywnosci};
        Aktywnosci aktywnosci = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(Aktywnosci.class));
        return aktywnosci;
    }

    public Aktywnosci get1(int numer_aktywnosci){
        Object[] args = {numer_aktywnosci};
        String sql = "SELECT * FROM AKTYWNOSCI WHERE NUMER_AKTYWNOSCI = " + args[0];
        Aktywnosci aktywnosci = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Aktywnosci.class));
        return aktywnosci;
    }

    public void update(Aktywnosci aktywnosci){
        String sql = "UPDATE AKTYWNOSCI SET data=:data, liczba_zawodnikow=:liczba_zawodnikow, poziom=:poziom, opis=:opis, id_kortu=:id_kortu WHERE numer_aktywnosci=:numer_aktywnosci";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(aktywnosci);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }

    public void delete(int numer_aktywnosci){
        String sql = "DELETE FROM AKTYWNOSCI WHERE numer_aktywnosci = ?";
        jdbcTemplate.update(sql, numer_aktywnosci);

    }

    public List<Aktywnosci> listAktywnosciKortu (int id_kortu){
        String sql = "SELECT * FROM AKTYWNOSCI WHERE ID_KORTU = ?";
        Object[] args = {id_kortu};
        List<Aktywnosci> listAktywnosciKortu = jdbcTemplate.query(sql, args, BeanPropertyRowMapper.newInstance(Aktywnosci.class));
        return listAktywnosciKortu;
    }


}
