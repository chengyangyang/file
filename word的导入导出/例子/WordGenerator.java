package com.softi.bean;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * word 的导出
 * @author cyy
 *
 */
public class WordGenerator {

	private static Configuration configuration = null;
	private static Map<String,Template> allTemplates = null;
	
	static {
		configuration = new Configuration();
		configuration.setDefaultEncoding("utf-8");
		configuration.setClassForTemplateLoading(WordGenerator.class, "/com/word");//模板路径
		allTemplates = new HashMap<String, Template>();
		try {
			allTemplates.put("word", configuration.getTemplate("word.ftl"));//模板路径
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static File createDoc(Map<?,?>dataMap, String type){
		String name = "d:\\ccccccworkbook.doc";
		File f = new File(name);
		Template t = allTemplates.get(type);
		//这个地方不能使用filewriter，要指定编码的类型
	Writer w;
	try {
		w = new OutputStreamWriter(new FileOutputStream(f),"utf-8");
		t.process(dataMap, w);
		w.close();
	} catch (UnsupportedEncodingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (TemplateException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}		
	return f ;
	}
	
	
}
