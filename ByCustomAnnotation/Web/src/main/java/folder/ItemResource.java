package folder;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
class ItemResource {

    @Autowired
    ItemService service;

    @GetMapping("/items")
    public List<Item> getAll() {
        return service.findAll();
    }

    @PostMapping("/items")
    public Item create(@RequestBody Item item, HttpSession session) {
        return service.create(item);
    }
}
