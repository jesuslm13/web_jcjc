package jcjc.bill.parsing;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CsvConvertBill {

	public int CsvConverPasstBill() throws IOException {

		int count = 0;

		Document doc = Jsoup
				.parse(new File("C:\\Project\\jcjc\\WebContent\\WEB-INF\\XmlParsing\\bill\\passBillXml\\passbill_1.xml"), "UTF-8");

		Pattern pattern = Pattern
				.compile("[\\/\\,\\\"\\.\\?\\!\\#\\%\\^\\&\\*\\[\\]\\{\\}\\|\\t\\n\\;\\:\\+\\`\\~\\(\\)]");

		String temp_count = doc.select("totalCount").text();
		int num = (Integer.parseInt(temp_count) / 100)+1;
		System.out.println(num);

		String bill = "";

		// csv 파일 만드는 코드
//		bill += "billNo,billName,proposer,proposerKind,proposeDt,submitDt,committeeName,procDt,generalResult\n";

		for (int i=1; i<=num; i++) {

			Document docc = Jsoup.parse(
					new File("C:\\Project\\jcjc\\WebContent\\WEB-INF\\XmlParsing\\bill\\passBillXml\\passbill_" + i + ".xml"),
					"UTF-8");
			Elements element = docc.select("item");

			for (Element res : element) {

				int index = res.select("proposer").text().trim().indexOf("의원");

				bill += pattern.matcher(res.select("billNo").text().trim()).replaceAll("") + ",";
				bill += pattern.matcher(res.select("billName").text().trim()).replaceAll("") + ",";

				if (res.select("proposer").text().trim().indexOf("의원") > 0) {
					bill += pattern.matcher(res.select("proposer").text().trim().substring(0, index)).replaceAll("")
							+ ",";
				} else {
					bill += pattern.matcher(res.select("proposer").text().trim()).replaceAll("") + ",";
				}

				bill += pattern.matcher(res.select("proposerKind").text().trim()).replaceAll("") + ",";
				bill += pattern.matcher(res.select("proposeDt").text().trim()).replaceAll("") + ",";
				bill += pattern.matcher(res.select("submitDt").text().trim()).replaceAll("") + ",";
				bill += pattern.matcher(res.select("committeeName").text().trim()).replaceAll("") + ",";
				bill += pattern.matcher(res.select("procDt").text().trim()).replaceAll("") + ",";
				bill += pattern.matcher(res.select("generalResult").text().trim()).replaceAll("") + "\n";

			}
			
			InputStream is = new ByteArrayInputStream(bill.getBytes(StandardCharsets.UTF_8));
			FileOutputStream fos = new FileOutputStream(
					"C:\\Project\\jcjc\\WebContent\\WEB-INF\\XmlParsing\\bill\\passBillCsv\\passbill_" + i + ".csv"); // csv
			int line = 0;

			while ((line = is.read()) != -1) {
				fos.write(line);
			}
			is.close();
			fos.close();

			count += 1;

			System.out.println("완성 파일 번호 : " + count);
			bill = "";
		}

		return count;
	}

	public int CsvConverWaittBill() throws IOException {

		int count = 0;

		Document doc = Jsoup
				.parse(new File("C:\\Project\\jcjc\\WebContent\\WEB-INF\\XmlParsing\\bill\\waitBillXml\\waitbill_1.xml"), "UTF-8");

		Pattern pattern = Pattern
				.compile("[\\/\\,\\\"\\.\\?\\!\\#\\%\\^\\&\\*\\[\\]\\{\\}\\|\\t\\n\\;\\:\\+\\`\\~\\(\\)]");

		String temp_count = doc.select("totalCount").text();
		int num = (Integer.parseInt(temp_count) / 100)+1;
		System.out.println(num);

		String bill = "";

		// csv 파일 만드는 코드
//		bill += "billNo,billName,proposer,proposerKind,proposeDt,submitDt,committeeName,procDt,generalResult\n";

		for (int i=1; i<=num; i++) {

			Document docc = Jsoup.parse(
					new File("C:\\Project\\jcjc\\WebContent\\WEB-INF\\XmlParsing\\bill\\waitBillXml\\waitbill_" + i + ".xml"),
					"UTF-8");
			Elements element = docc.select("item");

			for (Element res : element) {

				int index = res.select("proposer").text().trim().indexOf("의원");

				bill += pattern.matcher(res.select("billNo").text().trim()).replaceAll("") + ",";
				bill += pattern.matcher(res.select("billName").text().trim()).replaceAll("") + ",";

				if (res.select("proposer").text().trim().indexOf("의원") > 0) {
					bill += pattern.matcher(res.select("proposer").text().trim().substring(0, index)).replaceAll("")
							+ ",";
				} else {
					bill += pattern.matcher(res.select("proposer").text().trim()).replaceAll("") + ",";
				}

				bill += pattern.matcher(res.select("proposerKind").text().trim()).replaceAll("") + ",";
				bill += pattern.matcher(res.select("proposeDt").text().trim()).replaceAll("") + ",";
				bill += pattern.matcher(res.select("submitDt").text().trim()).replaceAll("") + ",";
				bill += pattern.matcher(res.select("committeeName").text().trim()).replaceAll("") + ",";
				bill += pattern.matcher(res.select("procDt").text().trim()).replaceAll("") + ",";
				bill += pattern.matcher(res.select("generalResult").text().trim()).replaceAll("") + "\n";

			}

			InputStream is = new ByteArrayInputStream(bill.getBytes(StandardCharsets.UTF_8));
			FileOutputStream fos = new FileOutputStream(
					"C:\\Project\\jcjc\\WebContent\\WEB-INF\\XmlParsing\\bill\\waitBillCsv\\waitbill_" + i + ".csv"); // csv
			int line = 0;

			while ((line = is.read()) != -1) {
				fos.write(line);
			}
			is.close();
			fos.close();

			count += 1;

			System.out.println("완성 파일 번호 : " + count);
			bill = "";
		}

		return count;
	}

	public static void main(String[] args) throws IOException {
		
		CsvConvertBill csvConvertPassBill = new CsvConvertBill();
		
		int res = csvConvertPassBill.CsvConverPasstBill();
		
		if(res>0) {
			System.out.println("[CsvConvertPassBill] 갯수 : " + res);
		} else {
			System.out.println("convert error!");
		}
		
		res = csvConvertPassBill.CsvConverWaittBill();
		
		if(res>0) {
			System.out.println("[CsvConverWaittBill] 갯수 : " + res);
		} else {
			System.out.println("convert error!");
		}
	}
}
