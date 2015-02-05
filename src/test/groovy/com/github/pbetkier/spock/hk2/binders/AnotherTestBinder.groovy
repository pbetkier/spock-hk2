package com.github.pbetkier.spock.hk2.binders

import groovy.transform.TypeChecked
import org.glassfish.hk2.utilities.binding.AbstractBinder

@TypeChecked
class AnotherTestBinder extends AbstractBinder {

    @Override
    protected void configure() {
        bind 100L
    }

}
