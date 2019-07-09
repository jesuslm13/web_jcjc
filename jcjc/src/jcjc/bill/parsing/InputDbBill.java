package jcjc.bill.parsing;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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

import au.com.bytecode.opencsv.CSVReader;
import jcjc.bill.dao.BillDaoImpl;
import jcjc.bill.entity.Bill;

public class InputDbBill {

	// 정치인 list Map으로 만드는 메소드
	public Map<String, String> getPoliticianNameList() throws IOException {

		Document doc = Jsoup.parse(
				new File("C:\\Project\\jcjc\\WebContent\\WEB-INF\\XmlParsing\\politicianXml\\politician_step1.xml"), "UTF-8");

		Map<String, String> map = new HashMap<String, String>();

		Elements item = doc.select("item");

		for (Element element : item) {

			map.put(element.select("empNm").text().trim(), element.select("hjNm").text().trim());
		}

		return map;

	}

	// 김성태, 최경환 의안 번호를 key로, 한문 이름을 value로 만든 map을 리턴하는 메소드
	public Map<String, String> getKimChoiBillList() throws IOException {

		String[] file_name = { "kim_A", "kim_B", "choi_A", "choi_B" };
		String[] hj_name = { "金聖泰", "金成泰", "崔炅煥", "崔敬煥" };
		Map<String, String> map = new HashMap<String, String>();

		for (int i = 0; i < 4; i++) {

			int count = 0;

			Document document = Jsoup.parse(
					new File("C:\\Project\\jcjc\\WebContent\\WEB-INF\\XmlParsing\\bill\\kimchoiBillXml\\" + file_name[i] + ".xml"),
					"UTF-8");

			Elements elements = document.getElementsByTag("item");

			for (Element element : elements) {

				map.put(element.getElementsByTag("billNo").text(), hj_name[i]);
				count++;
			}
			System.out.println("count [" + i + "] : " + count + "개");
		}

		System.out.println(map.size());
		return map;
	}

	// 김성태, 최경환 한문 이름 Update 하는 메소드
	public int updateKimChoiBill() throws IOException {
		
		BillDaoImpl dao = new BillDaoImpl();

		// 정치인 Map 생성
		HashMap<String, String> kim_choi_bill_list= (HashMap<String, String>) new InputDbBill().getKimChoiBillList();
		System.out.println(kim_choi_bill_list);
		Set<Entry<String, String>> set = kim_choi_bill_list.entrySet();
		Iterator<Entry<String, String>> ir = set.iterator();

		int count = 0;
		
		while(ir.hasNext()) {
			Entry<String, String> entry = ir.next();
			System.out.println("key : "+entry.getKey());
			System.out.println("value : "+entry.getValue());
			int res = dao.updateKimChoiBill(entry.getKey(), entry.getValue());
	
			if (res > 0) {
				count++;
				System.out.println("현재 " + count + "개 완료!");
			}
		}
		
		return count;
	}

	// key : 국문이름@한문이름, value : politician_no
	public Map<String, Integer> getPoliticianNoList() throws IOException {
		
		Document doc = Jsoup.parse(
				new File("C:\\Project\\jcjc\\WebContent\\WEB-INF\\XmlParsing\\politicianXml\\politician_step1.xml"), "UTF-8");

		Map<String, Integer> map = new HashMap<String, Integer>();

		Elements item = doc.select("item");

		for (Element element : item) {

			map.put((element.select("empNm").text().trim())+"@"+(element.select("hjNm").text().trim()), Integer.parseInt(element.select("deptCd").text().trim()));
		}
		
		return map;
		
	}
	
	public int updateBillColPoliticianNo() throws IOException {
		
		BillDaoImpl dao = new BillDaoImpl();
		
		HashMap<String, Integer> map = (HashMap<String, Integer>) new InputDbBill().getPoliticianNoList();
		
		System.out.println("map size : "+map.size());
		
		Set<Entry<String, Integer>> set = map.entrySet();
		Iterator<Entry<String, Integer>> ir = set.iterator();
		
		int count = 0;
		
		while(ir.hasNext()) {
			
			Entry<String, Integer> entry = ir.next();
			String [] key = entry.getKey().split("@");
			int value = entry.getValue();
			System.out.println("Key[0] : "+key[0]+" / Key[1] : "+key[1]+" / value : "+value);
			int res = dao.updateBillColPoliticianNo(key[0], key[1], value);
			
			if(res>0) {
				count++;
				System.out.println("현재 " + count + "개 완료!");
			}
		}
		
		return count;
	}
	
	public int deleteBill() {

		BillDaoImpl dao = new BillDaoImpl();

		// Delete Bill
		int res = dao.deleteBill();

		return res;
	}

