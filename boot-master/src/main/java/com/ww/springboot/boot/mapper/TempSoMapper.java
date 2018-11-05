package com.ww.springboot.boot.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.ww.springboot.boot.model.TempSo;

@Mapper
public interface TempSoMapper {
	
	@Select("select id, platform_order_code platformOrderCode, order_create_time orderCreateTime, buyer_reg_no buyerRegNo,  buyer_id_type buyerIdType, "
			+ "buyer_id_number buyerIdNumber, buyer_name buyerName, buyer_telephone buyerTelephone, ship_date shipDate, input_date inputDate, shipper_name shipperName, "
			+ "shipper_address shipperAddress, shipper_phone shipperPhone, consignee_no consigneeNo, consignee, consignee_telephone consigneeTelephone, "
			+ "consignee_address consigneeAddress, country, province, city, district, post_code postCode, delivery_time_preference deliveryTimePreference, "
			+ "product_amount productAmount, freight, discount, tax_total taxTotal, tax_currency taxCurrency, actural_paid_amount acturalPaidAmount, insured_fee insuredFee, "
			+ "freight_currency freightCurrency, platform_code platformCode, platform_name platformName, merchant_code merchantCode, merchant_name merchantName, shop_code shop_Code, "
			+ "shop_name shopName, inter_logistics_no interLogisticsNo, inter_logistics_company_code interLogisticsCompanyCode, inter_logistics_company_name interLogisticsCompanyName, "
			+ "logistics_no logisticsNo, logistics_note logisticsNote, pay_code payCode, pay_name payName, pay_transaction_id payTransactionId, pay_time payTime, pay_note payNote, "
			+ "customs_code customsCode, ciqb_code ciqbCode, ie_flag ieFlag, business_mode businessMode, order_type orderType, transport_mode transportMode, transport_no transportNo, "
			+ "voyage_no voyageNo, bill_no billNo, shipper_country_code shipperCountryCode, wrap_type wrapType, package_quantity packageQuantity, gross_weight grossWeight, net_weight netWeight, "
			+ "from_eplat fromEplat, print_header printHeader, note, status, remark, exception_code exceptionCode, created_by createdBy, create_time createTime, update_time updateTime, "
			+ "updated_by updatedBy, tenant_id tenantId, refuse_time refuseTime, refuser, refuse_remark refuseRemark, exception_remark exceptionRemark, platform_order_type platformOrderType, "
			+ "order_source orderSource, owner_user_id ownerUserId, owner_user_name ownerUserName, outer_store_code outerStoreCode, outer_order_code outerOrderCode, overseas_warehouse_code overseasWarehouseCode, "
			+ "message_id messageId, message_type messageType, sender_id senderId, receiver_id receiverId, send_time sendTime, exception_process_log_id exceptionProcessLogId, exception_time exceptionTime, "
			+ "rebuild_flag rebuildFlag, change_flag changeFlag, is_trace_source isTraceSource, trace_source_code traceSourceCode, vmi_flag vmiFlag, owner_flag ownerFlag, error_count errorCount, next_invoke_time nextInvokeTime, "
			+ "is_store_strategy isStoreStrategy, lp_order_code lpOrderCode, "
			+ "lp_code lpCode, waybill_no_url waybillNoUrl, is_first_delivery isFirstDelivery, is_receive_declare isReceiveDeclare, insur_curr insurCurr, trade_mode tradeMode, common_field commonField"
			+ " from bc_temp_so where id = #{id}")
	TempSo findById(Long id);
	
