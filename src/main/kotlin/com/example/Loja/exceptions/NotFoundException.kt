package com.example.Loja.exceptions

import java.lang.RuntimeException

class NotFoundException(override val message: String)
    : RuntimeException()