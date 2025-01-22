package com.example.beansfortype.processors2;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.example.beansfortype.ReqResProcessor;
import com.example.beansfortype.data.CharlieRequest;
import com.example.beansfortype.data.CharlieResponse;

@Component
@Order(Ordered.LOWEST_PRECEDENCE)
public class CharlieGenericReqResProcessor<REQ extends CharlieRequest, RES extends CharlieResponse> implements ReqResProcessor<REQ, RES> {

	@Override
	public void process(REQ bizRequest, RES bizResponse) {
		bizRequest.charlie = "Set by CharlieGenericReqResProcessor";
		bizRequest.common = "Set by CharlieGenericReqResProcessor";
		bizResponse.charlie = "Set by CharlieGenericReqResProcessor";
		bizResponse.common = "Set by CharlieGenericReqResProcessor";		
	}
}
