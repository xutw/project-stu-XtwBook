package xtw.book.pojo;
/*
 * 作者表，注意xtwUser的引用
 * @author xutw
 */
public class Author {
	private Integer id; 	//自增主键
	private XtwUser xtwUser; //外键引用XtwUser表
	private String realName;//真实姓名
	private String IDCard;	//身份证
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public XtwUser getXtwUser() {
		return xtwUser;
	}
	public void setXtwUser(XtwUser xtwUser) {
		this.xtwUser = xtwUser;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getIDCard() {
		return IDCard;
	}
	public void setIDCard(String iDCard) {
		IDCard = iDCard;
	}
	
}
