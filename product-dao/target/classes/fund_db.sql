drop database if exists fund_product;
create database fund_product;
use fund_product;

drop table if exists t_sale_org;
create table if not exists t_sale_org(
   f_sale_org_id bigint auto_increment comment '销售机构id',
   f_sale_org_name varchar(255) comment '销售机构名称',
   f_sale_org_latitude double comment '销售机构的纬度',
   f_sale_org_longtitude double comment '销售机构的经度',
   f_sale_org_memo varchar(255) comment '销售机构的备注',
   f_sale_org_city varchar(255) comment '销售机构所在的城市',
   f_sale_org_district varchar(255) comment '销售机构所在的区域',
   primary key(f_sale_org_id)
) engine=InnoDB default charset=UTF8;

drop table if exists t_financial_planner;
create table if not exists t_financial_planner(
   f_financial_planner_id bigint auto_increment comment '理财师id',
   f_financial_planner_icon varchar(255) comment '头像url',
   f_financial_planner_name varchar(255) comment '理财师姓名',
   f_financial_planner_mobile char(11) comment '理财师手机号',
   f_financial_planner_phone varchar(100) comment '理财师固定电话',
   f_financial_planner_webchat varchar(255) comment '理财师微信号',
   f_financial_planner_webchat_pic blob comment '理财师的微信二维码照片',
   f_financial_planner_qq varchar(100) comment '理财师qq',
   f_financial_planner_account varchar(255) comment '理财师账号',
   f_financial_planner_pwd varchar(255) comment '理财师账号密码',
   f_financial_planner_memo varchar(255) comment '备注',
   primary key(f_financial_planner_id)
) engine=InnoDB default charset=UTF8;

drop table if exists t_investor;
create table if not exists t_investor(
   f_investor_id bigint auto_increment comment '投资人信息表主键',
   f_investor_uuid varchar(255) comment '投资人手机端唯一编号',
   f_investor_icon varchar(255) comment '投资人头像url',
   f_investor_name varchar(255) comment '投资人姓名',
   f_investor_email varchar(255) comment '投资人邮箱',
   f_investor_qq varchar(255) comment '投资人qq号码',
   f_investor_webchat varchar(255) comment '投资人微信号',
   f_investor_mobile char(11) comment '投资人手机号',
   f_investor_address varchar(255) comment '投资人的通讯地址',
   f_investor_account varchar(255) comment '投资人账号',
   f_investor_pwd varchar(255) comment '投资人账号密码',
   f_investor_memo varchar(255) comment '备注',
   primary key(f_investor_id) comment '投资人id作为主键'
) engine=InnoDB default charset=UTF8;

drop table if exists t_investor_logininfo;
create table if not exists t_investor_logininfo(
   f_investor_logininfo_id bigint auto_increment comment '主键id',
   f_investor_id bigint comment '投资人的id',
   f_last_login_time timestamp comment '上一次登录时间',
   f_login_time timestamp comment '登录时间',
   f_login_nums bigint comment '登录次数',
   f_memo varchar(255) comment '备注',
   primary key(f_investor_logininfo_id),
   foreign key(f_investor_id) references t_investor(f_investor_id)
)engine=InnoDB default charset=UTF8;

drop table if exists t_product_info;
create table if not exists t_product_info(
   f_product_id bigint auto_increment comment '产品id',
   f_product_code varchar(255) comment '产品代码',
   f_product_name varchar(255) comment '产品名称',
   f_product_year_income_rate double comment '年化收益率',
   f_product_limit bigint comment '产品期限' ,
   f_product_org_name varchar(255) comment '理财机构名称',
   f_product_min_invest_sum double comment '最低起售金额',
   f_product_sale_start_time date comment '销售起始日期',
   f_product_sale_end_time date comment '销售截止日期',
   f_product_overdue_time date comment '产品到期时间',
   f_product_verify_status char(2) default '00' comment '产品审核状态 00-待审核 01-已审核 02-审核退回',
   f_product_type char(2) comment '产品类型 00-银行理财 01--货币基金',
   f_product_sale_total_sum double comment '产品销售规模',
   f_product_sale_remain_sum double comment '产品剩余金额',
   f_product_sale_saled_sum double comment '产品已销售金额',
   f_product_risk_type char(2) default '00' comment '产品风险类型 00-保本 01-非保本 02-保本浮动 03-保本预期',
   f_product_desc varchar(255) comment '产品描述',
   f_product_interest_pay_way_desc varchar(255) comment '付利息方式描述',
   f_product_memo varchar(255) comment '备注',
   primary key(f_product_id)
) engine=InnoDB default charset=UTF8;

