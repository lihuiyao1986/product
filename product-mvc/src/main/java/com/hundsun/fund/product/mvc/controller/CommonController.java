/**
 * @Title: CommonController.java
 * @Package com.hundsun.fund.product.mvc.controller
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年5月12日 下午10:18:20
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.product.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hundsun.fund.api.common.model.DictQueryByCodeAPIReqModel;
import com.hundsun.fund.api.common.model.DictQueryByCodeAPIRespModel;
import com.hundsun.fund.api.common.service.ICommonService;
import com.hundsun.fund.product.mvc.model.common.DictQueryReqModel;
import com.hundsun.fund.product.mvc.model.common.DictQueryRespModel;

/**
 *@Description:公共类的controller
 *@Author:李焱生
 *@Since:2015年5月12日下午10:18:20  
 */
@Controller()
@RequestMapping("/common")
public class CommonController extends BaseController {

    @Autowired
    private ICommonService commonService;

    /**
     * 
     *@Description: 查询产品类型数据字典 
     *@Author: 李焱生
     *@Since: 2015年5月12日下午10:23:11
     *@param params
     *@return
     */
    @ResponseBody
    @RequestMapping("/producttype_dict_query.json")
    public DictQueryRespModel productTypeDictQuery(DictQueryReqModel params){
        return queryDictByCode ("3");
    }

    /**
     * 
     *@Description: 风险等级数据字典查询 
     *@Author: 李焱生
     *@Since: 2015年5月13日上午10:01:34
     *@param params
     *@return
     */
    @ResponseBody
    @RequestMapping("/risktype_dict_query.json")
    public DictQueryRespModel risktypeDictQuery(DictQueryReqModel params){
        return queryDictByCode ("2");
    }

    /**
     * 
     *@Description:  产品校验状态字典查询
     *@Author: 李焱生
     *@Since: 2015年5月13日上午10:10:15
     *@param params
     *@return
     */
    @ResponseBody
    @RequestMapping("/product_verify_status_dict_query.json")
    public DictQueryRespModel productVerifyStatusDictQuery(DictQueryReqModel params){
        return queryDictByCode ("1");
    }

    /**
     * 
     *@Description: 根据字典代码查询字典
     *@Author: 李焱生
     *@Since: 2015年5月13日上午10:13:12
     *@param code
     *@return
     */
    private DictQueryRespModel queryDictByCode(String code){
        DictQueryByCodeAPIReqModel reqParam = new DictQueryByCodeAPIReqModel ();
        reqParam.setDictCode (code);
        DictQueryByCodeAPIRespModel respBean = commonService.queryDictByCode (reqParam);
        DictQueryRespModel result = new DictQueryRespModel ();
        result.setCode (respBean.getCode ());
        result.setMessage (respBean.getMessage ());
        result.setDicts (respBean.getDicts ());
        return result;
    }

}
