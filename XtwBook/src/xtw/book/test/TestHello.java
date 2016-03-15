package xtw.book.test;

import java.io.IOException;
import java.io.Reader;

import xtw.book.pojo.XtwUser;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
/**
 * 测试hello
 * @author xutw
 *
 */
public class TestHello {

	public static void main(String[] args) {
		
		String resource = "xtw/book/map/MyBatisConfig.xml"; // 基本配置文件相对路径
		Reader reader = null;
		SqlSession session;
		try {
			reader = Resources.getResourceAsReader(resource); // 读取基本配置文件
		} catch (IOException e) {
			e.printStackTrace();
		}
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader); // 建立session工厂
		session = sessionFactory.openSession(); // 打开session
		XtwUser xtwUser = session.selectOne("findById", 1); // 单行查询
		System.out.println(xtwUser.getUserName());
		session.close();
	}

}