drop table if exists t_product_saleorg_planner;
create table if not exists t_product_saleorg_planner(
   f_product_id bigint comment '产品id',
   f_financial_planner_id bigint comment '理财师id',
   f_sale_org_id bigint comment '销售机构id',
   primary key(f_product_id,f_financial_planner_id,f_sale_org_id)
)engine=InnoDB default charset=UTF8;

drop table if exists t_recommend_product_info;
create table if not exists t_recommend_product_info
(
    f_recommend_product_info_id bigint auto_increment comment '推荐信息id',
    f_product_id bigint comment '推荐产品ID',
    primary key(f_recommend_product_info_id),
    foreign key(f_product_id) references t_product_info(f_product_id) on delete cascade on update cascade
)engine=InnoDB default charset=UTF8;

drop table if exists t_product_praise;
create table if not exists t_product_praise(
   f_product_praise_id bigint auto_increment comment 'id',
   f_product_id  bigint comment '点赞产品id',
   f_investor_id bigint comment '点赞用户',
   f_memo varchar(255) comment '备注',
   primary key (f_product_praise_id)
)engine=InnoDB default charset=UTF8;

drop table if exists t_investor_hobby;
create table if not exists t_investor_hobby(
   f_hobby_id bigint auto_increment comment '喜好id',
   f_investor_id bigint comment '投资者的id',
   f_product_asset double comment '投资规模',
   f_product_year_income_rate double comment '收益率预期',
   f_product_limit bigint comment '产品期限',
   f_risk_ability char(2) default '00' comment '00-保本 01-非保本 02-保本浮动 03-保本预期',
   f_memo varchar(255) comment '备注',
   primary key(f_hobby_id),
   foreign key(f_investor_id) references t_investor(f_investor_id) on delete cascade on update cascade
)engine=InnoDB default charset=UTF8;

drop table if exists t_product_collection;
create table if not exists t_product_collection(
    f_product_collection_id bigint auto_increment comment '收藏id',
    f_collection_product_id bigint  comment '产品id',
    f_collection_investor_id bigint comment '投资人id',
    f_collection_memo varchar(255) comment '备注',
    f_collection_time timestamp comment '收藏时间',
    primary key(f_product_collection_id) comment '收藏id设置成主键',
    foreign key(f_collection_product_id) references t_product_info(f_product_id) on delete cascade on update cascade,
    foreign key(f_collection_investor_id) references t_investor(f_investor_id) on delete cascade on update cascade
)engine=InnoDB default charset=UTF8;

drop table if exists t_investor_trace_record;
create table if not exists t_investor_trace_record
(
    f_trace_record_id bigint auto_increment comment '浏览记录id',
    f_investor_id bigint comment '投资人的id',
    f_product_id bigint comment '产品id',
    f_trace_time timestamp comment '浏览时间',
    f_memo varchar(255) comment '备注',
    primary key (f_trace_record_id),
    foreign key (f_investor_id) references t_investor(f_investor_id) on delete cascade on update cascade,
    foreign key (f_product_id) references t_product_info(f_product_id) on delete cascade on update cascade
)engine=InnoDB default charset=UTF8;

drop table if exists t_investor_feedback_info;
create table if not exists t_investor_feedback_info(
   f_investor_feedback_id bigint auto_increment comment '反馈信息的id',
   f_investor_feedback_info text comment '反馈信息的内容',
   f_investor_id bigint comment '反馈人信息',
   f_investor_feedback_time timestamp comment '反馈时间',
   f_investor_feedback_email varchar(255) comment '反馈人的email',
   f_investor_feedback_mobile char(11) comment '反馈人的手机号',
   f_investor_feedback_memo varchar(255) comment '备注',
   primary key(f_investor_feedback_id),
   foreign key(f_investor_id) references t_investor(f_investor_id) on delete cascade on update cascade
)engine=InnoDB default charset=UTF8;

drop table if exists t_feedback_reply;
create table if not exists t_feedback_reply
(
     f_feedback_reply_id bigint auto_increment comment '回复的id',
     f_feedback_reply_content text comment '回复的内容',
     f_investor_feedback_id bigint comment '回复的反馈id',
     f_feedback_reply_time timestamp comment '回复的时间',
     f_feedback_reply_autor varchar(255) comment '回复人',
     f_feedback_reply_memo varchar(255) comment '备注',
     primary key (f_feedback_reply_id),
     foreign key (f_investor_feedback_id) references t_investor_feedback_info(f_investor_feedback_id) on delete cascade on update cascade
)engine=InnoDB default charset=UTF8;

