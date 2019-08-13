package util;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Calendar;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

import com.abbot.schimneylife.util.ConfigureUtil;
import com.abbot.schimneylife.util.Md5Util;

public class Mod5UtilTest {

	@Test
	public void testBit() {
		String password = "admin";
		String salt = Md5Util.createSalt();
		System.out.println(salt);
		try {
			String p = Md5Util.encodeByMod5(password, salt);
			System.out.println(p);
			System.out.println(Md5Util.checkPassword(password, salt, p));
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Test
	public void testSalt() {
		Random ranGen = new SecureRandom();
        byte[] aesKey = new byte[3];
        ranGen.nextBytes(aesKey);
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < aesKey.length; i++) {
            String hex = Integer.toHexString(0xff & aesKey[i]);
            if (hex.length() == 1)
                hexString.append('0');
            hexString.append(hex);
        }
        System.out.println(hexString);
	}
	@Test
	public void testRegex() {
		String mappingURL = "(/user/)|(/company/)";
		Pattern pattern = Pattern.compile(mappingURL);
		Matcher matcher = pattern.matcher("http://localhost:8080/SChimneyLife/company/validateCode.do");
		System.out.println(matcher.matches());
		System.out.println(matcher.find());
		
	}
	@Test
	public void testTime() {
		long good = System.currentTimeMillis();
		System.out.println(good);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long after = System.currentTimeMillis();
		System.out.println(after-good);
	}
	@Test
	public void testPath() {
		Calendar calendar = Calendar.getInstance();
		String path = ConfigureUtil.PRODUCT_IMAGE.toString();
		path += calendar.get(Calendar.YEAR)+"/"+(calendar.get(Calendar.MONTH)+1)+"/"+calendar.get(Calendar.DAY_OF_MONTH);
		System.out.println(path);
	}
	public void testInt() {
		
	}
}
