package com.laptrinhjavaweb.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.laptrinhjavaweb.dao.IUserDAO;
import com.laptrinhjavaweb.mapper.UserMapper;
import com.laptrinhjavaweb.model.UserModel;
import com.laptrinhjavaweb.paging.Pageable;

public class UserDAO extends AbstractDAO<UserModel>implements IUserDAO {

	@Override
	public UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status) {
		StringBuilder sql= new StringBuilder("SELECT * FROM user AS u");
		sql.append(" INNER JOIN role AS r ON r.id = u.roleid");
		sql.append(" WHERE username=? AND password=? AND status=?");
		List<UserModel> users =query(sql.toString(), new UserMapper(), userName,password,status);
		return users.isEmpty() ? null : users.get(0);
	}	

	@Override
	public Long save(UserModel userModel) {
		StringBuilder sql = new StringBuilder("INSERT INTO user(username,fullname,");
		sql.append("password,status,roleid,createddate,createdby)");
		sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?)");
		return insert(sql.toString(),userModel.getUserName(),userModel.getFullName(),
				userModel.getPassword(),userModel.getStatus(),userModel.getRoleId(),userModel.getCreatedDate(),userModel.getCreatedBy());
	}

	@Override
	public void delete(long id) {
		String sql="DELETE FROM user WHERE  id = ? ";
		update(sql, id);
	}

	@Override
	public List<UserModel> findAll(Pageable pageable) {
		StringBuilder sql = new StringBuilder("SELECT * FROM user");
		if(pageable.getSorter() != null && StringUtils.isNotBlank(pageable.getSorter().getSortName()) && StringUtils.isNotBlank(pageable.getSorter().getSortBy())) {
			sql.append(" ORDER BY "+pageable.getSorter().getSortName()+" "+pageable.getSorter().getSortBy());
		}
		if(pageable.getOffset() != null && pageable.getLimit() != null) {
			sql.append(" LIMIT "+pageable.getOffset()+", "+pageable.getLimit());
		}
		return query(sql.toString(), new UserMapper());
	}

	@Override
	public int getTotalItem() {
		String sql = "SELECT COUNT(*) FROM user";
		return count(sql);
	}

	@Override
	public UserModel findOne(long id) {
		String sql = "SELECT * FROM user WHERE id=?";
		List<UserModel> users = query(sql, new UserMapper(), id);
		return users.isEmpty() ? null : users.get(0);
	}

	@Override
	public void update(UserModel updateUser) {
		StringBuilder sql = new StringBuilder("UPDATE user SET username = ? , fullname = ? , password = ? ,");
		sql.append(" status = ? ,");
		sql.append(" createddate = ? , createdby = ?,modifieddate=?,modifiedby=? WHERE id = ?");
		update(sql.toString(),updateUser.getUserName(),updateUser.getFullName(),updateUser.getPassword(),
				updateUser.getStatus(),updateUser.getCreatedDate(),updateUser.getCreatedBy(),
				updateUser.getModifiedDate(),updateUser.getModifiedBy(),updateUser.getId());
	}

	@Override
	public UserModel findByUserName(String userName) {
		String sql = "SELECT * FROM user WHERE username=?";
		List<UserModel> users = query(sql, new UserMapper(), userName);
		return users.isEmpty() ? null : users.get(0);
	}
}
