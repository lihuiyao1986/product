/**
 * @Title: TestMain.java
 * @Package com.hundsun.fund.provider.redis
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年5月5日 下午3:20:12
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.provider.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hundsun.fund.provider.redis.client.RedisShardingClient;
import com.hundsun.fund.provider.redis.model.User;

/**
 *@Description:TODO(这里用一句话描述这个类的作用)
 *@Author:李焱生
 *@Since:2015年5月5日下午3:20:12  
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:META-INF/spring/redis-context.xml")
public class TestMain {

    @Autowired
    private RedisShardingClient client;

    @Test
    public void deleteObject(){// 根据key删除内容 pass
        client.del ("userHash");
    }

    @Test
    public void lpushObject(){// 向缓存队列中保存对象 pass
        User user = new User ();
        for ( int i = 0 ; i < 3 ; i++ ) {
            user.setId (1000 + i);
            user.setSex (1);
            user.setName ("用户" + i);
            user.setNick ("哈哈" + i);
            user.setEmail ("haha@clt.com" + i);
            boolean reusltCache = client.lpush ("userTeam", user);
            if (reusltCache) {
                System.out.println ("向队列中保存" + user.getNick () + "成功。");
            } else {
                System.out.println ("向队列中保存" + user.getNick () + "失败。");
            }
        }
    }

   // @Test
    public void rpopObject(){// 从队列右取对象，并删除 pass
        User user = new User ();
        user = client.rpop ("userTeam", User.class);
        if (user != null) {
            System.out.println (user);
        }
    }

    //@Test
    public void saveObject(){// 根据key保存对象 pass
        User user = new User ();
        user.setId (10002);
        user.setName ("王一");
        user.setNick ("屁颠屁颠");
        user.setSex (1);
        user.setEmail ("54321@clt.com");
        client.set (String.valueOf (user.getId ()), user);
    }

    //@Test
    public void findObject(){// 根据key获取对象 pass
        User user = new User ();
        user = client.get ("10002", User.class);
        if (user != null) {
            System.out.println ("从缓存中获取的对象，" + user);
        }
    }
}
