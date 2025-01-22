package com.example.beansfortype.processors2;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.example.beansfortype.ReqResProcessor;
import com.example.beansfortype.data.CharlieSubRequest;
import com.example.beansfortype.data.CharlieSubResponse;

@Component
@Order(Ordered.LOWEST_PRECEDENCE + 1000)
public class CharlieSubReqResProcessor implements ReqResProcessor<CharlieSubRequest, CharlieSubResponse> {

	@Override
	public void process(CharlieSubRequest bizRequest, CharlieSubResponse bizResponse) {
		bizRequest.charlie = "Set by CharlieSubReqResProcessor";
		bizRequest.common = "Set by CharlieSubReqResProcessor";
		bizResponse.charlie = "Set by CharlieSubReqResProcessor";
		bizResponse.common = "Set by CharlieSubReqResProcessor";
	}
}
