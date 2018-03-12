package com.ustcInfo.testone;

import usi.csp.blowfish.util.BlowfishService;

public class MakeAddress {

	public static void main(String[] args) throws Exception {
//		BlowfishService blowfishService = new BlowfishService();
//		String key = "2358f106adbe454f843a57577457770c";//从各个省份对应key值中获取；
//		String sysId = "kf";//系统标示
//		String userId = "14098"; //人员工号
//		String callId = "1234567890123456";//来电流水号
//		String callNo = "18530878356";//来电号码
//		String areaCode = "371";//区号（去掉最前面0）
//		long province = 410000;//省份编码
//		String u = blowfishService.encryptString(key, key+"|"+sysId+"|"+userId+"|"+ callId +"|"+callNo+"|"+areaCode+"|"+province);
//		System.out.println("秘钥k："+key);
//		System.out.println("密文u："+u);
		
		BlowfishService blowfishService = new BlowfishService();
		String key = "867eb0424f474210bac413189e70a329";//从各个省份对应key值中获取；
		String sysId = "kf";//系统标示
		String userId = "aaaa2K"; //人员工号
		String callId = "2017101113233081565";//来电流水号
		String callNo = "18703419167";//来电号码
		String areaCode = "351";//区号（去掉最前面0）
		String province = "00030010";//省份编码
		String u = blowfishService.encryptString(key, key+"|"+sysId+"|"+userId+"|"+ callId +"|"+callNo+"|"+areaCode+"|"+province);
		System.out.println("秘钥k："+key);
		System.out.println("密文u："+u);
	}

}
