package classes;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {
	
	public ArrayList<ToImport> ReadFiles;

	protected class ToImport{
		public String FileName;
		public ArrayList<String> Lines;
	}
	
	public class ToReturn{
		public String FileName;
		public People People;
	}
		
	public void readFiles(String path) {
		ReadFiles = new ArrayList<FileReader.ToImport>();
		
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();
		
		
		for (File file : listOfFiles) {
			 if (file.isFile() && file.getName().endsWith(".txt")) {
				 ToImport imported = new ToImport();
					
				imported.FileName = file.getName();
				imported.Lines = getContentFromFile(file.getAbsolutePath());
				
				ReadFiles.add(imported);
			 }	
		}
	}

	private ArrayList<String> getContentFromFile(String filepath) {
		ArrayList<String> list = new ArrayList<String>();
		
		try  
		{  
			FileInputStream fis=new FileInputStream(filepath);       
			Scanner sc=new Scanner(fis);
			while(sc.hasNextLine())  
			{  
				list.add(sc.nextLine());  
			}  
			
			sc.close();  
		}  
		catch(IOException e)  
		{  
		e.printStackTrace();  
		}  
		
		return list;
	}
	
	public ToReturn convertNextToPeople() {
		if(ReadFiles.size() == 0) return null;
		
		ToImport nextInLine = ReadFiles.remove(0);
		ToReturn toReturn = new ToReturn();
		
		toReturn.FileName = nextInLine.FileName;
		toReturn.People = getPeopleFromLines(nextInLine.Lines);
		
		return toReturn;
	}

	private People getPeopleFromLines(ArrayList<String> lines) {
		People people = new People();
		
		Person person = null; 
		
		for (String string : lines) {
			switch( string.substring(0, 1)) {
				case "P":
					person = new Person(string);
					people.addPerson(person);
					break;
					
				case "A":
					if(person.FamilyList != null) {
						person.FamilyList.get(person.FamilyList.size()-1).addAdress(new Adress(string));
					} else {
						person.addAdress(new Adress(string));
					}
					break;
					
				case "T":
					if(person.FamilyList != null) {
						person.FamilyList.get(person.FamilyList.size()-1).addPhone(new Phone(string));
					} else {
						person.addPhone(new Phone(string));
					}
					break;
					
				case "F":
					person.addFamily(new Family(string));
					break;
			}
		}
		
		return people;
	}
}
