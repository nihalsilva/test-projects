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
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/customerinfo/v1")
@Consumes("application/json")
@Produces("application/json")
public class CustomerInfo {

	@GET
	@Path("/customer/profile")
	public Response getProfileServices(@QueryParam("msisdn") String msisdn, @QueryParam("imsi") String imsi,
			@QueryParam("mcc") String mcc, @QueryParam("mnc") String mnc, @QueryParam("onBehalfOf") String onBehalfOf,
			@QueryParam("purchaseCategoryCode") String purchaseCategoryCode,
			@QueryParam("requestIdentifier") String requestIdentifier) {

		String responseString = "{\n" + "  \"customer\": {\n" + "    \"msisdn\": \"123456789\",\n"
				+ "    \"imsi\": \"0987654321\",\n" + "    \"title\": \"Mr\",\n" + "    \"firstName\": \"Bilbo\",\n"
				+ "    \"lastName\": \"Baggins\",\n" + "    \"dob\": \"21/10/2006\",\n"
				+ "    \"identificationType\": \"PP\",\n" + "    \"identificationNumber\": \"PP12345DC\",\n"
				+ "    \"onBehalfOf\": \"my_Merchant\",\n" + "    \"purchaseCategoryCode\": \"Game\",\n"
				+ "    \"accountType\": \"Postpaid\",\n" + "    \"ownerType\": \"Paymaster\",\n"
				+ "    \"status\": \"Confirmed\",\n" + "    \"requestIdentifier\": \"Gateway-ZZZZZZZZZZ\",\n"
				+ "    \"responseIdentifier\": \"RES12345678\",\n" + "    \"address\": {\n"
				+ "      \"line1\": \"Bag End\",\n" + "      \"line2\": \"\",\n" + "      \"line3\": \"\",\n"
				+ "      \"city\": \"The Shire\",\n" + "      \"country\": \"Middle Earth\"\n" + "    },\n"
				+ "    \"additionalInfo \": [{\n" + "      \"tag\": \"creditLimit\",\n" + "      \"value\": \"2500\"\n"
				+ "    }, {\n" + "      \"tag\": \"creditLimit\",\n" + "      \"value\": \"2500\"\n" + "    }],\n"
				+ "    \"resourceURL\": \"http://localhost:8080/DemoService/wso2/customerinfo/v1/customer/profile/123456789?msisdn=tel%3A%2B94775747251&requestIdentifier=Gateway-ZZZZZZZZZZ&imsi=098764321&mcc=413&mnc=02&onBehalfOf=my_Merchant&purchaseCategoryCode=Game\"\n"
				+ "  }\n" + "}";

		return Response.status(200).entity(responseString).build();
	}

	@GET
	@Path("/customer/profile/{requestId}")
	public Response getProfileServicesRecaller(@PathParam("requestId") String requestId,
			@QueryParam("msisdn") String msisdn, @QueryParam("imsi") String imsi, @QueryParam("mcc") String mcc,
			@QueryParam("mnc") String mnc, @QueryParam("onBehalfOf") String onBehalfOf,
			@QueryParam("purchaseCategoryCode") String purchaseCategoryCode,
			@QueryParam("requestIdentifier") String requestIdentifier) {
		
		
		
		
		String responseString = "{\n" + "  \"customer\": {\n" + "    \"msisdn\": \"123456789\",\n"
				+ "    \"imsi\": \"0987654321\",\n" + "    \"title\": \"Mr\",\n" + "    \"firstName\": \"Bilbo\",\n"
				+ "    \"lastName\": \"Baggins\",\n" + "    \"dob\": \"21/10/2006\",\n"
				+ "    \"identificationType\": \"PP\",\n" + "    \"identificationNumber\": \"PP12345DC\",\n"
				+ "    \"onBehalfOf\": \"my_Merchant\",\n" + "    \"purchaseCategoryCode\": \"Game\",\n"
				+ "    \"accountType\": \"Postpaid\",\n" + "    \"ownerType\": \"Paymaster\",\n"
				+ "    \"status\": \"Confirmed\",\n" + "    \"requestIdentifier\": \"HUB-YYYYYYYYYYYYY:urn:uuid:d3677aa8-a93c-4f46-829e-6cfc8227c6e1:0001CUSTOMERINFO2\",\n"
				+ "    \"responseIdentifier\": \"RES12345678\",\n" + "    \"address\": {\n"
				+ "      \"line1\": \"Bag End\",\n" + "      \"line2\": \"\",\n" + "      \"line3\": \"\",\n"
				+ "      \"city\": \"The Shire\",\n" + "      \"country\": \"Middle Earth\"\n" + "    },\n"
				+ "    \"additionalInfo \": [{\n" + "      \"tag\": \"creditLimit\",\n" + "      \"value\": \"2500\"\n"
				+ "    }, {\n" + "      \"tag\": \"creditLimit\",\n" + "      \"value\": \"2500\"\n" + "    }],\n"
				+ "    \"resourceURL\": \"http://localhost:8080/DemoService/wso2/customerinfo/v1/customer/profile/123456789?msisdn=tel%3A%2B94775747251&imsi=098764321&mcc=413&mnc=02&onBehalfOf=my_Merchant&purchaseCategoryCode=Game&requestIdentifier=HUB-YYYYYYYYYYYYY:urn:uuid:d3677aa8-a93c-4f46-829e-6cfc8227c6e1:0001CUSTOMERINFO2\"\n"
				+ "  }\n" + "}";

		return Response.status(200).entity(responseString).build();
	}

