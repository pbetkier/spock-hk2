package com.github.pbetkier.spock.hk2

import org.glassfish.hk2.utilities.Binder
import org.spockframework.runtime.extension.ExtensionAnnotation

import java.lang.annotation.ElementType
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import java.lang.annotation.Target

/**
 * Activates <a href="https://hk2.java.net/">HK2</a> integration for a specification.
 * The specified binders will be bound together to create a {@link org.glassfish.hk2.api.ServiceLocator}.
 * Services from this ServiceLocator will be injected into the specification based on regular
 * JSR330 annotations. The ServiceLocator will be shut down after the specification's execution.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@ExtensionAnnotation(Hk2Extension)
@interface UseBinders {

    /**
     * Binder classes to instantiate and bind in the ServiceLocator.
     */
    Class<? extends Binder>[] value() default []

    /**
     * Closure returning a single Binder instance or a list of Binder instances
     * to bind in the ServiceLocator.
     */
    Class<? extends Closure> instances() default {}

}