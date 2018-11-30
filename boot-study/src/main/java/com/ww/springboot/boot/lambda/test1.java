package com.ww.springboot.boot.lambda;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class test1 {

	public static void main(String[] args) {
		
		Runnable noArguments = () -> System.out.println("Hello World");
		noArguments.run();
		
		Runnable multiStatement = () -> {
				System.out.print("Hello");
				System.out.println(" World");
				};
		multiStatement.run();
		
		BinaryOperator<Long> add = (x, y) -> x - y;
		Long t = add.apply(1L, 2L);
		System.out.println(t);
		
		BinaryOperator<Long> addExplicit = (Long x, Long y) -> x + y;
		
		Long t2 = addExplicit.apply(1L, 2L);
		
		System.out.println(t2);
		
		
		List<String> collected = Stream.of("a", "b", "c")
				.collect(Collectors.toList());
		System.out.println(collected);
		
		String ids = "1,2,3,4";
		List<Long> idList = Stream.of(ids.split(",")).map(s -> Long.valueOf(s)+2 )
                .collect(Collectors.toList());
       System.out.println(idList);
       
       
       List<String> beginningWithNumbers
       = Stream.of("a", "1abc", "abc1")
       .filter(value -> isDigit(value.charAt(0)))
       .collect(Collectors.toList());
       System.out.println(beginningWithNumbers);
			
	}
	
	private static Boolean isDigit(char ch){
		System.out.println(ch >= '0' && ch <='9');
		return ch >= '0' && ch <='9';
	}
}
