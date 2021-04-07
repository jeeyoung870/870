package dept.dao;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryMaker {

	public static SqlSessionFactory factory;

	static {
		InputStream is = null;
		try  {
			is = Resources.getResourceAsStream("config.xml");
			factory = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(is != null) { try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			} }
		}
		 
	}
	public static SqlSessionFactory getSqlSessionFactory() {
		return factory;
	}

}
