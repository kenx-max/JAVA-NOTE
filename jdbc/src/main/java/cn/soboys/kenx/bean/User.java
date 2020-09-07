package cn.soboys.kenx.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private String userName;
    private String password;
    private String userID;
}
