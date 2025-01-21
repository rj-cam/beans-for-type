package com.example.beansfortype.processors;

import org.springframework.stereotype.Component;

import com.example.beansfortype.Processor;
import com.example.beansfortype.data.CharlieRequest;

@Component
public class CharlieProcessor implements Processor<CharlieRequest> {

	@Override
	public void process(CharlieRequest bizRequest) {
		bizRequest.charlie = "Set by CharlieProcessor";
		bizRequest.common = "Set by CharlieProcessor";
	}
}
