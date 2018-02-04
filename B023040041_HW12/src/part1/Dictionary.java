package part1;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
public class Dictionary {

	public static void main(String[] args) {
		HashSet<String> dictionary = new HashSet<String>();
		File file = new File("words.txt");
		String path;
		String name = null;
		try {
			path = file.getCanonicalPath();
			String fileSeparator = System.getProperty("file.separator");
			name = path + fileSeparator;
		} catch (IOException e) {
			e.printStackTrace();
		}
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(name);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		byte[] b = null;
		try {
			b = new byte[fis.available()];
			fis.read(b);
			fis.close();
		} catch (IOException e) {
			System.out.println("Error!Please run again.");
			e.printStackTrace();
		}
		String str = new String(b);	
		String[] Array=str.split("\n");
		for(int i=0;i<Array.length;i++){
			dictionary.add(Array[i]);
		}
		
		File file2 = new File("test.txt");
		String path2;
		String name2 = null;
		try {
			path2 = file2.getCanonicalPath();
			String fileSeparator2 = System.getProperty("file.separator");
			name2 = path2 + fileSeparator2;
		} catch (IOException e) {
			System.out.println("Error!Please run again.");
			e.printStackTrace();
		}
		FileInputStream fis2 = null;
		try {
			fis2 = new FileInputStream(name2);
		} catch (FileNotFoundException e) {
			System.out.println("Error!Please run again.");
			e.printStackTrace();
		}
		byte[] b2 = null;
		try {
			b2 = new byte[fis2.available()];
			fis2.read(b2);
			fis2.close();
		} catch (IOException e) {
			System.out.println("Error!Please run again.");
			e.printStackTrace();
		}
		System.out.println("These words don't find in the dictionary : ");
		String str2 = new String(b2);	
		String[] Array2=str2.split("\n");
		for(int i=0;i<Array2.length;i++){
			if(!dictionary.contains(Array2[i])){
				System.out.println(Array2[i]);
			}
		}
	}

}
