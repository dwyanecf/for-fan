package com.fanchen.clearmind;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Person {

		public int age;
		public String name;
		public String email;
		
		public Person(int ageFromInput, String nameFromInput, String emailFromInput) {
			this.age = ageFromInput;
			this.name = nameFromInput;
			this.email = emailFromInput;
		}
	
}
