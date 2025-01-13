# TodoApp
installing Java :

1.Click on this url:
2.Slecte latest version.
3.Select your OS and X64 bit
4.Download
5. open downloaded feile and click ok and next untill installation is successful. In between save the file path(Ex:C:\Program Files\Java\jdk-21\)C:\Program Files\Java\jdk-22\
6.in windows, search environment variables-> click on edit system environment variables-> system settings->select Path->edit-> new->give the saved file path from above step->move it to top by clicking on move up tab-> ok->ok
---------------------------------------------------------------------------------------------------------------------

Installing Eclipse:
1. Click on this URL:
2. Dont directly click on download , click on download packages
3. then select eclipse for enterprise edition and web applications
4. select os and then download
5. from downloads copy(normal eclipse folder not a zipped one) it to another folder( example: F drive)
6. Slect the copied folder and then click on eclipse folder starts runnimg and then it will install
---------------------------------------------------------------------------------------------------------------------------
installing project structure( Via start.spring.io):
1.do not use snapshot version as they are under edvlopment.
2.select maven project
3.select latest version of spring boot
4.project metadata: groupId(ex:com.practise.springboot) is simliar to package name and artificate id(Ex:learn-spring-boot) is similar to class name.
5.keep the rest of the values as default.
6.slect spring web as dpendency
7.click generate and download the file.
8.move the file to c drive
9.file->import->existing maven projects->next->browse->zip file
10.click on learnspingbootappilcation and run as.
----------------------------------------------------------------------------------------------------------------------------

Creating a simple REST API:
1.use @RestController annotation which is under org.springframework.web.bind.annotation.RestController
2.to map a URL we need to use @RequestMapping("/courses")
3.Stop the previous run in console and again run the learnSpringBoot application 
4. Now go to chrome and search for https:localhost:8080/courses
5.you will find the courses
----------------------------------------------------------------------------------------------------------------------------
Spring boot features:

prouction-ready,quicker.
To build uick we ahve 4 tools.They are :
1.Spring initializer-----to create spring boot projects(start.spring.io website)
2.Spring boot starter projects-------to define depedecies quickly for projectcc
3.Spring boot auto config-----automatically define configurations for dependencies in clsss path
4.Spring boot dev tools.-----to make application changes without starting the server.


To be prouction-ready:

1.logging
2.Different config for different envirnoment--------dev, prod,testing
3.monitoring-----------Spring boot actuator
----------------------------------------------------------------------------------------------------------------------
Spring boot starter:

To build a project we need tp build rest API(Spring, Spring MVC, Tomcat, Json Conversion), write UTs(Spring test, Junit, Mockito).

To group al these and ,make it easy to build applications we use starters.They are convenient dependency descriptors for different features.
For exmple in pom.xml, we have a dependency to build rest API and web Applications under org.springframework.boot->spring-bbot-starter-web dependency and spring-boot-starter-test(for tessts)
sprimg-boot-starter-json to convert to json, spring-boot-starter-tomcat to run tomcat server, spring-web for MVC framework
spring-boot-starter-JPA----talk to database using JPA
spring-boot-starter-JDBC-----talk to JDBC using JDBC
Sping-boot-starter-security-----securing our web application or rest API.

---------------------------------------------------------------------------------------------------------------------------------------

Spring Boot auto config:
we need configuration for dependencies like to component scan, dispatcherServelet, Data sources, JSon conversion.To simplify these we need auto configs.
It is based on the frameworks that are in class path, existing configs we can overrirde.
They are defined in jar----spring-boot-autoconfigure.jar folder.there will be multiple packages.Specificaly, org.springframework.boot.autoconfigure.web for all rst api related.
For example added this line in application.properties under src/main/resources:logging.level.org.springframework=debug
then the logs will be indebug level wher ewe have a conditions evaluation report.There are positive matches(which are auto configured) and negative matches(which are not).
Selecy one package then ctrl+shift+T paste the package you selected, open.
examle:errorMVCAutoconfig:for error page.(White Label Error page).

