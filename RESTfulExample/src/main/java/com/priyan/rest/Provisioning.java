/*******************************************************************************
 * Copyright  (c) 2015-2016, WSO2.Telco Inc. (http://www.wso2telco.com) All Rights Reserved.
 *  
 * WSO2.Telco Inc. licences this file to you under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package com.priyan.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/provision/v1")
@Consumes("application/json")
@Produces("application/json")
public class Provisioning {

	@GET
	@Path("/{msisdn}/list/applicable")
	public Response queryApplicableServices(@PathParam("msisdn") String msisdn, @QueryParam("offset") String offset,
			@QueryParam("limit") String limit) {

		String responseString = "{  \n" + "   \"serviceList\":{  \n" + "      \"serviceInfo\":[  \n" + "         {  \n"
				+ "            \"serviceCode\":\"sample1\",\n" + "            \"serviceType\":\"sample3\",\n"
				+ "            \"description\":\"sample4\",\n" + "            \"serviceCharge\":100.0\n"
				+ "         },\n" + "         {  \n" + "            \"serviceCode\":\"testCode\",\n"
				+ "            \"serviceType\":\"testType\",\n" + "            \"description\":\"testDes\",\n"
				+ "            \"serviceCharge\":100.0\n" + "         },\n" + "         {  \n"
				+ "            \"serviceCode\":\"SRV0011\",\n" + "            \"serviceType\":\"DATA\",\n"
				+ "            \"description\":\"ServiceDescription\",\n" + "            \"serviceCharge\":100.0\n"
				+ "         },\n" + "         {  \n" + "            \"serviceCode\":\"SRV0016\",\n"
				+ "            \"serviceType\":\"ROAMING\",\n"
				+ "            \"description\":\"ServiceDescriptionROAMING\",\n"
				+ "            \"serviceCharge\":100.0\n" + "         },\n" + "         {  \n"
				+ "            \"serviceCode\":\"SRV0025\",\n" + "            \"serviceType\":\"DATA\",\n"
				+ "            \"description\":\"ServiceDescription DATA\",\n" + "            \"serviceCharge\":null\n"
				+ "         },\n" + "         {  \n" + "            \"serviceCode\":\"SRV0023\",\n"
				+ "            \"serviceType\":\"DATA\",\n"
				+ "            \"description\":\"ServiceDescription DATA\",\n" + "            \"serviceCharge\":120.0\n"
				+ "         },\n" + "         {  \n" + "            \"serviceCode\":\"SRV0026\",\n"
				+ "            \"serviceType\":\"DATA\",\n"
				+ "            \"description\":\"ServiceDescription DATA\",\n" + "            \"serviceCharge\":14.9\n"
				+ "         },\n" + "         {  \n" + "            \"serviceCode\":\"SRV00100\",\n"
				+ "            \"serviceType\":\"DATA\",\n"
				+ "            \"description\":\"ServiceDescription DATA\",\n"
				+ "            \"serviceCharge\":1004.9\n" + "         },\n" + "         {  \n"
				+ "            \"serviceCode\":\"SRV00200\",\n" + "            \"serviceType\":\"DATA\",\n"
				+ "            \"description\":\"ServiceDescription DATA\",\n"
				+ "            \"serviceCharge\":1004.9\n" + "         },\n" + "         {  \n"
				+ "            \"serviceCode\":\"SRV00200\",\n" + "            \"serviceType\":\"DATA\",\n"
				+ "            \"description\":\"ServiceDescription DATA\",\n"
				+ "            \"serviceCharge\":1004.9\n" + "         },\n" + "         {  \n"
				+ "            \"serviceCode\":\"SRV00300\",\n" + "            \"serviceType\":\"DATA\",\n"
				+ "            \"description\":\"ServiceDescription DATA\",\n" + "            \"serviceCharge\":104.9\n"
				+ "         },\n" + "         {  \n" + "            \"serviceCode\":\"SRV00400\",\n"
				+ "            \"serviceType\":\"DATA\",\n"
				+ "            \"description\":\"ServiceDescription DATA\",\n" + "            \"serviceCharge\":104.9\n"
				+ "         },\n" + "         {  \n" + "            \"serviceCode\":\"SRV00500\",\n"
				+ "            \"serviceType\":\"DATA\",\n"
				+ "            \"description\":\"ServiceDescription DATA\",\n" + "            \"serviceCharge\":104.9\n"
				+ "         }\n" + "      ],\n" + "      \"currencyCode\":\"USD\",\n"
				+ "      \"onBehalfOf\":\"my_Merchant\",\n" + "      \"requestIdentifier\":\"REF_1214\",\n"
				+ "      \"responseIdentifier\":\"RESbVvBoZEu\",\n"
				+ "      \"resourceURL\":\"http://localhost:8183/provisioning/v1/tel:+94773524333/list/applicable/68953\"\n"
				+ "   }\n" + "}";

		return Response.status(200).entity(responseString).build();
	}

	@GET
	@Path("/{msisdn}/list/active")
	public Response listCustomerServices(@PathParam("msisdn") String msisdn, @QueryParam("offset") String offset,
			@QueryParam("limit") String limit) {

		String responseString = "{\n" + "	\"serviceList\": {\n" + "		\"serviceInfoList\": [{\n"
				+ "			\"serviceCode\": \"SRV0001\",\n" + "			\"description\": \"serviceDescription\",\n"
				+ "			\"timestamp\": \"2015-12-26T00:27:23.000Z \",\n" + "			\"serviceInfo\": [{\n"
				+ "				\"tag\": \"limit\",\n" + "				\"value\": \"1000\"\n" + "			}]\n"
				+ "		}, {\n" + "			\"serviceCode\": \"SRV0002\",\n"
				+ "			\"description\": \"serviceDescription\",\n"
				+ "			\"timestamp\": \"2015-12-26T00:27:23.000Z \",\n" + "			\"serviceInfo\": [{\n"
				+ "				\"tag\": \"count\",\n" + "				\"value\": \"25\"\n" + "			}]\n"
				+ "		}],\n" + "                          \"onBehalfOf\" : \"my_Merchant\",\n"
				+ "                          \"purchaseCategoryCode\" : \"game\",\n"
				+ "                          \"requestIdentifier\" : \"REQ12345678\",\n"
				+ "                          \"responseIdentifier\" : \"RES12345678\",\n"
				+ "		\"resourceURL\": \"www.google.com\n"
				+ "                                                      /provisioning/v1/123456789/list/active/67Xfrgs7\"\n"
				+ "	}\n" + "}";

		return Response.status(200).entity(responseString).build();
	}

	@POST
	@Path("/{msisdn}")
	public Response provisionServices(@PathParam("msisdn") String msisdn, @QueryParam("mcc") String mcc,
			@QueryParam("mnc") String mnc) {

		String responseString = "{\n" + "	\"serviceProvisionResponse\": {\n" + "		\"serviceCode\": \"SRV0001\",\n"
				+ "		\"clientCorrelator\": \"12345\",\n" + "		\"clientReferenceCode\": \"REF12345\",\n"
				+ "		\"serverReferenceCode\": \"SRV-REF5445\",\n" + "		\"onBehalfOf\": \"my_Merchant\",\n"
				+ "		\"purchaseCategoryCode\": \"game\",\n" + "		\"callbackReference\": {\n"
				+ "			\"notifyURL\": \"http:// application.com/notifyURL\",\n"
				+ "			\"callbackData\": \"some-data-useful-to-the-requester\",\n"
				+ "			\"resourceURL\": \"http://www.google.com/provisioning/v1/12345678901\"\n" + "		},\n"
				+ "		\"transactionStatus\": \"Pending\"\n" + "	}\n" + "}";

		return Response.status(201).entity(responseString).build();
	}

	@POST
	@Path("/{msisdn}/remove")
	public Response removeServices(@PathParam("msisdn") String msisdn, @QueryParam("mcc") String mcc,
			@QueryParam("mnc") String mnc) {

		String responseString = "{\n" + "	\"serviceRemoveResponse\": {\n" + "		\"serviceCode\": \"SRV0001\",\n"
				+ "		\"clientCorrelator\": \"12345\",\n" + "		\"clientReferenceCode\": \"REF12345\",\n"
				+ "		\"serverReferenceCode\": \"SRV-REF5445\",\n" + "		\"onBehalfOf\": \"my_Merchant\",\n"
				+ "		\"purchaseCategoryCode\": \"game\",\n" + "		\"callbackReference\": {\n"
				+ "			\"notifyURL\": \"http:// application.com/notifyURL\",\n"
				+ "			\"callbackData\": \"some-data-useful-to-the-requester\",\n"
				+ "			\"resourceURL\": \"www.google.com/provisioning/v1/12345678901/remove\"\n" + "		},\n"
				+ "		\"transactionStatus\": \"Pending\"\n" + "	}\n" + "}";

		return Response.status(201).entity(responseString).build();
	}
}
