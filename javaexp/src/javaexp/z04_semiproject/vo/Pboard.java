package javaexp.z04_semiproject.vo;

import java.util.Date;

public class Pboard {
	private String id;
	private String bno;
	private String btitle;
	private String notice;
	private Date crdate;
	private int cb;
	private String boardseq;
	
	public Pboard() {
		
	}
	//게시판생성
	public Pboard(String id, String btitle, String notice) {
		this.id = id;
		this.btitle = btitle;
		this.notice = notice;
	}
	public Pboard(String id, String bno, String btitle, String notice, Date crdate) {
		this.id = id;
		this.bno = bno;
		this.btitle = btitle;
		this.notice = notice;
		this.crdate = crdate;
	}
	//게시판수정(공지)
	public Pboard(String notice, String btitle) {
		this.btitle = btitle;
		this.notice = notice;
	}
	//게시판조회
	public Pboard(String bno, String btitle, String notice, int cb) {
		this.bno = bno;
		this.btitle = btitle;
		this.notice = notice;
		this.cb=cb;
	}
	
	public String getId() {
		return id;
	}	

	public void setId(String id) {
		this.id = id;
	}
	public String getBno() {
		return bno;
	}
	public void setBno(String bno) {
		this.bno = bno;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getNotice() {
		return notice;
	}
	public void setNotice(String notice) {
		this.notice = notice;
	}
	public Date getCrdate() {
		return crdate;
	}
	public void setCrdate(Date crdate) {
		this.crdate = crdate;
	}
	public int getCb() {
		return cb;
	}
	public void setCb(int cb) {
		this.cb = cb;
	}
	public String getBoardseq() {
		return boardseq;
	}
	public void setBoardseq(String boardseq) {
		this.boardseq = boardseq;
	}
	
	
}
