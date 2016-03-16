package xtw.book.test;

import xtw.book.pojo.Author;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
/**
 * 测试联合查询与构造查询、子查询
 * @author xutw
 *
 */
public class TestAssociation {

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
//			List<Author> ap = session.selectList("selectAuthorJoin");//联合查询与构造查询
			List<Author> ap=session.selectList("selectAuthor");	//子查询
			for(Author temp:ap)
			{
//				System.out.println("作者真实姓名="+temp.getRealName()+
//						"对应的用户名="+temp.getXtwUser().getUserName()); 
				System.out.println("作者真实姓名="+temp.getRealName());
				System.out.println("懒加载应用了");
				System.out.println("用户名="+temp.getXtwUser().getUserName());
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
