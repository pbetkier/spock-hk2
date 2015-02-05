package org.github.pbetkier.spock.hk2

import org.glassfish.hk2.utilities.Binder
import org.spockframework.runtime.extension.ExtensionAnnotation

import java.lang.annotation.ElementType
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import java.lang.annotation.Target

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@ExtensionAnnotation(Hk2Extension)
@interface UseBinders {

    Class<? extends Binder>[] value() default []
    Class<? extends Closure> instances() default {}

}