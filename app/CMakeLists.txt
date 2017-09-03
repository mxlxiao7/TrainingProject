cmake_minimum_required(VERSION 3.4.1)

aux_source_directory(src/main/cpp/c SRC_LIST)
add_library(
    native-c
    SHARED
    EXCLUDE_FROM_ALL
    ${SRC_LIST})


add_library(
    native-lib
    SHARED
    src/main/cpp/native-lib.cpp)

find_library(
    log-lib
    log)

target_link_libraries(
    native-lib
    ${log-lib})

target_link_libraries(
    native-c
    ${log-lib})