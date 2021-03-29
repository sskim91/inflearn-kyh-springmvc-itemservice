package hello.itemservice.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sskim on 2021/03/28
 * Github : http://github.com/sskim91
 */
@Repository
public class ItemRepository {

    private static final Map<Long, Item> store = new HashMap<>();   //static
    private static long sequence = 0L;  //static

    public Item save(Item item) {
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }

    public Item findById(Long id) {
        return store.get(id);
    }

    public List<Item> findAll() {
        return new ArrayList<>(store.values());
    }

    public void update(Long itemId, Item updateParam) {
        //보통 updateParam은 객체를 하나 더 만들어서 쓰는것이 낫다.
        //만약 그대로 Item을 사용하면 id는 뭐지..?라는 생각이들게된다.
        //중복이냐 명확성이냐? 항상 명확성을 따르는 것이 더 낫다.
        Item findItem = findById(itemId);
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }

    public void clearStore() {
        store.clear();
    }
}
