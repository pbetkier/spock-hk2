package com.github.pbetkier.spock.hk2

import org.glassfish.hk2.utilities.Binder
import org.spockframework.runtime.extension.AbstractAnnotationDrivenExtension
import org.spockframework.runtime.model.SpecInfo

class Hk2Extension extends AbstractAnnotationDrivenExtension<UseBinders> {

    private final Set<Binder> binders = new HashSet<>()

    @Override
    void visitSpecAnnotation(UseBinders annotation, SpecInfo spec) {
        binders.addAll(createClosure(annotation.instances()).call() ?: [])
        binders.addAll(annotation.value()*.newInstance())
    }

    private Closure createClosure(Class<? extends Closure> closureClass) {
        closureClass.getConstructor(Object, Object).newInstance(null, null)
    }

    @Override
    void visitSpec(SpecInfo spec) {
        if (!binders) {
            return
        }

        Hk2Interceptor interceptor = new Hk2Interceptor(binders)
        SpecInfo topSpec = spec.getTopSpec()
        topSpec.sharedInitializerMethod.addInterceptor(interceptor)
        topSpec.initializerMethod.addInterceptor(interceptor)
    }

}
