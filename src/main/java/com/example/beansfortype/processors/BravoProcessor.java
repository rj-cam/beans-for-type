package com.example.beansfortype.processors;

import org.springframework.stereotype.Component;

import com.example.beansfortype.Processor;
import com.example.beansfortype.data.BravoRequest;

@Component
public class BravoProcessor implements Processor<BravoRequest> {

	@Override
	public void process(BravoRequest bizRequest) {
		bizRequest.bravo = "Set by BravoProcessor";
		bizRequest.common = "Set by BravoProcessor";
	}
}
