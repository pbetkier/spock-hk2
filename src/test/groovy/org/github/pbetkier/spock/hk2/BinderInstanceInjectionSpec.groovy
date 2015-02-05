package org.github.pbetkier.spock.hk2

import org.github.pbetkier.spock.hk2.binders.AnotherTestBinder
import spock.lang.Specification

import javax.inject.Inject

@UseBinders(instances = { new AnotherTestBinder() })
class BinderInstanceInjectionSpec extends Specification {

    @Inject
    Long injected

    def "should inject into fields from provided binder instances"() {
        expect:
        injected == 100
    }

}