package com.github.pbetkier.spock.hk2

import com.github.pbetkier.spock.hk2.binders.AnotherTestBinder
import com.github.pbetkier.spock.hk2.binders.TestBinder
import spock.lang.Specification

import javax.inject.Inject

@UseBinders(value = TestBinder, instances = { new AnotherTestBinder() })
class MixedConfigurationSpec extends Specification {

    @Inject
    Integer intValue

    @Inject
    Long longValue

    def "should inject into fields from both binders"() {
        expect:
        intValue == 1
        longValue == 100
    }

}