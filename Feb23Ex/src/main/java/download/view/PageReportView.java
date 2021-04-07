package download.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;

import download.controller.PageRank;

@Component("pageReport")	//controller에서 리턴된 뷰네임
public class PageReportView extends AbstractPdfView {
	
	@SuppressWarnings("unchecked")
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//원하는 이름으로 pdf파일 다운 가능
		//attachment; : 붙이면 화면에 출력하지 않고 바로 다운로드됨
		response.setHeader("Content-Disposition", "attachment; filename=\"rank.pdf\";" );
		
		List<PageRank> pageRanks = (List<PageRank>) model.get("pageRanks");
		//내용을 넣을 table만들기(가로, 세로)
		Table table = new Table(2, pageRanks.size() + 1);
		table.setPadding(5);
		//글꼴설정 : 글꼴설치 경로에서 해당폰트 영어이름.확장자명 가져오기(속성에서 볼수있음)
		BaseFont bfKorean = BaseFont.createFont("C:\\Users\\Jiyoung\\AppData\\Local\\Microsoft\\Windows\\Fonts\\NanumSquareRoundB.ttf", 
				BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
		Font font = new Font(bfKorean);
		//표 채우기
		Cell cell = new Cell(new Paragraph("순위", font));  //한글은 Paragraph로 만들어야 안깨짐
		cell.setHeader(true);	//setHeader : 굵은글씨표현
		table.addCell(cell);
		cell = new Cell(new Paragraph("페이지", font));
		table.addCell(cell);
		table.endHeaders();		//헤더부분 끝냄

		for (PageRank rank : pageRanks) {
			table.addCell(Integer.toString(rank.getRank()));
			table.addCell(rank.getPage());
		}
		document.add(table);
	}

}
