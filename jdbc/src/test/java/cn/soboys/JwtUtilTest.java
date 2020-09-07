package cn.soboys;

import cn.hutool.json.JSONUtil;
import cn.soboys.kenx.bean.User;
import cn.soboys.kenx.jwt.JwtUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class JwtUtilTest {

    @Test
    public void login() {
        User u = new User("kenx", "1234qwer", "jwctlaio");
        long expiration = 1000 * 60 * 60 * 24;
        String token = JwtUtil.createJWT(expiration, u);
        Map map = new HashMap();
        map.put("token", token);
        map.put("user", u);
        System.out.println(JSONUtil.toJsonStr(map));

    }
}
