package xtw.book.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import xtw.book.pojo.Author;
import xtw.book.pojo.XtwUser;
import xtw.book.pojo.Visit;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
/**
 * 测试集合查询
 * @author xutw
 *
 */
public class TestCollection {

	public static void main(String[] args) {
		String resource = "xtw/book/map/MyBatisConfig.xml";
		Reader reader = null;
		SqlSession session;
		try {
			reader = Resources.getResourceAsReader(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder()
				.build(reader);
		session = sqlMapper.openSession();
		try{
			List<XtwUser> ap=session.selectList("selectVisit"); 
			for(XtwUser temp:ap) {
				System.out.println("用户名="+temp.getUserName());
				for(Visit oneVisit:temp.getVisitList())
				{
					System.out.println("登录时间="+oneVisit.getVisitDate()+
							"登录IP="+oneVisit.getVisitIP());
				}	
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}	

	}

}
