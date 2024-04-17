package kr.or.ddit.study06.sec03;

public class Sing {
	// 곡명 가수 가사
	String title;
	String singer;
	String descript;
	int since;

	public Sing() {

	}

	public Sing(String title, String singer,String descript) {
		this.since = 0000;
		this.title = title;
		this.singer = singer;
		this.descript = descript;
	}
	
	public Sing(String title, String singer,String descript, int since) {
		this.since = since;
		this.title = title;
		this.singer = singer;
		this.descript = descript;
	}
}
