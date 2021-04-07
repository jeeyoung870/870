package org.kdea.email;

import javax.mail.internet.InternetAddress; 
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service("emailService")
public class EmailService {

   @Autowired
    protected JavaMailSender  mailSender;

    public boolean sendMail(EmailVO email) throws Exception {

        try{
        	//전송할 메일 객체 생성
	        MimeMessage msg = mailSender.createMimeMessage();

	        msg.setSubject(email.getSubject());//제목 설정
	       	// 내용 설정 
	        // 일반 텍스트만 전송하려는 경우
	        msg.setText(email.getContent()); 
	        // HTML 컨텐츠를 전송시 사용
	        msg.setContent("<a href='https://www.naver.com'>클릭</a><br>"+email.getContent(), "text/html;charset=utf-8");
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