package com.ifound.common.utils

import org.koin.core.qualifier.Qualifier
import org.koin.core.qualifier.QualifierValue

@Target(AnnotationTarget.FIELD, AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
@Retention(AnnotationRetention.BINARY)
annotation class IODispatcher // Or however you've named it

@Target(AnnotationTarget.FIELD, AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
@Retention(AnnotationRetention.BINARY)
annotation class DefaultDispatcher

object IODispatcherQualifier : Qualifier {
    override val value: QualifierValue = "IODispatcher"
}

object DefaultDispatcherQualifier : Qualifier {
    override val value: QualifierValue = "DefaultDispatcher"
}