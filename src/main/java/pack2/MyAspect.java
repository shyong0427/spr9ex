package pack2;

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
		
		if(!no.equals("aa")) {
			System.out.println("ID 불일치! 작업을 여기서 종료합니다.");
			return null;
		} 
		
		Object object = joinPoint.proceed();
		
		return object;
	}
}	