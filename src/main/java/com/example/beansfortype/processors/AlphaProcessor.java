package com.example.beansfortype.processors;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.example.beansfortype.Processor;
import com.example.beansfortype.data.AlphaRequest;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class AlphaProcessor implements Processor<AlphaRequest> {

	@Override
	public void process(AlphaRequest bizRequest) {
		bizRequest.alpha = "Set by AlphaProcessor";
		bizRequest.common = "Set by AlphaProcessor";
	}
}
