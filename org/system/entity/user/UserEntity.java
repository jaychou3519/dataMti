package system.entity.user;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import system.entity.role.RoleEntity;

public class UserEntity implements Serializable{
	
	/**
	 * @author zhouq
	 * @create 2014年8月13日 上午11:05:03
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private Date createtime;
	private Date updatetime;
	private String name;
	private String pwd;
	private Integer type;//用户类型【0：超级管理员，1：普通成员】
	
	private Set<RoleEntity> roles = new HashSet<RoleEntity>(0);
	
	//授权页面的角色Ids 只做接收参数，不保存数据库
	private String roleIds;
	private String roleNames;

	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public Date getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	public Set<RoleEntity> getRoles() {
		return roles;
	}
	public void setRoles(Set<RoleEntity> roles) {
		this.roles = roles;
	}
	public String getRoleIds() {
		return roleIds;
	}
	public void setRoleIds(String roleIds) {
		this.roleIds = roleIds;
	}
	public String getRoleNames() {
		return roleNames;
	}
	public void setRoleNames(String roleNames) {
		this.roleNames = roleNames;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	
	
}
