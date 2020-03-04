package travel.util;

import java.util.UUID;

/**
 * 产生UUID随机字符串工具类
 */
public final class UuidUtil {
	private UuidUtil(){}
	//randomUUID()：生成全球唯一的字符串
	public static String getUuid(){
		return UUID.randomUUID().toString().replace("-","");
	}
	/**
	 * 测试
	 */
	public static void main(String[] args) {
		System.out.println(UuidUtil.getUuid());
		System.out.println(UuidUtil.getUuid());
		System.out.println(UuidUtil.getUuid());
		System.out.println(UuidUtil.getUuid());
	}
}
