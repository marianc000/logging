package folder;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tracing.annotations.Traced;

@Traced
@Service
public class ItemService {

    @Autowired
    ItemRepository db;

    public Item create(Item item) {
        int id = db.create(item);
        return find(id);
    }

    public Item find(int id) {
        return db.find(id);
    }

    public List<Item> findAll() {
        return db.findAll();
    }
}
