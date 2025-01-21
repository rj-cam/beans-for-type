package com.example.beansfortype.processors;

import org.springframework.stereotype.Component;

import com.example.beansfortype.Processor;
import com.example.beansfortype.data.CharlieRequest;
import com.example.beansfortype.data.CharlieSubRequest;

@Component
public class CharlieSubProcessor implements Processor<CharlieSubRequest> {

	@Override
	public void process(CharlieSubRequest bizRequest) {
		bizRequest.charlie = "Set by CharlieSubProcessor";
		bizRequest.common = "Set by CharlieSubProcessor";
	}
}
