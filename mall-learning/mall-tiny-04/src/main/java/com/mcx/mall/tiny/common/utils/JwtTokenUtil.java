package com.mcx.mall.tiny.common.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * JwtToken生成的工具类
 * JWT token的格式：header.payload.signature
 * header的格式（算法、token的类型）：
 * {"alg": "HS512","typ": "JWT"}
 * payload的格式（用户名、创建时间、生成时间）：
 * {"sub":"wang","created":1489079981393,"exp":1489684781}
 * signature的生成算法：
 * HMACSHA512(base64UrlEncode(header) + "." +base64UrlEncode(payload),secret)
 * @author mcx
 * @date 2020/12/8 16:58
 */
public class JwtTokenUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(JwtTokenUtil.class);
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private Long expiration;
    private static final String CLAIM_KEY_USERNAME = "sub";
    private static final String CLAIM_KEY_CREATED = "created";

    /**
     * 根据用户信息生成token
     * @param userDetails 从数据库中查询出来的用户信息（用户名、密码、权限）
     * @return String
     */
    public String generateToken(UserDetails userDetails){
        HashMap<String , Object> claims = new HashMap<String , Object>();
        String username = userDetails.getUsername();
        claims.put(CLAIM_KEY_USERNAME , username);
        claims.put(CLAIM_KEY_CREATED , new Date());
        return generateToken(claims);
    }

    /**
     * 从token中获取用户名
     * @param token
     * @return String
     */
    public String getUserNameFromToken(String token){
        String username = null;

        try{
            Claims claims = getClaimsFromToken(token);
            username = claims.getSubject();
        }catch (Exception e){
            LOGGER.info("获取用户名失败:{}",token);
        }
        return username;
    }

    /**
     * 验证token是否还有效
     * 要满足两种情况 1.token不能过期失效 2.token里面的用户信息和数据库查询处理的用户信息一致
     * @param token 客户端传来的token
     * @param userDetails 从数据库中查询出来的用户信息（用户名，密码，权限）
     * @return boolean
     */
    public boolean validateToken(String token , UserDetails userDetails){
        String username = getUserNameFromToken(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    /**
     * 刷新权限
     * @param token
     * @return String
     */
    public String refreshToken(String token){
        Claims claims = getClaimsFromToken(token);
//        claims.setExpiration(new Date());
        claims.put(CLAIM_KEY_CREATED , new Date());
        return generateToken(claims);
    }

    public boolean canRefresh(String token){
        return !isTokenExpired(token);
    }

    /**
     * 根据payload（有效负载）生成token
     * @param claims
     * @return String
     */
    private String generateToken(Map<String , Object> claims){
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512,secret)
                .compact();
    }

    /**
     * 算出token的过期时间
     * @return Date
     */
    private Date generateExpirationDate(){
        return new Date(System.currentTimeMillis() + expiration * 1000);
    }

    /**
     * 从token中获取payload（有效负载）
     * @param token
     * @return Claims
     */
    private Claims getClaimsFromToken(String token){
        Claims claims = null;
        try{
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        }catch (Exception e){
            LOGGER.info("JWT格式验证失败:{}",token);
        }

        return claims;
    }

    /**
     * 判断token是否已经失效
     * @param token
     * @return boolean
     */
    private boolean isTokenExpired(String token){
        Date expiredDate = getExpiredDateFromToken(token);
        boolean result = expiredDate.before(new Date());
        return result;
    }

    /**
     * 从token中获取过期时间
     * @param token
     * @return Date
     */
    private Date getExpiredDateFromToken(String token){
        Claims claims = getClaimsFromToken(token);
        Date expiration = claims.getExpiration();
        return expiration;
    }



}
