# :mushroom: GGWP - A Web App Project <sub>v: 0.0.1</sub> :mushroom:
:small_orange_diamond:[Jie Mei](https://github.com/M3IJI3) :small_orange_diamond: [Lucas da Silva Rocha](https://github.com/RochaLS) 
:small_orange_diamond: [Ryan Yang](https://github.com/Ryan19900529) :small_orange_diamond: [Ngoc Nguyen](https://github.com/nndu)

## :notebook_with_decorative_cover: About GGWP
GGWP is a gamers oriented community. It contains multiple trend game forums, games can find tutorial and tutors here.

## :bulb: What are used?
* Technology Stack components
* Frontend: HTML, CSS, JavaScript, Thyme leaf, Figma, Bootstrap
* Backend:  Java, Spring Boot
* Database:  MySQL, API
* Deployment: Amazon Web Service
* Versioning Control System: GitHub

## :mag_right: How to use?
1. Please copy repo link to local and open the project in any IDE which supports Springboot project.
```ruby
git clone https://github.com/M3IJI3/GGWP.git
```

2. start your local `Apache` and `Mysql` service on `XAMPP`, check port number of each
   
   ![image](https://github.com/M3IJI3/GGWP/assets/34743976/971a590b-de9a-47a9-b60a-c66e5ad09ccd)
  
3. open you local `phpmyadmin` and import <span color="green">**`ggwp.sql`**</span> to your database

   ![image](https://github.com/M3IJI3/GGWP/assets/34743976/31f2d6ab-70e1-4c05-9d0b-f8bea5282c53)

4. modify your `application.properties`, change xxxx` to your port number found in **step2**
 ```ruby
 spring.datasource.url=jdbc:mysql://localhost:xxxx/ggwp
 ```
5. modify other parameters in `application.properties`, check and make sure if they are correct, someone may not have a password for your database, keep `yourpassword` empty if so
```ruby
spring.datasource.username = yourusername
```

```ruby
spring.datasource.password = yourpassword
```




