package movie.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

/*RestTemplate
Spring 4.x부터 지원하는 spring의 http통신 템플릿
httpclient 검색해서 dependency 추가
HTTP요청 후 json, xml, String 과 같은 응답을 받을 수 있는 템플릿*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

import movie.model.ActorList;
import movie.model.ArtistList;
import movie.model.MovieList;

@Controller
public class MovieBoxController {

	RestTemplate restTemplate;
	
	//일별 박스오피스 API 
	@RequestMapping("/boxOffice/oneday")
	public String getMovie(Model model) {
		//restTemplate.getForObject("데이터 가져올 링크?key=사이트에서 제공하는 키값", 가져온 정보를 변환할 타입의 클래스);
		//원하는 format으로 어제 날짜 가져오기
		Date today = new Date();
		Date yesterday = new Date(today.getTime()+(1000*60*60*24*-1));	//어제 날짜 구하기
		SimpleDateFormat format = new SimpleDateFormat ("yyyyMMdd");
		String targetDate = format.format(yesterday);
		System.out.println(targetDate);
		//어제 날짜의 박스오피스 영화list구하기
		MovieList list = restTemplate.getForObject(
				"http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt="
				+ targetDate , MovieList.class);
		model.addAttribute("boxOfficeList",list);	//뷰페이지로 넘어가는 객체
		return "movie/boxOffice";
	}
	
	//영화 상세정보 조회 API
	@RequestMapping("/boxOffice/movieinfo/actor")
	public String movieinfo(String movieCd, Model model) {
		String url = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.json?key=f5eef3421c602c6cb7ea224104795888&movieCd="
					+ movieCd;
		ActorList list = restTemplate.getForObject(url, ActorList.class);
		model.addAttribute("actorList",list);	//뷰페이지로 넘어가는 객체
		return "movie/movieinfo";
	}
	
	@RequestMapping("/findArtist")
	public String artistFinder(Model model) {
		return "movie/artistFinder";
	}
	
	//영화인목록 조회 API 
	@RequestMapping("/find/artist")
	public String artistinfo(String peopleNm, Model model) {
		String url = "http://kobis.or.kr/kobisopenapi/webservice/rest/people/searchPeopleList.json?key=f5eef3421c602c6cb7ea224104795888&peopleNm="
					+ peopleNm;
		ArtistList list = restTemplate.getForObject(url ,ArtistList.class);
		model.addAttribute("artistList",list);	//뷰페이지로 넘어가는 객체
		return "movie/findFilmoResult";
	}
	
	
	
	@Autowired
	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

}