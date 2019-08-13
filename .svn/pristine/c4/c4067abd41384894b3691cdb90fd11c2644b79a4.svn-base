package com.abbot.schimneylife.util;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

public class AliMsgUtil {
	//不需要更改
    static final String product = "Dysmsapi";
    //不需要更改
    static final String domain = "dysmsapi.aliyuncs.com";

    // TODO AK
    static final String accessKeyId = "LTAIZNEb4i0pmo8G";
    static final String accessKeySecret = "gvaci61vzZiSa1XWkDQ0Oy5kKKoTN7";
    public static SendSmsResponse sendSms(String code,String phone) throws ClientException {

     
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");

 
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);

        SendSmsRequest request = new SendSmsRequest();
        request.setPhoneNumbers(phone);
        request.setSignName("炊烟生活");
        request.setTemplateCode("SMS_109445175");
        request.setTemplateParam("{\"code\":\""+code+"\"}");
        request.setOutId("yourOutId");
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);

        return sendSmsResponse;
    }
}