--------------------------------------------------------------------------------------------------------------------------

spring devtools:

Initially for evry change we have made we are restarting the server to run the project.To avoid this we use spring dev tools
to use it, we need pom.xml file.
open pom.xml file->add spring-boot-devtools as a dependency_> wait till it loads->try make some change->its automatically runs without restarting the server_>simply refresh the page
note: whenever we make change in pom.xml we should restart as the spring dev tools doesnt configur pom.xml.


-----------------------------------------------------------------------------------------------------------------------------------

Managing App configurations using profiles(Different config for different envirnoment):

Different enviroments need different configs like diferent databases, diff web services.
To provise diff configs for diff envi we need profiles.
Lets say we hav etwo environemts--prod,dev
For example,in application.properties under src/mian/resources
if ww need logging in trace level but not as debug level for dev we need to add this line by creating new file application-dev.properties under src/main/resources: logging.level.org.springgramework=trace 
in prod in info level ,logging.level.org.springgramework=info by creating new file application-prod.properties under src/main/resources
If no profiles are configured then application uses default application.properties which is having debug leevl
If we want to configure the profile, application.properties->spring.profiles.active=prod. then both default and the profile configs merges together
---------------------------------------------------------------------------------------------------------------------
logging levels supported:

trace->debug->ifo->warning->error->off in hierarchy

------------------------------------------------------------------------------------------------------------
Setting up complex configuration profiles: We are giving values from Application.properties via default and also through dev/prod properties.

1.create a file example, currencyServiceConfiguration----@ConfigurationProperties(prefix = "currency-service"), prefix is the value in application.properties which must match with the prefix.we need to add @component as as Spring needs to manage this.
2.we need to confiure these in application.properties with some default values if we want to overrride we can add them in application-dev.properies.
3.now create a controller calledd CurrencyConfigurationController.
4.@Autowired is used to use the instance(bean) created by spring in another class, then we can use it by naming the variable private classname variable name.
now http://localhost:8080/currency-configuratino

---------------------------------------------------------------------------------------------------------------------
Embedded Servers:Used to simplify deployements. we need it to be simple as there would be multiple environemts.

Old war approcah: install java-> install webServer/application Server(tomcat/websphere/webLogic)->Deploye the application
embedded Servers: intall java->run JAR file.

Process:
Go to project main head->run as->maven build->type clean install in goalss->run.
it will generate a building jar file.
Open cmd-> go to that folder->run command as java -jar file name
it will launch the application.by deploying.(ctrl+c to terminate)
[INFO] Building jar: C:\learn-spring-boot\target\learn-spring-boot-0.0.1-SNAPSHOT.jar(ctrl+c to terminate after successful launch)

embeddedd server examples:
spring-boot-starter-tomcat
sprint-boot-starter-jetty
spring-boot-starter-undertow

--------------------------------------------------------------------------------------------------------------------------------------------------------------

Monitoring Applications usng spring boot actuators:( localhost:8080/actuator/)

1. Monitor and manage your application in production
2. Provides number of end points
 	a.beans- complete lkst of Sprnig  beans in our app
	b.health- app health info
	c.metrics- Details around reuest mappings


--->add this dependency in pom.xml to monitor. after adding this line restart the application and run this link in chrome http:localhost:8080/actuator.If you want to check the health thn click on health link which shows status as up.BY default only health endpoint is exposed by running this , if we want to add some more features then we need to ad in application.properties as below:

<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-actuator</artifactId>
</dependency>

application.properties->management.endpoints.web.exposure.include=* which exposes all endpoints like (check actuator notes)

*beans: This is also used to check whether specific thing is auto configured or not we can check here as well
config-props: shows the properties of configuration values
*metrics:shows the environment properties like when the app started, when it is ready etc.,go to metrics/http.server.requests to see the time taken to run the app and giev the response also tracks how many times the application ran which is under value attribute under measurement.
*env: shows the available environments.


--------------------------------------------------------------------------------------------------------------------------------------------------------------------

SPRING BOOT VS SPRING MVC Vs SPRING:

