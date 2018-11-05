/*package com.ww.springboot.boot.iReport;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

*//**
 * @author wanwei
 * @TODO  图片生成器  : 图片生成需要两个包
 * @date: 2018年9月14日 下午5:11:39 
 *//*

@Component
public class PictureBulider {
private static final String PDF = ".pdf";
	
	private static final String FTP ="ftp://";
	
	private static final String PUBLIC = "/public/";
	
	private static final Logger logger = Logger.getLogger(PictureBulider.class);

	public void PictureBulider() {
		//记录错误消息
        try {
        	
        	//数据源
        	List<WayBillInfoDto> wayBillDtos = createDataSource(logisticsOrder);
            JRDataSource dataSource = new JRBeanCollectionDataSource(wayBillDtos);
        	Resource resource = new ClassPathResource("/static/huitong/huitong.jrxml");
        	//生成PDF流
        	byte[] bytes = IreportUtil.createPdf(logisticsOrder.getShipmentCode(), resource.getInputStream(), dataSource);
	        //上传到ftp 并将内外网地址存进订单表
        	uploadToFtp(logisticsOrder, bytes);
	        expInvokeLog.setIsSuccess(SuccessFailureEnum.SUCCESS);
	        updateShipmentSuccess(tskWayBill); 
        } catch (RuntimeException e) { 
        	errorMsg =e.getMessage();
        	RabbitMqUtils.sendExceptionMessage(rabbitTemplate, MqName.TMS_BAISHIHUITONG_WAYBILL_TASK, message, errorMsg,
					tskWayBill.getLogisticsOrderCode());
        	logger.error("汇通面单生成失败:" + e.getMessage() , e);
		}  catch (Exception e) {
			errorMsg =e.getMessage();
			RabbitMqUtils.sendRetryMessage(rabbitTemplate, MqName.TMS_BAISHIHUITONG_WAYBILL_TASK, message, errorMsg,
					tskWayBill.getLogisticsOrderCode());
			logger.error("汇通面单生成失败:" + e.getMessage() , e);
		}finally {
			if(expInvokeLog.getIsSuccess().equals(SuccessFailureEnum.FAILURE))	{
				updateShipmentException(tskWayBill, errorMsg);
			}
			expInvokeLog.setResponseData(errorMsg);
			expInvokeLog.setOriginalCode(tskWayBill.getLogisticsOrderCode());
			expInvokeLog.setEndTime(new Date());
			expInvokeLogService.insertExpInvokeLog(expInvokeLog);
		}
		
	}
	private String uploadToFtp(LogisticsOrder logisticsOrder, byte[] bytes)
			throws IOException {
		//pdf文件目录时间格式
		//ftp上传参数
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String date = df.format(new Date());
		String tmsbz = sysConfigService.getValueByKey(SysConfigKeyEnum.FTP_LIST_BZ);
		String baiShiHuiTong = sysConfigService.getValueByKey(SysConfigKeyEnum.FTP_LIST_BSHT);
		String ftpOutUrl = sysConfigService.getValueByKey(SysConfigKeyEnum.FTP_OUT_URL);
		String ftpInnerUrl = sysConfigService.getValueByKey(SysConfigKeyEnum.FTP_INNER_URL);
		int ftpPort = Integer.valueOf(sysConfigService.getValueByKey(SysConfigKeyEnum.FTP_PORT)).intValue();
		String ftpUserName = sysConfigService.getValueByKey(SysConfigKeyEnum.FTP_USERNAME);
		String ftpPassword = sysConfigService.getValueByKey(SysConfigKeyEnum.FTP_PASSWORD);
		//生成目录(只能一层一层地生成)
		FtpUtils.makeDirecotory( ftpOutUrl,ftpUserName, ftpPort, ftpPassword,"", tmsbz);
		FtpUtils.makeDirecotory(ftpOutUrl,ftpUserName,ftpPort, ftpPassword,tmsbz, baiShiHuiTong);
		FtpUtils.makeDirecotory(ftpOutUrl,ftpUserName, ftpPort, ftpPassword,tmsbz+baiShiHuiTong, date+"/");
		String directory = tmsbz+baiShiHuiTong+date+"/";
		//上传到FTP上去
		FtpUtils.upload(ftpOutUrl, ftpUserName, ftpPort, ftpPassword, directory,bytes,logisticsOrder.getShipmentCode()+PDF);
		//内外网地址赋值
        String waybillInnerUrl = FTP+ftpOutUrl+PUBLIC+directory+logisticsOrder.getShipmentCode()+PDF;
        String waybillUrl      = FTP+ftpInnerUrl+PUBLIC+directory+logisticsOrder.getShipmentCode()+PDF;
        logisticsOrderService.updateWayBillUrl(waybillInnerUrl,waybillUrl,logisticsOrder.getCode());
		return directory;
	}
	*//**
	 * @author wanwei
	 * @throws IOException 
	 * @TODO   生成数据源
	 * @date: 2017年12月7日 上午10:34:46 
	 *//*
	private List<WayBillInfoDto> createDataSource(LogisticsOrder logisticsOrder) throws IOException {
		List<WayBillInfoDto> wayBillDtos = new ArrayList<>();
		WayBillInfoDto wayBillDto = new WayBillInfoDto();
     	//广东省 广州市 越秀区 XXXXX路xxxxx
     	wayBillDto.setConsigneeAddress(logisticsOrder.getConsigneeAddress());
     	//广东省
     	wayBillDto.setConsigneeProvince(logisticsOrder.getConsigneeProvince());
     	wayBillDto.setConsigneeCity(logisticsOrder.getConsigneeCity());
     	wayBillDto.setConsigneeDistrict(logisticsOrder.getConsigneeDistrict());
     	wayBillDto.setConsigneeName(logisticsOrder.getConsigneeName());
     	wayBillDto.setConsigneeTelephone(logisticsOrder.getConsigneeMobilephone());
     	//配送方式为空
     	wayBillDto.setDeliveryWay("");
     	//团购id为空
     	wayBillDto.setGroupBuyId("");
     	//保价金额为空
     	wayBillDto.setInsuredAmount("0.00元");	
     	//包裹信息为空
     	wayBillDto.setPackageInfo("");
     	wayBillDto.setExpShipTime(logisticsOrder.getExpShipTime());
     	wayBillDto.setOrderId(logisticsOrder.getPlatformOrderCode());
     	wayBillDto.setShipperAddress(logisticsOrder.getShipperAddress());
     	wayBillDto.setShipperName(logisticsOrder.getShipperName());
     	wayBillDto.setShipperTelephone(logisticsOrder.getShipperTelephone());
     	wayBillDto.setShipperProvince(logisticsOrder.getShipperProvince());
     	wayBillDto.setShipperCity(logisticsOrder.getShipperCity());
     	wayBillDto.setShipperDistrict(logisticsOrder.getShipperDistrict());
     	wayBillDto.setShipmentCode(logisticsOrder.getShipmentCode());
     	LogisticsOrderHtoEx logisticsOrderHtoEx = logisticsOrderHtoExService.findByLogisticsOrderCode(logisticsOrder.getCode());
     	//pkg-code
     	wayBillDto.setPkgCode(logisticsOrderHtoEx.getPkgCode());
     	//MarkDestination 大头笔
     	wayBillDto.setMarkDestination(logisticsOrder.getBigPen());
     	//溯源码
     	String traceSourceStream = logisticsOrder.getTraceSourceStream();
     	if(!StringUtil.isEmpty(traceSourceStream)){
     		//base64转图片
     		byte[] bytes =Base64ForJpgUtil.GenerateImage(traceSourceStream);	
         	InputStream sym = new ByteArrayInputStream(bytes);
         	wayBillDto.setTraceSourceStream(sym);
     	}
     	wayBillDto.setTraceSourceCode(logisticsOrder.getTraceSourceCode());
        wayBillDto.setBaiShiHuiTong(this.getClass().getResourceAsStream("/static/huitong/baishilogo.jpg"));
        wayBillDto.setBaiShiHuiTong2(this.getClass().getResourceAsStream("/static/huitong/baishilogo.jpg"));
     	wayBillDto.setVip(this.getClass().getResourceAsStream("/static/huitong/baishiVIPlogo.png"));
     	wayBillDto.setVip2(this.getClass().getResourceAsStream("/static/huitong/baishiVIPlogo.png"));
     	wayBillDto.setZhuoZhi(this.getClass().getResourceAsStream("/static/huitong/zhuozhilogo.png"));
     	wayBillDtos.add(wayBillDto);
		return wayBillDtos;	
		
	}
	
	private void updateShipmentException(TskWayBill tskWayBill,String errorMsg) {
		TskWayBill condition = new TskWayBill();
		condition.setId(tskWayBill.getId());
		condition.setStatus(EnumConstants.WayBillState.BUILDER_FAIL.getValue());
		// 更新数据库
		tskWayBillService.update(condition);	
	}
	
	private void updateShipmentSuccess(TskWayBill tskWayBill) {
		
		TskWayBill condition = new TskWayBill();
		condition.setId(tskWayBill.getId());
		condition.setStatus(EnumConstants.WayBillState.BUILDER_SUCCESS.getValue());
		// 更新数据库
		tskWayBillService.update(condition);
		rabbitTemplate.convertAndSend("tms.waybill.callback", tskWayBill);	
	}
}
*/