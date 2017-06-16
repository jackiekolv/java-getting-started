package com.example.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.domain.AddItemRequest;
import com.example.domain.AddItemResponse;
import com.example.domain.GetOrderByBarcodesRequest;
import com.example.domain.GetOrderByBarcodesResponse;

@Controller
public class ThaipostMockController {

	@RequestMapping(path = "/webservice/addItem", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	AddItemResponse[] addItem(@RequestBody AddItemRequest request) {
		AddItemResponse item = new AddItemResponse();
		item.setErrorCode("000");
		item.setErrorDetail("success");
		item.setStatus("true");
		AddItemResponse responses[] = { item };
		return responses;
	}

	@RequestMapping(path = "/webservice/getOrderByBarcodes", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	GetOrderByBarcodesResponse[] getOrderByBarcodes(@RequestBody GetOrderByBarcodesRequest request) {
		String barcodes[] = request.getBarcodes().split(",");

		GetOrderByBarcodesResponse[] responses = new GetOrderByBarcodesResponse[barcodes.length];
		for (int i = 0; i < barcodes.length; i++) {
			responses[i] = new GetOrderByBarcodesResponse();
			responses[i].setBarcode(barcodes[i]);
			responses[i].setInvNo(barcodes[i]);
			responses[i].setStatus("9");
		}
		return responses;
	}

}
