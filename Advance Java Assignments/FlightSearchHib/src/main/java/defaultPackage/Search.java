package defaultPackage;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.concurrent.Callable;

import com.opencsv.exceptions.CsvValidationException;

//class for implementing  multi threading 
public class Search implements Runnable {
	
	private String file;
	
//	Constructing the thread object providng the file to read
	public Search(String file){
		
		this.file=file;
		
	}
//	
@Override
public void run() {
	// TODO Auto-generated method stub
	try {
		AddCsv.Add(this.file);
	} catch (CsvValidationException | IOException | ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
