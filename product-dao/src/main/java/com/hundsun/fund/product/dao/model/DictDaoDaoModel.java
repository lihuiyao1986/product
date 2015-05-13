/**
 * @Title: DictDaoDaoModel.java
 * @Package com.hundsun.fund.product.dao.model
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年5月12日 下午9:09:50
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.product.dao.model;

/**
 *@Description:字典表
 *@Author:李焱生
 *@Since:2015年5月12日下午9:09:50  
 */
public class DictDaoDaoModel extends BaseDaoModel {

    private static final long serialVersionUID = 6487477976095131023L;

    // 字典代码
    private String            dictCode;

    // 字典名称
    private String            dictName;

    // 字典值
    private String            dictValue;

    public String getDictCode(){
        return dictCode;
    }

    public void setDictCode(String dictCode){
        this.dictCode = dictCode;
    }

    public String getDictName(){
        return dictName;
    }

    public void setDictName(String dictName){
        this.dictName = dictName;
    }

    public String getDictValue(){
        return dictValue;
    }

    public void setDictValue(String dictValue){
        this.dictValue = dictValue;
    }

}
