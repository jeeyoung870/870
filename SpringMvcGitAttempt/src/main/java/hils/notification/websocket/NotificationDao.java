package hils.notification.websocket;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hils.notification.model.GeneralNotiDto;

@Repository
public class NotificationDao {
	@Autowired
	private SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	public int insertNoti(GeneralNotiDto notiDto) {
		return sqlSession.insert("noti.insertNoti", notiDto);
	}
	public int deleteNoti(Map<String, Object> paraMap) {
		return sqlSession.delete("noti.deleteNoti", paraMap);
	}
	public List<GeneralNotiDto> selectUserNoti(String user_id) {
		return sqlSession.selectList("noti.selectUserNoti", user_id);
	}
	public String checkThereisNoti(String user_id) {
		return sqlSession.selectOne("noti.checkThereisNoti", user_id);
	}
}
