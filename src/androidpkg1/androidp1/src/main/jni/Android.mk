LOCAL_PATH := $(call my-dir)

# Declare static library module
include $(CLEAR_VARS)
LOCAL_MODULE    := freertps_lib
LOCAL_SRC_FILES := static_lib/libfreertps_lib.a
LOCAL_EXPORT_C_INCLUDES := $(LOCAL_PATH)/static_lib/include
include $(PREBUILT_STATIC_LIBRARY)

# Declare shared library module
include $(CLEAR_VARS)
LOCAL_MODULE    := freertps_listener
LOCAL_SRC_FILES := src/freertps_listener.c
LOCAL_STATIC_LIBRARIES := freertps_lib
LOCAL_LDLIBS += -landroid -llog
LOCAL_CFLAGS += -std=c99
include $(BUILD_SHARED_LIBRARY)

