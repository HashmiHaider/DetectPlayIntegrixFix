cmake_minimum_required(VERSION 3.22.1)

# Project name
project("IntegrityChecker")

# Include directories (if needed)
include_directories(${CMAKE_CURRENT_SOURCE_DIR}/include)

# Create a shared library for IntegrityChecker
add_library(
        IntegrityChecker
        SHARED
        native-lib.c
)

# Find and link system libraries
find_library(log-lib log)

# Link IntegrityChecker against log library
target_link_libraries(
        IntegrityChecker
        ${log-lib}
)
