cmake_minimum_required(VERSION 3.4.1)

set(CMAKE_VERBOSE_MAKEFILE on)
#set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=gnu++11")

find_library(
    log-lib
    log)

#
# OpenES transcode
#
#aux_source_directory(src/main/cpp/avilib AVILIB_SRC_LIST)
#add_library(
#    avilib
#    SHARED
#    EXCLUDE_FROM_ALL
#    ${AVILIB_SRC_LIST})
#include_directories(src/main/cpp/avilib)
#include_directories(src/main/cpp/avilib/libtc)
#target_link_libraries(
#    avilib
#    ${log-lib})


###############################################################################

#
# BSdiff
#
aux_source_directory(src/main/cpp/bsdiff BSDIFF_SRC_LIST)
add_library(
    bsdiff
    SHARED
    EXCLUDE_FROM_ALL
    ${BSDIFF_SRC_LIST})

aux_source_directory(src/main/cpp/bzip2 BZIP2_SRC_LIST)
add_library(
    bzip2
    SHARED
    EXCLUDE_FROM_ALL
    ${BZIP2_SRC_LIST})

include_directories(src/main/cpp/bsdiff)
include_directories(src/main/cpp/bzip2)
target_link_libraries(
    bsdiff
    bzip2
    ${log-lib})

###############################################################################

#
# native-c
#
aux_source_directory(src/main/cpp/c SRC_LIST)
add_library(
    native-c
    SHARED
    EXCLUDE_FROM_ALL
    ${SRC_LIST})
target_link_libraries(
    native-c
    ${log-lib})

###############################################################################

#
# native-lib
#
add_library(
    native-lib
    SHARED
    src/main/cpp/native-lib.cpp)
target_link_libraries(
    native-lib
    ${log-lib})


###############################################################################

#
# NATIVE-FIX
#
aux_source_directory(src/main/cpp/hotfix HOTFIX_SRC)
add_library(
    native-fix
    SHARED
    EXCLUDE_FROM_ALL
    ${HOTFIX_SRC})
target_link_libraries(
    native-fix
    ${log-lib})


