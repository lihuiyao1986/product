/**
 * @Title: CommonServiceImpl.java
 * @Package com.hundsun.fund.provider.common
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @date 2015年5月12日 下午8:46:32
 * @Copyright:Copyright (c)
 * @Company:whty李焱生
 * @version V1.0
 */
package com.hundsun.fund.provider.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hundsun.fund.api.common.model.DictQueryByCodeAPIReqModel;
import com.hundsun.fund.api.common.model.DictQueryByCodeAPIRespModel;
import com.hundsun.fund.api.common.service.ICommonService;
import com.hundsun.fund.product.commons.exception.APIException;
import com.hundsun.fund.product.commons.utils.Errorcode;
import com.hundsun.fund.product.commons.utils.StringUtil;
import com.hundsun.fund.product.dao.mapper.CommonMapper;
import com.hundsun.fund.product.dao.model.DictDaoDaoModel;

/**
 *@Description:CommonServiceImpl
 *@Author:李焱生
 *@Since:2015年5月12日下午8:46:32  
 */
@Service("commonService")
public class CommonServiceImpl implements ICommonService {

    @Autowired
    private CommonMapper commonMapper;

    /**
     *@Description:根据code查询字典
     *@Author: 李焱生
     *@Since: 2015年5月12日下午10:11:18
     *@param params
     *@return
     */
    @Override
    public DictQueryByCodeAPIRespModel queryDictByCode(DictQueryByCodeAPIReqModel params){
        String code = StringUtil.trimNull (params.getDictCode ());
        if (StringUtil.isEmpty (code)) { throw new APIException (Errorcode.DEFAULT_ERROR_CODE,"字典代码为空"); }
        List<DictDaoDaoModel> list = commonMapper.queryDictByCode (code);
        DictQueryByCodeAPIRespModel respBean = new DictQueryByCodeAPIRespModel ();
        respBean.setCode (Errorcode.DEFAULT_SUCCESS_CODE);
        respBean.setMessage ("查询成功");
        respBean.setDicts (list);
        return respBean;
    }

}
