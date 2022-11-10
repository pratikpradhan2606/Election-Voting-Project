package com.nice.team110;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class Solution {

	public static void main(String[] args) {
		try {
			String file="src/main/resources/candidateFile.csv";
			FileReader my_filereader = new FileReader(file);
			CSVReader csvReader = new CSVReaderBuilder(my_filereader) .withSkipLines(1).build(); 
			List<String[]> allData = csvReader.readAll(); 
			HashMap<String,String> mp=new HashMap<String, String>();
			for (String[] row : allData) { 
				if(mp.containsKey(row[0])) {
					continue;
				}
				mp.put(row[1],row[0]); 
			} 
			
			for (Map.Entry<String,String> mapElement : mp.entrySet()) {
	            String key = mapElement.getKey();
	            String value=mapElement.getValue();
	            //System.out.println(key + " : " + value);
	        }
	         my_filereader.close();
	         
	        String file2="src/main/resources/votingFile.csv";
	        FileReader my_filereader2 = new FileReader(file2);
			CSVReader csvReader2 = new CSVReaderBuilder(my_filereader2) .withSkipLines(1).build(); 
			List<String[]> allData2 = csvReader2.readAll();
			
			//Unique arr[]=new Unique[200];
			ArrayList<Unqiue> all=new ArrayList<Unqiue>();
			
			for(String row[]:allData2) {
				//System.out.println(row[3]+"\t"+row[2]+"\t"+row[1]+"\t"+row[0]);
				boolean present=false;
				for(Unqiue obj:all) {
					if(obj.getCandidate().equals(row[3]) && obj.getConstituency().equals(row[1])) {
						present=true;
						//System.out.println("Reach");
						obj.setVotes(obj.getVotes()+1);
					}
				}
				if(!present)
				{
					Unqiue temp=new Unqiue(row[3],row[1],1);
					all.add(temp);
				}
				
			}
			
			HashMap<String, String> winnerMap = new HashMap<String, String>();

			for (Unqiue obj:all) {
				int maxCount=0;
				String candidate="";
				for(Unqiue obj1:all) {
					if(obj1.Constituency.equals(obj.Constituency)) {
						if(maxCount<obj1.votes) {
							maxCount=obj1.votes;
							candidate=obj1.candidate;
						}
					}
					
				}
				String lessthanNota=candidate;
				
				if(candidate.equals("NOTA")) {
					
					for(Unqiue obj2:all) {
						if(obj.Constituency.equals(obj2.Constituency) && obj2.votes==maxCount) {
							lessthanNota=obj2.candidate;
						}
					}
					if(lessthanNota.equals("NOTA")) {
						lessthanNota="NO_WINNER";
					}
				}
				winnerMap.put(obj.Constituency, lessthanNota);
				//System.out.println(obj.candidate+"\t"+obj.Constituency+"\t"+obj.votes);
				
			}
			
			TreeMap<String, String> sorted = new TreeMap<String, String>();
			
	        sorted.putAll(winnerMap);
	        JSONArray Result=new JSONArray();
	        JSONArray boothlist=new JSONArray();
	        boothlist.add("Result ");
	        for(Entry<String, String> data:sorted.entrySet()) {
	        	JSONArray boothlist1=new JSONArray();
	        	JSONObject election=new JSONObject();
	        	
	        	boothlist.add(data.getKey());
	        	
	 	        election.put("winnerName",data.getValue());
	 	        
	 	       for(Unqiue obj1:all) {
					if(obj1.Constituency.equals(data.getKey())) {
						election.put(obj1.candidate, obj1.votes);
					}
				}
	 	       boothlist1.add(election);
	 	       boothlist.add(boothlist1);
	 	       //boothlist.sort(null);
	 	       
	 	       System.out.println(data.getKey()+"\t"+data.getValue());
			}
	        Result.add(boothlist);
	        try {
	        	FileWriter Resultfile=new FileWriter("src/main/resources/ElectionResult.json");
	        	Resultfile.write(boothlist.toJSONString());
	        	Resultfile.flush();
	        }catch(Exception e) {
	        	e.printStackTrace();
	        }
	       
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println();
		}
	}

}
