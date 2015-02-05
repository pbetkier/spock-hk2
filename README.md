# Spock-HK2 [![Build Status](https://travis-ci.org/pbetkier/spock-hk2.svg?branch=master)](https://travis-ci.org/pbetkier/spock-hk2)

Spock extension which helps writing integration tests in your HK2-based application with explicit binders.

## Installation

To be added soon...

## Usage

Spock-HK2 provides ``@UseBinders`` annotation to define HK2 binders to be used in a given specification and its subclasses. This allows you to inject components into Spock specifications.

```groovy
@UseBinders(YourBinder)
class ExampleSpec extends Specification {

    @Inject
    YourComponent injectedComponent

    def "should inject components into spec fields"() {
        expect:
        injectedComponent != null
    }

}
```

You can define a list of binder classes if you want to.

### Binder instances

The example above defined binder classes to be used in an integration test. You can also define a binder instance or instances intead or besides binder classes: ``@UseBinders(instances = { new MyBinder() })`` or ``@UseBinders(instances = { [new MyBinder(), new MyOtherBinder()] })``.

### Other issues

You may define your binders in a superclass, e.g. in a common ``IntegrationSpec`` abstract specification. You can inject into ``@Shared`` fields as well. Consult the project's tests for more examples.