	@Insert("insert into bc_temp_so (platform_order_code, order_create_time, buyer_reg_no, "
			+ "buyer_id_type, buyer_id_number, buyer_name, buyer_telephone, "
			+ "ship_date, input_date, shipper_name, shipper_address, shipper_phone, "
			+ "consignee_no, consignee, consignee_telephone, consignee_address, country, "
			+ "province, city, district, post_code, delivery_time_preference, product_amount, "
			+ "freight, discount, tax_total, tax_currency, actural_paid_amount, insured_fee, "
			+ "freight_currency, platform_code, platform_name, merchant_code, merchant_name, "
			+ "shop_code, shop_name, inter_logistics_no, inter_logistics_company_code, "
			+ "inter_logistics_company_name, logistics_no, logistics_note, pay_code, "
			+ "pay_name, pay_transaction_id, pay_time, pay_note, customs_code, ciqb_code, "
			+ "ie_flag, business_mode, order_type, transport_mode, transport_no, voyage_no, "
			+ "bill_no, shipper_country_code, wrap_type, package_quantity, gross_weight, net_weight, "
			+ "from_eplat, print_header, note, status, remark, exception_code, created_by, create_time, "
			+ "update_time, updated_by, tenant_id, refuse_time, refuser, refuse_remark, exception_remark, "
			+ "platform_order_type, order_source, owner_user_id, owner_user_name, outer_store_code, "
			+ "outer_order_code, overseas_warehouse_code, message_id, message_type, sender_id, receiver_id, "
			+ "send_time, exception_process_log_id, exception_time, rebuild_flag, change_flag, is_trace_source, "
			+ "trace_source_code, vmi_flag, owner_flag, error_count, next_invoke_time, is_store_strategy, "
			+ "lp_order_code, lp_code, waybill_no_url, is_first_delivery, is_receive_declare, "
			+ "insur_curr, trade_mode, common_field)"
			+ "values"
			+ "(#{platformOrderCode},#{orderCreateTime},#{buyerRegNo},#{buyerIdType},"
			+ "#{buyerIdNumber},#{buyerName},#{buyerTelephone},#{shipDate},#{inputDate},"
			+ "#{shipperName},#{shipperAddress},#{shipperPhone},#{consigneeNo},#{consignee},"
			+ "#{consigneeTelephone},#{consigneeAddress},#{country},#{province},#{city},#{district}"
			+ ",#{postCode},#{deliveryTimePreference},#{productAmount},#{freight},"
			+ "#{discount},#{taxTotal},#{taxCurrency},#{acturalPaidAmount},"
			+ "#{insuredFee},#{freightCurrency},#{platformCode},#{platformName},"
			+ "#{merchantCode},#{merchantName},#{shopCode},#{shopName},#{interLogisticsNo},"
			+ "#{interLogisticsCompanyCode},#{interLogisticsCompanyName},#{logisticsNo},"
			+ "#{logisticsNote},#{payCode},#{payName},#{payTransactionId},#{payTime},#{payNote},"
			+ "#{customsCode},#{ciqbCode},#{ieFlag},#{businessMode},#{orderType},"
			+ "#{transportMode},#{transportNo},#{voyageNo},#{billNo},"
			+ "#{shipperCountryCode},#{wrapType},#{packageQuantity},"
			+ "#{grossWeight},#{netWeight},#{fromEplat},#{printHeader},#{note},#{status},"
			+ "#{remark},#{exceptionCode},#{createdBy},#{createTime},#{updateTime},"
			+ "#{updatedBy},#{tenantId},#{refuseTime},#{refuser},#{refuseRemark},"
			+ "#{exceptionRemark},#{platformOrderType},#{orderSource},#{ownerUserId},"
			+ "#{ownerUserName},#{outerStoreCode},#{outerOrderCode},#{overseasWarehouseCode},"
			+ "#{messageId},#{messageType},#{senderId},#{receiverId},#{sendTime},#{exceptionProcessLogId},"
			+ "#{exceptionTime},#{rebuildFlag},#{changeFlag},#{isTraceSource},#{traceSourceCode},#{vmiFlag},#{ownerFlag},"
			+ "#{errorCount},#{nextInvokeTime},#{isStoreStrategy},#{lpOrderCode},#{lpCode},#{waybillNoUrl},"
			+ "#{isFirstDelivery},#{isReceiveDeclare},#{insurCurr},#{tradeMode},#{commonField})")
	void insert(TempSo tempSo);

}
