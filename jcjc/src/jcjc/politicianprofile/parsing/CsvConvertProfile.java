package jcjc.politicianprofile.parsing;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CsvConvertProfile extends XmlParsingPolitician{

//	public int csvConvertPolitician() throws IOException {
//
//		Document document = Jsoup.parse(new File("C:\\Project\\jcjc\\WebContent\\WEB-INF\\XmlParsing\\politicianXml\\politician_step1.xml"), "UTF-8");
//		Elements elements = document.select("item");
//		
//		Pattern pattern = Pattern.compile("[\\/\\,\\\"\\.\\?\\!\\#\\%\\^\\&\\*\\[\\]\\{\\}\\|\\t\\n\\;\\:\\+\\`\\~\\(\\)]");
//		Pattern homep_pattern = Pattern.compile("[\\,\\\"\\?\\!\\#\\%\\^\\&\\*\\[\\]\\{\\}\\|\\t\\n\\;\\:\\+\\`\\~\\(\\)]");
//		String politician = "";
//		
//		// csv 파일 만드는 코드
////		politician += "deptCd, num, empNm, hjNm, engNm, reeleGbnNm, origNm, jpgLink\n";
//		
//		for(Element res : elements) {
//			
//			politician+=pattern.matcher(res.select("deptCd").text().trim()).replaceAll("") + ",";
//			politician+=pattern.matcher(res.select("num").text().trim()).replaceAll("") + ",";
//			politician+=pattern.matcher(res.select("empNm").text().trim()).replaceAll("") + ",";
//			politician+=pattern.matcher(res.select("hjNm").text().trim()).replaceAll("") + ",";
//			politician+=pattern.matcher(res.select("engNm").text().trim()).replaceAll("") + ",";
//			politician+=pattern.matcher(res.select("reeleGbnNm").text().trim()).replaceAll("") + ",";
//			politician+=pattern.matcher(res.select("origNm").text().trim()).replaceAll("") + ",";
//			politician+=homep_pattern.matcher(res.select("jpgLink").text().trim()).replaceAll("") + "\n";
//
//		}
//		
//		InputStream is = new ByteArrayInputStream(politician.getBytes(StandardCharsets.UTF_8));
//		FileOutputStream fos = new FileOutputStream("C:\\Project\\jcjc\\WebContent\\WEB-INF\\XmlParsing\\politicianCsv\\politician_step1.csv"); // csv
//		
//		int line = 0;
//		int count = 0;
//		
//		while((line = is.read()) != -1) {
//			fos.write(line);
//		}
//		
//		is.close();
//		fos.close();
//		
//		count+=1;
//		
//		System.out.println("완성 파일 번호 : " + count);
//		System.out.println(politician);
//		politician="";
//		
//		return count;
//	}
	
	public int csvConvertPoliticianProfile() throws IOException {
		
		HashMap<String, String> list = (HashMap<String, String>) new XmlParsingPolitician().getMapList();
		Set<Entry<String, String>> set = list.entrySet();
		Iterator<Entry<String, String>> iterator = set.iterator();

		int count = 0;

		while (iterator.hasNext()) {

			Entry<String, String> entry = iterator.next();
			String dept_cd = entry.getKey();
		
			Document document = Jsoup.parse(new File("C:\\Project\\jcjc\\WebContent\\WEB-INF\\XmlParsing\\politicianXml\\politician_step2_"+dept_cd+".xml"), "UTF-8");
			
			Elements elements = document.select("item");

//			\\&amp;\\lt;\\&gt;
			Pattern pattern = Pattern.compile("[\\/\\,\\\"\\.\\?\\!\\#\\%\\^\\&\\*\\[\\]\\{\\}\\|\\t\\n\\;\\:\\+\\`\\~\\(\\)]");
			Pattern homep_pattern = Pattern.compile("[\\,\\\"\\?\\!\\#\\%\\^\\&\\*\\[\\]\\{\\}\\|\\t\\n\\;\\:\\+\\`\\~\\(\\)]");
			Pattern email_pattern = Pattern.compile("[\\/\\,\\\"\\?\\!\\#\\%\\^\\&\\*\\[\\]\\{\\}\\|\\t\\n\\;\\:\\+\\`\\~\\(\\)]");
			String profile = "";
			
			// csv 파일 만드는 코드
//			profile += "empNm, hjNm, engNm, bthDate, polyNm, origNm, shrtNm, reeleGbnNm, electionNum, assemTel, assemHomep, assemEmail, hbbyCd, examCd\n";
			
			for(Element res : elements) {
				
				profile+=pattern.matcher(res.select("empNm").text().trim()).replaceAll("") + ",";
				profile+=pattern.matcher(res.select("hjNm").text().trim()).replaceAll("") + ",";
				profile+=pattern.matcher(res.select("engNm").text().trim()).replaceAll("") + ",";
				profile+=pattern.matcher(res.select("bthDate").text().trim()).replaceAll("") + ",";
				profile+=pattern.matcher(res.select("polyNm").text().trim()).replaceAll("") + ",";
				profile+=pattern.matcher(res.select("origNm").text().trim()).replaceAll("") + ",";
				profile+=pattern.matcher(res.select("shrtNm").text().trim()).replaceAll("") + ",";
				profile+=pattern.matcher(res.select("reeleGbnNm").text().trim()).replaceAll("") + ",";
				profile+=pattern.matcher(res.select("electionNum").text().trim()).replaceAll(" ") + ",";
				profile+=pattern.matcher(res.select("assemTel").text().trim()).replaceAll("") + ",";
				profile+=homep_pattern.matcher(res.select("assemHomep").text().trim()).replaceAll("") + ",";
				profile+=email_pattern.matcher(res.select("assemEmail").text().trim()).replaceAll("") + ",";
				profile+=pattern.matcher(res.select("hbbyCd").text().trim()).replaceAll("") + ",";
				profile+=pattern.matcher(res.select("examCd").text().trim()).replaceAll("") + "\n";
	
			}
			
			InputStream is = new ByteArrayInputStream(profile.getBytes(StandardCharsets.UTF_8));
			FileOutputStream fos = new FileOutputStream("C:\\Project\\jcjc\\WebContent\\WEB-INF\\XmlParsing\\politicianCsv\\politician_step2_"+dept_cd+".csv"); // csv
			
			int line = 0;
			
			while((line = is.read()) != -1) {
				fos.write(line);
			}
			is.close();
			fos.close();
			
			count+=1;
			
			System.out.println("완성 파일 번호 : " + count);
			System.out.println(profile);
			profile="";
		}
		
		return count;
	}
	
	public static void main(String[] args) throws IOException {
		
		CsvConvertProfile csvConvertProfile= new CsvConvertProfile();
		
		int res = csvConvertProfile.csvConvertPoliticianProfile();
		
		if(res>0) {
			System.out.println("[csvConvertPoliticianProfile] : "+res+"개 완료!");
		} else {
			System.out.println("csvConvertPoliticianProfile error!");
		}
	}
}
