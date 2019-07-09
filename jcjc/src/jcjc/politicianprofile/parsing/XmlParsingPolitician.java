package jcjc.politicianprofile.parsing;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class XmlParsingPolitician {

	public void xmlParsingStep1() throws IOException {
		
		Document temp_document = Jsoup.connect("http://apis.data.go.kr/9710000/NationalAssemblyInfoService/getMemberCurrStateList"
				+ "?numOfRows=300"
				+ "&servicekey=Qdb5KydABzjhFWA4CzQ4gSgtLMnxo6C5jGrv%2FOLaQ6evALcjMQDkPllXowGQzr9DzraCGymtgDwuQmge6QJzng%3D%3D").get();
		
		String temp_count = temp_document.select("totalCount").text();
		int count = (Integer.parseInt(temp_count)/100) + 1;
		
		//xml을 바로 파싱해서 전달하고 싶은때는 Jsoup.parse() 메소드를 이용한다
		//toString 으로 전달하면 태그 검색이 안됨
		
		for(int i =1 ;i<count+1 ;i++ ) {
			Document document = Jsoup.connect("http://apis.data.go.kr/9710000/NationalAssemblyInfoService/getMemberCurrStateList"
					+ "?numOfRows=300"
					+ "&servicekey=Qdb5KydABzjhFWA4CzQ4gSgtLMnxo6C5jGrv%2FOLaQ6evALcjMQDkPllXowGQzr9DzraCGymtgDwuQmge6QJzng%3D%3D").get();
			
			String xml = document.toString();
			
			InputStream is = new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8));
			
			FileOutputStream fos = new FileOutputStream("C:\\Project\\jcjc\\WebContent\\WEB-INF\\XmlParsing\\politicianXml\\politician_step1.xml");
			
			int r = 0;
			while((r=is.read())!=-1) {
				fos.write(r);
			}
			is.close();
			fos.close();
		
		}
		System.out.println("완료!");
		
	}
	
	// 정치인 deptCd, num를 HashMap으로 관리하는 메소드
	public Map<String, String> getMapList() throws IOException {

		Document doc = Jsoup.parse(
				new File("C:\\Project\\jcjc\\WebContent\\WEB-INF\\XmlParsing\\politicianXml\\politician_step1.xml"), "UTF-8");

		Map<String, String> map = new HashMap<String, String>();

		Elements item = doc.select("item");

		for (Element element : item) {

			map.put(element.select("deptCd").text().trim(), element.select("num").text().trim());
		}

		return map;

	}
	
	public int xmlParsingStep2() throws IOException {
		
		HashMap<String, String> list = (HashMap<String, String>) new XmlParsingPolitician().getMapList();

		System.out.println(list.size());
		System.out.println(list);

		Set<Entry<String, String>> set = list.entrySet();

		Iterator<Entry<String, String>> iterator = set.iterator();

		int count = 0;

		while (iterator.hasNext()) {

			Entry<String, String> entry = iterator.next();
			
			String dept_cd = entry.getKey();
			String num = entry.getValue();
			
			// xml을 바로 파싱해서 전달하고 싶은때는 Jsoup.parse() 메소드를 이용한다
			// toString 으로 전달하면 태그 검색이 안됨

			Document document = Jsoup
					.connect("http://apis.data.go.kr/9710000/NationalAssemblyInfoService/getMemberDetailInfoList"
							+ "?dept_cd=" + dept_cd
							+ "&num=" + num
							+ "&servicekey=Qdb5KydABzjhFWA4CzQ4gSgtLMnxo6C5jGrv%2FOLaQ6evALcjMQDkPllXowGQzr9DzraCGymtgDwuQmge6QJzng%3D%3D").get();

			String xml = document.toString();

			InputStream is = new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8));

			FileOutputStream fos = new FileOutputStream(
					"C:\\Project\\jcjc\\WebContent\\WEB-INF\\XmlParsing\\politicianXml\\politician_step2_"+dept_cd+".xml");

			int r = 0;
			while ((r = is.read()) != -1) {
				
				fos.write(r);
				
			}
			
			is.close();
			fos.close();
			
			count++;
			System.out.println("[" + count + "] : "+dept_cd+"완료!");
		}
		
		return count;
	}

	public static void main(String[] args) throws IOException {

		XmlParsingPolitician xmlParsingStep2 = new XmlParsingPolitician();
		
		xmlParsingStep2.xmlParsingStep1();
		int res = xmlParsingStep2.xmlParsingStep2();
		
		if(res>0) {
			System.out.println("[xmlParsingStep2 : ]"+res+"개 완료!");
		} else {
			System.out.println("xmlParsingStep2 error!");
		}
	}
}
