package com.ww.springboot.boot.model;

import java.util.Date;

public class te {
	   
	
    private  long id;
   
	 //订单编号(平台订单号)
    private  String platform_order_code;
   
	 //下单时间
    private  Date order_create_time;
   
	 //订购人注册号
    private  String buyer_reg_no;
   
	 //订购人证件类型
    private  String buyer_id_type;
   
	 //订购人证件号码
    private  String buyer_id_number;
   
	 //订购人姓名
    private  String buyer_name;
   
	 //订购人电话
    private  String buyer_telephone;
   
	 //发货日期
    private  Date ship_date;
   
	 //录入日期
    private  Date input_date;
   
	 //发货人名称
    private  String shipper_name;
   
	 //发货人地址
    private  String shipper_address;
   
	 //发货人电话
    private  String shipper_phone;
   
	 //收货人证件号码
    private  String consignee_no;
   
	 //收货人姓名
    private  String consignee;
   
	 //收货人电话
    private  String consignee_telephone;
   
	 //收货地址
    private  String consignee_address;
   
	 //国家
    private  String country;
   
	 //省
    private  String province;
   
	 //市
    private  String city;
   
	 //区
    private  String district;
   
	 //邮编
    private  String post_code;
   
	 //国内送货时间
    private  Date delivery_time_preference;
   
	 //商品价格（商品总价）
    private  double product_amount;
   
	 //运杂费
    private  double freight;
   
	 //非现金抵扣金额
    private  double discount;
   
	 //代扣税款
    private  double tax_total;
   
	 //税费币种
    private  String tax_currency;
   
	 //实际支付金额（订单金额）
    private  double actural_paid_amount;
   
	 //保价费（不在订单金额）
    private  double insured_fee;
   
	 //运费币种
    private  String freight_currency;
   
	 //电商平台编码(平台)
    private  String platform_code;
   
	 //电商平台名称
    private  String platform_name;
   
	 //电商企业编码(商家)
    private  String merchant_code;
   
	 //电商企业名称
    private  String merchant_name;
   
	 //店铺id
    private  String shop_code;
   
	 //店铺名称
    private  String shop_name;
   
	 //国际物流单号
    private  String inter_logistics_no;
   
	 //物流企业ID
    private  String inter_logistics_company_code;
   
	 //物流企业名称
    private  String inter_logistics_company_name;
   
	 //国内物流运单编号
    private  String logistics_no;
   
	 //物流备注
    private  String logistics_note;
   
	 //支付企业编码
    private  String pay_code;
   
	 //支付企业名称
    private  String pay_name;
   
	 //支付交易编号
    private  String pay_transaction_id;
   
	 //支付时间
    private  Date pay_time;
   
	 //支付备注
    private  String pay_note;
   
	 //海关关区代码
    private  String customs_code;
   
	 //检疫口岸代码
    private  String ciqb_code;
   
	 //进出口标记(I-进口,E-出口)
    private  String ie_flag;
   
	 //业务模式10：BBC；20：BC；30：保留； 40：个人物品
    private  long business_mode;
   
	 //运营模式(1：非自营，2：自营，3：卓志仓)
    private  String order_type;
   
	 //运输方式（BC才有）
    private  String transport_mode;
   
	 //运输工具编号（BC才有）
    private  String transport_no;
   
	 //航班航次号（BC才有）
    private  String voyage_no;
   
	 //总运单号（BC才有）
    private  String bill_no;
   
	 //起运国
    private  String shipper_country_code;
   
	 //包装种类代码
    private  String wrap_type;
   
	 //件数
    private  long package_quantity;
   
	 //毛重（克）
    private  double gross_weight;
   
	 //净重（克）
    private  double net_weight;
   
	 //是否第e仓
    private  int from_eplat = 0;
   
	 //打印抬头
    private  String print_header;
   
	 //备注
    private  String note;
   
	 //0 初始化 1 转单成功 2 转单失败 3 拒单 4取消
    private  int status = 0;
   
	
    private  String remark;
   
	 //异常码（只有一个）
    private  String exception_code;
   
	
    private  long created_by;
   
	
    private  Date create_time;
   
	
    private  Date update_time;
   
	
    private  long updated_by;
   
	
    private  long tenant_id;
   
	 //拒单时间
    private  Date refuse_time;
   
	 //拒单人
    private  long refuser;
   
	 //拒单原因
    private  String refuse_remark;
   
