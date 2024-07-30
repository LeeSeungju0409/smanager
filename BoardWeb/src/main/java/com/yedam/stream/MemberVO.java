package com.yedam.stream;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // 기본생성자 만들어줌
@AllArgsConstructor //필드 전체 매개값 가지는 생성자 만들어줌 -> 기본생성자 없어지기 때문에 
@NoArgsConstructor // 이걸 넣어줌.
public class MemberVO implements Serializable {
	private int memberNo;
	private String memberName;
	private int point;
}
