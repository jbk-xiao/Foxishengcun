package com.trace.trace.dao;

import com.trace.trace.util.JedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;

import java.util.Set;

@Slf4j
@Repository
public class ChartsRedisDao {

    private final JedisUtil jedisUtil;

    public ChartsRedisDao(JedisUtil jedisUtil) {
        this.jedisUtil = jedisUtil;
    }

    public Set<String> getCompetSkuIds(String skuId) {
        Jedis jedis = jedisUtil.getClient();
        jedis.select(2);
        Set<String> skuIds = jedis.zrange(skuId, 0, -1);
        jedis.close();
        return skuIds;
    }
}
