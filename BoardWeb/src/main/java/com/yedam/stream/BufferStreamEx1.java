package com.yedam.stream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.util.List;

public class BufferStreamEx1 {

	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("c:/temp/file4.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			List<MemberVO> list = (List<MemberVO>) ois.readObject();
			list.forEach(member -> System.out.println(member));
			
			ois.close();fis.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("완료!!!");
		
		
		
	}
	
	static void writer1() {
		// 기본스트림 -> 버퍼스트림
		try {
			FileInputStream fis = new FileInputStream("c:/temp/vscode.exe");
			BufferedInputStream bis = new BufferedInputStream(fis);
			
			FileOutputStream fos = new FileOutputStream("c:/temp/vscopy2.exe");
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			
			byte[] buf = new byte[10];
			int read = -1;
			
			while(true) {
//				read = fis.read(buf); // 버퍼의 크기만큼 읽기.
				read = bis.read();
				if (read == -1)
					break;
//				fos.write(buf); // 버퍼의 크기만큼 쓰기.
				bos.write(read);
			}
			bos.flush();bos.close();fos.flush();fos.close();
			bis.close();fis.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
