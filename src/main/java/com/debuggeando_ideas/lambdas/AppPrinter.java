package com.debuggeando_ideas.lambdas;

import com.debuggeando_ideas.fundamentals.Employee;
import com.debuggeando_ideas.fundamentals.Product;

public class AppPrinter {
    public static void main(String[] args) {
        Printer<String> printString = word -> System.out.println(word);
        Printer<Product> printProduct = product -> System.out.println(product);
        Printer<Employee> printEmployee = employee -> System.out.println(employee);

        printString.print("Hello, World!");
        printProduct.print(new Product("Laptop", 1000.0));
        printEmployee.print(new Employee("John", 1000.0));
    }
}
