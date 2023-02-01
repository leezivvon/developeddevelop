package javaexp.z04_semiproject.vo;

import java.util.Date;

public class Ppost {
	private String id;
	private String btitle;
	private String bno;
	private String pnoseq;
	private String pno;
	private String pcont;
	private Date wtime;
	private int likecnt;
	
	private String schbtitle;
	
	public Ppost() {

	}
	// 게시글 작성
	public Ppost(String id, String bno, String pcont) {
		this.id = id;
		this.bno = bno;
		this.pcont = pcont;
	}
	// 게시글 조회
	public Ppost(String btitle, String pcont, Date wtime, int likecnt) {
		this.btitle = btitle;
		this.pcont = pcont;
		this.wtime = wtime;
		this.likecnt = likecnt;
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
	public String getPno() {
		return pno;
	}
	public void setPno(String pno) {
		this.pno = pno;
	}
	public String getPcont() {
		return pcont;
	}
	public void setPcont(String pcont) {
		this.pcont = pcont;
	}
	public Date getWTime() {
		return wtime;
	}
	public void setWtime(Date wtime) {
		this.wtime = wtime;
	}
	public int getLikecnt() {
		return likecnt;
	}
	public void setLikecnt(int likecnt) {
		this.likecnt = likecnt;
	}
	public String getPnoseq() {
		return pnoseq;
	}
	public void setPnoseq(String pnoseq) {
		this.pnoseq = pnoseq;
	}


	public String getSchbtitle() {
		return schbtitle;
	}


	public void setSchbtitle(String schbtitle) {
		this.schbtitle = schbtitle;
	}
	
	
	
}
