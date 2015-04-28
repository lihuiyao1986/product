/**
 * @Title: User.java
 * @Package com.hundsun.fund.product.model.api
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年4月27日 下午4:45:12
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.product.model.api;

import java.io.Serializable;

/**
 *@Description:TODO(这里用一句话描述这个类的作用)
 *@Author:李焱生
 *@Since:2015年4月27日下午4:45:12  
 */
public class User implements Serializable {

    private static final long serialVersionUID = -5953809222060882401L;

    private String            name;

    private int               age;

    private char              sex;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public char getSex(){
        return sex;
    }

    public void setSex(char sex){
        this.sex = sex;
    }
}