	 //异常备注
    private  String exception_remark;
   
	 //1 销售单 2 换货到哪
    private  String platform_order_type = "1";
   
	 //订单来源 201 淘宝
    private  long order_source;
   
	 //货主id
    private  String owner_user_id;
   
	 //货主名称
    private  String owner_user_name;
   
	 //外部仓库编码
    private  String outer_store_code;
   
	 //外部系统单号
    private  String outer_order_code;
   
	 //海外仓编码
    private  String overseas_warehouse_code;
   
	
    private  String message_id;
   
	
    private  String message_type;
   
	
    private  String sender_id;
   
	
    private  String receiver_id;
   
	
    private  String send_time;
   
	 //异常登记ID
    private  long exception_process_log_id;
   
	 //异常上报时间
    private  Date exception_time;
   
	 //重报标志 0否 1是
    private  int rebuild_flag = 0;
   
	 //换单标识0否，1是
    private  int change_flag = 0;
   
	 //是否溯源 0否，1是
    private  int is_trace_source;
   
	 //溯源码
    private  String trace_source_code;
   
	 //是否VMI模式
    private  int vmi_flag;
   
	 //是否一单多业主
    private  int owner_flag = 0;
   
	 //失败次数
    private  long error_count = 0;
   
	
    private  Date next_invoke_time;
   
	 //是否校验库存策略0：否，1：是
    private  int is_store_strategy;
   
	 //lp编码
    private  String lp_order_code;
   
	
    private  String lp_code;
   
	 //面单URL
    private  String waybill_no_url;
   
	 //是否优先发货 0否，1是
    private  int is_first_delivery = 0;
   
	 //是否收到申报信息（速运用） 0否，1是
    private  int is_receive_declare = 0;
   
	 //保费币制
    private  String insur_curr;
   
	 //贸易模式
    private  String trade_mode;
   
	 //通用字段
    private  String common_field;
   
    
    public  long  getId(){
    		return  this.id;
    };
    public  void  setId(long id){
    	this.id=id;
    }  
   
    public  String  getPlatform_order_code(){
    		return  this.platform_order_code;
    };
    public  void  setPlatform_order_code(String platform_order_code){
    	this.platform_order_code=platform_order_code;
    }  
   
    public  Date  getOrder_create_time(){
    		return  this.order_create_time;
    };
    public  void  setOrder_create_time(Date order_create_time){
    	this.order_create_time=order_create_time;
    }  
   
    public  String  getBuyer_reg_no(){
    		return  this.buyer_reg_no;
    };
    public  void  setBuyer_reg_no(String buyer_reg_no){
    	this.buyer_reg_no=buyer_reg_no;
    }  
   
    public  String  getBuyer_id_type(){
    		return  this.buyer_id_type;
    };
    public  void  setBuyer_id_type(String buyer_id_type){
    	this.buyer_id_type=buyer_id_type;
    }  
   
    public  String  getBuyer_id_number(){
    		return  this.buyer_id_number;
    };
    public  void  setBuyer_id_number(String buyer_id_number){
    	this.buyer_id_number=buyer_id_number;
    }  
   
    public  String  getBuyer_name(){
    		return  this.buyer_name;
    };
    public  void  setBuyer_name(String buyer_name){
    	this.buyer_name=buyer_name;
    }  
   
    public  String  getBuyer_telephone(){
    		return  this.buyer_telephone;
    };
    public  void  setBuyer_telephone(String buyer_telephone){
    	this.buyer_telephone=buyer_telephone;
    }  
   
    public  Date  getShip_date(){
    		return  this.ship_date;
    };
    public  void  setShip_date(Date ship_date){
    	this.ship_date=ship_date;
    }  
   
    public  Date  getInput_date(){
    		return  this.input_date;
    };
    public  void  setInput_date(Date input_date){
    	this.input_date=input_date;
    }  
   
    public  String  getShipper_name(){
    		return  this.shipper_name;
    };
    public  void  setShipper_name(String shipper_name){
    	this.shipper_name=shipper_name;
    }  
   
    public  String  getShipper_address(){
    		return  this.shipper_address;
    };
    public  void  setShipper_address(String shipper_address){
    	this.shipper_address=shipper_address;
    }  
   
    public  String  getShipper_phone(){
    		return  this.shipper_phone;
    };
    public  void  setShipper_phone(String shipper_phone){
    	this.shipper_phone=shipper_phone;
    }  
   
