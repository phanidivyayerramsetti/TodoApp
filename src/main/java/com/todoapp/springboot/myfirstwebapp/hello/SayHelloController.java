package com.todoapp.springboot.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //to mention spring that this class is h=going to handle web requests
public class SayHelloController {
	
	//"say-helo"=>"HEllo! What are you learning today?"
	@RequestMapping("say_hello") // to redirect to the url:http://localhost:8080/say_hello
	@ResponseBody 
	/*without this the string which we want to print will not print as
		spring has some concept called view and it searches for that view so to
		 avoid that we add this annotation so as to print the response in the format what we want to
	*/
	public String sayHello() {
		return "Hello! What are you learning today?";
	}
	
	@RequestMapping("say_hello_html") 
	@ResponseBody 
	public String sayHelloHtml()
	{
		StringBuffer sb = new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>My First WebPage</title>");
		sb.append("</head>");
		sb.append("<body>My First HTML PAGE Edited</body> ");
		sb.append("<html>");
		return sb.toString();
	}
	
	/*it will be difficult when we want to use html but there are hundreds of lines so here is where we use views.*/
	//creating a view using JSP
	
	//src/main/resources/META_INF?resources/WEB_INF/jsp/sayHello.jsp
	@RequestMapping("say_hello_jsp") // to redirect to the url:http://localhost:8080/say_hello
	
	public String sayHelloJSP() {
		return "sayHello";
	}
}
