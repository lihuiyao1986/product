/**
 * @Title: BaseReqModel.java
 * @Package com.hundsun.fund.product.model.mvc.base
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年4月29日 上午10:42:13
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.product.mvc.model.base;

import java.io.Serializable;

import com.hundsun.fund.product.commons.utils.Constant;

/**
 *@Description:所有请求入参的基类
 *@Author:李焱生
 *@Since:2015年4月29日上午10:42:13  
 */
public class BaseReqModel implements Serializable {

    private static final long serialVersionUID = 7172531807912046993L;
    // 版本
    protected String          version;
    // 随机数
    protected String          random;
    // 时间戳
    protected String          timestamp;
    // 请求url
    protected String          url;
    // 签名串
    protected String          sign;
    // 令牌
    protected String          token;
    // 唯一串
    protected String          uuid;
    // 用户代理
    protected String          useragent;
    // 终端来源
    protected String          source;
    // 是否分页 0--不分页 1--分页
    protected String          isPage;
    // 页码
    protected int             pageNo           = Constant.DEFAULT_PAGENO;
    // 每页记录数
    protected int             pageSize         = Constant.DEFAULT_PAGESIZE;

    public String getVersion(){
        return version;
    }

    public void setVersion(String version){
        this.version = version;
    }

    public String getRandom(){
        return random;
    }

    public void setRandom(String random){
        this.random = random;
    }

    public String getTimestamp(){
        return timestamp;
    }

    public void setTimestamp(String timestamp){
        this.timestamp = timestamp;
    }

    public String getUrl(){
        return url;
    }

    public void setUrl(String url){
        this.url = url;
    }

    public String getSign(){
        return sign;
    }

    public void setSign(String sign){
        this.sign = sign;
    }

    public String getToken(){
        return token;
    }

    public void setToken(String token){
        this.token = token;
    }

    public String getUuid(){
        return uuid;
    }

    public void setUuid(String uuid){
        this.uuid = uuid;
    }

    public String getUseragent(){
        return useragent;
    }

    public void setUseragent(String useragent){
        this.useragent = useragent;
    }

    public String getSource(){
        return source;
    }

    public void setSource(String source){
        this.source = source;
    }

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

    /**
     *@Description:用于生成签名的加密串
     *@Author: 张聪
     *@Since: 2014年10月31日下午12:26:25
     *@return
     */
    @Override
    public String toString(){
        return version + "|" + timestamp + "|" + token + "|" + random + "|" + uuid + "|" + url + "|" + useragent + "|" + source;
    }
}
