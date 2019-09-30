package pack;

import java.util.List;
import java.util.Scanner;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component @Aspect
public class MyAspect {
	@Around("execution(public * pack..*(..))")
	public Object mbc(ProceedingJoinPoint joinPoint) throws Throwable {

		System.out.println("권한 확인이 필요합니다.");
		
		System.out.print("사번을 입력하세요 : ");
		Scanner scanner1 = new Scanner(System.in);
		String no = scanner1.nextLine();
		
		System.out.print("이름을 입력하세요 : ");
		Scanner scanner2 = new Scanner(System.in);
		String name = scanner2.nextLine();
		
		Object object = joinPoint.proceed();
		
		if(!no.equals("1") && !name.equals("김")) {
			System.out.println("신원이 불확실합니다. 시스템을 종료합니다.");
			return null;
		} 
		
		
		return object;
	}
}	