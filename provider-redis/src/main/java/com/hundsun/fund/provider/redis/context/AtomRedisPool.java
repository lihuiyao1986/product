/**
 * @Title: AtomRedisPool.java
 * @Package com.hundsun.fund.provider.redis
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年5月5日 下午2:47:33
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.provider.redis.context;

import java.util.List;

import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

/**
 *@Description:TODO(这里用一句话描述这个类的作用)
 *@Author:李焱生
 *@Since:2015年5月5日下午2:47:33  
 */
public class AtomRedisPool {
    
    private ShardedJedisPool          shardedJedisPool;                               // 基于分片的Redis资源池
    private JedisPoolConfig           configPool;                                     // 资源池配置项
    private List<JedisShardInfo>      sharded;                                         // 分片服务器信息配置
    private ThreadLocal<ShardedJedis> shardedLocal = new ThreadLocal<ShardedJedis> (); // 设置当前线程获取的ShardedJedis资源

    public void refush(){
        shardedJedisPool = new ShardedJedisPool (configPool,sharded);
    }

    /** 获取链接操作资源 */
    public ShardedJedis getShardedJedis(){
        ShardedJedis shardedJedis = shardedJedisPool.getResource ();
        shardedLocal.set (shardedJedis);
        return shardedJedis;
    }

    /** 将链接资源回收 */
    public boolean backtoPool(){
        ShardedJedis shardedJedis = shardedLocal.get ();
        shardedJedisPool.returnResource (shardedJedis);
        return true;
    }

    public JedisPoolConfig getConfigPool(){
        return configPool;
    }

    public void setConfigPool(JedisPoolConfig configPool){
        this.configPool = configPool;
    }

    public List<JedisShardInfo> getSharded(){
        return sharded;
    }

    public void setSharded(List<JedisShardInfo> sharded){
        this.sharded = sharded;
    }
}
