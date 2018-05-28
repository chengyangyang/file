package com.softi.ws;
/**
 * 调用自己发送的ws服务
 * @author Administrator
 *
 */
public class Main {

	public static void main(String[] args) {
		//获取websevice的服务名称
		MyWebServiceService service = new MyWebServiceService();
		//获取服务的类型
		MyWebService port = service.getMyWebServicePort();
		//调用服务提供的方法
		System.out.println(port.sayHello("hello"));
	}
}
