package spring.service;

import org.springframework.stereotype.Component;

@Component
public class SearchService {
	public SearchResult search(SearchCommand command) {
		//db연동후 검색조건에 따라 검색한 결과물
		return new SearchResult();
	}
}