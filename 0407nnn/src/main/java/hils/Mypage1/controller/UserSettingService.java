package hils.Mypage1.controller;

import java.util.HashMap;
import java.util.List;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class UserSettingService {
	
	@Autowired
	UserSettingDao dao; 
	@Autowired
    protected JavaMailSender  mailSender;
	
	public void setDao(UserSettingDao dao) {
		this.dao = dao;
	}

	
	
	
	
	public List<ProfileDto> userInfo(String user_id) {
		return dao.userInfo(user_id);
	}
	
	public String getPw(String user_id) {
		return dao.getPw(user_id);
	}
	
	public int changePw(ProfileDto pdto) {
		return dao.changePw(pdto);
	}
	
	public String getPhone(String user_id) {
		return dao.getPhone(user_id);
	}
	
	public int phoneCheck(String user_phone) {
		return dao.phoneCheck(user_phone);
	}
	
	public int changePhone(ProfileDto pdto) {
		return dao.changePhone(pdto);
	}
	
	public int changeEmail(ProfileDto pdto) {
		return dao.changeEmail(pdto);
	}
	
	public int changeLoc(ProfileDto pdto) {
		return dao.changeLoc(pdto);
	}
	
	public int changeHilOpen(ProfileDto pdto) {
		return dao.changeHilOpen(pdto);
	}
	
	public int changeHilWB(ProfileDto pdto) {
		return dao.changeHilWB(pdto);
	}
	
	public int leaveHils(String user_id) {
		return dao.leaveHils(user_id);
	}
	
	
	
	
	//메일전송 Service
	public boolean sendMail(EmailVO email, int random) throws Exception {

        try{
        	//전송할 메일 객체 생성
	        MimeMessage msg = mailSender.createMimeMessage();

	        msg.setSubject(email.getSubject());//제목 설정
	       	// 내용 설정 
	        // 일반 텍스트만 전송하려는 경우
	        msg.setText(email.getContent()); 
	        // HTML 컨텐츠를 전송시 사용
	        String htmlContent = "<br><span style='font-family:Noto Sans;font-size:30px;'>";
	        msg.setContent(email.getContent()+htmlContent+random+"</span>", "text/html;charset=utf-8");
	        //수신자 설정
	        msg.setRecipient(RecipientType.TO , new InternetAddress(email.getReceiver()));
	        //여러명에게 전송할 경우, InternetAddress[]에 주소들을 담아 addRecipients()메소드로 추가한다.
	        //InternetAddress[] addresses = {new InternetAddress(email.getReceiver()),new InternetAddress("y_096@naver.com") };
	        //msg.addRecipients(RecipientType.TO , addresses);
	       
	       //메일 전송  
	       mailSender.send(msg);
		//문제없이 전송했다면,
	        return true;
	//문제가 생겼다면,
        }catch(Exception ex) {
        	ex.printStackTrace();
        }

        return false;
    }

}
