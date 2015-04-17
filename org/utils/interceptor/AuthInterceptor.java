package utils.interceptor;

import java.net.URLEncoder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import system.entity.user.UserEntity;



/**
 * 权限拦截器
 * @author  www.jeecg.org
 *
 */
public class AuthInterceptor extends HandlerInterceptorAdapter {
	
	private final static Logger log= Logger.getLogger(AuthInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		HandlerMethod method = (HandlerMethod)handler;
		Auth  auth = method.getMethod().getAnnotation(Auth.class);
		String baseUri = request.getContextPath();
		
		////验证登陆超时问题  auth = null，默认验证 
		if( auth != null && auth.verifyLogin()){
			String path = request.getServletPath();
			UserEntity user =SessionUtils.getUser(request);
			
			if(user  == null){
				if(path.endsWith(".shtml") || path.endsWith(".do")){
					String msg = URLEncoder.encode("请先登录！！","UTF-8"); //解决乱码问题
					String backUrl = "index.jsp";  //需要返回的页面
					String url = baseUri+"/loginController.do?error&msg=" + msg + "&herf=" + backUrl; //重定向url
					response.sendRedirect(url);
					return false;
				}/*else{
					response.setStatus(HttpServletResponse.SC_GATEWAY_TIMEOUT);
					Map<String, Object> result = new HashMap<String, Object>();
					result.put(BaseAction.SUCCESS, false);
					result.put(BaseAction.LOGOUT_FLAG, true);//登录标记 true 退出
					result.put(BaseAction.MSG, "登录超时.");
					HtmlUtil.writerJson(response, result);
					return false;
				}*/
			}
		}
		//验证URL权限
/*		if( auth == null || auth.verifyURL()){		
			
			if(SessionUtils.isNotNull(request)){
				String menuUrl = StringUtils.remove( request.getRequestURI(),request.getContextPath());;
				if(!SessionUtils.isAccessUrl(request, StringUtils.trim(menuUrl))){					
					//日志记录
					String userName = SessionUtils.getUser(request).getName();
					String msg = URLEncoder.encode("没有权限访问:[url="+menuUrl+"][账号 ="+ userName+"]","UTF-8"); //解决乱码问题
					log.error(msg);
					response.sendRedirect(baseUri+"/loginController.do?main&msg=" + msg);
					return false;
				}
			}
		}*/
		return super.preHandle(request, response, handler);
	}

	
}
