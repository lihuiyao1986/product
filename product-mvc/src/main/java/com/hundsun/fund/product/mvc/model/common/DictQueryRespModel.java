/**
 * @Title: DictQueryRespModel.java
 * @Package com.hundsun.fund.product.mvc.model.common
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年5月13日 上午10:07:46
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.product.mvc.model.common;

import java.util.List;

import com.hundsun.fund.product.dao.model.DictDaoDaoModel;
import com.hundsun.fund.product.mvc.model.base.BaseRespModel;

/**
 *@Description: 字典查询
 *@Author:李焱生
 *@Since:2015年5月13日上午10:07:46  
 */
public class DictQueryRespModel extends BaseRespModel {

    private static final long     serialVersionUID = -3494675646827685056L;

    /** 字典列表 **/
    private List<DictDaoDaoModel> dicts;

    public List<DictDaoDaoModel> getDicts(){
        return dicts;
    }

    public void setDicts(List<DictDaoDaoModel> dicts){
        this.dicts = dicts;
    }

}