    public  String  getConsignee_no(){
    		return  this.consignee_no;
    };
    public  void  setConsignee_no(String consignee_no){
    	this.consignee_no=consignee_no;
    }  
   
    public  String  getConsignee(){
    		return  this.consignee;
    };
    public  void  setConsignee(String consignee){
    	this.consignee=consignee;
    }  
   
    public  String  getConsignee_telephone(){
    		return  this.consignee_telephone;
    };
    public  void  setConsignee_telephone(String consignee_telephone){
    	this.consignee_telephone=consignee_telephone;
    }  
   
    public  String  getConsignee_address(){
    		return  this.consignee_address;
    };
    public  void  setConsignee_address(String consignee_address){
    	this.consignee_address=consignee_address;
    }  
   
    public  String  getCountry(){
    		return  this.country;
    };
    public  void  setCountry(String country){
    	this.country=country;
    }  
   
    public  String  getProvince(){
    		return  this.province;
    };
    public  void  setProvince(String province){
    	this.province=province;
    }  
   
    public  String  getCity(){
    		return  this.city;
    };
    public  void  setCity(String city){
    	this.city=city;
    }  
   
    public  String  getDistrict(){
    		return  this.district;
    };
    public  void  setDistrict(String district){
    	this.district=district;
    }  
   
    public  String  getPost_code(){
    		return  this.post_code;
    };
    public  void  setPost_code(String post_code){
    	this.post_code=post_code;
    }  
   
    public  Date  getDelivery_time_preference(){
    		return  this.delivery_time_preference;
    };
    public  void  setDelivery_time_preference(Date delivery_time_preference){
    	this.delivery_time_preference=delivery_time_preference;
    }  
   
    public  double  getProduct_amount(){
    		return  this.product_amount;
    };
    public  void  setProduct_amount(double product_amount){
    	this.product_amount=product_amount;
    }  
   
    public  double  getFreight(){
    		return  this.freight;
    };
    public  void  setFreight(double freight){
    	this.freight=freight;
    }  
   
    public  double  getDiscount(){
    		return  this.discount;
    };
    public  void  setDiscount(double discount){
    	this.discount=discount;
    }  
   
    public  double  getTax_total(){
    		return  this.tax_total;
    };
    public  void  setTax_total(double tax_total){
    	this.tax_total=tax_total;
    }  
   
    public  String  getTax_currency(){
    		return  this.tax_currency;
    };
    public  void  setTax_currency(String tax_currency){
    	this.tax_currency=tax_currency;
    }  
   
    public  double  getActural_paid_amount(){
    		return  this.actural_paid_amount;
    };
    public  void  setActural_paid_amount(double actural_paid_amount){
    	this.actural_paid_amount=actural_paid_amount;
    }  
   
    public  double  getInsured_fee(){
    		return  this.insured_fee;
    };
    public  void  setInsured_fee(double insured_fee){
    	this.insured_fee=insured_fee;
    }  
   
    public  String  getFreight_currency(){
    		return  this.freight_currency;
    };
    public  void  setFreight_currency(String freight_currency){
    	this.freight_currency=freight_currency;
    }  
   
    public  String  getPlatform_code(){
    		return  this.platform_code;
    };
    public  void  setPlatform_code(String platform_code){
    	this.platform_code=platform_code;
    }  
   
    public  String  getPlatform_name(){
    		return  this.platform_name;
    };
    public  void  setPlatform_name(String platform_name){
    	this.platform_name=platform_name;
    }  
   
    public  String  getMerchant_code(){
    		return  this.merchant_code;
    };
    public  void  setMerchant_code(String merchant_code){
    	this.merchant_code=merchant_code;
    }  
   
    public  String  getMerchant_name(){
    		return  this.merchant_name;
    };
    public  void  setMerchant_name(String merchant_name){
    	this.merchant_name=merchant_name;
    }  
   
    public  String  getShop_code(){
    		return  this.shop_code;
    };
    public  void  setShop_code(String shop_code){
    	this.shop_code=shop_code;
    }  
   
    public  String  getShop_name(){
    		return  this.shop_name;
    };
    public  void  setShop_name(String shop_name){
    	this.shop_name=shop_name;
    }  
   
    public  String  getInter_logistics_no(){
    		return  this.inter_logistics_no;
    };
    public  void  setInter_logistics_no(String inter_logistics_no){
    	this.inter_logistics_no=inter_logistics_no;
    }  
   
