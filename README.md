# Spock-HK2 [![Build Status](https://travis-ci.org/pbetkier/spock-hk2.svg?branch=master)](https://travis-ci.org/pbetkier/spock-hk2)

Spock extension which helps writing integration tests in your [HK2-based](https://hk2.java.net/) application with explicit binders.

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

You can provide either a single binder or a list of binder classes.

### Binder instances

The example above defined binder classes to be used in an integration test. You can also define a binder instance or instances instead or besides binder classes: ``@UseBinders(instances = { new MyBinder() })`` or ``@UseBinders(instances = { [new MyBinder(), new MyOtherBinder()] })``.

### Other features

You may define your binders in a superclass, e.g. in a common ``IntegrationSpec`` abstract specification. You can inject into ``@Shared`` fields as well. Consult the project's tests for more examples.

## License

```
Copyright (C) 2015 Piotr Betkier

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0      

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

