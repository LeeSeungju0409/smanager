package com.yedam.stream;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 바이트(1byte), char (2byte) => 객체를 처리하는 보조스트림.
 */
public class ObjectStreamEx1 {
	public static void main(String[] args) {
		List<MemberVO> members = new ArrayList<>();
		members.add(new MemberVO(101, "김꽃님", 120));
		members.add(new MemberVO(102, "박달님", 110));
		members.add(new MemberVO(102, "이햇님", 110));
		members.add(new MemberVO(102, "최별님", 100));
		
		try {
			FileOutputStream fos = new FileOutputStream("c:/temp/file4.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			// serialize(직렬화) -> deserialize(역직렬화)
			oos.writeObject(members);
			
			oos.flush();oos.close();
			fos.flush();fos.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("완료!!!");
	}
}
