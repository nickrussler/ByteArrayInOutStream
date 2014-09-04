package info.whitebyte.utils;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class Example {
	public static void main(String[] args) {
		ByteArrayInOutStream baios = new ByteArrayInOutStream();
		ByteArrayInputStream inputStream;
		
		try {
			baios.write(new byte[]{123});			
			
			// The internal buffer of the ByteArrayOutputStream is NOT copied
			// therefore the 'conversion' to a ByteArrayInputStream is fast
			inputStream = baios.getInputStream();
			
			byte[] tmp = new byte[1];
			inputStream.read(tmp);
			
			System.out.println(tmp[0]);
			
			// The streams should be closed in a finally block normally..
			baios.close();
			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
