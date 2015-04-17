package system.entity.role;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import system.entity.resource.ResourceEntity;
import system.entity.user.UserEntity;

public class RoleEntity implements Serializable{
	
	/**
	 * @author zhouq
	 * @create 2014年8月13日 上午11:05:03
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String pid;
	private RoleEntity role;
	private String name;
	private String remark;
	private Integer seq;
	private Set<RoleEntity> roles = new HashSet<RoleEntity>(0);
	private Set<ResourceEntity> resources = new HashSet<ResourceEntity>(0);
	private Set<UserEntity> users = new HashSet<UserEntity>(0);
	
	private String resourceIds;//授权页面的菜单Ids 只做接收参数，不保存数据库
	private String resourceNames;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public RoleEntity getRole() {
		return role;
	}
	public void setRole(RoleEntity role) {
		this.role = role;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getSeq() {
		return seq;
	}
	public void setSeq(Integer seq) {
		this.seq = seq;
	}
	public Set<RoleEntity> getRoles() {
		return roles;
	}
	public void setRoles(Set<RoleEntity> roles) {
		this.roles = roles;
	}
	public Set<UserEntity> getUsers() {
		return users;
	}
	public void setUsers(Set<UserEntity> users) {
		this.users = users;
	}
	public Set<ResourceEntity> getResources() {
		return resources;
	}
	public void setResources(Set<ResourceEntity> resources) {
		this.resources = resources;
	}
	public String getResourceIds() {
		return resourceIds;
	}
	public void setResourceIds(String resourceIds) {
		this.resourceIds = resourceIds;
	}
	public String getResourceNames() {
		return resourceNames;
	}
	public void setResourceNames(String resourceNames) {
		this.resourceNames = resourceNames;
	}
	
}
