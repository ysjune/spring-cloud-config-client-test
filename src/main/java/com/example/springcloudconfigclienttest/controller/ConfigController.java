package com.example.springcloudconfigclienttest.controller;

import com.example.springcloudconfigclienttest.service.DynamicConfigService;
import com.example.springcloudconfigclienttest.service.StaticConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {

  private final StaticConfigService staticConfigService;
  private final DynamicConfigService dynamicConfigService;

  @Autowired
  public ConfigController(
      StaticConfigService staticConfigService,
      DynamicConfigService dynamicConfigService) {
    this.staticConfigService = staticConfigService;
    this.dynamicConfigService = dynamicConfigService;
  }

  @GetMapping(value = "/static")
  public Object getConfigMapOfStatic() {
    return staticConfigService.getConfig();
  }

  @GetMapping(value = "/dynamic")
  public Object getConfigMapOfDynamic() {
    return dynamicConfigService.getConfig();
  }
}