drop table if exists t_investor_device_info;
create table if not exists t_investor_device_info(
    f_investor_mobile_info_id bigint auto_increment comment '主键',
    f_investor_id bigint comment '投资人id',
    f_sys_name varchar(255) comment '手机系统的名称',
    f_sys_version varchar(100) comment '手机系统的版本',
    f_app_version varchar(255) comment '应用的版本号',
    f_app_version_name varchar(255) comment '应用的版本号名称',
    f_device_info varchar(255) comment '设备信息',
    f_screen_height varchar(255) comment '设备的高度',
    f_screen_width varchar(255) comment '设备的宽度',
    f_mobile_uuid varchar(255) comment '手机唯一标识',
    f_net_type varchar(255) comment '网络类型',
    f_device_density varchar(255) comment '屏幕密度',
    f_memo varchar(255) comment '备注',
    primary key(f_investor_mobile_info_id),
    foreign key(f_investor_id) references t_investor(f_investor_id)
)engine=InnoDB default charset=UTF8;


drop table if exists t_investor_phone_record;
create table if not exists t_investor_phone_record(
   f_record_id bigint auto_increment comment '主键',
   f_investor_id bigint comment '拨打电话的投资者',
   f_financial_planner_id bigint comment '被叫的理财师',
   f_create_time timestamp comment '拨打时间',
   primary key(f_record_id),
   foreign key(f_financial_planner_id) references t_financial_planner(f_financial_planner_id)
)engine=InnoDB default charset=UTF8;

drop table if exists t_most_income_product_info;
create table if not exists t_most_income_product_info(
     f_id bigint auto_increment comment '主键字段',
     f_year_income_rate_desc varchar(255) comment '年化收益描述',
     f_product_limit_desc varchar(255) comment '产品周期描述',
     f_min_sale_sum_desc varchar(255) comment '产品最低起购金额描述',
     f_city varchar(255) comment '城市',
     f_memo varchar(255) comment '备注',
     primary key(f_id)
)engine=InnoDB default charset=UTF8;

DELIMITER $$
drop function if exists getDistance $$
create function getDistance
          (lat1 double,
           lgt1 double,
           lat2 double, 
           lgt2 double) 
		returns double
begin
    if (lat1 is null or lgt1 is null) 
		then return 99999;
	else
		return ACOS(SIN((lat2 * 3.1415) / 180 ) *SIN((lat1 * 3.1415) / 180 )+COS((lat2 * 3.1415) / 180 ) * COS((lat1 * 3.1415) / 180 ) *COS((lgt2 * 3.1415) / 180 - (lgt1 * 3.1415) / 180 ) ) * 6380;
	end if;
end$$
DELIMITER ;

drop table  if exists  t_dictionary;
create table if not exists t_dictionary(
    f_id bigint auto_increment,
    f_dict_code bigint comment '字典code',
    f_dict_name varchar(255) comment '字典名称',
    f_dict_value varchar(500) comment '字典值',
    primary key(f_id)
)engine=InnoDB default charset=UTF8;

insert into t_dictionary(f_dict_code,f_dict_name,f_dict_value)
values(1,'#','产品审核状态');
insert into t_dictionary(f_dict_code,f_dict_name,f_dict_value)
values(1,'00','待审核');
insert into t_dictionary(f_dict_code,f_dict_name,f_dict_value)
values(1,'01','已审核');
insert into t_dictionary(f_dict_code,f_dict_name,f_dict_value)
values(1,'02','审核退回');
commit;

insert into t_dictionary(f_dict_code,f_dict_name,f_dict_value)
values(2,'#','风险等级');
insert into t_dictionary(f_dict_code,f_dict_name,f_dict_value)
values(2,'00','保本');
insert into t_dictionary(f_dict_code,f_dict_name,f_dict_value)
values(2,'01','非保本');
insert into t_dictionary(f_dict_code,f_dict_name,f_dict_value)
values(2,'02','非保本');
insert into t_dictionary(f_dict_code,f_dict_name,f_dict_value)
values(2,'03','保本预期');
commit;

insert into t_dictionary(f_dict_code,f_dict_name,f_dict_value)
values(3,'#','产品类型');
insert into t_dictionary(f_dict_code,f_dict_name,f_dict_value)
values(3,'00','银行理财');
insert into t_dictionary(f_dict_code,f_dict_name,f_dict_value)
values(3,'01','货币基金');

commit;





