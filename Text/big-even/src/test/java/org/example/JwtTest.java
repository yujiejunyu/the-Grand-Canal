package org.example;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class JwtTest {
    @Test
    public void textGen(){
        Map<String, Object>claims=new HashMap<>();
        claims.put("id",1);
        claims.put("username","张三");
        String token=JWT.create()
                .withClaim("user",claims)//添加载荷
                .withExpiresAt(new Date(System.currentTimeMillis()+1000*60*12))//添加过期时间
                .sign(Algorithm.HMAC256("miya"));
        System.out.println(token);
    }


}
