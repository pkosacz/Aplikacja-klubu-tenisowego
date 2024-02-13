package bdb_projekt.SpringApplication.Adresy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Adresy_DAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    public Adresy_DAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Adresy> list(){
        String sql = "SELECT * FROM ADRESY";
        List<Adresy> listAdresy = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Adresy.class));
        return listAdresy;
    }

    public void save(Adresy adresy){
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("adresy").usingColumns("miasto", "ulica", "numer_budynku", "numer_lokalu", "kod_pocztowy");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(adresy);
        insertActor.execute(param);

    }

    public Adresy get(int id_adresu){
        String sql = "SELECT * FROM ADRESY WHERE ID_ADRESU = ?";
        Object[] args = {id_adresu};
        Adresy adresy = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(Adresy.class));
        return adresy;
    }
    public Adresy get1(int id_adresu){
        Object[] args = {id_adresu};
        String sql = "SELECT * FROM ADRESY WHERE ID_ADRESU = " + args[0];
        Adresy adresy = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Adresy.class));
        return adresy;
    }

    public void update(Adresy adresy){
        String sql = "UPDATE ADRESY SET miasto=:miasto, ulica=:ulica, numer_budynku=:numer_budynku, numer_lokalu=:numer_lokalu," +
                "kod_pocztowy=:kod_pocztowy WHERE id_adresu=:id_adresu";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(adresy);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }

    public void delete(int id_adresu){
        String sql = "DELETE FROM ADRESY WHERE id_adresu = ?";
        jdbcTemplate.update(sql, id_adresu);
    }


}
