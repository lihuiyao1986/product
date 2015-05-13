/**
 * @Title: DictQueryByCodeAPIRespModel.java
 * @Package com.hundsun.fund.api.common.model
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年5月12日 下午10:08:07
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.api.common.model;

import java.util.List;

import com.hundsun.fund.product.commons.model.BaseAPIRespParam;
import com.hundsun.fund.product.dao.model.DictDaoDaoModel;

/**
 *@Description:根据code查询字典
 *@Author:李焱生
 *@Since:2015年5月12日下午10:08:07  
 */
public class DictQueryByCodeAPIRespModel extends BaseAPIRespParam {

    private static final long     serialVersionUID = 7111071212988816788L;

    // 字典对象
    private List<DictDaoDaoModel> dicts;

    public List<DictDaoDaoModel> getDicts(){
        return dicts;
    }

    public void setDicts(List<DictDaoDaoModel> dicts){
        this.dicts = dicts;
    }

}
