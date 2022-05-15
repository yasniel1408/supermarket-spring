#Zenith application architecture and code overview

The Zenith application is based in the micro-service architecture using Spring Boot. Each of these micro-services has three layers inside them, the Controller layer, the Service layer and the DAO layer:

 * **Controller Layer** - It contains everything related to the http layer. (no business logic).

    * **Service Layer** - It contains ALL the business logic of the application.

        * **DAO Layer** – It contains only database calls (no business logic).

The rule for the three-layer architecture is that each layer above knows about the layer below, but the layer below doesn’t know anything about the layer above.

##Controllers:
All controllers should extend one of these 5 controllers:

1.	BaseCreateController.
2.	BaseDeleteController.
3.	BaseReadMonoController.
4.	BaseReadPolyController.
5.	BaseUpdateController.

**Controllers** should not have any implementations. Only the RestController and RequestMapping annotation and their three respective generics in their class signature.

##Service Layer
**All services** should extend one of these 5 services:

1.	BaseCreateService.
2.	BaseDeleteService.
3.	BaseReadMonoService.
4.	BaseReadPolyService.
5.	BaseUpdateService.

The method that is being forced to be overridden in these services will contain the business logic of what is needed to do for this service.

These services will call a Repository interfaces most of the time to read from the database.

##DAO Layer:
DAO stand for Data Access Object.

The DAOs are called <EntityName>Repository and use the Spring Data JPA framework.

##POMs:
All dependencies **versions** and **scopes** are managed in the **zenith pom** in the dependencyManagement section.

All **children poms** should **NOT** have any **explicit dependency or scope**, unless you really need to override it. It should be inherited by the parent pom.

##Exceptions:
There are only two custom exceptions in our application: 

1. **ApplicationServerException – Used when catching a checked exception**. Then in the catch section just throw new ApplicationServierException (**<original_exception>**) passing the original exception as a parameter.
2. **ApplicationClientException – Used when we want to send a message back to the consumer**.

All exceptions for all our code are handled in the **ControllersExceptionsHandler** class.

##Unit Tests:
Unit tests are super important, and 100% coverage is mandatory during the development phase.

Controllers unit tests should extend one of these:
1.	BaseCreateControllerTest.
2.	BaseDeleteControllerTest.
3.	BaseReadMonoControllerTest.
4.	BaseReadPolyControllerTest.
5.	BaseUpdateControllerTest.

All the other classes should have unit tests with the same package as the real class. Use IntelliJ Junit test generator for this for each class if you want to save some manual work.

Please add all the possible scenarios, 1 positive and as many as negative tests possible for each functionality.

Don’t do unit tests for POJOs or model classes. We use OpenPojo framework for that only extending the BaseModel class and using the @BusinessKey annotation on the fields of the Pojo.

Please name them finishing with the suffix Test so maven will recognize them as Unit tests.

The maven clean install will break if any unit tests fail so we know we introduced an error.

##Integration Tests:
Integration tests are just for the developers to have a test method to test everything end to end (like using postman but without having to start tomcat).  One positive scenario for Controllers.

**Controllers** integration tests should extend BaseControllerIT.

Please name them finishing with the suffix IT so maven could recognize them as integration tests.

##Constants:
Try to avoid classes holding constants fields. Constants fields usually belong to one class in specific.

When several constants fields are related please create an Enum for them. Put the Enum class inside the Model or Class it’s being used or outside in the model package or any package that is being used if it actually doesn’t belong to any class in particular but to several instead.

##Logging:
Use **logger.entry(parameters for the method)** at the beginning of each important method.

Use **logger.exit(return parameters of the method)** at the end of each important method.

All the **logger.catching** and **logger.errors** will send an email alert to our team. Use this one ONLY when it is strictly necessary, otherwise use logger.warn.

User **logger.warn(“Comment”, exception)** when something is serious but not as serious as to get an email alert.

Use **logger.debug(“The customer id is {}, customerId)** when in need to log something for debugging purpose.

There is log4j2.xml file for each environment inside **config** API in the **src/main/resources/{EPAAS_ENV}/log4j2.xml** files. The e3 one contains the one for production, its level should remain to **ERROR** and not being changed ever. This is the section in src/main/resources/e3/log4j2.xml file where indicates that the level is ERROR:

```
<Root level="ERROR" includeLocation="true">
    <AppenderRef ref="Console"/>
</Root>
```

With **LoggingController** log levels can be changed on the fly in any environment if needed. Just type this in the url **{host}/loglevel/debug** for example. Please be careful changing this in production, if you lower the level to something different than error, put it back to error as soon as you are finished.

##Application.properties:
Do **NOT duplicate the same key and value in application properties** for **different environments**. If the value is the same use a common application.properties for all the environments and only use specific for each environments for different values. Look at the application.properties inside services.base as an example of this.

##GIT:
Create a **feature branch** from **develop** when starting a new feature using feature/<sprint_number>/<description> like for example feature/20.1.1/base-controlller-test-refactoring.

As soon as someone merge to develop bring the latest changes from it to avoid big conflicts in the future (Add a watch in bitbucket to know when somebody merge to develop).

Commit often to your local and push at least once a day before the end of the day, push more often if possible. In case you are sick the next day somebody will be able to continue with your work.

We follow the git workflow, please take a look at it [https://www.atlassian.com/git/tutorials/comparing-workflows/gitflow-workflow]






 
