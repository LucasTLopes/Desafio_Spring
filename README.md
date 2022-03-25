# Spring Boot "Challenge - 1" by "ITB-Two-Factor"


The objective of this project is to exercise all the learning acquired during module 1/2 (01/2022) of IT MELI BOOTCAMP


## How to Run 

You run it using the ```java -jar``` or the ```mvn spring-boot:run``` commands.

* Clone this repository 
* Make sure you are using JDK 1.8 and Maven 3.x
* You can build the project and run the tests by running ```mvn clean package```
* Once successfully built, you can run the service by one of these two methods:
```
       mvn spring-boot:run 
```
* Check the stdout on your console to view logs, exceptions  and more 

Once the application runs you should confirm  something like this

```
http:/localhost:8080/ping
```

## About the Service

An online product sales platform wants to improve search options and
filtering your products; For that, I decided to implement a search engine that,
of the options that the user determines, returns the product(s) that he
matches.

## ENDPOINTS 
Here are explication about endpoints you can call:

 * [Articles](/docs/Articles.MD)
 * [Purchases](/docs/Purchases.MD)
 * [Cart](./docs/Cart.MD)
 * [Customer](./docs/Customer.MD)


### RELEASE 1.0.0 (2022-03-25)

##### New Features

*  create PurchaseDTO ([d73eb117](https://github.com/olimpioluis/Desafio_Spring/commit/d73eb117726cd1f11aa914dfe82ede6cd323170f))
*  create endpoint to list cart ([4d036871](https://github.com/olimpioluis/Desafio_Spring/commit/4d036871d46bb95e398e9faf2ecc64a16eda5c5d))
*  create endpoint to list all purchases ([fcb3b5e6](https://github.com/olimpioluis/Desafio_Spring/commit/fcb3b5e6f961de721d8f183a92c67dd4ccad53ac))
*  save purchases in json file ([c3651719](https://github.com/olimpioluis/Desafio_Spring/commit/c36517193d86f70df06a5c2b7b4977e98a31e367))
*  implement read and write in archives and finish filters ([741a7cfe](https://github.com/olimpioluis/Desafio_Spring/commit/741a7cfe302dca7486f696e73467b74f0d3ba483))
*  validator exceptions ([fc05df02](https://github.com/olimpioluis/Desafio_Spring/commit/fc05df020b5d11b77a012eab2624ecc32da03445))
*  Create endpoint to save Purchase ([6abf16a6](https://github.com/olimpioluis/Desafio_Spring/commit/6abf16a6c973dd8fa1ad0b73d503e362a281ca04))
*  create endpoint to list articles and filter by category name ([f979cbc4](https://github.com/olimpioluis/Desafio_Spring/commit/f979cbc4a595cf8124f252e96014295ace986f67))
*  create endpoint to register a list of articles ([d103fd48](https://github.com/olimpioluis/Desafio_Spring/commit/d103fd480c3715bbe255c661c06118305ba909e9))

##### Bug Fixes

*  articles.json file formatted after the initial articles warehouse ([b4efa093](https://github.com/olimpioluis/Desafio_Spring/commit/b4efa093b914b9fcba608bf58397beeec58ad702))
*  git  conflicts ([991751a7](https://github.com/olimpioluis/Desafio_Spring/commit/991751a79a301c0512d9f05f89d751fa1711d07e))
*  savePurchase repair ([4661715c](https://github.com/olimpioluis/Desafio_Spring/commit/4661715cc4c811b0f928b9ebc9fe6d1a9eb22a57))

##### Other Changes

*  create postman collection ([88a10e56](https://github.com/olimpioluis/Desafio_Spring/commit/88a10e56eef05ad54894c30b862efa131f82050a))
*  create exceptions  handler ([cf405246](https://github.com/olimpioluis/Desafio_Spring/commit/cf4052463ac992709371514116179660f601791b))
*  create product attributes ([6fbfa5b7](https://github.com/olimpioluis/Desafio_Spring/commit/6fbfa5b7f6bf560a990b495929ba5785d1af5edd))
*  structure of folders ([71de1e13](https://github.com/olimpioluis/Desafio_Spring/commit/71de1e139bb23a461ee275904faa1ec1e13d9e4f))
*  initial commit ([dac3330b](https://github.com/olimpioluis/Desafio_Spring/commit/dac3330b47d4f78fca1190ec388386dcab4d5eea))

##### Refactors

*  adjusts on methods name and params ([303ea9b0](https://github.com/olimpioluis/Desafio_Spring/commit/303ea9b09547919ed72150aa643ce010545cb8ff))

#### 1.0.0 (2022-03-25)




# About Spring Boot

Spring Boot is an "opinionated" application bootstrapping framework that makes it easy to create new RESTful services (among other types of applications). It provides many of the usual Spring facilities that can be configured easily usually without any XML. 



# Questions and Comments:
     Open a issue on this project 
