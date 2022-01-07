package folder;

import java.util.List;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.runtime.internal.AroundClosure;
import org.aspectj.runtime.reflect.Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tracing.aspects.TracingAspect;

@RestController
class ItemResource {

    @Autowired
    ItemService service;
    static JoinPoint.StaticPart ajc$tjp_0;
    static JoinPoint.StaticPart ajc$tjp_1;

    ItemResource() {
    }

    @GetMapping(value = {"/items"})
    public List<Item> getAll() {
        JoinPoint joinPoint = Factory.makeJP(ajc$tjp_0, this, this);
        Object[] arrobject = new Object[]{this, joinPoint};
        return (List) TracingAspect.aspectOf().measureTime(new ItemResource$AjcClosure1(arrobject).linkClosureAndJoinPoint(69648));
    }

    class ItemResource$AjcClosure1 extends AroundClosure {

        public ItemResource$AjcClosure1(Object[] arrobject) {
            super(arrobject);
        }

        public Object run(Object[] arrobject) {
            Object[] arrobject2 = this.state;
            return ItemResource.getAll_aroundBody0((ItemResource) arrobject2[0], (JoinPoint) arrobject2[1]);
        }
    }

    static final List getAll_aroundBody0(ItemResource ajc$this, JoinPoint joinPoint) {
        return ajc$this.service.findAll();
    }

    @PostMapping(value = {"/items"})
    public Item create(@RequestBody Item item) {
        Item item2 = item;
        JoinPoint joinPoint = Factory.makeJP((JoinPoint.StaticPart) ajc$tjp_1, this, this, item2);
        Object[] arrobject = new Object[]{this, item2, joinPoint};
        ItemResource$AjcClosure3 itemResource$AjcClosure3 = new ItemResource$AjcClosure3(arrobject);
        return (Item) TracingAspect.aspectOf().measureTime(itemResource$AjcClosure3.linkClosureAndJoinPoint(69648));
    }

    static {
        ItemResource.ajc$preClinit();
    }

    static final Item create_aroundBody2(ItemResource ajc$this, Item item, JoinPoint joinPoint) {
        return ajc$this.service.create(item);
    }

    static void ajc$preClinit() {
        Factory factory = new Factory("ItemResource.java", ItemResource.class);
        ajc$tjp_0 = factory.makeSJP("method-execution", (Signature) factory.makeMethodSig("1", "getAll", "folder.ItemResource", "", "", "", "java.util.List"), 18);
        ajc$tjp_1 = factory.makeSJP("method-execution", (Signature) factory.makeMethodSig("1", "create", "folder.ItemResource", "folder.Item", "item", "", "folder.Item"), 23);
    }

    class ItemResource$AjcClosure3 extends AroundClosure {

        public ItemResource$AjcClosure3(Object[] arrobject) {
            super(arrobject);
        }

        public Object run(Object[] arrobject) {
            Object[] arrobject2 = this.state;
            return ItemResource.create_aroundBody2((ItemResource) arrobject2[0], (Item) arrobject2[1], (JoinPoint) arrobject2[2]);
        }
    }
}
