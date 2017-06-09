package mh;

/**
 * 
 * @Description TODO
 * @author muhong
 * @time 2017年6月9日 上午11:44:49
 */
public class CommonUtil {

	public static String getFullPath(String fileName) {
		String fullPath = "";
		fullPath = System.getProperty("user.dir")+fileName;
		System.out.println(fullPath);  
		return fullPath;
	}
}
