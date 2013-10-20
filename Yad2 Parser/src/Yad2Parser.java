import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.io.ObjectInputStream.GetField;
import java.nio.charset.Charset;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Yad2Parser {

	public static String getInfo(Document doc, String title) {

		Elements els = doc.getElementsContainingOwnText(title);
		String info = "";
		if(!els.isEmpty()){
			info = els.get(0).nextElementSibling().text();
		} 
		return info.replace("\"", "\\\"");
		
	}
	
	public static String getSuroundingInfo(Document doc, String title) {

		Elements els = doc.getElementsContainingOwnText(title);
		String info = "";
		if(!els.isEmpty()){
			info = els.get(0).parent().text();
		}
		return info.replace("\"", "''");
		
	}
	



	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			File input = new File("/home/jvalansi/Downloads/yad2.html");
			PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("yad2csv.txt",true)));
			Document doc = Jsoup.parse(input, "windows-1255", "http://example.com/");
			Element el = doc.getElementById("wrapperDetails");
			writer.print("\"\",");
			writer.print("\""+getInfo(doc, "איש קשר:")+"\", ");
			writer.print("\"\",");
			writer.print("\""+getInfo(doc, "טלפון 1:")+"\n"+getInfo(doc, "טלפון 2")+"\", ");
			writer.print("\""+getInfo(doc, "מחיר :")+"\", ");
			writer.print("\""+getSuroundingInfo(doc, "ארנונה לחודשיים:")+"\", ");
			writer.print("\""+getSuroundingInfo(doc, "תשלום לועד בית:")+"\", ");
			writer.print("\""+getInfo(doc, "חדרים:")+"\", ");
			writer.print("\""+getInfo(doc, "כתובת:")+"\", ");
			writer.print("\""+getInfo(doc, "מיזוג:")+"\", ");
			writer.print("\""+getInfo(doc, "קומה:")+"\", ");
			writer.print("\""+getSuroundingInfo(doc, "תוספות:")+"\", ");
			writer.println();
//			System.out.println(els);
			writer.close();
					
		} catch (IOException e) {
			e.printStackTrace();
		}

//		try {
//			File fileDir = new File("/home/jvalansi/Downloads/yad2.html");
//	 
//			BufferedReader in = new BufferedReader(
//			   new InputStreamReader(
//	                      new FileInputStream(fileDir), "windows-1255"));
//
//			PrintStream pout = new PrintStream(System.out, true, "windows-1255");
//			
//			File fileOut = new File("test.txt");
//			 
//			Writer wout = new BufferedWriter(new OutputStreamWriter(
//				new FileOutputStream(fileOut), "windows-1255"));
//	 
//	 
//			String str;
//			while ((str = in.readLine()) != null) {
//			    pout.println(str);
//			    wout.append(str).append("\r\n");
//
//
//			}
//	 
//			in.close();
//				 
//			wout.flush();
//			wout.close();
//
//		} 
//		catch (UnsupportedEncodingException e) 
//		{
//			System.out.println(e.getMessage());
//		} 
//		catch (IOException e) 
//		{
//			System.out.println(e.getMessage());
//		}
//		catch (Exception e)
//		{
//			System.out.println(e.getMessage());
//		}
	}

}
