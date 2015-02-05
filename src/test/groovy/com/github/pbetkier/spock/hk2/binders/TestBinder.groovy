package com.github.pbetkier.spock.hk2.binders

import groovy.transform.TypeChecked
import org.glassfish.hk2.utilities.binding.AbstractBinder

import javax.inject.Inject

@TypeChecked
class TestBinder extends AbstractBinder {

    @Override
    protected void configure() {
        bind "my value" to String
        bind 1 to Integer
        bind 10.0 to BigDecimal named "firstBigDecimal"
        bind 20.0 to BigDecimal named "secondBigDecimal"
    }
}
