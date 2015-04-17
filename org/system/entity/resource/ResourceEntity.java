package system.entity.resource;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import system.entity.role.RoleEntity;

public class ResourceEntity implements Serializable{
	
	/**
	 * @author zhouq
	 * @create 2014年8月13日 上午11:05:03
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String pid;
	private ResourceEntity resource;
	private String name;
	private String remark;
	private Integer seq;
	private String url;
	private String imgurl;
	private Set<RoleEntity> roles = new HashSet<RoleEntity>(0);
	private Set<ResourceEntity> resources = new HashSet<ResourceEntity>(0);
	private List<ResourceEntity> children = new ArrayList<ResourceEntity>();
	
	private int subCount;//子菜单总数
	
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
	public ResourceEntity getResource() {
		return resource;
	}
	public void setResource(ResourceEntity resource) {
		this.resource = resource;
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Set<RoleEntity> getRoles() {
		return roles;
	}
	public void setRoles(Set<RoleEntity> roles) {
		this.roles = roles;
	}
	public Set<ResourceEntity> getResources() {
		return resources;
	}
	public void setResources(Set<ResourceEntity> resources) {
		this.resources = resources;
	}
	public int getSubCount() {
		return subCount;
	}
	public void setSubCount(int subCount) {
		this.subCount = subCount;
	}
	public List<ResourceEntity> getChildren() {
		return children;
	}
	public void setChildren(List<ResourceEntity> children) {
		this.children = children;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
}
