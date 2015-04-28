package com.hundsun.fund.product.provider.query;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

/**
 *@Description:dal单元测试基类
 *@Author:许亮
 *@Since:2015年1月13日 上午10:52:26
 */
@ContextConfiguration(locations = { "classpath*:META-INF/spring/*.xml" })
public class BaseServiceTest extends AbstractTransactionalJUnit4SpringContextTests {

    // 启动服务
    public static void main(String[] args){
        try {
            // 加载spring，启动接口网关
            new ClassPathXmlApplicationContext (new String[] { "classpath*:META-INF/spring/*.xml" }).registerShutdownHook ();
        } catch (Exception e) {
            System.out.println ("启动失败：" + e.getMessage ());
            System.exit (1);
        }

        System.out.println ("启动成功，请输入 exit 退出");
        String result = "";
        while (true) {
            // 输出提示文字
            InputStreamReader is_reader = new InputStreamReader (System.in);
            try {
                result = new BufferedReader (is_reader).readLine ();
            } catch (IOException e) {}

            if (result.equals ("exit")) {
                System.exit (0);
            } else {
                System.out.println ("请输入 exit 退出");
            }
        }
    }
}
