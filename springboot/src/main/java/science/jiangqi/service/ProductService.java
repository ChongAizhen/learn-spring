package science.jiangqi.service;

import science.jiangqi.entity.Product;

/**
 * Created by chongaizhen on 2018/03/08.
 */
public interface ProductService {

    int insertProduct(Product product);

    Product selectById(int id);

    int buyProduct(Product product);

    void testTransaction();

}
