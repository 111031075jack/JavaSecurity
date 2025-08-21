package aes;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;

import javax.crypto.spec.SecretKeySpec;

public class AESSample {
	
	public static void main(String[] args) throws Exception {
		// 明文
		String originalText = "行政院宣布全民發放一萬元";
		System.out.printf("明文: %s%n", originalText);
		System.out.println("-------------------------");
		// 利用 AES 進行加密
		// 1. 建立密鑰
		SecretKeySpec key = loadKeyFromFile("mykey.key");
		
	}
	
	// 取得金鑰
	private static SecretKeySpec loadKeyFromFile(String filePath) throws Exception {
		String keyBase64 = Files.readString(Path.of(filePath));
		byte[] keyByte = Base64.getDecoder().decode(keyBase64);
		return new SecretKeySpec(keyByte, "AES");
	}
	
}
