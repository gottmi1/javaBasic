package kr.or.ddit.study05;

public enum Month {
	JAN("1월"), FEB("2월"), MAR("3월"), APR("4월"), MAY("5월"), JUN("6월"), JUL("7월"), AUG("8월"), SEP("9월"), OCT("10월"),
	NOV("11월"), DEC("12월");

	String str;

	Month(String str) {
		this.str = str;
	}
}
