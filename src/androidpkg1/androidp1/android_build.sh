#!/bin/sh

export PATH=$PATH:/home/ecorbellini/Android/android-ndk

echo $NDK_PROJECT_PATH

SCRIPT="jni/Android.mk"
APPLICATION="jni/Application.mk"
cd src/main
ndk-build V=1 APP_BUILD_SCRIPT=${SCRIPT} NDK_APPLICATION_MK=${APPLICATION}

