package com.example.draftstreaks.exception

import java.io.IOException

class ApiException(message: String) : IOException(message)
class NoInternetException(message: String) : IOException(message)
class RefreshException(message: String) : IOException(message)