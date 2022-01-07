package folder;

import java.sql.PreparedStatement;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class ItemRepository extends LoggedRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int create(Item item) {
        String sql = "INSERT INTO ITEMS(description) VALUES (?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql, new String[]{"ID"});
            ps.setString(1, item.getDescription());
            return ps;
        }, keyHolder);

        return keyHolder.getKey().intValue();
    }

    public Item find(Integer id) {
        logQuery(id);
        return jdbcTemplate.queryForObject("SELECT * FROM ITEMS WHERE id=?",
                BeanPropertyRowMapper.newInstance(Item.class), id);
    }

    public List<Item> findAll() {
        logQuery(null);
        return jdbcTemplate.query("SELECT * from ITEMS", BeanPropertyRowMapper.newInstance(Item.class));
    }
}
