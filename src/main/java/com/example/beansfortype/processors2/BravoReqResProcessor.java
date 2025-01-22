package com.example.beansfortype.processors2;

import org.springframework.stereotype.Component;

import com.example.beansfortype.ReqResProcessor;
import com.example.beansfortype.data.BravoRequest;
import com.example.beansfortype.data.BravoResponse;

@Component
public class BravoReqResProcessor implements ReqResProcessor<BravoRequest, BravoResponse> {

	@Override
	public void process(BravoRequest bizRequest, BravoResponse bizResponse) {
		bizRequest.bravo = "Set by BravoReqResProcessor";
		bizRequest.common = "Set by BravoReqResProcessor";
		bizResponse.bravo = "Set by BravoReqResProcessor";
		bizResponse.common = "Set by BravoReqResProcessor";
	}
}
