package com.far.dictionaryapp.domain.exception

open class DomainException(message: String, title: String? = null) :
    RuntimeException(message, RuntimeException(title))

class MissingParamsException : DomainException("O parâmetros não podem ser nulos.")

class EmptyParamException : DomainException("O parâmetro não pode ser vazio.")