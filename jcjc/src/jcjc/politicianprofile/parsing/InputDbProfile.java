package jcjc.politicianprofile.parsing;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.ibatis.annotations.Param;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import au.com.bytecode.opencsv.CSVReader;
import jcjc.politicianprofile.dao.PoliticianProfileDaoImpl;
import jcjc.politicianprofile.entity.PoliticianProfileEntity;

public class InputDbProfile extends XmlParsingPolitician {

//	// Politician table insert
//	public int inputDbPolitician() throws IOException {
//
//		PoliticianProfileDaoImpl dao = new PoliticianProfileDaoImpl();
//		
//		CSVReader csvReader = new CSVReader(new FileReader(
//				new File("C:\\Project\\jcjc\\WebContent\\WEB-INF\\XmlParsing\\politicianCsv\\politician_step1.csv")));
//
//		String[] line;
//		
//		int count = 0;
//		
//		while ((line = csvReader.readNext()) != null) {
//
//			Politician entity = new Politician(Integer.parseInt(line[0]), line[1], line[2], line[3],
//					line[4], line[5], line[6], line[7]);
//
//			System.out.println(entity);
//
//			int res = dao.insertPolitician(entity);
//			if (res > 0) {
//
//				count++;
//				System.out.println("현재 " + count + "개 완료!");
//			}
//		}
//		
//		return 0;
//	}

	public int deletePolitician() {

		PoliticianProfileDaoImpl dao = new PoliticianProfileDaoImpl();

		int res = dao.deleteProfile();

		if (res > 0) {
			System.out.println("delete 성공!");
		} else {
			System.out.println("delete error");
		}
		return res;
	}

	// PoliticianProfile insert
	public int inputDbPoliticianProfile() throws IOException {

		PoliticianProfileDaoImpl dao = new PoliticianProfileDaoImpl();

		HashMap<String, String> list = (HashMap<String, String>) new XmlParsingPolitician().getMapList();
		Set<Entry<String, String>> set = list.entrySet();
		Iterator<Entry<String, String>> iterator = set.iterator();

		int count = 0;

		while (iterator.hasNext()) {

			Entry<String, String> entry = iterator.next();
			System.out.println(entry);
			String dept_cd = entry.getKey();

			CSVReader csvReader = new CSVReader(new FileReader(
					new File("C:\\Project\\jcjc\\WebContent\\WEB-INF\\XmlParsing\\politicianCsv\\politician_step2_"
							+ dept_cd + ".csv")));

			String[] line;

			while ((line = csvReader.readNext()) != null) {

//				politician_no number,
//				politician_num number,
//				politician_kor_name varchar2(1000),
//				politician_hj_name varchar2(1000),
//				politician_eng_name varchar2(1000),
//				bth_date date,
//				poly_name varchar2(1000),
//				orig_name varchar2(1000),
//				shrt_name varchar2(1000),
//				reele_gbn_name varchar2(1000),
//				election_name varchar2(1000),
//				assem_tel varchar2(1000),
//				assem_homep varchar2(1000),
//				assem_email varchar2(1000),
//				hbby_cd varchar2(1000),
//				exam_cd varchar2(1000),
//				politician_jpg_link varchar2(1000)
				
//				profile+=pattern.matcher(res.select("empNm").text().trim()).replaceAll("") + ",";
//				profile+=pattern.matcher(res.select("hjNm").text().trim()).replaceAll("") + ",";
//				profile+=pattern.matcher(res.select("engNm").text().trim()).replaceAll("") + ",";
//				profile+=pattern.matcher(res.select("bthDate").text().trim()).replaceAll("") + ",";
//				profile+=pattern.matcher(res.select("polyNm").text().trim()).replaceAll("") + ",";
//				profile+=pattern.matcher(res.select("origNm").text().trim()).replaceAll("") + ",";
//				profile+=pattern.matcher(res.select("shrtNm").text().trim()).replaceAll("") + ",";
//				profile+=pattern.matcher(res.select("reeleGbnNm").text().trim()).replaceAll("") + ",";
//				profile+=pattern.matcher(res.select("electionNum").text().trim()).replaceAll(" ") + ",";
//				profile+=pattern.matcher(res.select("assemTel").text().trim()).replaceAll("") + ",";
//				profile+=homep_pattern.matcher(res.select("assemHomep").text().trim()).replaceAll("") + ",";
//				profile+=email_pattern.matcher(res.select("assemEmail").text().trim()).replaceAll("") + ",";
//				profile+=pattern.matcher(res.select("hbbyCd").text().trim()).replaceAll("") + ",";
//				profile+=pattern.matcher(res.select("examCd").text().trim()).replaceAll("") + "\n";
				
				
				PoliticianProfileEntity entity = new PoliticianProfileEntity(0, 0, line[0], line[1], line[2], line[3],
						line[4], line[5], line[6], line[7], line[8], line[9], line[10], line[11], line[12], line[13],"");

				System.out.println(entity);

				int res = dao.insertProfile(entity);
				if (res > 0) {

					count++;
					System.out.println("현재 " + count + "개 완료!");
				}
			}
		}

		return count;
	}
	
