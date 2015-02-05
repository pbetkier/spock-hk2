package org.github.pbetkier.spock.hk2

import org.glassfish.hk2.api.ServiceLocator
import org.glassfish.hk2.utilities.Binder
import org.glassfish.hk2.utilities.ServiceLocatorUtilities
import org.spockframework.runtime.extension.AbstractMethodInterceptor
import org.spockframework.runtime.extension.IMethodInvocation
import org.spockframework.runtime.model.FieldInfo
import org.spockframework.runtime.model.SpecInfo

import javax.inject.Inject

class Hk2Interceptor extends AbstractMethodInterceptor {

    private final ServiceLocator locator
    private final List<FieldInfo> injectedFields

    Hk2Interceptor(SpecInfo spec, Set<Binder> binders) {
        this.locator = ServiceLocatorUtilities.bind("spock-hk2-spec-service-locator-${System.currentTimeMillis()}", binders.toArray() as Binder[])
        this.injectedFields = spec.fields.findAll { it.isAnnotationPresent(Inject) }
    }

    @Override
    void interceptSharedInitializerMethod(IMethodInvocation invocation) {
        handleAnyInitializerMethodInterception(invocation)
    }

    @Override
    void interceptInitializerMethod(IMethodInvocation invocation) {
        handleAnyInitializerMethodInterception(invocation)
    }

    private void handleAnyInitializerMethodInterception(IMethodInvocation invocation) {
        locator.inject(invocation.target)
        invocation.proceed()
    }

}
