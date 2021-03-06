package com.softi.controller;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Paragraph;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.hwpf.usermodel.Table;
import org.apache.poi.hwpf.usermodel.TableCell;
import org.apache.poi.hwpf.usermodel.TableIterator;
import org.apache.poi.hwpf.usermodel.TableRow;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.mybatis.generator.config.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.softi.bean.Msg;
import com.softi.bean.Person;
import com.softi.bean.WordGenerator;
import com.softi.bean.WordImport;
import com.softi.service.PersonService;
import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;


@Controller
@RequestMapping("/person")
public class PersonController {

	@Autowired
	PersonService personService;
		
	@RequestMapping("/list")
	public String getPersonList(@RequestParam(value="pn",defaultValue="1")Integer pn, Model model){				
		List<Person> person = personService.getAllPerson();		
		model.addAttribute("personlist",person);
		return "list";
	}
	
	//excel 导出
	@RequestMapping("/excel")
	public void getexcelList(@RequestParam(value="pn",defaultValue="1")Integer pn, Model model){				
		System.out.println("----------------");
		List<Person> person = personService.getAllPerson();		
		//创建HSSFWorkbook对象
		HSSFWorkbook wb = new HSSFWorkbook();
			HSSFSheet createSheet = wb.createSheet("sheet01");
			//设置所有单元格的行高和列宽
			/*createSheet.setDefaultRowHeightInPoints(20);
			createSheet.setDefaultColumnWidth(20);*/
			
			//createSheet.setColumnWidth(0, 256 * 50);//设置单独的列的宽
			HSSFCellStyle createCellStyle = wb.createCellStyle();//设置单元格的格式
			createCellStyle.setAlignment(HSSFCellStyle.ALIGN_JUSTIFY);
			createCellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			
			//创建HSSFCell对象
			HSSFRow createRow = createSheet.createRow(2);
			HSSFCell createCell = createRow.createCell(2);
			createSheet.addMergedRegion(new CellRangeAddress(1,1,0,2));//合并单元格
			//设置单元格的值
			createCell.setCellValue("单元格中的中文");
			
			
			
			FileOutputStream output = null;
			try {
				output=new FileOutputStream("d:\\workbook.xls");
				wb.write(output);
				output.flush();
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				
				try {
					wb.close();
					output.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
	}
	
	//excel 导入
	@RequestMapping("/exceldr")
	public void excledr(){
		try {
			FileInputStream fileIn = new FileInputStream("d:\\workbook.xls");
			//根据指定的文件输入流导入Excel从而产生Workbook对象
			Workbook wb0 = new HSSFWorkbook(fileIn);
			//获得的excle的第一个表单
			Sheet sht0 = wb0.getSheetAt(0);
			Row row = sht0.getRow(2);
			Cell cell = row.getCell(2);
			String stringCellValue = cell.getStringCellValue();
		System.out.println(stringCellValue+"------");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	
	//word文档的导出
	@RequestMapping("/word")
	public void createDoc(){
		Map<String,Object> map  = new HashMap<String,Object>();
		map.put("name", "刘备");
		map.put("pone", "1233445");
		WordGenerator.createDoc(map, "word");	
	}
	
	//word文档导入
	@RequestMapping("/worddr")
	    public void testWord(String filePath){  
			 filePath = "d:\\ccccccworkbook.docx";
			 List wordIn = WordImport.wordIn(filePath);
			 for (int i = 0; i < wordIn.size(); i++) {
				System.out.println(wordIn.get(i)+"-----");
			}	        
	    }  
	
	
	
	
}
