package com.fanchen.clearmind;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class PeopleTest {
	public static void main(String[] args) {
		
		List<List<String>> list = Arrays.asList(
				  Arrays.asList("a"),
				  Arrays.asList("b"));
				System.out.println(list);
				
				
				System.out.println(list
						  .stream()
						  .flatMap(Collection::stream)
						  .collect(Collectors.toList()));
		
		People JinBao = new People("ChenJin",25,"CHN");
		System.out.println(JinBao.toBigString());
		
		
	}
	
	
	

}
