# Good practices and standards

## Git Flow

- Notify **zenith-java-dev** slack channel when you:
    - Raise a pull request
    - Code review
    - Finish code review
    - Need additional reviewers
    - Need an urgent pull request reviewed (@here or @ tag individual(s))
    - Merge a branch and ask everyone to update their branches from develop
- Feature branch naming convention follows:
    - **feature**/\<iteration>/\<Jira ticket>-\<description>
    - e.g. feature/20.1.1/base-controller-unit-tests
- Release branch naming convention follows:
    - **release**/\<iteration>.\<version>
    - e.g. release/20.2.9.1
    - Version aligns with Jira release version.

- General git flow policies:
    - Work in small iterations, small PRs please. The smallest the better.
    - Commit often. Several times a day.
    - Push at least once a day, if possible, several times a day also.
    - Do not squash your code manually. Squashes will happen in bitbucket when PR is approved it.

## Main Code Conventions

### General

- Keep it simple
- Follow object-oriented programming principles
- Follow SOLID design principles
- Fully qualify class, interface, enum and member definitions e.g. **Id** is preferred over **id**
- Check existing code if something can be reused before building something new, whether the code exists in the code base
  or there is an existing library

### Exceptions

- There is only 2 custom application-wide exceptions:

  a. **ApplicationServerException. Used when catching a checked exception** Then in the catch section just throw new
  ApplicationException(<original_exception>) passing the original exception as a parameter.

  b. **ApplicationClientException: Used when we want to send a message back to the UI** using MessageKey enum and
  error-messages.properties file from framework-exception API.

### Logging

- Be cautious and check with the architect when using **logger.error** and **logger.catching** **(logger.error**
  and **logger.catching** will generate email alerts)

### Main Code

- Refrain from using **@JsonProperty** (this is handled already in **UtilitiesCommonConfig** on the **ObjectMapper** ).
- Don’t forget to add Hibernate Validation on service request models.
- Don’t forget to add HTTP header validation on service request headers (extends **BaseHttpInterceptor** ) and add to
  the service configuration.
- Don’t forget to add role-based access logic.
- Don’t forget to add audit logs events.

### Documentation

- Don’t forget to add Javadocs on the main code
- Don’t forget to add READMES

### Versions

- Ensure that child poms do not have version or scope.

## Test Code Conventions

### Unit Testing

- Strive to have 100% test code coverage.
- Unit test class names will suffix with **\*Test**
- Test method naming convention follows:
    - **methodUnderTest_given\<condition>_expected\<results>**
    - e.g. create_givenNullServiceRequest_expectedNullResponse
- Repository tests will leverage H2 in-memory database and are considered unit tests
- For any test class that needs to stub behavior, use **@ExtendWith(MockitoExtension.class)**
    - Use **@Mock** to stub a call.
    - Use **@Spy** when intending to call the real method,it could also be stubbed though.
- Add test sample data in test/resources
- Use **ClasspathObjectFactory** to transform sample test data into Java objects.

### Integration Testing

- Integration test class names will suffix with **\*IT**
- Integration test classes need only 1 successful test case
- Controller tests will be slice tests that require Spring
    - Add tests for Hibernate Validation
    - Add tests for role-based access
- Add Postman collections for service and client integrations
