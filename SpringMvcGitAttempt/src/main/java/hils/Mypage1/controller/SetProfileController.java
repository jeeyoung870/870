package hils.Mypage1.controller;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import lombok.Setter;

@Controller
@Setter
public class SetProfileController {

	@Autowired
	SetProfileService setp;
	
	
	@PostMapping("saveIamge")
	public String saveIamge(@RequestParam(value="croppedImage", required=true) MultipartFile[] file) {
		//System.out.println("file size : " + file[0].getSize() +" "+file[0].getOriginalFilename());
		printInfo("jyjy", file[0]);
		return "mypage";
	}

	
	
	//�������ϸ����� ������ο� ���ε�
	private String upload(MultipartFile profileImg) {
		//���ε� ��� 
		String dir = "c://upload/";
		String origName = profileImg.getOriginalFilename();
		System.out.println(origName);
		//ext : .������ Ȯ���ڸ� ���ϱ�
		//int index = origName.lastIndexOf(".");
		//String ext = origName.substring(index + 1);
		String ext = "png";		//img�� pngȮ���ڷ� ����
		//���� ���ϸ� �����ֱ�
		Random r = new Random();
		String fileName = System.currentTimeMillis() + "_" + r.nextInt(50) + "." + ext;
		File f = new File(dir + fileName); 
		
		try {
			//File(���ϰ�θ�)�� ����� f(����)�� �ش��ο� �����ϱ�.
			profileImg.transferTo(f);
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return f.getPath();
	}

	//upload()�ϰ� �������� ����� ��, ���� �������� ����� db�� ���������� ����
	private void printInfo(String user_id, MultipartFile profileImg) {
			String path = upload(profileImg);
			System.out.println("id+���+�������ϸ� : "+user_id+" "+ path+ " "+profileImg.getOriginalFilename());
			//������ ������ ��������
			String oldimgPath = setp.findProfileImg(user_id);
			//������������ �����
			File deleteFile = new File(oldimgPath);
			deleteFile.delete(); 
			//�� ������ db�� ����ϱ�
			setp.addImgFile(user_id, path);
		}
	
}
