package hello.itemservice.domain.item;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by sskim on 2021/03/28
 * Github : http://github.com/sskim91
 */
@Getter
@Setter
public class Item {

    private Long id;
    private String itemName;
    private Integer price;
    private Integer quantity;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