    public  String  getInter_logistics_company_code(){
    		return  this.inter_logistics_company_code;
    };
    public  void  setInter_logistics_company_code(String inter_logistics_company_code){
    	this.inter_logistics_company_code=inter_logistics_company_code;
    }  
   
    public  String  getInter_logistics_company_name(){
    		return  this.inter_logistics_company_name;
    };
    public  void  setInter_logistics_company_name(String inter_logistics_company_name){
    	this.inter_logistics_company_name=inter_logistics_company_name;
    }  
   
    public  String  getLogistics_no(){
    		return  this.logistics_no;
    };
    public  void  setLogistics_no(String logistics_no){
    	this.logistics_no=logistics_no;
    }  
   
    public  String  getLogistics_note(){
    		return  this.logistics_note;
    };
    public  void  setLogistics_note(String logistics_note){
    	this.logistics_note=logistics_note;
    }  
   
    public  String  getPay_code(){
    		return  this.pay_code;
    };
    public  void  setPay_code(String pay_code){
    	this.pay_code=pay_code;
    }  
   
    public  String  getPay_name(){
    		return  this.pay_name;
    };
    public  void  setPay_name(String pay_name){
    	this.pay_name=pay_name;
    }  
   
    public  String  getPay_transaction_id(){
    		return  this.pay_transaction_id;
    };
    public  void  setPay_transaction_id(String pay_transaction_id){
    	this.pay_transaction_id=pay_transaction_id;
    }  
   
    public  Date  getPay_time(){
    		return  this.pay_time;
    };
    public  void  setPay_time(Date pay_time){
    	this.pay_time=pay_time;
    }  
   
    public  String  getPay_note(){
    		return  this.pay_note;
    };
    public  void  setPay_note(String pay_note){
    	this.pay_note=pay_note;
    }  
   
    public  String  getCustoms_code(){
    		return  this.customs_code;
    };
    public  void  setCustoms_code(String customs_code){
    	this.customs_code=customs_code;
    }  
   
    public  String  getCiqb_code(){
    		return  this.ciqb_code;
    };
    public  void  setCiqb_code(String ciqb_code){
    	this.ciqb_code=ciqb_code;
    }  
   
    public  String  getIe_flag(){
    		return  this.ie_flag;
    };
    public  void  setIe_flag(String ie_flag){
    	this.ie_flag=ie_flag;
    }  
   
    public  long  getBusiness_mode(){
    		return  this.business_mode;
    };
    public  void  setBusiness_mode(long business_mode){
    	this.business_mode=business_mode;
    }  
   
    public  String  getOrder_type(){
    		return  this.order_type;
    };
    public  void  setOrder_type(String order_type){
    	this.order_type=order_type;
    }  
   
    public  String  getTransport_mode(){
    		return  this.transport_mode;
    };
    public  void  setTransport_mode(String transport_mode){
    	this.transport_mode=transport_mode;
    }  
   
    public  String  getTransport_no(){
    		return  this.transport_no;
    };
    public  void  setTransport_no(String transport_no){
    	this.transport_no=transport_no;
    }  
   
    public  String  getVoyage_no(){
    		return  this.voyage_no;
    };
    public  void  setVoyage_no(String voyage_no){
    	this.voyage_no=voyage_no;
    }  
   
    public  String  getBill_no(){
    		return  this.bill_no;
    };
    public  void  setBill_no(String bill_no){
    	this.bill_no=bill_no;
    }  
   
    public  String  getShipper_country_code(){
    		return  this.shipper_country_code;
    };
    public  void  setShipper_country_code(String shipper_country_code){
    	this.shipper_country_code=shipper_country_code;
    }  
   
    public  String  getWrap_type(){
    		return  this.wrap_type;
    };
    public  void  setWrap_type(String wrap_type){
    	this.wrap_type=wrap_type;
    }  
   
    public  long  getPackage_quantity(){
    		return  this.package_quantity;
    };
    public  void  setPackage_quantity(long package_quantity){
    	this.package_quantity=package_quantity;
    }  
   
    public  double  getGross_weight(){
    		return  this.gross_weight;
    };
    public  void  setGross_weight(double gross_weight){
    	this.gross_weight=gross_weight;
    }  
   
    public  double  getNet_weight(){
    		return  this.net_weight;
    };
    public  void  setNet_weight(double net_weight){
    	this.net_weight=net_weight;
    }  
   
