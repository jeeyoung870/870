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
	
	 
	public List<ProfileDto> userInfo() {
		return dao.userInfo();
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
	
	
	//�������� Service
	public boolean sendMail(EmailVO email, int random) throws Exception {

        try{
        	//������ ���� ��ü ����
	        MimeMessage msg = mailSender.createMimeMessage();

	        msg.setSubject(email.getSubject());//���� ����
	       	// ���� ���� 
	        // �Ϲ� �ؽ�Ʈ�� �����Ϸ��� ���
	        msg.setText(email.getContent()); 
	        // HTML �������� ���۽� ���
	        String htmlContent = "<br><span style='font-family:Noto Sans;font-size:30px;'>";
	        msg.setContent(email.getContent()+htmlContent+random+"</span>", "text/html;charset=utf-8");
	        //������ ����
	        msg.setRecipient(RecipientType.TO , new InternetAddress(email.getReceiver()));
	        //�������� ������ ���, InternetAddress[]�� �ּҵ��� ��� addRecipients()�޼ҵ�� �߰��Ѵ�.
	        //InternetAddress[] addresses = {new InternetAddress(email.getReceiver()),new InternetAddress("y_096@naver.com") };
	        //msg.addRecipients(RecipientType.TO , addresses);
	       
	       //���� ����  
	       mailSender.send(msg);
		//�������� �����ߴٸ�,
	        return true;
	//������ ����ٸ�,
        }catch(Exception ex) {
        	ex.printStackTrace();
        }

        return false;
    }

}
