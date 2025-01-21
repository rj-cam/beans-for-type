package com.example.beansfortype.processors;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.example.beansfortype.Processor;
import com.example.beansfortype.data.CharlieRequest;

@Component
@Order(Ordered.LOWEST_PRECEDENCE)
public class CharlieGenericProcessor<REQ extends CharlieRequest> implements Processor<REQ> {

	@Override
	public void process(REQ bizRequest) {
		bizRequest.charlie = "Set by CharlieGenericProcessor";
		bizRequest.common = "Set by CharlieGenericProcessor";
	}
}
