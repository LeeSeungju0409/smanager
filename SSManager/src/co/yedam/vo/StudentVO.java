package co.yedam.vo;

import java.util.Date;

import lombok.Data;
@Data

public class StudentVO {
	private String stdNo; //std_no
	private String stdName;
	private String stdPhone;
	private String address;
	private String birthDate; // 1999-01-01
	private Date creationDate;
	
	
	public String briefShow() {
		return stdNo +"  "+stdName+"  "+stdPhone;
	}
}
