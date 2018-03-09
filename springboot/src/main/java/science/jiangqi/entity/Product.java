package science.jiangqi.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Product {
    private Integer id;

    private String productName;

    private Integer productCount;
}