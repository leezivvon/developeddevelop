package javaexp.a06_object;

import java.util.ArrayList;

public class A16_ONeVsMultiExp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		OnTrain onSys = new OnTrain("온라인 기차 예매");
		onSys.setTlist(new Ticketing("서울-부산","1호차 3B",42000));
		onSys.setTlist(new Ticketing("서울-부산","1호차 3B",42000));
		onSys.setTlist(new Ticketing("서울-부산","1호차 3B",42000));
		onSys.showList();
		
	}
}
/*
 ex) 코레일 예매 시스템

OnTrian(시스템명,ArrayList<Ticketing>)   
Ticketing(구간, 좌석, 비용)
*/
class OnTrain{
	private String sname;
	private ArrayList<Ticketing> tlist;
	public OnTrain(String sname) {
		this.sname = sname;
		this.tlist = new ArrayList<Ticketing>();
	}
	public void setTlist(Ticketing tk) { // 예매할때마다 예매 추가
		this.tlist.add(tk);
		System.out.println(tk.getFromTo()+"예매추가");
	}
	public void showList() {
		System.out.println("시스템명: "+this.sname);
		if(tlist.size()>0) {
			System.out.println("예매 내역 리스트");
			System.out.println("구간\t좌석\t비용");
			for(Ticketing t:tlist) {
				t.ticketInfo();
			}
		
	     }else {
	    	 System.out.println("예매 내역이 없습니다.");
	     }
	}		
//	public void addTicket(Ticketing ticket) {
//		this.tlist.add(ticket);
//		System.out.println(ticket.getSection()+"구간 "+ticket.getSeat()+"번 좌석이 예매되었습니다.");
//		System.out.println("요금은 "+ticket.getFee()+"입니다.");
//	}
//	public void showTicketAll() {
//		System.out.println("---총 예매 내역---");
//		if(tlist.size()>0) {
//			System.out.println("번호\t구간\t좌석 번호\t요금");
//			for(int idx=0;idx<tlist.size();idx++) {
//				Ticketing tt = tlist.get(idx);
//				tt.ticketInfo();
//			}
//			System.out.println("총 예매 표 수: "+tlist.size()+"장");
//			System.out.println("총 예매 요금: "+tot);
//		}
//	}
	
}
class Ticketing {
	private String fromTo;
	private String seat;
	private int fee;
	public Ticketing(String section, String seat, int fee) {
		this.fromTo = fromTo;
		this.seat = seat;
		this.fee = fee;
	}
	
	public void ticketInfo() {
		System.out.print(this.fromTo+"\t");
		System.out.print(this.seat+"\t");
		System.out.print(this.fee+"\t");
	}
	
	// 추후에 필드값을 변경할 때 필요할 수 있으니
	public String getFromTo() {
		return fromTo;
	}
	public void setSection(String fromTo) {
		this.fromTo = fromTo;
	}
	public String getSeat() {
		return seat;
	}
	public void setSeat(String seat) {
		this.seat = seat;
	}
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
	
}

