/**
 * @Title: RedisShardingClient.java
 * @Package com.hundsun.fund.provider.redis.client
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年5月5日 下午2:50:42
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.provider.redis.client;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import redis.clients.jedis.ShardedJedis;

import com.alibaba.fastjson.JSON;
import com.hundsun.fund.provider.redis.context.RedisAbstractTemplate;

/**
 *@Description:RedisShardingClient
 *@Author:李焱生
 *@Since:2015年5月5日下午2:50:42  
 */
public class RedisShardingClient extends RedisAbstractTemplate {

    /** 向缓存中设置字符串内容 */
    public boolean set(String key,String value){
        try {
            ShardedJedis shardedJedis = atomRedisPool.getShardedJedis ();
            shardedJedis.set (key, value);
            return true;
        } catch (Exception e) {
            throw e;
        } finally {
            atomRedisPool.backtoPool ();
        }
    }

    /** 向缓存中设置有生命周期字符串内容 */
    public boolean setEx(String key,int seconds,String value) throws Exception{
        try {
            ShardedJedis shardedJedis = atomRedisPool.getShardedJedis ();
            shardedJedis.setex (key, seconds, value);
            return true;
        } catch (Exception e) {
            throw e;
        } finally {
            atomRedisPool.backtoPool ();
        }
    }

    /** 根据key获取内容 */
    public Object get(String key){
        try {
            ShardedJedis shardedJedis = atomRedisPool.getShardedJedis ();
            Object value = shardedJedis.get (key);
            return value;
        } catch (Exception e) {
            throw e;
        } finally {
            atomRedisPool.backtoPool ();
        }
    }

    /** 根据key删除缓存中的对象 */
    public boolean del(String key){// pass
        try {
            ShardedJedis shardedJedis = atomRedisPool.getShardedJedis ();
            shardedJedis.del (key);
            return true;
        } catch (Exception e) {
            throw e;
        } finally {
            atomRedisPool.backtoPool ();
        }
    }

    /** 向缓存中设置对象 */
    public boolean set(String key,Object value){// pass
        try {
            ShardedJedis shardedJedis = atomRedisPool.getShardedJedis ();
            String objectJson = JSON.toJSONString (value);
            shardedJedis.set (key, objectJson);
            return true;
        } catch (Exception e) {
            throw e;
        } finally {
            atomRedisPool.backtoPool ();
        }
    }

    /** 向缓存中存具有生命周期的对象 */
    public boolean setex(String key,int seconds,Object value){
        try {
            ShardedJedis shardedJedis = atomRedisPool.getShardedJedis ();
            String objectJson = JSON.toJSONString (value);
            shardedJedis.setex (key, seconds, objectJson);
            return true;
        } catch (Exception e) {
            throw e;
        } finally {
            atomRedisPool.backtoPool ();
        }
    }

    /** 根据key 获取对象 */
    public <T> T get(String key,Class<T> clazz){// pass
        try {
            ShardedJedis shardedJedis = atomRedisPool.getShardedJedis ();
            String value = shardedJedis.get (key);
            return JSON.parseObject (value, clazz);
        } catch (Exception e) {
            throw e;
        } finally {
            atomRedisPool.backtoPool ();
        }
    }

    // *************************************list****************************************//

    /** 对象放入队列头（左入） */
    public boolean lpush(String key,Object value){// pass
        try {
            ShardedJedis shardedJedis = atomRedisPool.getShardedJedis ();
            String objectJson = JSON.toJSONString (value);
            shardedJedis.lpush (key, objectJson);
            return true;
        } catch (Exception e) {
            throw e;
        } finally {
            atomRedisPool.backtoPool ();
        }
    }

    /** 对象放入队列尾（右入） */
    public boolean rpush(String key,Object value){// pass
        try {
            ShardedJedis shardedJedis = atomRedisPool.getShardedJedis ();
            String objectJson = JSON.toJSONString (value);
            shardedJedis.rpush (key, objectJson);
            return true;
        } catch (Exception e) {
            throw e;
        } finally {
            atomRedisPool.backtoPool ();
        }
    }

    /** 移除并返回列表 key 的尾元素（右出） */
    public <T> T rpop(String key,Class<T> clazz){// pass
        try {
            ShardedJedis shardedJedis = atomRedisPool.getShardedJedis ();
            String value = shardedJedis.rpop (key);
            return JSON.parseObject (value, clazz);
        } catch (Exception e) {
            throw e;
        } finally {
            atomRedisPool.backtoPool ();
        }
    }

    /** 移除并返回列表 key 的头元素 （左出） */
    public <T> T lpop(String key,Class<T> clazz){
        try {
            ShardedJedis shardedJedis = atomRedisPool.getShardedJedis ();
            String value = shardedJedis.lpop (key);
            return JSON.parseObject (value, clazz);
        } catch (Exception e) {
            throw e;
        } finally {
            atomRedisPool.backtoPool ();
        }
    }

