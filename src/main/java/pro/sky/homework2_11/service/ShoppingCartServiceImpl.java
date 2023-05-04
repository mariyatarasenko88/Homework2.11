package pro.sky.homework2_11.service;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import pro.sky.homework2_11.model.ShoppingCart;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@SessionScope
public class ShoppingCartServiceImpl implements ShoppingCartService {
    ShoppingCart shoppingCart;
    public ShoppingCartServiceImpl(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
    @Override
    public Set<Integer> addProduct(String productListString) {
        Set<String> productList = new HashSet<>(List.of(productListString.split(",")));
        Set<Integer> resultList = productList.stream()
                .filter(e -> StringUtils.isNumeric(e))
                .map(e -> NumberUtils.toInt(e))
                .collect(Collectors.toSet());
        shoppingCart.addProductToProductIdList(resultList);
        return resultList;
    }
    @Override
    public Set<Integer> getAllProduct() {
        return shoppingCart.getProductIdList();
    }
}