	public int inputDbWaitBill() throws IOException {

		BillDaoImpl dao = new BillDaoImpl();

		// 정치인 Map 생성
		HashMap<String, String> politician_name_list = (HashMap<String, String>) new InputDbBill()
				.getPoliticianNameList();

		List<String> wait_bill_no_list = new ArrayList<String>();
		
		int file_count = 0;

		String path = "C:\\Project\\jcjc\\WebContent\\WEB-INF\\XmlParsing\\bill\\waitBillCsv";

		File f = new File(path);
		File[] files = f.listFiles();

		file_count = files.length;
		System.out.println("file_count : " + file_count);

		int count = 0;

		for (int i = 1; i <= file_count; i++) {
			CSVReader csvReader = new CSVReader(new FileReader(
					new File("C:\\Project\\jcjc\\WebContent\\WEB-INF\\XmlParsing\\bill\\waitBillCsv\\waitbill_" + i + ".csv")));
			String[] line;
			Bill billEntity;

			while ((line = csvReader.readNext()) != null) {
				if(!wait_bill_no_list.contains(line[0])) {
					if (line[3].equals("의원") & politician_name_list.containsKey(line[2])) {
						billEntity = new Bill(line[0], line[1], 0, line[2], politician_name_list.get(line[2]), line[3], line[4], line[5], line[6], line[7], line[8]);
					} else {
						billEntity = new Bill(line[0], line[1], 0, line[2], "", line[3], line[4], line[5], line[6], line[7], line[8]);
					}
					wait_bill_no_list.add(line[0]);
				} else {
					continue;
				} 

				System.out.println("billEntity : " + billEntity);
				
				int res = dao.insertBill(billEntity);

				if (res > 0) {
					count++;
					System.out.println("현재 " + count + "개 완료!");
				}
			}
		}

		return count;

	}

	public int inputDbPassBill() throws IOException {

		BillDaoImpl dao = new BillDaoImpl();

		HashMap<String, String> politician_name_list = (HashMap<String, String>) new InputDbBill()
				.getPoliticianNameList();

		int file_count = 0;

		String path = "C:\\Project\\jcjc\\WebContent\\WEB-INF\\XmlParsing\\bill\\passBillCsv";

		File f = new File(path);
		File[] files = f.listFiles();

		file_count = files.length;
		System.out.println("count : " + file_count);

		int count = 0;

		for (int i = 1; i <= file_count; i++) {
			CSVReader csvReader = new CSVReader(new FileReader(
					new File("C:\\Project\\jcjc\\WebContent\\WEB-INF\\XmlParsing\\bill\\passBillCsv\\passbill_" + i + ".csv")));
			String[] line;
			Bill billEntity;

//			bill_no
//			bill_name
//			politician_no	=> 메소드로 추가
//			proposer
//			proposer_hj		=> 메소드로 추가
//			proposer_kind
//			propose_dt
//			submit_dt
//			committee_name
//			proc_dt
//			general_result
			
			while ((line = csvReader.readNext()) != null) {
				if (line[3].equals("의원") & politician_name_list.containsKey(line[2])) {
					billEntity = new Bill(line[0], line[1], 0, line[2], politician_name_list.get(line[2]), line[3], line[4], line[5], line[6], line[7],
							line[8]);
				} else {
					billEntity = new Bill(line[0], line[1], 0, line[2], "", line[3], line[4], line[5], line[6], line[7],
							line[8]);
				}

				System.out.println("billEntity : " + billEntity);
				
				int res = dao.insertBill(billEntity);

				if (res > 0) {
					count++;
					System.out.println("현재 " + count + "개 완료!");
				}
			}
		}

		return count;
	}

	public static void main(String[] args) throws IOException {

		InputDbBill inputDbBill = new InputDbBill();
		
		// Delete Bill
		int res = inputDbBill.deleteBill();

		if (res > 0) {
			System.out.println("delete bill 성공!");
		} else {
			System.out.println("delete error!");
		}

		// Insert Pass Bill
		res = inputDbBill.inputDbPassBill();

		if (res > 0) {
			System.out.println("[inputDbPassBill] 갯수 : " + res);
		} else {
			System.out.println("input error!");
		}
		
		// Insert Wait Bill
		res = inputDbBill.inputDbWaitBill();

		if (res > 0) {
			System.out.println("[inputDbWaitBill] 갯수 : " + res);
		} else {
			System.out.println("input error!");
		}

		// Update Kim, Choi hj_name
		res = inputDbBill.updateKimChoiBill();
	
		if (res > 0) {
			System.out.println("[updateKimChoiBill] 갯수 : " + res);
		} else {
			System.out.println("input error!");
		}
		
		// Update Politician_no
		res = inputDbBill.updateBillColPoliticianNo();
		
		if (res > 0) {
			System.out.println("[updateBillColPoliticianNo] 갯수 : " + res);
		} else {
			System.out.println("updateBillColPoliticianNo error!");
		}
	}
}