*spring framework is all about dependency injection. It uses @Component, @Autorwired, component scan etc..(just dependency injection is not sufficient, we need other frameworks like if we want to deal with DB we need hibernte/JPA and we need Junit/mockito for unit testing....these will be provide by Spring Modules and Spring projects under Sprig framework which extend Spring Eco System to integrate with other frameworks)..
*Spring MVC:It is a Spring Module to simplify building web apps and REST APi. Befor this it wass Struts which is very complex.MVC provides @Controller, @restController, @Requestmapping
*Spring Boot: Builds production-ready apps quickly.(to eliminate work in pom.xml, web.xml, application.xml)
		1.Spring initializer-----to create spring boot projects(start.spring.io website)
		2.Spring boot starter projects-------to define depedecies quickly for projectcc
		3.Spring boot auto config-----automatically define configurations for dependencies in clsss path
		4.Spring boot dev tools.-----to make application changes without starting the server.

SPRING BOOT IS NOT A COMPETITOR FOR SPRING MVC OR SPRING, IT IS A WRAPPER THAT MAKES IT EASY TO USE BOTH OF THEM.

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
PROJECT STARTED:
------------------------------------------------------------------------------------------------------------------------------------------------------------------
Building first web application:



It includes:
->web app concepts:browser, html, css, Reuest, response, form, authentication
->Spring MVC: Dispatcher servelet, View Resolvers, Model, view, Controller, Validations
->Spring Boot: Starters, Auto Cconfigurations
-> Frameworks/tools: JSP, JSTL, JPA, Bootstrap, Spring security, Myslq, H2 


STATUS CODE:200 -----success
STATUS CODE:404 -----failed(page not found)

-------------------------------------------------------------------------------------------------------------------------------------------------------------------
To change the port that application run:
application.properties->add this line->server.port=8081
-----------------------------------------------------------------------------------------------------
using html in java code using string buffer is quite complex, so we do use views which include jsp files.


JSP files must created under src/main/resources/META-INF/resources/WEB_INF/jsp/sayHello.jsp

->instead of writing all html code in sayHelloController, we can create a file in the above path and give it a name by which you need to call from controller.
->created sayHello.jsp file in the above folder and from Controller class called that file as return "sayHello" the rest of the path is given as prefix and suffix in application.properties. by adding this line, spring.mvc.view.prefix=""

HOW DOES WEB WORK:

1.Broswer sends a request(HttpRequest) 2. Server handles the request(our spring boot application) 3. Server returns the response(HttpResponse)



model1 Architecture:browser->views(jsps)->model

there is no controller and views seperately, all view logics,flow logics, dat base queries everything is in jsp files only.It is very complex, zero sepertation.

model2 arch:browser->servelets->views(jsps)->model

seperation of concerns.Controller(servelet) is added in between browser->servelets->views(jsps)->model. disadvantage is if same logic is needed across different controllers liek authentication then its repetition.so we use front controller


model2 with  front controller:

browser->front controller->servelets/views->model. Common features can be implemented here.


Dispatcher servelet:


1. recieves http request
2. Processes Http request
	a. Identifies correct controller method(based on request url example: localhost:8080/login)
	b. Executes controller method (Returns model and view name.Ex: LoginController.gotoLoginPage)
	c. identifies correct view (using viewResolver. ex: maps the prefix and suffix in application.properties with the file name given in conroller..WEB_INF/jsp/login.jsp)
	d. executes view
3.Return http response

-----------------------------------------------------------------------------------------------

->if <form method="post">, the data in username and pwd is not displayed in url, if its get or default they will be displayedd which is not secure
->initially, the when the web page loads, its get method but after submitting the form it turns to post method.
->as the login controller is ahving both get and post methods, if we want only one method to execute for login controller.
->this cn be done be done by adding metho=get in requestmapping like as follows: @RequestMapping(value="login",method=RequestMethod.POST)..this restricts the method to execute only foe post.


------------------------------------------------------------------------------------------------------------------
Session vs Request:


