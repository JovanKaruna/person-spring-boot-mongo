package com.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionController {

  @Value(value = "${info.app.group-id:}")
  private String groupId;

  @Value(value = "${info.app.artifact-id:}")
  private String artifactId;

  @Value(value = "${info.app.version:}")
  private String version;

  @Value(value = "${info.app.build-timestamp:}")
  private String timestamp;

  @GetMapping(value = "/version", produces = MediaType.TEXT_PLAIN_VALUE)
  public String version() {
    StringBuilder version = new StringBuilder();
    version.append("maven.project.groupId=").append(this.groupId).append("\n");
    version.append("maven.project.artifactId=").append(this.artifactId).append("\n");
    version.append("maven.project.version=").append(this.version).append("\n");
    version.append("maven.build.timestamp=").append(this.timestamp);
    return version.toString();
  }

}