package com.ch.bean;

import java.io.File;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
/**
 * 
 * 本次测试时将xml的内容打印在控制器中，（根节点没有做处理）
 */
import org.dom4j.io.SAXReader;

public class XmlUtil {

	private static SAXReader saxreader;
	private static int num = 0;

	static {
		saxreader = new SAXReader();
	}

	public static void getXmlContext(String url) {
		try {
			Document document = saxreader.read(new File(url));
			Element rootElement = document.getRootElement();// 得到根节点
			String rootname = rootElement.getName();
			getStyleElement(rootElement, rootname);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void getStyleElement(Element rootElement, String rootname) {
		List elements = rootElement.elements();
		if (!elements.isEmpty()) {
			num++;
			for (int i = 0; i < elements.size(); i++) {
				Element object = (Element) elements.get(i);
				String st = "";
				// 拼接节点的空格
				for (int j = 0; j < num - 1; j++) {
					st += "	";
				}
				String attr = "";// 定义节点的属性进行拼接
				// 获得节点的属性
				List attributes = object.attributes();
				for (int j = 0; j < attributes.size(); j++) {
					Attribute object2 = (Attribute) attributes.get(j);
					object2.getName();
					object2.getValue();
					String attr01 = "  " + object2.getName() + "=" + object2.getValue();
					attr += attr01;
				}

				System.out.println(st + "<" + object.getName() + attr + ">");// 获得节点的名称和所有的属性
				// System.out.println("afasdf"+object.getNamespacePrefix());//得到节点的前缀
				// System.out.println("chan"+object.getStringValue().replaceAll("\\s*",
				// ""));//将大片空格全部替换为""
				if (object.elements().size() == 0 && !object.getStringValue().replaceAll("\\s*", "").equals("")) {
					System.out.println(st + object.getStringValue());// 获得节点的值
					System.out.println(st + "<" + object.getName() + " />");
				}
				getStyleElement(object, rootname);
				Element parent = object.getParent();
				if (parent.getName().equals(rootname)) {
					num = 1;
					System.out.println();
				}

			}

		}

	}

}
