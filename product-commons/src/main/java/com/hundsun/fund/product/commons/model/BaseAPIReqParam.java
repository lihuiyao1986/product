/**
 * @Title: BaseAPIReqParam.java
 * @Package com.hundsun.fund.product.commons.model
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年4月30日 上午11:16:29
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.product.commons.model;

import java.io.Serializable;

import com.hundsun.fund.product.commons.utils.Constant;

/**
 *@Description:调用api的入参类
 *@Author:李焱生
 *@Since:2015年4月30日上午11:16:29  
 */
public class BaseAPIReqParam implements Serializable {

    private static final long serialVersionUID = -5662635073760820425L;

    // 是否分页 0--不分页 1--分页
    protected String          isPage;

    // 页码
    protected int             pageNo           = Constant.DEFAULT_PAGENO;

    // 每页记录数
    protected int             pageSize         = Constant.DEFAULT_PAGESIZE;

    public String getIsPage(){
        return isPage;
    }

    public void setIsPage(String isPage){
        this.isPage = isPage;
    }

    public int getPageNo(){
        if (pageNo <= 0) {
            pageNo = Constant.DEFAULT_PAGENO;
        }
        return pageNo;
    }

    public void setPageNo(int pageNo){
        this.pageNo = pageNo;
    }

    public int getPageSize(){
        if (pageSize <= 0) {
            pageSize = Constant.DEFAULT_PAGESIZE;
        }
        return pageSize;
    }

    public void setPageSize(int pageSize){
        this.pageSize = pageSize;
    }

}
