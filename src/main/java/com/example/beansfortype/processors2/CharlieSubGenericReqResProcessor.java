package com.example.beansfortype.processors2;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.example.beansfortype.ReqResProcessor;
import com.example.beansfortype.data.CharlieSubRequest;
import com.example.beansfortype.data.CharlieSubResponse;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CharlieSubGenericReqResProcessor<REQ extends CharlieSubRequest, RES extends CharlieSubResponse> implements ReqResProcessor<REQ, RES> {

	@Override
	public void process(REQ bizRequest, RES bizResponse) {
		bizRequest.charlie = "Set by CharlieSubGenericReqResProcessor";
		bizRequest.common = "Set by CharlieSubGenericReqResProcessor";
		bizResponse.charlie = "Set by CharlieSubGenericReqResProcessor";
		bizResponse.common = "Set by CharlieSubGenericReqResProcessor";	}
}
