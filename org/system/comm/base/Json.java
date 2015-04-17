package system.comm.base;

/**
 * 
 * JSON模型
 * 
 * 用户后台向前台返回的JSON对象
 * 
 * @author zhouq
 * 
 */
public class Json implements java.io.Serializable {

	/**
	 * @author zhouq
	 * @create 2014年8月13日 上午11:15:15
	 */
	private static final long serialVersionUID = 1L;

	private boolean success = false;

	private String msg = "";

	private Object obj = null;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

}
