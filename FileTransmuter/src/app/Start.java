package app;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import classes.FileReader;
import classes.FileReader.ToReturn;
import classes.XmlFormatter;

public class Start {

	public static void main(String[] args) throws IOException {
		
		FileReader reader = new FileReader();
		String path = Paths.get("").toAbsolutePath().toString();
		reader.readFiles(path);
		
		for (int i = 0; i < reader.ReadFiles.size(); i++) {
			ToReturn converted = reader.convertNextToPeople();
			
			if(converted.People != null) {
				String xml = XmlFormatter.format(converted.People.generateXml());
				String filename = converted.FileName.replace(".txt", ".xml");

				FileWriter myWriter = new FileWriter(filename);
			      myWriter.write(xml);
			      myWriter.close();

			}
			
		}
		
	}

}