    /** 返回列表 key 中，下标为 index 的对象 */
    public <T> T lindex(String key,long index,Class<T> clazz){
        try {
            ShardedJedis shardedJedis = atomRedisPool.getShardedJedis ();
            String value = shardedJedis.lindex (key, index);
            return JSON.parseObject (value, clazz);
        } catch (Exception e) {
            throw e;
        } finally {
            atomRedisPool.backtoPool ();
        }
    }

    /** 返回列表 key 的长度 llen */
    public long llen(String key){
        try {
            ShardedJedis shardedJedis = atomRedisPool.getShardedJedis ();
            return shardedJedis.llen (key);
        } catch (Exception e) {
            throw e;
        } finally {
            atomRedisPool.backtoPool ();
        }
    }

    // *************************************hash****************************************//

    /** 返回哈希表所有的对象 hgetAll */
    public <T> List<T> hgetAll(String key,Class<T> clazz){
        try {
            ShardedJedis shardedJedis = atomRedisPool.getShardedJedis ();
            Map<String, String> objects = shardedJedis.hgetAll (key);
            List<T> clazzs = new ArrayList<T> ();
            Set<String> set = objects.keySet ();// 返回Map中包含的键的 Set列表。
            Iterator<String> it = set.iterator ();// 获得列表迭代器
            while (it.hasNext ()) {
                String objKey = it.next ();
                if (objects.containsKey (objKey)) {
                    clazzs.add ((T) JSON.parseObject (objects.get (objKey), clazz));
                }
            }
            return clazzs;
        } catch (Exception e) {
            throw e;
        } finally {
            atomRedisPool.backtoPool ();
        }
    }

    /** 保存 对象到哈希表 hset */
    public boolean hset(String key,String field,Object value){
        try {
            ShardedJedis shardedJedis = atomRedisPool.getShardedJedis ();
            String objectJson = JSON.toJSONString (value);
            shardedJedis.hset (key, field, objectJson);
            return true;
        } catch (Exception e) {
            throw e;
        } finally {
            atomRedisPool.backtoPool ();
        }
    }

    /** 获取哈希表中对象 hget */
    public <T> T hget(String key,String field,Class<T> clazz){
        try {
            ShardedJedis shardedJedis = atomRedisPool.getShardedJedis ();
            String value = shardedJedis.hget (key, field);
            return JSON.parseObject (value, clazz);
        } catch (Exception e) {
            throw e;
        } finally {
            atomRedisPool.backtoPool ();
        }
    }

    /** 返回哈希表 key 中域的数量 hlen */
    public long hlen(String key){
        try {
            ShardedJedis shardedJedis = atomRedisPool.getShardedJedis ();
            return shardedJedis.hlen (key);
        } catch (Exception e) {
            throw e;
        } finally {
            atomRedisPool.backtoPool ();
        }
    }

    /** 删除哈希表 key 中的一个或多个指定域，不存在的域将被忽略 hdel */
    public boolean hdel(String key,String field1){
        try {
            ShardedJedis shardedJedis = atomRedisPool.getShardedJedis ();
            shardedJedis.hdel (key, field1);
            return true;
        } catch (Exception e) {
            throw e;
        } finally {
            atomRedisPool.backtoPool ();
        }
    }

    /**
     * score set加入元素
     * @param key
     * @param score
     * @param value
     */
    public void zadd(String key,double score,Object value){
        try {
            ShardedJedis shardedJedis = atomRedisPool.getShardedJedis ();
            String objectJson = JSON.toJSONString (value);
            shardedJedis.zadd (key, score, objectJson);
        } catch (Exception e) {
            throw e;
        } finally {
            atomRedisPool.backtoPool ();
        }
    }

    /**
     * score set移除
     * @param key
     * @param value
     */
    public void zremove(String key,Object value){
        try {
            ShardedJedis shardedJedis = atomRedisPool.getShardedJedis ();
            String objectJson = JSON.toJSONString (value);
            shardedJedis.zrem (key, objectJson);
        } catch (Exception e) {
            throw e;
        } finally {
            atomRedisPool.backtoPool ();
        }
    }

    /**
     * 根据score范围获取list
     * @param key
     * @param min
     * @param max
     * @param clazz
     * @return
     */
    public <T> List<T> zrangeByScore(String key,double min,double max,Class<T> clazz){
        try {
            ShardedJedis shardedJedis = atomRedisPool.getShardedJedis ();
            Set<String> set = shardedJedis.zrangeByScore (key, min, max);
            List<T> clazzs = new ArrayList<T> ();
            Iterator<String> it = set.iterator ();
            while (it.hasNext ()) {
                clazzs.add ((T) JSON.parseObject (it.next (), clazz));
            }
            return clazzs;
        } catch (Exception e) {
            throw e;
        } finally {
            atomRedisPool.backtoPool ();
        }
    }

    /**
     * 根据成员获取score
     * @param key
     * @param value
     * @return
     */
    public double zscore(String key,Object value){
        try {
            ShardedJedis shardedJedis = atomRedisPool.getShardedJedis ();
            String objectJson = JSON.toJSONString (value);
            return shardedJedis.zscore (key, objectJson);
        } catch (Exception e) {
            throw e;
        } finally {
            atomRedisPool.backtoPool ();
        }
    }
}
