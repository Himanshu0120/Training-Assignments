//Returns the list of all the available csv files

package defaultPackage;
import java.io.*;
public class FilesList {
	public static String[] getFilesPath() {
		try {
		String path=".\\Files";
		
		File file=new File(path);
		String[] str=file.list();
		
		for(int i=0;i<str.length;i++) {
			str[i]=path+"//"+str[i];			
		}
		return str;
		}
		catch(Exception e) {
			String path="..\\Files";
			
			File file=new File(path);
			String[] str=file.list();
			
			for(int i=0;i<str.length;i++) {
				str[i]=path+"//"+str[i];			
			}
			return str;
		}
		
	}
}
