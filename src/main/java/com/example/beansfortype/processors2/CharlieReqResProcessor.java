package com.example.beansfortype.processors2;

import org.springframework.stereotype.Component;

import com.example.beansfortype.ReqResProcessor;
import com.example.beansfortype.data.CharlieRequest;
import com.example.beansfortype.data.CharlieResponse;

@Component
public class CharlieReqResProcessor implements ReqResProcessor<CharlieRequest, CharlieResponse> {

	@Override
	public void process(CharlieRequest bizRequest, CharlieResponse bizResponse) {
		bizRequest.charlie = "Set by CharlieReqResProcessor";
		bizRequest.common = "Set by CharlieReqResProcessor";
		bizResponse.charlie = "Set by CharlieReqResProcessor";
		bizResponse.common = "Set by CharlieReqResProcessor";
	}
}
