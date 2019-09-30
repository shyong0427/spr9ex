package pack;

public class BusinessImpl implements BusinessInter {
	private DeptInter deptInter;
	
	public void setDeptInter(DeptInter deptInter) {
		this.deptInter = deptInter;
	}
	
	public void dataShow() {
		int count = 0;
		for(DeptDto d : deptInter.selectList()) {
			System.out.println(d.getJikwon_no() + " " + d.getJikwon_name() + " " + d.getBuser_name() + " " + d.getJikwon_jik());
			count++;
		}
		System.out.println("인원 수 : " + count);
	}
}