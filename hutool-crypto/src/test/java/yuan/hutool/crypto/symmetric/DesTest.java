package yuan.hutool.crypto.symmetric;

import cn.hutool.core.util.StrUtil;
import yuan.hutool.crypto.Mode;
import yuan.hutool.crypto.Padding;
import yuan.hutool.crypto.SecureUtil;
import org.junit.Assert;
import org.junit.Test;

/**
 * DES加密解密单元测试
 */
public class DesTest {

	@Test
	public void encryptDecryptTest(){
		String content = "我是一个测试的test字符串123";
		final DES des = SecureUtil.des();

		final String encryptHex = des.encryptHex(content);
		final String result = des.decryptStr(encryptHex);

		Assert.assertEquals(content, result);
	}

	@Test
	public void encryptDecryptWithCustomTest(){
		String content = "我是一个测试的test字符串123";
		final DES des = new DES(
				Mode.CTS,
				Padding.PKCS5Padding,
				StrUtil.bytes("12345678"),
				StrUtil.bytes("11223344")
		);

		final String encryptHex = des.encryptHex(content);
		final String result = des.decryptStr(encryptHex);

		Assert.assertEquals(content, result);
	}
}
