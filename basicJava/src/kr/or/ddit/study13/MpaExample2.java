package kr.or.ddit.study13;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MpaExample2 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		MpaExample2 obj = new MpaExample2();
		obj.process();
	}

	public void process() {
		List<Map> processLst = dataInput();
		int max = getMaxSalary(processLst);
		System.out.println("최대 salary는 : " + max);
		printEmp103(processLst);
		Map<String,Integer> map1 = getAddDept(processLst);

//		Set set = map1.keySet();
		Iterator<String> it = map1.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next();
			int salary = map1.get(key);
			System.out.println(key + " : " + salary + "\t원");
		}
		
	}
	
	public Map<String,Integer> getAddDept(List<Map> salList) {
		
		// 각 부서별 월급 총합 구하기
		Map<String,Integer> resultMap = new HashMap();		
		
		for (int i = 0; i < salList.size(); i++) {
			Map map = salList.get(i);
			
			String departmentId = (String)map.get("dept");
			int salary = (int)map.get("salary");
			
			int sum = 0;
			// containsKey 키값 포함 여부 확인
			// resultMap에 이미 같은 dept키 값(영업부,기획부,총무부)이 포함되어 있으면
			if(resultMap.containsKey(departmentId))sum = resultMap.get(departmentId);
			// 전에 저장되어 있던 값을 sum으로 가져옴
			sum+=salary;
			
			resultMap.put(departmentId, sum);
		}
		return resultMap;
	}

	public void printEmp103(List salList) {
		// emp_no 103의 정보 출력
		for (int i = 0; i < salList.size(); i++) {
			Map map = (Map)salList.get(i);
			if((int)map.get("emp_no") == 103) System.out.println(salList.get(i));
		}
	}

	public int getMaxSalary(List salList) {
		// 전체 사원중 가장 높은 salary를 리턴
		int max = 0;
		
		for (int i = 0; i < salList.size(); i++) {
			
			Map map = (Map)salList.get(i);
			int sal = (int)map.get("salary");
			if(max == 0) max = sal;
			if(max < sal) max = sal;
//			for (int j = 0; j < salList.size(); j++) {
//				Map nextMap = (Map)salList.get(j);
//				
//				if(max < (int)nextMap.get("salary")) {
//					max = (int)nextMap.get("salary");
//				}
//			}
		}
		
		return max;
	}

	private List<Map> dataInput() {

		Map map1 = new HashMap();
		map1.put("emp_no", 101);
		map1.put("emp_name", "차정원");
		map1.put("dept", "영업부");
		map1.put("salary", 3000000);

		Map map2 = new HashMap();
		map2.put("emp_no", 102);
		map2.put("emp_name", "이정원");
		map2.put("dept", "기획부");
		map2.put("salary", 350);

		Map map3 = new HashMap();
		map3.put("emp_no", 103);
		map3.put("emp_name", "최정원");
		map3.put("dept", "기획부");
		map3.put("salary", 500);

		Map map4 = new HashMap();
		map4.put("emp_no", 104);
		map4.put("emp_name", "오정원");
		map4.put("dept", "영업부");
		map4.put("salary", 300);

		Map map5 = new HashMap();
		map5.put("emp_no", 105);
		map5.put("emp_name", "김진원");
		map5.put("dept", "총무부");
		map5.put("salary", 1678800);

//		Set set1 = map1.keySet();
//		Set set2 = map2.keySet();
//		Set set3 = map3.keySet();
//		Set set4 = map4.keySet();
//		Set set5 = map5.keySet();

		List<Map> salaryLst = new ArrayList();
		salaryLst.add(map1);
		salaryLst.add(map2);
		salaryLst.add(map3);
		salaryLst.add(map4);
		salaryLst.add(map5);

		return salaryLst;
	}
}
