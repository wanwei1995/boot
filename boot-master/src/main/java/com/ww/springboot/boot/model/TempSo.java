package com.ww.springboot.boot.model;

import java.util.Date;

public class TempSo {
	private Long id;

	// 订单编号(平台订单号)
	private String platformOrderCode;

	// 下单时间
	private Date orderCreateTime;

	// 订购人注册号
	private String buyerRegNo;

	// 订购人证件类型
	private String buyerIdType;

	// 订购人证件号码
	private String buyerIdNumber;

	// 订购人姓名
	private String buyerName;

	// 订购人电话
	private String buyerTelephone;

	// 发货日期
	private Date shipDate;

	// 录入日期
	private Date inputDate;

	// 发货人名称
	private String shipperName;

	// 发货人地址
	private String shipperAddress;

	// 发货人电话
	private String shipperPhone;

	// 收货人证件号码
	private String consigneeNo;

	// 收货人姓名
	private String consignee;

	// 收货人电话
	private String consigneeTelephone;

	// 收货地址
	private String consigneeAddress;

	// 国家
	private String country;

	// 省
	private String province;

	// 市
	private String city;

	// 区
	private String district;

	// 邮编
	private String postCode;

	// 国内送货时间
	private Date deliveryTimePreference;

	// 商品价格（商品总价）
	private double productAmount;

	// 运杂费
	private double freight;

	// 非现金抵扣金额
	private double discount;

	// 代扣税款
	private double taxTotal;

	// 税费币种
	private String taxCurrency;

	// 实际支付金额（订单金额）
	private double acturalPaidAmount;

	// 保价费（不在订单金额）
	private double insuredFee;

	// 运费币种
	private String freightCurrency;

	// 电商平台编码(平台)
	private String platformCode;

	// 电商平台名称
	private String platformName;

	// 电商企业编码(商家)
	private String merchantCode;

	// 电商企业名称
	private String merchantName;

	// 店铺id
	private String shopCode;

	// 店铺名称
	private String shopName;

	// 国际物流单号
	private String interLogisticsNo;

	// 物流企业ID
	private String interLogisticsCompanyCode;

	// 物流企业名称
	private String interLogisticsCompanyName;

	// 国内物流运单编号
	private String logisticsNo;

	// 物流备注
	private String logisticsNote;

	// 支付企业编码
	private String payCode;

	// 支付企业名称
	private String payName;

	// 支付交易编号
	private String payTransactionId;

	// 支付时间
	private Date payTime;

	// 支付备注
	private String payNote;

	// 海关关区代码
	private String customsCode;

	// 检疫口岸代码
	private String ciqbCode;

	// 进出口标记(I-进口,E-出口)
	private String ieFlag;

	// 业务模式10：BBC；20：BC；30：保留； 40：个人物品
	private long businessMode;

	// 运营模式(1：非自营，2：自营，3：卓志仓)
	private String orderType;

	// 运输方式（BC才有）
	private String transportMode;

	// 运输工具编号（BC才有）
	private String transportNo;

	// 航班航次号（BC才有）
	private String voyageNo;

	// 总运单号（BC才有）
	private String billNo;

	// 起运国
	private String shipperCountryCode;

	// 包装种类代码
	private String wrapType;

	// 件数
	private long packageQuantity;

	// 毛重（克）
	private double grossWeight;

	// 净重（克）
	private double netWeight;

	// 是否第e仓
	private int fromEplat = 0;

	// 打印抬头
	private String printHeader;

	// 备注
	private String note;

	// 0 初始化 1 转单成功 2 转单失败 3 拒单 4取消
	private int status = 0;

	private String remark;

	// 异常码（只有一个）
	private String exceptionCode;

	private long createdBy;

	private Date createTime;

	private Date updateTime;

	private long updatedBy;

	private long tenantId;

	// 拒单时间
	private Date refuseTime;

	// 拒单人
	private long refuser;

	// 拒单原因
	private String refuseRemark;

	// 异常备注
	private String exceptionRemark;

	// 1 销售单 2 换货到哪
	private String platformOrderType = "1";

