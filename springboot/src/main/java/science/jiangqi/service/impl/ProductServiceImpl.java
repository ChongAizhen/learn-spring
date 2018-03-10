package science.jiangqi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import science.jiangqi.dao.ProductMapper;
import science.jiangqi.entity.Product;
import science.jiangqi.service.ProductService;

/**
 * Created by chongaizhen on 2018/03/08.
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    public int insertProduct(Product product) {
        return productMapper.insert(product);
    }

    public Product selectById(int id) {
        return null;
    }

    public int buyProduct(Product product) {
        return 0;
    }

    public void testTransaction() {
        Product product = new Product();
        product.setProductName("1234");
        product.setProductCount(1);
        productMapper.insert(product);
        product.setProductName("12345");
        productMapper.insert(product);
        product.setProductName("1234567890987654321");
        productMapper.insert(product);
        product.setProductName("123456");
        productMapper.insert(product);
    }
}
