import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Keypad {
	private BufferedReader br;
	public Keypad () {
		br = new BufferedReader(new InputStreamReader(System.in));
	}
	public int  getInput() {
		int n = 0;
		String x = null;
		
			//n = Integer.parseInt(br.readLine());
			try {
				x = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try{
				n = Integer.parseInt(x);
			} catch(Exception e){
				return -999;
			}
		return n;
	}
	
}
