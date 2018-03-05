package science.jiangqi.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by chongaizhen on 2017/12/17.
 */
@Data
@NoArgsConstructor
public class User {

    private String userName;
    private String passWord;
    private String authority;

}
