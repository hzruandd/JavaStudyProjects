package lanqiao.homework;

public class Stu {
	private int stu_id;
	private int info_id;
	private String stu_name;
	private int stu_age;
	private String stu_sex;
	private String stu_address;
	
	public Stu(int stu_id,int info_id, String stu_name, int stu_age, String stu_sex, String stu_address) {
		super();
		this.info_id = info_id;
		this.stu_id = stu_id;
		this.stu_name = stu_name;
		this.stu_age = stu_age;
		this.stu_sex = stu_sex;
		this.stu_address = stu_address;
	}

	//将学生信息转化为对象数组
	public Object[] stuToArray() {
		Object[] object = {stu_id, stu_name, stu_age, stu_sex, stu_address};
		return object;
	}
	
	public int getInfo_id() {
		return info_id;
	}

	public void setInfo_id(int info_id) {
		this.info_id = info_id;
	}

	public int getStu_age() {
		return stu_age;
	}

	public void setStu_age(int stu_age) {
		this.stu_age = stu_age;
	}

	public int getStu_id() {
		return stu_id;
	}

	public void setStu_id(int stu_id) {
		this.stu_id = stu_id;
	}

	public String getStu_name() {
		return stu_name;
	}

	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}

	public int getStu_number() {
		return stu_age;
	}

	public void setStu_number(int stu_number) {
		this.stu_age = stu_number;
	}

	public String getStu_sex() {
		return stu_sex;
	}

	public void setStu_sex(String stu_sex) {
		this.stu_sex = stu_sex;
	}

	public String getStu_address() {
		return stu_address;
	}

	public void setStu_address(String stu_address) {
		this.stu_address = stu_address;
	}
	

}
