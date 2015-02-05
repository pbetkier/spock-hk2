package org.github.pbetkier.spock.hk2

import org.github.pbetkier.spock.hk2.binders.TestBinder
import spock.lang.Shared
import spock.lang.Specification

import javax.inject.Inject
import javax.inject.Named

@UseBinders(TestBinder)
class BasicInjectionSpec extends Specification {

    @Shared
    @Inject
    Integer sharedInjected

    @Inject
    String injected

    @Inject
    @Named("firstBigDecimal")
    BigDecimal first

    @Inject
    @Named("secondBigDecimal")
    BigDecimal second

    def "should inject into shared fields"() {
        expect:
        sharedInjected == 1
    }

    def "should inject into non-shared fields"() {
        expect:
        injected == "my value"
    }

    def "should inject into named fields"() {
        expect:
        first == 10.0
        second == 20.0
    }

}
