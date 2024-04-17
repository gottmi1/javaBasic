package vo;

public class BookVo {
	private int book_no;
	private String writer;
	private String title;
	private String content;
	private String pub_date;
	private String pub;
	// Map의 단점 : 데이터 가져올 때 컬럼명을 일치시켜야 함 = db의 컬럼을 외워야해서 드럽게 귀찮음
	// Vo쓰면 맵으로 캐스팅할 필요가 없다
	
	// Vo의 단점, Map으로 가져온 걸 일일이 여기로 담아줘야 함
	
	public int getBook_no() {
		return book_no;
	}
	public void setBook_no(int book_no) {
		this.book_no = book_no;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPub_date() {
		return pub_date;
	}
	public void setPub_date(String pub_date) {
		this.pub_date = pub_date;
	}
	public String getPub() {
		return pub;
	}
	public void setPub(String pub) {
		this.pub = pub;
	}
	
	@Override
	public String toString() {
		return book_no+"\t"+title+"\t"+content+"\t"+writer+"\t"+pub_date+"\t"+pub;
	}
	
}
