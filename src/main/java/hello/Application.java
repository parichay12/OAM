package hello;

import java.nio.file.Files;
import java.io.File;
import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jackson.model.Employee;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@SpringBootApplication
@RestController
@EnableAutoConfiguration
public class Application {
	private final AtomicInteger counter = new AtomicInteger(0);


	public Application() {
	}

	@RequestMapping("/")
	public String home() {
		return "Hello Docker World";
	}

	@RequestMapping("/copyfile")
	public String copyFileUsingJava7Files() throws IOException {
		File source = new File("D:\\logs\\application.log");
		File dest = new File("D:\\Marketplace\\logs\\application\\application.log");
		Files.copy(source.toPath(), dest.toPath());
		return "File copied successfully";
	}

	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public ResponseEntity<Resource> downloadFile() {

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachments; filename=\"Download.zip\"");
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

		File file = new File("D:\\Demo\\download\\sample.zip");

		FileSystemResource fileSystemResource = new FileSystemResource(file);

		return new ResponseEntity<>(fileSystemResource, headers, HttpStatus.OK);

	}

	@RequestMapping(value = "/readjson", method = RequestMethod.GET)
	public Employee readJsonWithObjectMapper() throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		Employee emp = objectMapper.readValue(new File("D:\\Demo\\json\\employee.json"), Employee.class);
		System.out.println(emp.toString());
		return emp;
	}
	
	
	/*public DeferredResult<ResponseEntity<?>> timeDeferred() {
	   
	    DeferredResult<ResponseEntity<?>> result = new DeferredResult<>();
	    

	    new Thread(() -> {
	        result.setResult(ResponseEntity.ok(method1()));
	    }, "MyThread-" + counter.incrementAndGet()).start();

	    return result;
	}*/
	
	@RequestMapping(value = "/deferred/{id}", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<String>> method1(@PathVariable("id") int id) {
		ArrayList<String> status = new ArrayList<String>();
		if(id == 1)
		{
		int i, m = 0, flag = 0;
		int n = 17;// it is the number to be checked
		m = n / 2;
		for (i = 2; i <= m; i++) {
			if (n % i == 0) {
				System.out.println("Number is not prime");
				flag = 1;
				break;
			}
		}
		if (flag == 0)
		{
			System.out.println("Number is prime");
		}
		status.add("Method 1 executed successfully");
		}
		else if(id == 2)
		{
		method2(status);
		}
		else if (id ==3) {
			method3(status);
		}
		else
		{
			method4(status);
		}
		return new ResponseEntity<>(status, HttpStatus.OK);
		
	}

	private ResponseEntity<ArrayList<String>> method2(ArrayList<String> status) {
		//ArrayList<String> status = new ArrayList<String>();
		int i, fact = 1;
		int number = 5;// It is the number to calculate factorial
		for (i = 1; i <= number; i++) {
			fact = fact * i;
		}
		System.out.println("Factorial of " + number + " is: " + fact);
		status.add("Method 2 executed successfully");
		//status1.add("Method 2 executed successfully");
		//method3(status1);
		return new ResponseEntity<>(status, HttpStatus.OK);

	}

	private ResponseEntity<ArrayList<String>> method3(ArrayList<String> status) {
		//ArrayList<String> status = new ArrayList<String>();
		int c = 0, a, temp;
		int n = 153;// It is the number to check armstrong
		temp = n;
		while (n > 0) {
			a = n % 10;
			n = n / 10;
			c = c + (a * a * a);
		}
		if (temp == c)
			System.out.println("153 is an armstrong number");
		else
			System.out.println("Not armstrong number");
		//status2.add("Method 3 executed successfully");
		//method4(status2);
		status.add("Method 3 executed successfully");
		return new ResponseEntity<>(status, HttpStatus.OK);

	}

	private ResponseEntity<ArrayList<String>> method4(ArrayList<String> status) {
		//ArrayList<String> status = new ArrayList<String>();
		int number = 17654; //reverse number
		int reverse = 0;
		while (number != 0) {
			reverse = (reverse * 10) + (number % 10);
			number = number / 10;
			System.out.println("reverse number is"+number);
		}
		status.add("Method 4 executed successfully");
		return new ResponseEntity<>(status, HttpStatus.OK);

	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}