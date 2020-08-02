package com.study.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;

@Component
@ConfigurationProperties(prefix = "apiserver")
@Getter
@Setter
public class AppProperties {
	@NotNull
	private String clientId;
	@NotNull
	private String clientSecret;
}
