# Fancode
Fancode -SDET Assignment 
Explanation

Dependencies:
1. Create Maven Project
1. Add Rest Assured library in Pom.xml

 <dependency>
        <groupId>io.rest-assured</groupId>
        <artifactId>rest-assured</artifactId>
        <version>5.3.0</version>
    </dependency>
    
2. Add jackson library in Pom.xml

	<!-- https://mvnrepository.com/artifact/org.json/json -->
		<dependency>
			<groupId>org.json</groupId>
			<artifactId>json</artifactId>
			<version>20240303</version>
		</dependency>

<!-- Jackson Databind for JSON Parsing -->
    <dependency>
        <groupId>com.fasterxml.jackson.core</groupId>
        <artifactId>jackson-databind</artifactId>
        <version>2.15.2</version>
    </dependency>

    
***Program Execution*****:

1. Fetch Users:
/users endpoint provides user information, including latitude and longitude.
Parse the response and filter users based on:
Latitude between -40 and 5.
Longitude between 5 and 100.

2. Fetch TODO Tasks:
For each user in FanCode city, fetch their tasks from /todos endpoint using userId as a parameter.

3. Calculate Task Completion:
Count the total tasks and completed tasks for each user.
Calculate the completion percentage using the formula:
Percentage
= ( completed tasks/ total tasks) × 100

4. Condition:
Ensure that the task completion percentage is greater than 50%.

Output:
Print the details of users, their task completion percentage, and whether they meet the condition.