    public  int  getFrom_eplat(){
    		return  this.from_eplat;
    };
    public  void  setFrom_eplat(int from_eplat){
    	this.from_eplat=from_eplat;
    }  
   
    public  String  getPrint_header(){
    		return  this.print_header;
    };
    public  void  setPrint_header(String print_header){
    	this.print_header=print_header;
    }  
   
    public  String  getNote(){
    		return  this.note;
    };
    public  void  setNote(String note){
    	this.note=note;
    }  
   
    public  int  getStatus(){
    		return  this.status;
    };
    public  void  setStatus(int status){
    	this.status=status;
    }  
   
    public  String  getRemark(){
    		return  this.remark;
    };
    public  void  setRemark(String remark){
    	this.remark=remark;
    }  
   
    public  String  getException_code(){
    		return  this.exception_code;
    };
    public  void  setException_code(String exception_code){
    	this.exception_code=exception_code;
    }  
   
    public  long  getCreated_by(){
    		return  this.created_by;
    };
    public  void  setCreated_by(long created_by){
    	this.created_by=created_by;
    }  
   
    public  Date  getCreate_time(){
    		return  this.create_time;
    };
    public  void  setCreate_time(Date create_time){
    	this.create_time=create_time;
    }  
   
    public  Date  getUpdate_time(){
    		return  this.update_time;
    };
    public  void  setUpdate_time(Date update_time){
    	this.update_time=update_time;
    }  
   
    public  long  getUpdated_by(){
    		return  this.updated_by;
    };
    public  void  setUpdated_by(long updated_by){
    	this.updated_by=updated_by;
    }  
   
    public  long  getTenant_id(){
    		return  this.tenant_id;
    };
    public  void  setTenant_id(long tenant_id){
    	this.tenant_id=tenant_id;
    }  
   
    public  Date  getRefuse_time(){
    		return  this.refuse_time;
    };
    public  void  setRefuse_time(Date refuse_time){
    	this.refuse_time=refuse_time;
    }  
   
    public  long  getRefuser(){
    		return  this.refuser;
    };
    public  void  setRefuser(long refuser){
    	this.refuser=refuser;
    }  
   
    public  String  getRefuse_remark(){
    		return  this.refuse_remark;
    };
    public  void  setRefuse_remark(String refuse_remark){
    	this.refuse_remark=refuse_remark;
    }  
   
    public  String  getException_remark(){
    		return  this.exception_remark;
    };
    public  void  setException_remark(String exception_remark){
    	this.exception_remark=exception_remark;
    }  
   
    public  String  getPlatform_order_type(){
    		return  this.platform_order_type;
    };
    public  void  setPlatform_order_type(String platform_order_type){
    	this.platform_order_type=platform_order_type;
    }  
   
    public  long  getOrder_source(){
    		return  this.order_source;
    };
    public  void  setOrder_source(long order_source){
    	this.order_source=order_source;
    }  
   
    public  String  getOwner_user_id(){
    		return  this.owner_user_id;
    };
    public  void  setOwner_user_id(String owner_user_id){
    	this.owner_user_id=owner_user_id;
    }  
   
    public  String  getOwner_user_name(){
    		return  this.owner_user_name;
    };
    public  void  setOwner_user_name(String owner_user_name){
    	this.owner_user_name=owner_user_name;
    }  
   
    public  String  getOuter_store_code(){
    		return  this.outer_store_code;
    };
    public  void  setOuter_store_code(String outer_store_code){
    	this.outer_store_code=outer_store_code;
    }  
   
    public  String  getOuter_order_code(){
    		return  this.outer_order_code;
    };
    public  void  setOuter_order_code(String outer_order_code){
    	this.outer_order_code=outer_order_code;
    }  
   
    public  String  getOverseas_warehouse_code(){
    		return  this.overseas_warehouse_code;
    };
    public  void  setOverseas_warehouse_code(String overseas_warehouse_code){
    	this.overseas_warehouse_code=overseas_warehouse_code;
    }  
   
    public  String  getMessage_id(){
    		return  this.message_id;
    };
    public  void  setMessage_id(String message_id){
    	this.message_id=message_id;
    }  
   
    public  String  getMessage_type(){
    		return  this.message_type;
    };
    public  void  setMessage_type(String message_type){
    	this.message_type=message_type;
    }  
   
