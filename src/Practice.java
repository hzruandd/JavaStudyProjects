import java.util.ArrayList;
import java.util.List;

public class Practice {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		List<String> test = new ArrayList<String>();
		System.out.println(test.size());
		if (null == test) {
			System.out.println("111");
		}
		String a = "ddd";
		test.add(a);
		test.remove(0);
		if (null == test) {
			System.out.println("222");
		}
		System.out.println("333");
	}

}
