package com.yedam.vo;

import java.sql.Date;

import lombok.Data;


@Data
public class ReplyVO {
	private int replyNo;
	private String replyContent;
	private String replyer;
	private Date replyDate;
	private int boardNo;
}
