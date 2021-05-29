import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

public class Teste2 {

	public static void main(String[] args) throws IOException {
		char[] myBuffer = new char[1024];
		int bytesRead = 0;
		BufferedReader in = new BufferedReader(new FileReader("C:\\FuncoesResumo - SHA1.mp4"));

		ArrayList<char[]> list = new ArrayList<char[]>();
		while ((bytesRead = in.read(myBuffer, 0, 1024)) != -1) {
//			System.out.println(myBuffer);
			list.add(myBuffer);
		}

		Stack<char[]> stack = new Stack<char[]>();

		stack.addAll(list);

		char[] teste = stack.pop();

		while (!stack.isEmpty()) {
			System.out.println(teste);
		}

	}

}
