package xtw.book.map;

import org.apache.ibatis.annotations.Delete;

public interface InterfaceXtwUserMap {
	@Delete("delete from xtwUser where id=#{id}")
	public void deleteUser(Integer id);
}
