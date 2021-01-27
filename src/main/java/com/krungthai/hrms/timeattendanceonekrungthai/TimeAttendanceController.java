package com.krungthai.hrms.timeattendanceonekrungthai;

import java.security.Security;
import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("time-attendance")
public class TimeAttendanceController {

	@RequestMapping(value = "/getSystemDateTime" , method = RequestMethod.GET, headers = "Accept=application/json")
	public String getSystemDateTime() {
		
		
		String localDateTime = LocalDateTime.now().toString();
		//response.setTime(localDateTime.toLocalTime().toString());
		//response.setDate(localDateTime.toLocalDate().toString());
		
		return localDateTime;
	}

	@RequestMapping(value = "/checkin" , method = RequestMethod.POST, headers = "Accept=application/json")
	public CheckinResponseModel checkin(
			@RequestHeader (name="Authorization") String token, 
			@RequestHeader (name="Latitude") String latitude,
			@RequestHeader (name="Longitude") String longitude,
			@RequestHeader (name="QrCodeRaw") String qrCodeRaw,
			@RequestHeader (name="SystemDateTime") String systemDateTime
	) throws Exception {
		
		Security.setProperty("crypto.policy", "unlimited");
	    
		//Decrypt for get data in qrcode.
		//String decryptedString = CryptoUtil.decrypt(qrCodeRaw, CryptoUtil.AES_KEY_TEXT);
	    //System.out.println("decryptedText :: " + decryptedString);
				
	    CheckinResponseModel response = new CheckinResponseModel();
		response.setResultCode("700");
		response.setResultMessage("บันทึกข้อมูล Hrms สำเร็จ");
		
		
		return response;
	}
}
