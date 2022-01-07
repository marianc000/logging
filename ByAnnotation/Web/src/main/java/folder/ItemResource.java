package folder;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class ItemResource {

    @Autowired
    ItemService service;

    @GetMapping("/items")
    public List<Item> getAll() {
        return service.findAll();
    }

    @PostMapping("/items")
    public Item create(@RequestBody Item item) {
        return service.create(item);
    }
}
