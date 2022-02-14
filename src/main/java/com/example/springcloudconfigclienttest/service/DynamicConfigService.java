package com.example.springcloudconfigclienttest.service;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

@Service
@RefreshScope
public class DynamicConfigService {

  @Value("${config.profile}")
  private String profile;

  @Value("${config.comment}")
  private String comment;

  public Map<String, String> getConfig() {
    Map<String, String> map = new HashMap<>();
    map.put("profile", profile);
    map.put("comment", comment);
    return map;
  }
}
