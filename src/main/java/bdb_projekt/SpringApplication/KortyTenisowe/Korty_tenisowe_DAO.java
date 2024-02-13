package bdb_projekt.SpringApplication.KortyTenisowe;

import bdb_projekt.SpringApplication.Aktywnosci.Aktywnosci;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Repository
public class Korty_tenisowe_DAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    public Korty_tenisowe_DAO(JdbcTemplate jdbcTemplate){
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Korty_tenisowe> list(){
        String sql = "SELECT * FROM KORTY_TENISOWE";
        List<Korty_tenisowe> listKortyTenisowe = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Korty_tenisowe.class));
        return listKortyTenisowe;
    }

    public void save(Korty_tenisowe kortyTenisowe){
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("korty_tenisowe").usingColumns("nawierzchnia", "numer_kortu",
                "oswietlenie", "pojemnosc", "dlugosc", "szerokosc", "id_klubu", "id_adresu");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(kortyTenisowe);
        kortyTenisowe.setId_klubu(1);
        kortyTenisowe.setId_adresu(1);
        insertActor.execute(param);

    }

    public Korty_tenisowe get(int id_kortu){
        String sql = "SELECT * FROM KORTY_TENISOWE WHERE ID_KORTU = ?";
        Object[] args = {id_kortu};
        Korty_tenisowe kortyTenisowe = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(Korty_tenisowe.class));

        return kortyTenisowe;
    }

    public Korty_tenisowe get1(int id_kortu){
        Object[] args = {id_kortu};
        String sql = "SELECT * FROM KORTY_TENISOWE WHERE ID_KORTU = " + args[0];
        Korty_tenisowe kortyTenisowe = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Korty_tenisowe.class));
        return kortyTenisowe;
    }

    public void update(Korty_tenisowe kortyTenisowe){
        String sql = "UPDATE KORTY_TENISOWE SET nawierzchnia=:nawierzchnia, oswietlenie=:oswietlenie," +
                "pojemnosc=:pojemnosc WHERE id_kortu=:id_kortu";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(kortyTenisowe);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }

    public void delete(int id_kortu){
        String sql = "DELETE FROM KORTY_TENISOWE WHERE id_kortu = ?";
        jdbcTemplate.update(sql, id_kortu);

    }



}
