package system.comm.utils;


import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class HttpClientUtil {
	private String  URL;
	
	private String content_Type="application/json;utf-8";
	private String encoded="utf-8";
	public HttpClientUtil(String URL){
		this.URL=URL;
	}
	
	/**
	 * 读取内容
	 * @param url
	 * @return
	 * 		URL包含的资源
	 */
	public  String excuteGet(){
		try {
			HttpClient httpclient = new DefaultHttpClient();
			HttpGet httpGet=new HttpGet(URL);
			httpGet.addHeader("Content-Type",content_Type); 
			httpGet.addHeader("Accept-Language", "zh-cn");
			httpGet.addHeader("Accept-Encoding", "gzip, deflate");
			HttpResponse response = httpclient.execute(httpGet);
			HttpEntity entity = response.getEntity();
			return EntityUtils.toString(entity,encoded);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 读取内容
	 * @param url
	 * @return
	 * 		URL包含的资源
	 */
	public  String excutePost(String params){
		try {
			System.out.println("body为:"+params);
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httpPost=new HttpPost(URL);
            httpPost.addHeader("Content-Type", content_Type); 
            httpPost.addHeader("Accept-Language", "zh-cn");
            httpPost.addHeader("Accept-Encoding", "gzip, deflate");
            StringEntity reqEntity = new StringEntity(params,"UTF-8");
            reqEntity.setContentType("text/html;charset=utf-8");
        	httpPost.setEntity(reqEntity);
			HttpResponse response = httpclient.execute(httpPost);
			response.addHeader("Accept-Language", "zh-cn");
			response.addHeader("Content-Type", content_Type); 
			HttpEntity entity = response.getEntity();
			
			return EntityUtils.toString(entity,encoded);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 读取内容
	 * @param url
	 * @return
	 * 		URL包含的资源
	 */
	public  String excutePut(String params){
		try {
			HttpClient httpclient = new DefaultHttpClient();
			HttpPut httpPut=new HttpPut(URL);
			httpPut.addHeader("Content-Type", content_Type); 
			httpPut.addHeader("Accept-Language", "zh-cn");
			httpPut.addHeader("Accept-Encoding", "gzip, deflate");
            StringEntity reqEntity = new StringEntity(params,"UTF-8");
            reqEntity.setContentType("text/html;charset=utf-8");
			httpPut.setEntity(reqEntity);
			HttpResponse response = httpclient.execute(httpPut);
			response.addHeader("Accept-Language", "zh-cn");
			response.addHeader("Content-Type", content_Type); 
			HttpEntity entity = response.getEntity();
			return EntityUtils.toString(entity,encoded);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 读取内容
	 * @param url
	 * @return
	 * 		URL包含的资源
	 */
	public  String excuteDelete(){
		try {
			HttpClient httpclient = new DefaultHttpClient();
			HttpUriRequest httpUriRequest=new HttpDelete(URL);
			HttpResponse response = httpclient.execute(httpUriRequest);
			HttpEntity entity = response.getEntity();
			return EntityUtils.toString(entity,encoded);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}

	public String getContent_Type() {
		return content_Type;
	}

	public void setContent_Type(String content_Type) {
		this.content_Type = content_Type;
	}

	public String getEncoded() {
		return encoded;
	}

	public void setEncoded(String encoded) {
		this.encoded = encoded;
	}
}
