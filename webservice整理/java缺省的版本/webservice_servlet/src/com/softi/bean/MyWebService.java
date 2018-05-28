package com.softi.bean;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;


/**
 * 自定义的webservice 服务
 * @author Administrator
 *
 */
@WebService//默认静态的不能发布
public class MyWebService {

	public String sayHello(String name){
		
		return name + "你好！";
	}
	
	public static void main(String[] args) {
		//服务器地址
		String address = "http://192.168.0.98:8888/ws";
		//一个端口可以发布多个服，所以可以需要添加/ws;
		Endpoint.publish(address, new MyWebService());
		System.out.println("访问wsdl的地址为："+address+"?wsdl");
	}
	
	
}
