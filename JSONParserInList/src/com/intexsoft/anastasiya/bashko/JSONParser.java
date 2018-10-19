package com.intexsoft.anastasiya.bashko;

import java.util.ArrayList;
import java.util.List;

public class JSONParser {

	public static  List<?> parsingJSON(String jsonString)  
	{
		List<JSONClass> list=new ArrayList<JSONClass>();

		if ((jsonString.startsWith("{")) && (jsonString.endsWith("}"))) {

			for ( int i=0; i<jsonString.length()-1;i++) {

				int finishIndexField =jsonString.indexOf(":",i);
				//получаем название свойства  до двоеточия 
				String nameField =jsonString.substring(i+1,finishIndexField).trim();	

				//проверяем есть ли после двoеточия { (проверка на подобъект)			
				String podsvoistvo =jsonString.substring(finishIndexField+1,jsonString.length()-1).trim();
				if (podsvoistvo.startsWith("{")) {
					int countel=0;
					int k;

					for ( k=finishIndexField+1; k<jsonString.length()-1;k++) {
						if (jsonString.charAt(k)=='{') countel++;
						if (jsonString.charAt(k)=='}') countel--;
						if (countel==0) break;
					}

					String stringPodClassa=jsonString.substring(finishIndexField+1,  k+1);	
					//рекурсия	
					List<?> podList= JSONParser.parsingJSON(stringPodClassa);					

					Object object2=new JSONClass(nameField, podList);					

					list.add((JSONClass) object2);
										
					i=k;

					continue;
				}					

				String massivSTR =jsonString.substring(finishIndexField+1);
				// проверяем есть ли после двоеточия [ (проверка на массив)
				if (massivSTR.startsWith("[")) {

					String stringMassiv=jsonString.substring(finishIndexField+1, jsonString.indexOf("}",i));

					if (massivSTR.substring(1).startsWith("{")){
						List<?> podList= JSONParser.parsingJSON(stringMassiv);	
					};			

					ArrayList<String> massiv=new ArrayList<String>();
					for (int j=1; j<stringMassiv.length()-1; j++) {
						
						if (massivSTR.substring(1).startsWith("{")){
							List<?> podList= JSONParser.parsingJSON(stringMassiv);	
						};	

						int finishIndexValueMassiv =stringMassiv.indexOf(",",j);
						if (finishIndexValueMassiv<0) {
							finishIndexValueMassiv=stringMassiv.length()-1;						
						}	

						String valueMassiv=stringMassiv.substring(j, finishIndexValueMassiv);
						j=finishIndexValueMassiv;
						massiv.add(valueMassiv);			}

					List<?> podList= massiv;				

					Object object2=new JSONClass(nameField, podList);					

					list.add((JSONClass) object2);
					i=jsonString.indexOf("]",i);
					continue;
				}				

				// получаем индекс значения свойства до запятой 
				int finishIndexValueFild =jsonString.indexOf(",",finishIndexField);
				i=finishIndexValueFild-1;

				// проверка 
				if (finishIndexValueFild<0) {
					finishIndexValueFild=jsonString.length()-1;
					i=jsonString.length()-1;
				}	

				String valueFild=jsonString.substring(finishIndexField+1,finishIndexValueFild).trim();			

				List<String> intList = new ArrayList<String>(); 
				intList.add(valueFild); 

				Object object=new JSONClass(nameField, intList);
				list.add((JSONClass) object);
			}
		}			
		return list;			
	}	

}
