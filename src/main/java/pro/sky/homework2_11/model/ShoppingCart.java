package pro.sky.homework2_11.model;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.HashSet;
import java.util.Set;
@Data
@Component
@SessionScope
public class ShoppingCart {
    private Set<Integer> productIdList;

    public ShoppingCart() {
        productIdList = new HashSet<>();
    }
    public void addProductToProductIdList(Set<Integer> resultList) {
        if (productIdList.isEmpty()) {
            productIdList = resultList;
        } else {
            productIdList.addAll(resultList);
        }
    }
}