    public  String  getSender_id(){
    		return  this.sender_id;
    };
    public  void  setSender_id(String sender_id){
    	this.sender_id=sender_id;
    }  
   
    public  String  getReceiver_id(){
    		return  this.receiver_id;
    };
    public  void  setReceiver_id(String receiver_id){
    	this.receiver_id=receiver_id;
    }  
   
    public  String  getSend_time(){
    		return  this.send_time;
    };
    public  void  setSend_time(String send_time){
    	this.send_time=send_time;
    }  
   
    public  long  getException_process_log_id(){
    		return  this.exception_process_log_id;
    };
    public  void  setException_process_log_id(long exception_process_log_id){
    	this.exception_process_log_id=exception_process_log_id;
    }  
   
    public  Date  getException_time(){
    		return  this.exception_time;
    };
    public  void  setException_time(Date exception_time){
    	this.exception_time=exception_time;
    }  
   
    public  int  getRebuild_flag(){
    		return  this.rebuild_flag;
    };
    public  void  setRebuild_flag(int rebuild_flag){
    	this.rebuild_flag=rebuild_flag;
    }  
   
    public  int  getChange_flag(){
    		return  this.change_flag;
    };
    public  void  setChange_flag(int change_flag){
    	this.change_flag=change_flag;
    }  
   
    public  int  getIs_trace_source(){
    		return  this.is_trace_source;
    };
    public  void  setIs_trace_source(int is_trace_source){
    	this.is_trace_source=is_trace_source;
    }  
   
    public  String  getTrace_source_code(){
    		return  this.trace_source_code;
    };
    public  void  setTrace_source_code(String trace_source_code){
    	this.trace_source_code=trace_source_code;
    }  
   
    public  int  getVmi_flag(){
    		return  this.vmi_flag;
    };
    public  void  setVmi_flag(int vmi_flag){
    	this.vmi_flag=vmi_flag;
    }  
   
    public  int  getOwner_flag(){
    		return  this.owner_flag;
    };
    public  void  setOwner_flag(int owner_flag){
    	this.owner_flag=owner_flag;
    }  
   
    public  long  getError_count(){
    		return  this.error_count;
    };
    public  void  setError_count(long error_count){
    	this.error_count=error_count;
    }  
   
    public  Date  getNext_invoke_time(){
    		return  this.next_invoke_time;
    };
    public  void  setNext_invoke_time(Date next_invoke_time){
    	this.next_invoke_time=next_invoke_time;
    }  
   
    public  int  getIs_store_strategy(){
    		return  this.is_store_strategy;
    };
    public  void  setIs_store_strategy(int is_store_strategy){
    	this.is_store_strategy=is_store_strategy;
    }  
   
    public  String  getLp_order_code(){
    		return  this.lp_order_code;
    };
    public  void  setLp_order_code(String lp_order_code){
    	this.lp_order_code=lp_order_code;
    }  
   
    public  String  getLp_code(){
    		return  this.lp_code;
    };
    public  void  setLp_code(String lp_code){
    	this.lp_code=lp_code;
    }  
   
    public  String  getWaybill_no_url(){
    		return  this.waybill_no_url;
    };
    public  void  setWaybill_no_url(String waybill_no_url){
    	this.waybill_no_url=waybill_no_url;
    }  
   
    public  int  getIs_first_delivery(){
    		return  this.is_first_delivery;
    };
    public  void  setIs_first_delivery(int is_first_delivery){
    	this.is_first_delivery=is_first_delivery;
    }  
   
    public  int  getIs_receive_declare(){
    		return  this.is_receive_declare;
    };
    public  void  setIs_receive_declare(int is_receive_declare){
    	this.is_receive_declare=is_receive_declare;
    }  
   
    public  String  getInsur_curr(){
    		return  this.insur_curr;
    };
    public  void  setInsur_curr(String insur_curr){
    	this.insur_curr=insur_curr;
    }  
   
    public  String  getTrade_mode(){
    		return  this.trade_mode;
    };
    public  void  setTrade_mode(String trade_mode){
    	this.trade_mode=trade_mode;
    }  
   
