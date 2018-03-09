package science.jiangqi.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import science.jiangqi.entity.Product;

/**
 * Created by chongaizhen on 2018/03/08.
 */
@Service
public interface ProductService {

    int insertProduct(Product product);

    Product selectById(int id);

    int buyProduct(Product product);

    @Transactional
    void testTransaction();

}
