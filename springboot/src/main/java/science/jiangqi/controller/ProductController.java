package science.jiangqi.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import science.jiangqi.service.ProductService;

/**
 * Created by chongaizhen on 2018/03/08.
 */
@RestController
@RequestMapping("/api")
@Slf4j
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/product/testTransaction", method = RequestMethod.GET)
    public void testTransaction(){
        productService.testTransaction();
    }
    
}
