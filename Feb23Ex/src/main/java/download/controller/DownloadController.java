package download.controller;

import java.io.File;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DownloadController implements ApplicationContextAware {

	private WebApplicationContext context = null;
	
	@RequestMapping("/file")
	public ModelAndView download() throws Exception {
		File downloadFile = getFile();
		//BeanNameViewResolver에 의해 이름이 download인 뷰를 찾아간다.
		return new ModelAndView("download", "downloadFile", downloadFile);
	}
	
	private File getFile() {
		String path = context.getServletContext().getRealPath("/WEB-INF/설명.txt");
		System.out.println(path);
		return new File(path);
	}
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.context = (WebApplicationContext) applicationContext;
		
	}

}