	@GET
	@Path("/customer/attribute")
	public Response getAttributesServices(@QueryParam("msisdn") String msisdn, @QueryParam("imsi") String imsi,
			@QueryParam("schema") String schema, @QueryParam("mcc") String mcc, @QueryParam("mnc") String mnc,
			@QueryParam("onBehalfOf") String onBehalfOf,
			@QueryParam("purchaseCategoryCode") String purchaseCategoryCode,
			@QueryParam("requestIdentifier") String requestIdentifier) {

		String responseString = "{\n" + "	\"customer\": {\n" + "		\"msisdn\": \"123456789\",\n"
				+ "		\"imsi\": \"0987654321\",\n" + "		\"onBehalfOf\": \"my_Merchant\",\n"
				+ "		\"purchaseCategoryCode\": \"Game\",\n"
				+ "		\"requestIdentifier\": \"Gateway-ZZZZZZZZZZ\",\n"
				+ "		\"responseIdentifier\": \"RES12345678\",\n" + "		\"basic\": {\n"
				+ "			\"title\": \"Mr\",\n" + "			\"firstName\": \"Bilbo\",\n"
				+ "			\"lastName\": \"Baggins\",\n" + "			\"dob\": \"21/10/2006\",\n"
				+ "			\"address\": {\n" + "				\"line1\": \"Bag End\",\n"
				+ "				\"line2\": \"\",\n" + "				\"line3\": \"\",\n"
				+ "				\"city\": \"The Shire\",\n" + "				\"country\": \"Middle Earth\"\n"
				+ "			}\n" + "		},\n" + "		\"billing\": {\n" + "			\"creditLimit\": 2500,\n"
				+ "			\"balance\": 1000,\n" + "			\"outStanding\": 0,\n"
				+ "			\"currency\": \"LKR\"\n" + "		},\n" + "		\"identification\": {\n"
				+ "			\"type\": \"Passport\",\n" + "			\"number\": \"N123456\",\n"
				+ "			\"expiry\": \"2026/01/01\"\n" + "		},\n" + "		\"account\": {\n"
				+ "			\"type\": \"Postpaid\",\n" + "			\"status\": \"Active\"\n" + "		},\n"
				+ "		\"resourceURL\": \"http://localhost:8080/DemoService/wso2/customerinfo/v1/customer/attribute/123456789?msisdn=tel%3A%2B94775747251&schema=basic,billing&imsi=098764321&mcc=413&mnc=02&onBehalfOf=my_Merchant&purchaseCategoryCode=Game&requestIdentifier=Gateway-ZZZZZZZZZZ\"\n"
				+ "	}\n" + "}";

		return Response.status(200).entity(responseString).build();
	}

	@GET
	@Path("/customer/attribute/{requestId}")
	public Response getAttributesServicesRecaller(@PathParam("requestId") String requestId,
			@QueryParam("msisdn") String msisdn, @QueryParam("imsi") String imsi, @QueryParam("schema") String schema,
			@QueryParam("mcc") String mcc, @QueryParam("mnc") String mnc, @QueryParam("onBehalfOf") String onBehalfOf,
			@QueryParam("purchaseCategoryCode") String purchaseCategoryCode,
			@QueryParam("requestIdentifier") String requestIdentifier) {

		String responseString = "{\n" + "	\"customer\": {\n" + "		\"msisdn\": \"123456789\",\n"
				+ "		\"imsi\": \"0987654321\",\n" + "		\"onBehalfOf\": \"my_Merchant\",\n"
				+ "		\"purchaseCategoryCode\": \"Game\",\n"
				+ "		\"requestIdentifier\": \"HUB-YYYYYYYYYYYYY:urn:uuid:d3677aa8-a93c-4f46-829e-6cfc8227c6e1:0001CUSTOMERINFO2\",\n"
				+ "		\"responseIdentifier\": \"RES12345678\",\n" + "		\"basic\": {\n"
				+ "			\"title\": \"Mr\",\n" + "			\"firstName\": \"Bilbo\",\n"
				+ "			\"lastName\": \"Baggins\",\n" + "			\"dob\": \"21/10/2006\",\n"
				+ "			\"address\": {\n" + "				\"line1\": \"Bag End\",\n"
				+ "				\"line2\": \"\",\n" + "				\"line3\": \"\",\n"
				+ "				\"city\": \"The Shire\",\n" + "				\"country\": \"Middle Earth\"\n"
				+ "			}\n" + "		},\n" + "		\"billing\": {\n" + "			\"creditLimit\": 2500,\n"
				+ "			\"balance\": 1000,\n" + "			\"outStanding\": 0,\n"
				+ "			\"currency\": \"LKR\"\n" + "		},\n" + "		\"identification\": {\n"
				+ "			\"type\": \"Passport\",\n" + "			\"number\": \"N123456\",\n"
				+ "			\"expiry\": \"2026/01/01\"\n" + "		},\n" + "		\"account\": {\n"
				+ "			\"type\": \"Postpaid\",\n" + "			\"status\": \"Active\"\n" + "		},\n"
				+ "		\"resourceURL\": \"http://localhost:8080/DemoService/wso2/customerinfo/v1/customer/attribute/123456789?msisdn=tel%3A%2B94775747251&schema=basic,billing&imsi=098764321&mcc=413&mnc=02&onBehalfOf=my_Merchant&purchaseCategoryCode=Game&requestIdentifier=HUB-YYYYYYYYYYYYY:urn:uuid:d3677aa8-a93c-4f46-829e-6cfc8227c6e1:0001CUSTOMERINFO2\"\n"
				+ "	}\n" + "}";

		return Response.status(200).entity(responseString).build();
	}
}
