package xtw.book.test;

import java.io.IOException;
import java.io.Reader;

import xtw.book.pojo.Author;
import xtw.book.pojo.XtwUser;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
/**
 * 事务测试
 * @author xutw
 *
 */
public class TestTran {

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
		session = sqlMapper.openSession(false);	//不使用自动提交
		try{
			XtwUser one = new XtwUser();
			one.setUserName("author001");
			one.setPassword("123456");
			session.insert("insertUser",one);
			System.out.println("新加入的user id=" + one.getId());
			
			Author at = new Author();
			at.setXtwUser(one);
			at.setRealName("一个大牛");
			session.insert("insertAuthor", at);
			session.commit();	//事务提交

		}
		catch(Exception e)
		{
			e.printStackTrace();
			session.rollback();	//回滚
		}
		finally
		{
			session.close();//关闭session
		}
	}

}
