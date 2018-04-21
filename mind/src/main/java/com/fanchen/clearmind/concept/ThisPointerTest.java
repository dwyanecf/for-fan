package com.fanchen.clearmind.concept;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Builder
@Slf4j
public class ThisPointerTest {

	public static void main(String[] args) {
		int ageFromInput = 25;
		String nameFromInput = "fan";
		String emailFromInput = "dwyanecf@gmail.com";

		Person person = Person.builder().age(ageFromInput).name(nameFromInput).email(emailFromInput).build();
		log.info(person.toString());
	}

}
