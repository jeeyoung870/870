package files.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import files.service.FBoardService;

//화면전환 없이, 바로 파일 다운로드시키는 뷰
@Component("download")
public class DownloadView extends AbstractView {

	@Autowired
	FBoardService service;
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//이 부분만 바꿔가면서 복붙사용하면 됨.
		HashMap<String, Object> m = (HashMap<String, Object>) model.get("model");
		File file = (File) m.get("downloadFile");
		int no = (int) m.get("no");
		//File file = (File) model.get("downloadFile");
		
		response.setContentType(getContentType());
		response.setContentLength((int) file.length());
		
		String userAgent = request.getHeader("User-Agent");
		/*
		boolean ie = userAgent.indexOf("MSIE") > -1;
		String fileName = null;
		if(ie) {
			fileName = URLEncoder.encode(file.getName(), "utf-8");
		}else {
			fileName = new String(file.getName().getBytes("utf-8"),"iso-8859-1");
		}
		*/
		String fileName = service.findOrigName(no);
		//어떤 이름으로 파일 다운받을건지 설정
		//attachment; : 브라우저가 보여줄 수 있는 파일이어도 무조건 다운로드됨
		response.setHeader("Content-Disposition", "attachment; filename=\""
				+ fileName + "\";");
		response.setHeader("Content-Transfer-Encoding", "binary");
		//파일 내용을 response객체에 내보내기
		OutputStream out = response.getOutputStream();
		//FileInputStream(file): 파일에서 데이터를 읽어들임
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			FileCopyUtils.copy(fis, out);
		}finally {
			//파일 다 읽었으면,
			if(fis != null) {
				try {
					fis.close();
				}catch(IOException ex){
				}
			}
		}//남아있는 데이터 없애기
		out.flush();
		
	}

}