	// 订单来源 201 淘宝
	private long orderSource;

	// 货主id
	private String ownerUserId;

	// 货主名称
	private String ownerUserName;

	// 外部仓库编码
	private String outerStoreCode;

	// 外部系统单号
	private String outerOrderCode;

	// 海外仓编码
	private String overseasWarehouseCode;

	private String messageId;

	private String messageType;

	private String senderId;

	private String receiverId;

	private String sendTime;

	// 异常登记ID
	private long exceptionProcessLogId;

	// 异常上报时间
	private Date exceptionTime;

	// 重报标志 0否 1是
	private int rebuildFlag = 0;

	// 换单标识0否，1是
	private int changeFlag = 0;

	// 是否溯源 0否，1是
	private int isTraceSource;

	// 溯源码
	private String traceSourceCode;

	// 是否VMI模式
	private int vmiFlag;

	// 是否一单多业主
	private int ownerFlag = 0;

	// 失败次数
	private long errorCount = 0;

	private Date nextInvokeTime;

	// 是否校验库存策略0：否，1：是
	private int isStoreStrategy;

	// lp编码
	private String lpOrderCode;

	private String lpCode;

	// 面单URL
	private String waybillNoUrl;

	// 是否优先发货 0否，1是
	private int isFirstDelivery = 0;

	// 是否收到申报信息（速运用） 0否，1是
	private int isReceiveDeclare = 0;

	// 保费币制
	private String insurCurr;

	// 贸易模式
	private String tradeMode;

	// 通用字段
	private String commonField;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlatformOrderCode() {
		return platformOrderCode;
	}

	public void setPlatformOrderCode(String platformOrderCode) {
		this.platformOrderCode = platformOrderCode;
	}

	public Date getOrderCreateTime() {
		return orderCreateTime;
	}

	public void setOrderCreateTime(Date orderCreateTime) {
		this.orderCreateTime = orderCreateTime;
	}

	public String getBuyerRegNo() {
		return buyerRegNo;
	}

	public void setBuyerRegNo(String buyerRegNo) {
		this.buyerRegNo = buyerRegNo;
	}

	public String getBuyerIdType() {
		return buyerIdType;
	}

	public void setBuyerIdType(String buyerIdType) {
		this.buyerIdType = buyerIdType;
	}

	public String getBuyerIdNumber() {
		return buyerIdNumber;
	}

	public void setBuyerIdNumber(String buyerIdNumber) {
		this.buyerIdNumber = buyerIdNumber;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public String getBuyerTelephone() {
		return buyerTelephone;
	}

	public void setBuyerTelephone(String buyerTelephone) {
		this.buyerTelephone = buyerTelephone;
	}

	public Date getShipDate() {
		return shipDate;
	}

	public void setShipDate(Date shipDate) {
		this.shipDate = shipDate;
	}

	public Date getInputDate() {
		return inputDate;
	}

	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}

	public String getShipperName() {
		return shipperName;
	}

	public void setShipperName(String shipperName) {
		this.shipperName = shipperName;
	}

	public String getShipperAddress() {
		return shipperAddress;
	}

	public void setShipperAddress(String shipperAddress) {
		this.shipperAddress = shipperAddress;
	}

	public String getShipperPhone() {
		return shipperPhone;
	}

	public void setShipperPhone(String shipperPhone) {
		this.shipperPhone = shipperPhone;
	}

	public String getConsigneeNo() {
		return consigneeNo;
	}

	public void setConsigneeNo(String consigneeNo) {
		this.consigneeNo = consigneeNo;
	}

