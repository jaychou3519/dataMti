package system.entity.role;

public class RoleAndResource implements java.io.Serializable {

	/**
	 * @author zhouq
	 * @create 2014年8月19日 上午10:28:00
	 */
	private static final long serialVersionUID = 1L;
	private String roleId;
	private String resourceId;
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getResourceId() {
		return resourceId;
	}
	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}


}
