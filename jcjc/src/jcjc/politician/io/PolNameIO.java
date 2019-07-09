package jcjc.politician.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PolNameIO {

	public String [] MkPolList(File f) throws IOException{
		
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		String [] line = new String[300];
		String line_temp = null;
		int count = 0;
		
		while((line_temp = br.readLine()) != null) {
			
//			pol_list.add(line_temp);
			System.out.println(line_temp);
			line[count]=line_temp;
			System.out.println(line[count]);
			System.out.println("add complate : "+line[count]);
			
			count++;
			
		}
		
		System.out.println("count : "+line.length);
		
		return line;
	}
	
	public void MkPolListFile(String [] list) throws IOException {
		int count = list.length;
		String line = "";
		for(int i=0; i<count; i++) {
			for(int j=0; j<count; j++) {
				line += list[i]+"/"+list[j]+"\n";
				System.out.println("append complate : "+list[i]+"/"+list[j]);
			}
		}
		
		File f = new File("C:\\Users\\Playdata\\Desktop\\강의용\\09.Linux\\mydata\\pol_list.csv");
		FileWriter fw = new FileWriter(f, true);
		fw.write(line);
		System.out.println("input complate");
	}
	
	public static void main(String[] args) throws IOException{
		
		File f = new File("C:\\Project\\jcjc\\WebContent\\db\\result.txt");
		
		PolNameIO con = new PolNameIO();
		String [] list = con.MkPolList(f);
		con.MkPolListFile(list);
	}

}
