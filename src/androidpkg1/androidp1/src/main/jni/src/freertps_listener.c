#include <stdio.h>
#include <string.h>
#include "freertps/freertps.h"
#include "freertps_listener.h"


void chatter_cb(const void *msg)
{
  uint32_t str_len = *((uint32_t *)msg);
  char buf[128] = {0};
  for (int i = 0; i < str_len && i < sizeof(buf)-1; i++)
    buf[i] = ((uint8_t *)msg)[4+i];
  //printf("I heard: [%s]\n", buf);
}

void f1(void)
{
  //printf("hello, world!\r\n");
  freertps_system_init();
  frudp_pub_t *pub = freertps_create_pub(
      "chatter", "std_msgs::msg::dds_::String_");
  frudp_disco_start();
  int pub_count = 0;
  char msg[64] = {0};
  while (freertps_system_ok())
  {
    frudp_listen(500000);
    frudp_disco_tick();
    snprintf(&msg[4], sizeof(msg) - 4, "Hello World: %d", pub_count++);
    uint32_t rtps_string_len = strlen(&msg[4]) + 1;
    uint32_t *str_len_ptr = (uint32_t *)msg;
    *str_len_ptr = rtps_string_len;
    freertps_publish(pub, (uint8_t *)msg, rtps_string_len + 4);
    //printf("sending: [%s]\r\n", &msg[4]);
  }
  frudp_fini();
  //return 0;
}

JNIEXPORT jint JNICALL Java_com_github_rosjava_android_androidp1_FreeRTPSListener_listener
  (JNIEnv * env, jobject obj)
{
  /*int i = 0;
  //printf("hello, world!\r\n");
  freertps_system_init();
  freertps_create_sub("chatter", 
                      "std_msgs::msg::dds_::String_",
                      chatter_cb);
  freertps_start(); // all pubs/subs are created. let's start!
  while (freertps_system_ok() && i < 1)
  {
    i++;
    frudp_listen(1000000);
    frudp_disco_tick();
  }
  frudp_fini();*/
  f1();
  return 0;
}

