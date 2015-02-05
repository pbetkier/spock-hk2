package org.github.pbetkier.spock.hk2

import org.github.pbetkier.spock.hk2.binders.TestBinder
import spock.lang.Specification

import javax.inject.Inject

@UseBinders(TestBinder)
class BasicConfigurationSpec extends Specification {

    @Inject
    String injected

    def "should inject into fields from binder class"() {
        expect:
        injected == "my value"
    }

}