	// key : 이름|지역구, value : politician_no
	public Map<String, Integer> getPoliticianNoList() throws IOException {
		
		Document doc = Jsoup.parse(
				new File("C:\\Project\\jcjc\\WebContent\\WEB-INF\\XmlParsing\\politicianXml\\politician_step1.xml"), "UTF-8");

		Map<String, Integer> map = new HashMap<String, Integer>();

		Elements item = doc.select("item");

		for (Element element : item) {

			map.put((element.select("empNm").text().trim())+"@"+(element.select("origNm").text().trim()), Integer.parseInt(element.select("deptCd").text().trim()));
		}
		
		return map;
		
	}
	
	// key : 이름|지역구, value : politician_num
	public Map<String, Integer> getPoliticianNumList() throws IOException{
		
		Document doc = Jsoup.parse(
				new File("C:\\Project\\jcjc\\WebContent\\WEB-INF\\XmlParsing\\politicianXml\\politician_step1.xml"), "UTF-8");

		Map<String, Integer> map = new HashMap<String, Integer>();

		Elements item = doc.select("item");

		for (Element element : item) {

			map.put((element.select("empNm").text().trim())+"@"+(element.select("origNm").text().trim()), Integer.parseInt(element.select("num").text().trim()));
		}
		
		return map;
	}
	
	// key : 이름|지역구, value : Politician_jpgLink
	public Map<String, String> getPoliticianJpgLinkList() throws IOException{
		
		Document doc = Jsoup.parse(
				new File("C:\\Project\\jcjc\\WebContent\\WEB-INF\\XmlParsing\\politicianXml\\politician_step1.xml"), "UTF-8");

		Map<String, String> map = new HashMap<String, String>();

		Elements item = doc.select("item");

		for (Element element : item) {

			map.put((element.select("empNm").text().trim())+"@"+(element.select("origNm").text().trim()), element.select("jpgLink").text().trim());
		}
		
		return map;
	}
	
	public int updatePoliticianColNo() throws IOException {
		
		PoliticianProfileDaoImpl dao = new PoliticianProfileDaoImpl();
		
		HashMap<String, Integer> map = (HashMap<String, Integer>) new InputDbProfile().getPoliticianNoList();
		Set<Entry<String, Integer>> set = map.entrySet();
		Iterator<Entry<String, Integer>> ir = set.iterator();
		
		int count = 0;
		
		while(ir.hasNext()) {
			Entry<String, Integer> entry = ir.next();
			
			String [] key = entry.getKey().split("@");
			
			int res = dao.updatePoliticianNo(key[0], key[1], entry.getValue());
			
			if(res>0) {
				count++;
				System.out.println("현재 " + count + "개 완료!");
			}
		}
		
		return count;
	}

	public int updatePoliticianColJpgLink() throws IOException {
		
		PoliticianProfileDaoImpl dao = new PoliticianProfileDaoImpl();
		
		HashMap<String, String> map = (HashMap<String, String>) new InputDbProfile().getPoliticianJpgLinkList();
		Set<Entry<String, String>> set = map.entrySet();
		Iterator<Entry<String, String>> ir = set.iterator();
		
		int count = 0;
		
		while(ir.hasNext()) {
			Entry<String, String> entry = ir.next();
			
			String [] key = entry.getKey().split("@");
			
			int res = dao.updatePoliticianJpgLinkList(key[0], key[1], entry.getValue());
			
			if(res>0) {
				count++;
				System.out.println("현재 " + count + "개 완료!");
			}
		}
		
		return count;
	}
	
	public int updatePoliticianColNum() throws IOException {
		
		PoliticianProfileDaoImpl dao = new PoliticianProfileDaoImpl();
		
		HashMap<String, Integer> map = (HashMap<String, Integer>) new InputDbProfile().getPoliticianNumList();
		Set<Entry<String, Integer>> set = map.entrySet();
		Iterator<Entry<String, Integer>> ir = set.iterator();
		
		int count = 0;
		
		while(ir.hasNext()) {
			Entry<String, Integer> entry = ir.next();
			
			String [] key = entry.getKey().split("@");
			
			int res = dao.updatePoliticianNum(key[0], key[1], entry.getValue());
			
			if(res>0) {
				count++;
				System.out.println("현재 " + count + "개 완료!");
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) throws IOException {

		InputDbProfile inputDbProfile = new InputDbProfile();
		
		// delete
		int res = inputDbProfile.deletePolitician();
		if(res>0) {
			System.out.println("[delete 성공!]");
		} else {
			System.out.println(" error!");
		}
		
		// insert
		res = inputDbProfile.inputDbPoliticianProfile();
		if(res>0) {
			System.out.println("[inputDbPoliticianProfile : ]"+res+"개 성공!");
		} else {
			System.out.println("inputDbPoliticianProfile error!");
		}
		
		// update No
		res = inputDbProfile.updatePoliticianColNo();
		if(res>0) {
			System.out.println("[updatePoliticianColNo : ]"+res+"개 성공!");
		} else {
			System.out.println("updatePoliticianColNo error!");
		}
		
		// update Num
		res = inputDbProfile.updatePoliticianColNum();
		if(res>0) {
			System.out.println("[updatePoliticianColNum : ]"+res+"개 성공!");
		} else {
			System.out.println("updatePoliticianColNum error!");
		}
		
		// update jpglink
		res = inputDbProfile.updatePoliticianColJpgLink();
		if(res>0) {
			System.out.println("[updatePoliticianColJpgLink : ]"+res+"개 성공!");
		} else {
			System.out.println("updatePoliticianColJpgLink error!");
		}
	}
}