	public String getConsignee() {
		return consignee;
	}

	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}

	public String getConsigneeTelephone() {
		return consigneeTelephone;
	}

	public void setConsigneeTelephone(String consigneeTelephone) {
		this.consigneeTelephone = consigneeTelephone;
	}

	public String getConsigneeAddress() {
		return consigneeAddress;
	}

	public void setConsigneeAddress(String consigneeAddress) {
		this.consigneeAddress = consigneeAddress;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public Date getDeliveryTimePreference() {
		return deliveryTimePreference;
	}

	public void setDeliveryTimePreference(Date deliveryTimePreference) {
		this.deliveryTimePreference = deliveryTimePreference;
	}

	public double getProductAmount() {
		return productAmount;
	}

	public void setProductAmount(double productAmount) {
		this.productAmount = productAmount;
	}

	public double getFreight() {
		return freight;
	}

	public void setFreight(double freight) {
		this.freight = freight;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getTaxTotal() {
		return taxTotal;
	}

	public void setTaxTotal(double taxTotal) {
		this.taxTotal = taxTotal;
	}

	public String getTaxCurrency() {
		return taxCurrency;
	}

	public void setTaxCurrency(String taxCurrency) {
		this.taxCurrency = taxCurrency;
	}

	public double getActuralPaidAmount() {
		return acturalPaidAmount;
	}

	public void setActuralPaidAmount(double acturalPaidAmount) {
		this.acturalPaidAmount = acturalPaidAmount;
	}

	public double getInsuredFee() {
		return insuredFee;
	}

	public void setInsuredFee(double insuredFee) {
		this.insuredFee = insuredFee;
	}

	public String getFreightCurrency() {
		return freightCurrency;
	}

	public void setFreightCurrency(String freightCurrency) {
		this.freightCurrency = freightCurrency;
	}

	public String getPlatformCode() {
		return platformCode;
	}

	public void setPlatformCode(String platformCode) {
		this.platformCode = platformCode;
	}

	public String getPlatformName() {
		return platformName;
	}

	public void setPlatformName(String platformName) {
		this.platformName = platformName;
	}

	public String getMerchantCode() {
		return merchantCode;
	}

	public void setMerchantCode(String merchantCode) {
		this.merchantCode = merchantCode;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public String getShopCode() {
		return shopCode;
	}

	public void setShopCode(String shopCode) {
		this.shopCode = shopCode;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getInterLogisticsNo() {
		return interLogisticsNo;
	}

	public void setInterLogisticsNo(String interLogisticsNo) {
		this.interLogisticsNo = interLogisticsNo;
	}

	public String getInterLogisticsCompanyCode() {
		return interLogisticsCompanyCode;
	}

	public void setInterLogisticsCompanyCode(String interLogisticsCompanyCode) {
		this.interLogisticsCompanyCode = interLogisticsCompanyCode;
	}

	public String getInterLogisticsCompanyName() {
		return interLogisticsCompanyName;
	}

	public void setInterLogisticsCompanyName(String interLogisticsCompanyName) {
		this.interLogisticsCompanyName = interLogisticsCompanyName;
	}

	public String getLogisticsNo() {
		return logisticsNo;
	}

	public void setLogisticsNo(String logisticsNo) {
		this.logisticsNo = logisticsNo;
	}

	public String getLogisticsNote() {
		return logisticsNote;
	}

	public void setLogisticsNote(String logisticsNote) {
		this.logisticsNote = logisticsNote;
	}

	public String getPayCode() {
		return payCode;
	}

	public void setPayCode(String payCode) {
		this.payCode = payCode;
	}

	public String getPayName() {
		return payName;
	}

	public void setPayName(String payName) {
		this.payName = payName;
	}

	public String getPayTransactionId() {
		return payTransactionId;
	}

	public void setPayTransactionId(String payTransactionId) {
		this.payTransactionId = payTransactionId;
	}

	public Date getPayTime() {
		return payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	public String getPayNote() {
		return payNote;
	}

	public void setPayNote(String payNote) {
		this.payNote = payNote;
	}

	public String getCustomsCode() {
		return customsCode;
	}

	public void setCustomsCode(String customsCode) {
		this.customsCode = customsCode;
	}

	public String getCiqbCode() {
		return ciqbCode;
	}

	public void setCiqbCode(String ciqbCode) {
		this.ciqbCode = ciqbCode;
	}

	public String getIeFlag() {
		return ieFlag;
	}

	public void setIeFlag(String ieFlag) {
		this.ieFlag = ieFlag;
	}

	public long getBusinessMode() {
		return businessMode;
	}

	public void setBusinessMode(long businessMode) {
		this.businessMode = businessMode;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getTransportMode() {
		return transportMode;
	}

	public void setTransportMode(String transportMode) {
		this.transportMode = transportMode;
	}

	public String getTransportNo() {
		return transportNo;
	}

	public void setTransportNo(String transportNo) {
		this.transportNo = transportNo;
	}

	public String getVoyageNo() {
		return voyageNo;
	}

	public void setVoyageNo(String voyageNo) {
		this.voyageNo = voyageNo;
	}

	public String getBillNo() {
		return billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	public String getShipperCountryCode() {
		return shipperCountryCode;
	}

	public void setShipperCountryCode(String shipperCountryCode) {
		this.shipperCountryCode = shipperCountryCode;
	}

	public String getWrapType() {
		return wrapType;
	}

	public void setWrapType(String wrapType) {
		this.wrapType = wrapType;
	}

	public long getPackageQuantity() {
		return packageQuantity;
	}

	public void setPackageQuantity(long packageQuantity) {
		this.packageQuantity = packageQuantity;
	}

	public double getGrossWeight() {
		return grossWeight;
	}

	public void setGrossWeight(double grossWeight) {
		this.grossWeight = grossWeight;
	}

	public double getNetWeight() {
		return netWeight;
	}

	public void setNetWeight(double netWeight) {
		this.netWeight = netWeight;
	}

	public int getFromEplat() {
		return fromEplat;
	}

	public void setFromEplat(int fromEplat) {
		this.fromEplat = fromEplat;
	}

	public String getPrintHeader() {
		return printHeader;
	}

	public void setPrintHeader(String printHeader) {
		this.printHeader = printHeader;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getExceptionCode() {
		return exceptionCode;
	}

	public void setExceptionCode(String exceptionCode) {
		this.exceptionCode = exceptionCode;
	}

	public long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(long createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public long getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(long updatedBy) {
		this.updatedBy = updatedBy;
	}

	public long getTenantId() {
		return tenantId;
	}

	public void setTenantId(long tenantId) {
		this.tenantId = tenantId;
	}

	public Date getRefuseTime() {
		return refuseTime;
	}

	public void setRefuseTime(Date refuseTime) {
		this.refuseTime = refuseTime;
	}

	public long getRefuser() {
		return refuser;
	}

	public void setRefuser(long refuser) {
		this.refuser = refuser;
	}

	public String getRefuseRemark() {
		return refuseRemark;
	}

	public void setRefuseRemark(String refuseRemark) {
		this.refuseRemark = refuseRemark;
	}

	public String getExceptionRemark() {
		return exceptionRemark;
	}

	public void setExceptionRemark(String exceptionRemark) {
		this.exceptionRemark = exceptionRemark;
	}

	public String getPlatformOrderType() {
		return platformOrderType;
	}

	public void setPlatformOrderType(String platformOrderType) {
		this.platformOrderType = platformOrderType;
	}

	public long getOrderSource() {
		return orderSource;
	}

	public void setOrderSource(long orderSource) {
		this.orderSource = orderSource;
	}

	public String getOwnerUserId() {
		return ownerUserId;
	}

	public void setOwnerUserId(String ownerUserId) {
		this.ownerUserId = ownerUserId;
	}

	public String getOwnerUserName() {
		return ownerUserName;
	}

	public void setOwnerUserName(String ownerUserName) {
		this.ownerUserName = ownerUserName;
	}

	public String getOuterStoreCode() {
		return outerStoreCode;
	}

	public void setOuterStoreCode(String outerStoreCode) {
		this.outerStoreCode = outerStoreCode;
	}

	public String getOuterOrderCode() {
		return outerOrderCode;
	}

	public void setOuterOrderCode(String outerOrderCode) {
		this.outerOrderCode = outerOrderCode;
	}

	public String getOverseasWarehouseCode() {
		return overseasWarehouseCode;
	}

	public void setOverseasWarehouseCode(String overseasWarehouseCode) {
		this.overseasWarehouseCode = overseasWarehouseCode;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	public String getSenderId() {
		return senderId;
	}

	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}

	public String getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(String receiverId) {
		this.receiverId = receiverId;
	}

	public String getSendTime() {
		return sendTime;
	}

	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}

	public long getExceptionProcessLogId() {
		return exceptionProcessLogId;
	}

	public void setExceptionProcessLogId(long exceptionProcessLogId) {
		this.exceptionProcessLogId = exceptionProcessLogId;
	}

	public Date getExceptionTime() {
		return exceptionTime;
	}

	public void setExceptionTime(Date exceptionTime) {
		this.exceptionTime = exceptionTime;
	}

	public int getRebuildFlag() {
		return rebuildFlag;
	}

	public void setRebuildFlag(int rebuildFlag) {
		this.rebuildFlag = rebuildFlag;
	}

	public int getChangeFlag() {
		return changeFlag;
	}

	public void setChangeFlag(int changeFlag) {
		this.changeFlag = changeFlag;
	}

	public int getIsTraceSource() {
		return isTraceSource;
	}

	public void setIsTraceSource(int isTraceSource) {
		this.isTraceSource = isTraceSource;
	}

	public String getTraceSourceCode() {
		return traceSourceCode;
	}

	public void setTraceSourceCode(String traceSourceCode) {
		this.traceSourceCode = traceSourceCode;
	}

	public int getVmiFlag() {
		return vmiFlag;
	}

	public void setVmiFlag(int vmiFlag) {
		this.vmiFlag = vmiFlag;
	}

	public int getOwnerFlag() {
		return ownerFlag;
	}

	public void setOwnerFlag(int ownerFlag) {
		this.ownerFlag = ownerFlag;
	}

	public long getErrorCount() {
		return errorCount;
	}

	public void setErrorCount(long errorCount) {
		this.errorCount = errorCount;
	}

	public Date getNextInvokeTime() {
		return nextInvokeTime;
	}

	public void setNextInvokeTime(Date nextInvokeTime) {
		this.nextInvokeTime = nextInvokeTime;
	}

	public int getIsStoreStrategy() {
		return isStoreStrategy;
	}

	public void setIsStoreStrategy(int isStoreStrategy) {
		this.isStoreStrategy = isStoreStrategy;
	}

	public String getLpOrderCode() {
		return lpOrderCode;
	}

	public void setLpOrderCode(String lpOrderCode) {
		this.lpOrderCode = lpOrderCode;
	}

	public String getLpCode() {
		return lpCode;
	}

	public void setLpCode(String lpCode) {
		this.lpCode = lpCode;
	}

	public String getWaybillNoUrl() {
		return waybillNoUrl;
	}

	public void setWaybillNoUrl(String waybillNoUrl) {
		this.waybillNoUrl = waybillNoUrl;
	}

	public int getIsFirstDelivery() {
		return isFirstDelivery;
	}

	public void setIsFirstDelivery(int isFirstDelivery) {
		this.isFirstDelivery = isFirstDelivery;
	}

	public int getIsReceiveDeclare() {
		return isReceiveDeclare;
	}

	public void setIsReceiveDeclare(int isReceiveDeclare) {
		this.isReceiveDeclare = isReceiveDeclare;
	}

	public String getInsurCurr() {
		return insurCurr;
	}

	public void setInsurCurr(String insurCurr) {
		this.insurCurr = insurCurr;
	}

	public String getTradeMode() {
		return tradeMode;
	}

	public void setTradeMode(String tradeMode) {
		this.tradeMode = tradeMode;
	}

	public String getCommonField() {
		return commonField;
	}

	public void setCommonField(String commonField) {
		this.commonField = commonField;
	}

	@Override
	public String toString() {
		return "TempSo [id=" + id + ", platformOrderCode=" + platformOrderCode + ", orderCreateTime=" + orderCreateTime
				+ ", buyerRegNo=" + buyerRegNo + ", buyerIdType=" + buyerIdType + ", buyerIdNumber=" + buyerIdNumber
				+ ", buyerName=" + buyerName + ", buyerTelephone=" + buyerTelephone + ", shipDate=" + shipDate
				+ ", inputDate=" + inputDate + ", shipperName=" + shipperName + ", shipperAddress=" + shipperAddress
				+ ", shipperPhone=" + shipperPhone + ", consigneeNo=" + consigneeNo + ", consignee=" + consignee
				+ ", consigneeTelephone=" + consigneeTelephone + ", consigneeAddress=" + consigneeAddress + ", country="
				+ country + ", province=" + province + ", city=" + city + ", district=" + district + ", postCode="
				+ postCode + ", deliveryTimePreference=" + deliveryTimePreference + ", productAmount=" + productAmount
				+ ", freight=" + freight + ", discount=" + discount + ", taxTotal=" + taxTotal + ", taxCurrency="
				+ taxCurrency + ", acturalPaidAmount=" + acturalPaidAmount + ", insuredFee=" + insuredFee
				+ ", freightCurrency=" + freightCurrency + ", platformCode=" + platformCode + ", platformName="
				+ platformName + ", merchantCode=" + merchantCode + ", merchantName=" + merchantName + ", shopCode="
				+ shopCode + ", shopName=" + shopName + ", interLogisticsNo=" + interLogisticsNo
				+ ", interLogisticsCompanyCode=" + interLogisticsCompanyCode + ", interLogisticsCompanyName="
				+ interLogisticsCompanyName + ", logisticsNo=" + logisticsNo + ", logisticsNote=" + logisticsNote
				+ ", payCode=" + payCode + ", payName=" + payName + ", payTransactionId=" + payTransactionId
				+ ", payTime=" + payTime + ", payNote=" + payNote + ", customsCode=" + customsCode + ", ciqbCode="
				+ ciqbCode + ", ieFlag=" + ieFlag + ", businessMode=" + businessMode + ", orderType=" + orderType
				+ ", transportMode=" + transportMode + ", transportNo=" + transportNo + ", voyageNo=" + voyageNo
				+ ", billNo=" + billNo + ", shipperCountryCode=" + shipperCountryCode + ", wrapType=" + wrapType
				+ ", packageQuantity=" + packageQuantity + ", grossWeight=" + grossWeight + ", netWeight=" + netWeight
				+ ", fromEplat=" + fromEplat + ", printHeader=" + printHeader + ", note=" + note + ", status=" + status
				+ ", remark=" + remark + ", exceptionCode=" + exceptionCode + ", createdBy=" + createdBy
				+ ", createTime=" + createTime + ", updateTime=" + updateTime + ", updatedBy=" + updatedBy
				+ ", tenantId=" + tenantId + ", refuseTime=" + refuseTime + ", refuser=" + refuser + ", refuseRemark="
				+ refuseRemark + ", exceptionRemark=" + exceptionRemark + ", platformOrderType=" + platformOrderType
				+ ", orderSource=" + orderSource + ", ownerUserId=" + ownerUserId + ", ownerUserName=" + ownerUserName
				+ ", outerStoreCode=" + outerStoreCode + ", outerOrderCode=" + outerOrderCode
				+ ", overseasWarehouseCode=" + overseasWarehouseCode + ", messageId=" + messageId + ", messageType="
				+ messageType + ", senderId=" + senderId + ", receiverId=" + receiverId + ", sendTime=" + sendTime
				+ ", exceptionProcessLogId=" + exceptionProcessLogId + ", exceptionTime=" + exceptionTime
				+ ", rebuildFlag=" + rebuildFlag + ", changeFlag=" + changeFlag + ", isTraceSource=" + isTraceSource
				+ ", traceSourceCode=" + traceSourceCode + ", vmiFlag=" + vmiFlag + ", ownerFlag=" + ownerFlag
				+ ", errorCount=" + errorCount + ", nextInvokeTime=" + nextInvokeTime + ", isStoreStrategy="
				+ isStoreStrategy + ", lpOrderCode=" + lpOrderCode + ", lpCode=" + lpCode + ", waybillNoUrl="
				+ waybillNoUrl + ", isFirstDelivery=" + isFirstDelivery + ", isReceiveDeclare=" + isReceiveDeclare
				+ ", insurCurr=" + insurCurr + ", tradeMode=" + tradeMode + ", commonField=" + commonField + "]";
	}
}
