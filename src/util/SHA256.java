package util;


import java.security.MessageDigest;

public class SHA256 {
	//암호화 작업
	public static String getSHA256(String input) { // 파라미터는 이메일 값
		StringBuffer result = new StringBuffer();
		
		
		String[] nameArr = {"Soobin","Dongjoo","Junseok","Boyoung","Goodee","Korea","Wow","JAVA","Spring","south","north","everybody","dance","wowwowwowow","bigbang","bts","blackpink"};
		int randNum = (int)((Math.random() * 10000) % (nameArr.length-1));
		
		String mixInput = input + nameArr[randNum];
		System.out.println(randNum);
		
		
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] goodie = (nameArr[randNum]).getBytes();
			digest.reset();
			digest.update(goodie);
			byte[] chars = digest.digest(mixInput.getBytes("UTF-8"));
			for (int i = 0; i < chars.length; i++) {
				String hex = Integer.toHexString(0xff & chars[i]);
				if(hex.length() == 1) result.append("0");
				result.append(hex);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result.toString();
	}
}
