package common.webservice.entity;


import javax.xml.bind.annotation.XmlRootElement;

/**
 * 接口返回数据库格式
 * @author zhouq
 * @create 2014年7月7日 上午10:02:59
 */
@XmlRootElement(name = "jsonMap")
public class JsonMap implements java.io.Serializable {

	/**
	 * @author zhouq
	 * @create 2014年7月7日 上午10:03:11
	 */
	private static final long serialVersionUID = 1L;

	private String code;
	private String msg = "";
	private Object body = null;


	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getBody() {
		return body;
	}

	public void setBody(Object body) {
		this.body = body;
	}



}
