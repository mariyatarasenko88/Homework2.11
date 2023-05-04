package pro.sky.homework2_11.service;

import java.util.Set;

public interface ShoppingCartService {
    Set<Integer> addProduct(String productListString);

    Set<Integer> getAllProduct();
}
