package com.intexsoft.anastasiya.bashko;

import java.util.List;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

	public static void main(String[] args)  {

		String srcDir = "C:/git/in/";	 //������� ��� ������������� ������         
		String dstDir = "C:/git/out/";   //������� ��� ������������ ������		

		String fileName = "file.txt";

		String strLineNext;
		String strLine ="";		

		//�������� ������ �� ����� � ������
		try{
			FileInputStream fstream = new FileInputStream(srcDir+fileName);
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));	    
			while ((strLineNext = br.readLine()) != null){
				strLine=strLine+strLineNext.trim();			
			}
			br.close();
		}catch (IOException e){
			System.out.println("������ ������ ����� ");			
		}

		//������� ������� 
		strLine=strLine.replaceAll("\"","");

		//parsing JSON
		List<JSONClass> jsonString=(List<JSONClass>) JSONParser.parsingJSON (strLine);		

		for(JSONClass jsonClass:jsonString){

			System.out.println(jsonClass.getNameProperty().toString()+": " +jsonClass.getValue().toString());
		}		

		try {
			Files.move(Paths.get(srcDir+fileName), Paths.get(dstDir+fileName));
		}catch (IOException e) {
			System.out.println("������ ����������� ����� ");
		}
	}
}
