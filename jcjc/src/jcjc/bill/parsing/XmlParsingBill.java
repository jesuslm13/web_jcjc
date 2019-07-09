package jcjc.bill.parsing;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class XmlParsingBill {

	public int XmlParsingPassBill() throws IOException {

		Document temp_document = Jsoup
				.connect("http://apis.data.go.kr/9710000/BillInfoService2/getJsictionComiteProcessList" + "?pageNo=1"
						+ "&numOfRows=10" + "&start_age_cd=20"
						+ "&ServiceKey=Qdb5KydABzjhFWA4CzQ4gSgtLMnxo6C5jGrv%2FOLaQ6evALcjMQDkPllXowGQzr9DzraCGymtgDwuQmge6QJzng%3D%3D")
				.get();

		String temp_count = temp_document.select("totalCount").text();
		int page_count = (Integer.parseInt(temp_count) / 100) + 1;

		// xml을 바로 파싱해서 전달하고 싶은때는 Jsoup.parse() 메소드를 이용한다
		// toString 으로 전달하면 태그 검색이 안됨

		int count = 0;

		for (int i = 1; i < page_count + 1; i++) {
			Document document = Jsoup
					.connect("http://apis.data.go.kr/9710000/BillInfoService2/getJsictionComiteProcessList" + "?pageNo="
							+ i + "&numOfRows=100" + "&start_age_cd=20"
							+ "&ServiceKey=Qdb5KydABzjhFWA4CzQ4gSgtLMnxo6C5jGrv%2FOLaQ6evALcjMQDkPllXowGQzr9DzraCGymtgDwuQmge6QJzng%3D%3D")
					.get();

			String xml = document.toString();

			InputStream is = new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8));

			FileOutputStream fos = new FileOutputStream(
					"C:\\Project\\jcjc\\WebContent\\WEB-INF\\XmlParsing\\bill\\passBillXml\\passbill_" + i + ".xml");

			int r = 0;
			while ((r = is.read()) != -1) {

				fos.write(r);
			}

			is.close();
			fos.close();

			count++;

			System.out.println("현재 [" + count + "]개 완료!!");
		}
		return count;

	}

	public int XmlParsingWaitBill() throws IOException {

		Document temp_document = Jsoup.connect("http://apis.data.go.kr/9710000/BillInfoService2/getRecentMoorList"
				+ "?pageNo=1" + "&numOfRows=10" + "&start_age_cd=20"
				+ "&ServiceKey=Qdb5KydABzjhFWA4CzQ4gSgtLMnxo6C5jGrv%2FOLaQ6evALcjMQDkPllXowGQzr9DzraCGymtgDwuQmge6QJzng%3D%3D")
				.get();

		String temp_count = temp_document.select("totalCount").text();
		int page_count = (Integer.parseInt(temp_count) / 100) + 1;

		// xml을 바로 파싱해서 전달하고 싶은때는 Jsoup.parse() 메소드를 이용한다
		// toString 으로 전달하면 태그 검색이 안됨

		int count = 0;

		for (int i = 1; i < page_count + 1; i++) {
			Document document = Jsoup.connect("http://apis.data.go.kr/9710000/BillInfoService2/getRecentMoorList"
					+ "?pageNo=" + i + "&numOfRows=100" + "&start_age_cd=20"
					+ "&ServiceKey=Qdb5KydABzjhFWA4CzQ4gSgtLMnxo6C5jGrv%2FOLaQ6evALcjMQDkPllXowGQzr9DzraCGymtgDwuQmge6QJzng%3D%3D")
					.get();

			String xml = document.toString();

			InputStream is = new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8));

			FileOutputStream fos = new FileOutputStream(
					"C:\\Project\\jcjc\\WebContent\\WEB-INF\\XmlParsing\\bill\\waitBillXml\\waitbill_" + i + ".xml");

			int r = 0;
			while ((r = is.read()) != -1) {

				fos.write(r);
			}

			is.close();
			fos.close();

			count++;

			System.out.println("현재 [" + count + "]개 완료!!");
		}
		return count;
	}

	public int XmlParsingKimChoiBill() throws IOException {

		// xml을 바로 파싱해서 전달하고 싶은때는 Jsoup.parse() 메소드를 이용한다
		// toString 으로 전달하면 태그 검색이 안됨

		int count = 0;

		
		String [] file_name = {"kim_A", "kim_B", "choi_A", "choi_B"};
		String [] url = {
				
			"http://apis.data.go.kr/9710000/BillInfoService2/getBillInfoList"
				+ "?pageNo=1"
				+ "&numOfRows=1000"
				+ "&gbn=dae_num_name"
				+ "&mem_name=%EA%B9%80%EC%84%B1%ED%83%9C"
				+ "&hj_nm=%E9%87%91%E8%81%96%E6%B3%B0"
				+ "&mem_name_check=G01"
				+ "&ord=A01"
				+ "&start_ord=20"
				+ "&end_ord=20"
				+ "&proposer_kind_cd=F01"
				+ "&ServiceKey=Qdb5KydABzjhFWA4CzQ4gSgtLMnxo6C5jGrv%2FOLaQ6evALcjMQDkPllXowGQzr9DzraCGymtgDwuQmge6QJzng%3D%3D",
				
			"http://apis.data.go.kr/9710000/BillInfoService2/getBillInfoList"
				+ "?pageNo=1"
				+ "&numOfRows=1000"
				+ "&gbn=dae_num_name"
				+ "&mem_name=%EA%B9%80%EC%84%B1%ED%83%9C"
				+ "&hj_nm=%E9%87%91%E6%88%90%E6%B3%B0"
				+ "&mem_name_check=G01"
				+ "&ord=A01&start_ord=20"
				+ "&end_ord=20"
				+ "&proposer_kind_cd=F01"
				+ "&ServiceKey=Qdb5KydABzjhFWA4CzQ4gSgtLMnxo6C5jGrv%2FOLaQ6evALcjMQDkPllXowGQzr9DzraCGymtgDwuQmge6QJzng%3D%3D",
					
			"http://apis.data.go.kr/9710000/BillInfoService2/getBillInfoList"
				+ "?pageNo=1"
				+ "&numOfRows=1000"
				+ "&gbn=dae_num_name"
				+ "&mem_name=%EC%B5%9C%EA%B2%BD%ED%99%98"
				+ "&hj_nm=%E5%B4%94%E7%82%85%E7%85%A5"
				+ "&mem_name_check=G01&ord=A01"
				+ "&start_ord=20&end_ord=20"
				+ "&proposer_kind_cd=F01"
				+ "&ServiceKey=Qdb5KydABzjhFWA4CzQ4gSgtLMnxo6C5jGrv%2FOLaQ6evALcjMQDkPllXowGQzr9DzraCGymtgDwuQmge6QJzng%3D%3D",
							
			"http://apis.data.go.kr/9710000/BillInfoService2/getBillInfoList"
				+ "?pageNo=1"
				+ "&numOfRows=1000"
				+ "&gbn=dae_num_name"
				+ "&mem_name=%EC%B5%9C%EA%B2%BD%ED%99%98"
				+ "&hj_nm=%E5%B4%94%E6%95%AC%E7%85%A5"
				+ "&mem_name_check=G01"
				+ "&ord=A01&start_ord=20"
				+ "&end_ord=20"
				+ "&proposer_kind_cd=F01"
				+ "&ServiceKey=Qdb5KydABzjhFWA4CzQ4gSgtLMnxo6C5jGrv%2FOLaQ6evALcjMQDkPllXowGQzr9DzraCGymtgDwuQmge6QJzng%3D%3D"};
		
		for(int i=0; i<4; i++) {
		
			Document document = Jsoup.connect(url[i]).get();
			
			String xml = document.toString();
	
			InputStream is = new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8));
	
			FileOutputStream fos = new FileOutputStream(
					"C:\\Project\\jcjc\\WebContent\\WEB-INF\\XmlParsing\\bill\\kimchoiBillXml\\"+file_name[i]+".xml");
	
			int r = 0;
			while ((r = is.read()) != -1) {
	
				fos.write(r);
			}
	
			is.close();
			fos.close();
	
			count++;
	
			System.out.println("현재 [" + count + "]개 완료!!");
		
		}
		
		return count;

	}

	public static void main(String[] args) throws IOException {

		XmlParsingBill xmlParsingBill = new XmlParsingBill();

		int res = xmlParsingBill.XmlParsingPassBill();

		if (res > 0) {
			System.out.println("[XmlParsingPassBill] 갯수 : " + res);
		} else {
			System.out.println("parsing error!");
		}

		res = xmlParsingBill.XmlParsingWaitBill();

		if (res > 0) {
			System.out.println("[XmlParsingWaitBill] 갯수 : " + res);
		} else {
			System.out.println("parsing error!");
		}
		
		// 중복 의원 김성태, 최경환 xml parsing
		
		res = xmlParsingBill.XmlParsingKimChoiBill();
		
		if (res > 0) {
			System.out.println("[XmlParsingKimChoiBill] 갯수 : " + res);
		} else {
			System.out.println("parsing error!");
		}
	}
}
