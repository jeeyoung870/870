package files.controller;

import java.io.File;
import java.util.HashMap;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import files.service.FBoardService;

@Controller
public class DownloadController implements ApplicationContextAware {
	
	@Autowired
	FBoardService service;
	
	private WebApplicationContext context = null;
	
	@RequestMapping("/downFile")
	public ModelAndView download( @RequestParam(value = "no")int no) throws Exception {
		File downloadFile = getFile(no);
		HashMap<String, Object> m = new HashMap<>();
		m.put("downloadFile", downloadFile);
		m.put("no", no);
		//BeanNameViewResolver에 의해 이름이 download인 뷰를 찾아간다.
		return new ModelAndView("download", "model", m);
	}
	
	private File getFile(int no) {
		String path = service.findPath(no);
		//String path = context.getServletContext().getRealPath("/WEB-INF/설명.txt");
		System.out.println(path);
		return new File(path);
	}
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.context = (WebApplicationContext) applicationContext;
		
	}

}
