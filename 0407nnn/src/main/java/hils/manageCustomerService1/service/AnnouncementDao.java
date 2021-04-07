package hils.manageCustomerService1.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hils.manageCustomerService1.model.AnnouncementDto;

@Repository
public class AnnouncementDao {
	
	
	private SqlSession sqlSession;
	
	public AnnouncementDao() {};
	@Autowired
	public AnnouncementDao(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	public void newAnnouncement(AnnouncementDto announcementDto) {
		sqlSession.insert("manageCustService.newAnnouncement", announcementDto);
	}
	public int countTotalAnnou() {
		return sqlSession.selectOne("manageCustService.countTotalAnnou");
	}
	public List<AnnouncementDto> searchAnnou(Map<String, String> paraMap){
		return sqlSession.selectList("manageCustService.searchAnnou", paraMap );
	}
	public AnnouncementDto selectAnnou(int annou_writing_num) {
		return sqlSession.selectOne("manageCustService.selectAnnou", annou_writing_num);
	}
	public void deleteAnnou(int annou_writing_num){
		sqlSession.delete("manageCustService.deleteAnnou", annou_writing_num);
	}
	public void updateAnnou(Map<String, Object> paraMap) {
		sqlSession.update("manageCustService.updateAnnou", paraMap);
	}
	
	/////user
	public List<AnnouncementDto> userAnnouBoard(Map<String, Integer> paraMap){
		return sqlSession.selectList("annou.userAnnouList", paraMap);
	}
	
}
