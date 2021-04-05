package mapper;

//package com.laptrinhjavaweb.mapper;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import com.laptrinhjavaweb.model.RoleModel;
//import com.laptrinhjavaweb.model.UserModel;
//
//public class UserMapper implements RowMapper<UserModel> {
//
//	@Override
//	public UserModel mapRow(ResultSet resultSet) {
//		try {
//			UserModel user = new UserModel();
//			user.setId(resultSet.getLong("id"));
//			user.setUserName(resultSet.getString("username"));
//			user.setFullName(resultSet.getString("fullname"));
//			user.setPassword(resultSet.getString("password"));
//			user.setStatus(resultSet.getInt("status"));
//			user.setRoleId(resultSet.getLong("roleId"));
//			user.setCreatedBy(resultSet.getString("createdby"));
//			user.setCreatedDate(resultSet.getTimestamp("createddate"));
//			if(resultSet.getTimestamp("modifieddate") != null) {
//				user.setModifiedDate(resultSet.getTimestamp("modifieddate"));
//			}
//			if(resultSet.getString("modifiedby") != null) {
//				user.setModifiedBy(resultSet.getString("modifiedby"));
//			}
//			try {
//				RoleModel role = new RoleModel();
//				role.setCode(resultSet.getString("code"));
//				role.setName(resultSet.getString("name"));
//				user.setRole(role);
//			} catch (Exception e) {
//				System.out.println(e.getMessage());
//			}
//			return user;
//		} catch (SQLException e) {
//			return null;
//		}
//	}
//}
