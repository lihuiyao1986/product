/**
 *@Title: RedisAbstractTemplate.java 
 *@Package com.hundsun.fund.provider.redis.context 
 *@Description: TODO(用一句话描述该文件做什么) 
 *@author A18ccms A18ccms_gmail_com   
 *@date 2015年5月5日 下午2:51:29 
 *@Copyright:Copyright (c) 
 *@Company:whty李焱生
 *@version V1.0 
 */
package com.hundsun.fund.provider.redis.context;




/**
 *@Description:TODO(这里用一句话描述这个类的作用)
 *@Author:李焱生
 *@Since:2015年5月5日下午2:51:29  
 */
public abstract class RedisAbstractTemplate {
    
    protected AtomRedisPool atomRedisPool; //控制资源的上下文对象

    public AtomRedisPool getAtomRedisPool() {
     return atomRedisPool;
    }

    public void setAtomRedisPool(AtomRedisPool atomRedisPool) {
     this.atomRedisPool = atomRedisPool;
    }
}
