package science.jiangqi.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {
    private String username;

    private String password;

    private String sex;

    private String authority;
}