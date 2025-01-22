package com.example.beansfortype.processors;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.example.beansfortype.Processor;
import com.example.beansfortype.data.CharlieSubRequest;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CharlieSubGenericProcessor<REQ extends CharlieSubRequest> implements Processor<REQ> {

	@Override
	public void process(REQ bizRequest) {
		bizRequest.charlie = "Set by CharlieSubGenericProcessor";
		bizRequest.common = "Set by CharlieSubGenericProcessor";
	}
}
