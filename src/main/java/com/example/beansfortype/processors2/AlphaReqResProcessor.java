package com.example.beansfortype.processors2;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.example.beansfortype.ReqResProcessor;
import com.example.beansfortype.data.AlphaRequest;
import com.example.beansfortype.data.AlphaResponse;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class AlphaReqResProcessor implements ReqResProcessor<AlphaRequest, AlphaResponse> {

	@Override
	public void process(AlphaRequest bizRequest, AlphaResponse bisResponse) {
		bizRequest.alpha = "Set by AlphaReqResProcessor";
		bizRequest.common = "Set by AlphaReqResProcessor";
		bisResponse.alpha = "Set by AlphaReqResProcessor";
		bisResponse.common = "Set by AlphaReqResProcessor";
	}
}
