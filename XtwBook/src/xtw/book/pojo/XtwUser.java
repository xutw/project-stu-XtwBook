package xtw.book.pojo;

import java.util.List;

import xtw.book.pojo.Visit;

/**
 * 用户表
 * @author xutw
 *
 */
public class XtwUser {
	private int id;			//ID自增主键
	private String userName;//用户名
	private String password;//密码
	private List<Visit> visitList;
	
	public XtwUser() {
		super();
	}
	public XtwUser(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Visit> getVisitList() {
		return visitList;
	}
	public void setVisitList(List<Visit> visitList) {
		this.visitList = visitList;
	}
	
}
