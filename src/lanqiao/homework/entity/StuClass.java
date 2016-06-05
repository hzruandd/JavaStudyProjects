package lanqiao.homework.entity;

/**
 * 班级信息实体类
 * @author Doctor邓
 *
 */
public class StuClass {
	private int class_id;
	private String class_name;
	private String class_desc;
	
	public StuClass(){
		
	}
	public StuClass(int class_id, String class_name, String class_desc) {
		this.class_id = class_id;
		this.class_name = class_name;
		this.class_desc = class_desc;
	}

	/**
	 * 将班级信息转化为一个对象数组
	 * @return 返回班级信息的对象数组
	 */
	public Object[] classToArray() {
		Object[] object = {class_id, class_name, class_desc};
		return object;
	}
	
	public int getClass_id() {
		return class_id;
	}

	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}

	public String getClass_name() {
		return class_name;
	}

	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}

	public String getClass_desc() {
		return class_desc;
	}

	public void setClass_desc(String class_desc) {
		this.class_desc = class_desc;
	}
}
