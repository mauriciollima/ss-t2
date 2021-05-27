import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Teste2 {

	public static void main(String[] args) {
		
		try {
		    File file = new File("C:/FuncoesResumo - SHA1.mp4");
		    FileInputStream is = new FileInputStream(file);
		    byte[] chunk = new byte[1024];
		    int chunkLen = 0;
		    while ((chunkLen = is.read(chunk)) != -1) {
		        // your code..
		    }
		} catch (FileNotFoundException fnfE) {
		    // file not found, handle case
		} catch (IOException ioE) {
		    // problem reading, handle case
		}

	}

}
