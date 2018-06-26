LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE    := Helloworld
LOCAL_SRC_FILES := Helloworld.c

include $(BUILD_SHARED_LIBRARY)
