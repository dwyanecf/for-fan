package com.fanchen.clearmind.ebay;

public class LC176SecondHighestSalary {

//	select max(Salary) as SecondHighestSalary
//	from Employee as e
//	where e.Salary < (select max(Salary) as SecondHighestSalary from Employee)
}
