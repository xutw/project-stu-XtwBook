package xtw.book.test;

import java.io.IOException;
import java.io.Reader;

import xtw.book.map.InterfaceXtwUserMap;
import xtw.book.pojo.XtwUser;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
/**
 * 测试 增删改操作
 * @author wsdhr
 *
 */
public class TestUpdate {

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
			//测试增加
//			XtwUser jku=new XtwUser(); 
//			jku.setUserName("json");
//			jku.setPassword("123456");
//			session.insert("insertUser", jku);
//			System.out.println(jku.getId());
			
			//测试更新
//			XtwUser jku2=new XtwUser();
//			jku2.setUserName("json007");
//			jku2.setPassword("8468655");
//			jku2.setId(2);
//			session.update("updateUser", jku2);
			
			//测试删除 采用map接口的注解配置应用
			InterfaceXtwUserMap ijum=session.getMapper(InterfaceXtwUserMap.class);
			ijum.deleteUser(1);
			
			session.commit();
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
