package com.example.beansfortype;

import com.example.beansfortype.data.Request;
import com.example.beansfortype.data.Response;

public interface ReqResProcessor<REQ extends Request, RES extends Response> 
{
	void process(REQ bizRequest, RES bizResponse);
}