    public  String  getCommon_field(){
    		return  this.common_field;
    };
    public  void  setCommon_field(String common_field){
    	this.common_field=common_field;
    }
	@Override
	public String toString() {
		return "te [id=" + id + ", platform_order_code=" + platform_order_code + ", order_create_time="
				+ order_create_time + ", buyer_reg_no=" + buyer_reg_no + ", buyer_id_type=" + buyer_id_type
				+ ", buyer_id_number=" + buyer_id_number + ", buyer_name=" + buyer_name + ", buyer_telephone="
				+ buyer_telephone + ", ship_date=" + ship_date + ", input_date=" + input_date + ", shipper_name="
				+ shipper_name + ", shipper_address=" + shipper_address + ", shipper_phone=" + shipper_phone
				+ ", consignee_no=" + consignee_no + ", consignee=" + consignee + ", consignee_telephone="
				+ consignee_telephone + ", consignee_address=" + consignee_address + ", country=" + country
				+ ", province=" + province + ", city=" + city + ", district=" + district + ", post_code=" + post_code
				+ ", delivery_time_preference=" + delivery_time_preference + ", product_amount=" + product_amount
				+ ", freight=" + freight + ", discount=" + discount + ", tax_total=" + tax_total + ", tax_currency="
				+ tax_currency + ", actural_paid_amount=" + actural_paid_amount + ", insured_fee=" + insured_fee
				+ ", freight_currency=" + freight_currency + ", platform_code=" + platform_code + ", platform_name="
				+ platform_name + ", merchant_code=" + merchant_code + ", merchant_name=" + merchant_name
				+ ", shop_code=" + shop_code + ", shop_name=" + shop_name + ", inter_logistics_no=" + inter_logistics_no
				+ ", inter_logistics_company_code=" + inter_logistics_company_code + ", inter_logistics_company_name="
				+ inter_logistics_company_name + ", logistics_no=" + logistics_no + ", logistics_note=" + logistics_note
				+ ", pay_code=" + pay_code + ", pay_name=" + pay_name + ", pay_transaction_id=" + pay_transaction_id
				+ ", pay_time=" + pay_time + ", pay_note=" + pay_note + ", customs_code=" + customs_code
				+ ", ciqb_code=" + ciqb_code + ", ie_flag=" + ie_flag + ", business_mode=" + business_mode
				+ ", order_type=" + order_type + ", transport_mode=" + transport_mode + ", transport_no=" + transport_no
				+ ", voyage_no=" + voyage_no + ", bill_no=" + bill_no + ", shipper_country_code=" + shipper_country_code
				+ ", wrap_type=" + wrap_type + ", package_quantity=" + package_quantity + ", gross_weight="
				+ gross_weight + ", net_weight=" + net_weight + ", from_eplat=" + from_eplat + ", print_header="
				+ print_header + ", note=" + note + ", status=" + status + ", remark=" + remark + ", exception_code="
				+ exception_code + ", created_by=" + created_by + ", create_time=" + create_time + ", update_time="
				+ update_time + ", updated_by=" + updated_by + ", tenant_id=" + tenant_id + ", refuse_time="
				+ refuse_time + ", refuser=" + refuser + ", refuse_remark=" + refuse_remark + ", exception_remark="
				+ exception_remark + ", platform_order_type=" + platform_order_type + ", order_source=" + order_source
				+ ", owner_user_id=" + owner_user_id + ", owner_user_name=" + owner_user_name + ", outer_store_code="
				+ outer_store_code + ", outer_order_code=" + outer_order_code + ", overseas_warehouse_code="
				+ overseas_warehouse_code + ", message_id=" + message_id + ", message_type=" + message_type
				+ ", sender_id=" + sender_id + ", receiver_id=" + receiver_id + ", send_time=" + send_time
				+ ", exception_process_log_id=" + exception_process_log_id + ", exception_time=" + exception_time
				+ ", rebuild_flag=" + rebuild_flag + ", change_flag=" + change_flag + ", is_trace_source="
				+ is_trace_source + ", trace_source_code=" + trace_source_code + ", vmi_flag=" + vmi_flag
				+ ", owner_flag=" + owner_flag + ", error_count=" + error_count + ", next_invoke_time="
				+ next_invoke_time + ", is_store_strategy=" + is_store_strategy + ", lp_order_code=" + lp_order_code
				+ ", lp_code=" + lp_code + ", waybill_no_url=" + waybill_no_url + ", is_first_delivery="
				+ is_first_delivery + ", is_receive_declare=" + is_receive_declare + ", insur_curr=" + insur_curr
				+ ", trade_mode=" + trade_mode + ", common_field=" + common_field + "]";
	}  
    
}