->All request from browser are handled by our web application deployed on a server
->erquest scope: once the response is sent back , the request attributes will be removed from memory
->these cannot be used for future requests
->recommened for mst use cases

Sessions:

->details stored across mutiple requests
->be careful while storing sessions as it takes extra space
----------------------------------------------------------------------------------------------------------------------

->we are using expression tags for simple notations of displaying names in jsp files, but if its a complex and more number of lines then we need to use jstl tags.
->For that we need to add jstl dependency in pom.xml as follows.
<dependency>
			<groupId>jakarta.servlet.jsp.jstl</groupId>
			<artifactId>jakarta.servlet.jsp.jstl-api</artifactId>
			</dependency>
		<dependency>
			<groupId>org.eclipse.jetty</groupId>
			<artifactId>glassfish-jstl</artifactId>
			<version>11.0.22</version>
		</dependency>

->jstl tags:https://docs.oracle.com/javaee/5/jstl/1.1/docs/tlddocs/c/tld-summary.html

----------------------------------------------------------------------------------------------------------------------------------------

Using Bootstrap:

add th downloaded bootstrap in the statsi folder
ad the depenedency to add bootstrap in pom.xml

while fetchinh the files from jar u need to add /META-INF/resources/webjars/bootstrap/5.1.3/css/bootstrap.min.css whole path, its enough from webjars/bootstrap/5.1.3/css/bootstrap.min.css
add this in link tag in head, js and jquery should be added before closing body tag

------------------------------------------------------------------------------------------------

VALIDATIONS with Sring boot:

->validation done in front side like adding required tag in input fileds of html can and js can easily be hacked so its always recommendedd to add validation in server side.
-> Springboot starter validations: adding in pom.xml(<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-validation</artifactId>
		</dependency>)
->Command bean(form backing object): 2-way binding(todo.jsp & TodoController.java)-> if there are more request params it would be complex to initialise them paramteres so we use beans where we pass the class 
.....object instead of requestparams
....https://docs.spring.io/spring-framework/docs/3.2.x/spring-framework-reference/html/view.html(18.2.4) import the line in jsp file so that your class object can be used in the jsp file which is calle bounding
->Add validations to bean: todo.java
->Display validation Errors in the view:todo.jsp


----------------------------------------------------------------------------------------------
To add date format to input use datepickerin starter tool
<dependency>
			<groupId>org.webjars</groupId>
			<artifactId>jquery</artifactId>
			<version>3.6.0</version>
		</dependency>

https://bootstrap-datepicker.readthedocs.io/en/latest/


To add authentication:in pom.xml
<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-validation</artifactId>
		</dependency>

-------------------------------------------------------------------------------------------------

Accessing DB:

sources: 
JDBC ->more queries and more java code, 
Spring data JPA-> will take care of everything just implement interface persistantJPAApi
JPA(Java persistence API) or hybernate-> no queries, just mapping entities to tables is enough
Spring JDBC> lot of queries, less jav acode


----------------------------------------------------------------------------------------------------
h2 DB:add this in pom.xml
	<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>com.h2database</groupId>
			<artifactId>h2</artifactId>
			<scope>runtime</scope>
		</dependency>
----------------------------------------------------------------------------------------------------
SQL Db: you need to install docker
then in pom.xml
---------------------------------------------------------------------------------------------------
REST API:

Rest: REpresentational State Transfer
Key Abstraction: Resourse which means for example users and todos in our app. the every opertation that we perform on resource has a URI(unified Resource Identifier). Example URIs: /users/Divya,/Users/Divya/todos, Users/Divya/todos/1.
Action: retrieve/add/update/delete user/todoc


HTTP REQUEST METHODS: 
GET---retrieve details of a resourse
POST---- Create a new resource
PUT----Update an existing resourse
PATCH-----Update part of a resource
DELETE----Delete a resource


RESPONSE STATUS FROM REST API:

Success: 200
Created successfully: 201
Updated Succesfully: 204/200
unAuthorised :401
Bad Request: 400
Resource not found: 404
Server Error: 500
