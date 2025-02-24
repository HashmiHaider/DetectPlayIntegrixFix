package com.example.assessment1

object IntegrityChecker {
    init {
        System.loadLibrary("IntegrityChecker") // Ensure this matches CMakeLists.txt
    }

    external fun detectPlayIntegrityFix(): Boolean
}
