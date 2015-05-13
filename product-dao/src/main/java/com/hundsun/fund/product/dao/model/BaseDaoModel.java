/**
 * @Title: BaseDaoModel.java
 * @Package com.hundsun.fund.product.dao.model
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年5月6日 下午12:54:31
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.product.dao.model;

import java.io.Serializable;

/**
 *@Description:TODO(这里用一句话描述这个类的作用)
 *@Author:李焱生
 *@Since:2015年5月6日下午12:54:31  
 */

public class BaseDaoModel implements Serializable {

    private static final long serialVersionUID = -2176466384931270737L;

    // 主键id
    protected String          id;

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

}
