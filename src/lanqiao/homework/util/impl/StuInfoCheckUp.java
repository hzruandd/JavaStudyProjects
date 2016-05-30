package lanqiao.homework.util.impl;

import lanqiao.homework.util.InputCheckUp;
/**
 * 验证学生信息是否输入正确
 * @author Doctor邓
 *
 */
public class StuInfoCheckUp implements InputCheckUp {

	@Override
	public boolean checkInput(String input, String symbol) {
		boolean temp = false;
		
		switch(symbol) {
		case "stu_id":
			temp = checkId(input);
			break;
		case "class_id":
			temp = checkClassId(input);
			break;
		case "stu_name":
			temp = checkName(input);
			break;
		case "stu_age":
			temp = checkAge(input);
			break;
		case "stu_address":
			temp = checkAddress(input);
			break;
		}
		
		return temp;
	}
	
	public boolean checkId(String input) {
		return false;
	}
	
	public boolean checkClassId(String input) {
		return false;
	}
	
	public boolean checkName(String input) {
		return false;
	}
	
	public boolean checkAge(String input) {
		return false;
	}
	
	public boolean checkAddress(String input) {
		return false;
	}
}
