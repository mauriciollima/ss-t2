import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Stack;

import org.apache.commons.io.FileUtils;

import com.google.common.hash.Hashing;

public class FunctionResume {
	public static void main(String[] args) throws IOException, NoSuchAlgorithmException {

		String FILE_TO_SEND = "C:/FuncoesResumo - SHA1.mp4";

		FileInputStream fis = null;
		BufferedInputStream bis = null;
		OutputStream os = null;

		File myFile = new File(FILE_TO_SEND);
//		byte[] mybytearray = new byte[(int) myFile.length()];
//
//		fis = new FileInputStream(myFile);
//		bis = new BufferedInputStream(fis);
//		bis.read(mybytearray, 0, mybytearray.length);
//
//		System.out.println(myFile.length() / 1024);
//
//		ArrayList<String> hashs = getSha256Hash(myFile);
//		System.out.println(hashs);
//
//		String aux = null;
//		for (String hash : hashs) {
//		aux = Hashing.sha256().hashString(aux + hash, StandardCharsets.UTF_8).toString();
//		}
//		System.out.println(aux);

//		byte[] bytes = FileUtils.readFileToByteArray(myFile);
//		
		String teste = FileUtils.readFileToString(myFile);
//		System.out.println(teste);

		String encoding = "iso-8859-1";
		ByteArrayInputStream in = new ByteArrayInputStream(teste.getBytes(encoding));
		byte[] buffer = new byte[1024];
		int len;

		Stack<String> hashTeste = new Stack<String>();
		String aux = null;
		while ((len = in.read(buffer)) > 0) {
			hashTeste.add(buffer.toString());
			aux = Hashing.sha256().hashString(aux + buffer.toString(), StandardCharsets.UTF_8).toString();
		}


		String t = null;
		while(!hashTeste.isEmpty()) {
			String hx = hashTeste.pop();
			t = Hashing.sha256().hashString(aux + hx, StandardCharsets.UTF_8).toString();
		}
		
		System.out.println(t);
		
		
		
		System.out.println(aux);
//		

	}

	public static ArrayList<String> getSha256Hash(File file) throws IOException, NoSuchAlgorithmException {
		MessageDigest shaDigest = MessageDigest.getInstance("SHA-256");
		return getFileChecksum(shaDigest, file);
	}

	private static ArrayList<String> getFileChecksum(MessageDigest digest, File file) throws IOException {
		// Get file input stream for reading the file content
		FileInputStream fis = new FileInputStream(file);

		// Create byte array to read data in chunks
		byte[] byteArray = new byte[1024];
		int bytesCount = 0;

		ArrayList<String> hashs = new ArrayList<String>();

		// Read file data and update in message digest
		while ((bytesCount = fis.read(byteArray)) != -1) {
			digest.update(byteArray, 0, bytesCount);
			hashs.add(getHash(digest));
		}

//		// close the stream; We don't need it now.
//		fis.close();
//
//		// Get the hash's bytes
//		byte[] bytes = digest.digest();
//
//		// This bytes[] has bytes in decimal format;
//		// Convert it to hexadecimal format
//		StringBuilder sb = new StringBuilder();
//		for (int i = 0; i < bytes.length; i++) {
//			sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
//		}
//		// return complete hash
//		return sb.toString();

		return hashs;
	}

	private static String getHash(MessageDigest digest) {

		// Get the hash's bytes
		byte[] bytes = digest.digest();

		// This bytes[] has bytes in decimal format;
		// Convert it to hexadecimal format
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < bytes.length; i++) {
			sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
		}
		// return complete hash
		return sb.toString();

	}
}
