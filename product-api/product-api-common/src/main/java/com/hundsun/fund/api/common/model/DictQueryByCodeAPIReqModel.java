/**
 * @Title: DictQueryByCodeAPIReqModel.java
 * @Package com.hundsun.fund.api.common.model
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年5月12日 下午10:07:29
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.api.common.model;

import com.hundsun.fund.product.commons.model.BaseAPIReqParam;

/**
 *@Description:根据code查询字典
 *@Author:李焱生
 *@Since:2015年5月12日下午10:07:29  
 */
public class DictQueryByCodeAPIReqModel extends BaseAPIReqParam {

    private static final long serialVersionUID = -4728167149237122905L;

    // 字典代码
    private String            dictCode;

    public String getDictCode(){
        return dictCode;
    }

    public void setDictCode(String dictCode){
        this.dictCode = dictCode;
    }

}
