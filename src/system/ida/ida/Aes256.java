/**
 * 아래에 나오는 클래스의 소속 패키지 경로를 설정하기
 * 모든 자바 클래스 최상단에는 소속 패키지 경로가 먼저 나옴
 */
package system.ida.ida;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

/**
 * Aes256 클래스
 * 데이터를 암호화, 복호화 하기 위해 사용하는 클래스
 * @author Jo
 */
public class Aes256 {
	/**
	 * 속성변수 선언
	 */
	private String iv;
	private Key keySpec;	// 16자리 이상의 키값을 입력하여 객체를 생성
	final static String key = "komos20200213onm";	// 암/복호화를 위한 16자리 이상의 키값

	/**
	 * 생성자 선언
	 */
	public Aes256() throws UnsupportedEncodingException {
		this.iv = key.substring(0, 16);
		byte[] keyBytes = new byte[16];
		byte[] b = key.getBytes("UTF-8");
		int len = b.length;
		if (len > keyBytes.length) {
			len = keyBytes.length;
		}
		System.arraycopy(b, 0, keyBytes, 0, len);
		SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");

		this.keySpec = keySpec;
	}
	
	/**
	 * 메소드 선언
	 */
	/**
	 * 문자열을 AES256 방식으로 암호화
	 * @param str : 암호화할 문자열
	 * @return enStr : 암호화된 키값
	 * @throws NoSuchAlgorithmException
	 * @throws GeneralSecurityException
	 * @throws UnsupportedEncodingException : 키값의 길이가 16이하일 경우 발생
	 */
	public String encrypt(String str)
			throws NoSuchAlgorithmException, GeneralSecurityException, UnsupportedEncodingException {
		Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
		c.init(Cipher.ENCRYPT_MODE, keySpec, new IvParameterSpec(iv.getBytes()));
		byte[] encrypted = c.doFinal(str.getBytes("UTF-8"));
		String enStr = new String(Base64.encodeBase64(encrypted));
		
		return enStr;
	}

	/**
	 * AES256 방식으로 암호화된 문자열을 복호화
	 * @param str : 복호화할 문자열
	 * @return deStr : 복호화된 문자열
	 * @throws NoSuchAlgorithmException
	 * @throws GeneralSecurityException
	 * @throws UnsupportedEncodingException : 키값의 길이가 16이하일 경우 발생
	 */
	public String decrypt(String str)
			throws NoSuchAlgorithmException, GeneralSecurityException, UnsupportedEncodingException {
		Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
		c.init(Cipher.DECRYPT_MODE, keySpec, new IvParameterSpec(iv.getBytes()));
		byte[] byteStr = Base64.decodeBase64(str.getBytes());
		String deStr = new String(c.doFinal(byteStr), "UTF-8");
		
		return deStr;
	}
}