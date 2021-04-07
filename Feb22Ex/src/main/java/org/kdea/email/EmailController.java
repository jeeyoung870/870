package org.kdea.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class EmailController {	

    @Autowired
    private EmailService emailService;

     
    @RequestMapping("/send")
    @ResponseBody	//가 받은 객체를 클라이언트view로 보냄
    public String sendMail() throws Exception {

         EmailVO email = new EmailVO();

			/*
			 * String receiver = "메일 받을 주소"; 
			 * String subject = "Email 제목"; 
			 * String content = "Email 내용";
			 */
         String receiver = "didjrmfjr@gmail.com";
         String subject  = "testmailSending";
         String content = "뉴뉴냐ㅑ냐냐ㅑ냐냐냐";

        email.setReceiver(receiver);
        email.setSubject(subject);
        email.setContent(content);

        boolean result = emailService.sendMail(email);	//성공시 true, 실패시 false

        return "Mail Send: "+result;

    }

}