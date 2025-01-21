package com.example.beansfortype;

import com.example.beansfortype.data.Request;

public interface Processor<REQ extends Request> 
{
	void process(REQ bizRequest);
}
