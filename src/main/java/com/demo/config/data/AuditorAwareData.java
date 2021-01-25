package com.demo.config.data;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.util.StringUtils;

public class AuditorAwareData implements AuditorAware<String> {

	public static final String INITIATOR = "SYSTEM";

	@Override
	public Optional<String> getCurrentAuditor() {
		return Optional.of(StringUtils.isEmpty(Credential.getUsername()) ? INITIATOR : Credential.getUsername());
	}
}
