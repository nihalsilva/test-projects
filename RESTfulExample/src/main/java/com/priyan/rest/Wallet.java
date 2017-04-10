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

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

@Path("/wallet/v1")
@Consumes("application/json")
@Produces("application/json")
public class Wallet {

	@POST
	@Path("/transaction/{endUserId}/payment")
	public Response makePaymentServices(@Context HttpHeaders headers, String jsonBody,
			@PathParam("endUserId") String endUserId) {

		String outputString = "{\"HTTP POST \": \"Headers : " + getHeadersInfo(headers) + "\" ,\"JsonBody \": \""
				+ jsonBody.replace("\"", "\'") + "\",\"Date\": \"" + new Date() + "\"}";

		String responseString = null;

		try {

			File file = new File("D:/logs.txt");

			if (!file.exists()) {

				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("Make Payment Service -------------> " + "\n");
			bw.write(outputString + "\n");
			bw.close();

			responseString = "{\n" + "	\"makePayment\": {\n" + "		\"clientCorrelator\": \"urn:uuid:c0020a7c-59b6-4f97-931f-63ea153f7b03:0001WALLET2\",\n"
					+ "		\"endUserId\": \"tel:+94775747251\",\n" + "		\"paymentAmount\": {\n"
					+ "			\"chargingInformation\": {\n" + "				\"amount\": \"2\",\n"
					+ "				\"currency\": \"LKR\",\n"
					+ "				\"description\": \"Alien Invaders Game\"\n" + "			},\n"
					+ "			\"chargingMetaData\": {\n" + "				\"onBehalfOf\": \"Example Games Inc\",\n"
					+ "				\"purchaseCategoryCode\": \"Game\",\n" + "				\"channel\": \"Mobile\"\n"
					+ "			}\n" + "		},\n" + "		\"referenceCode\": \"REF-12345\",\n"
					+ "		\"serverReferenceCode\": \"WALLET_REF_XX67675XX\",\n"
					+ "		\"notifyURL\": \"http://myapplication/mynotifyurl\",\n"
					+ "		\"transactionOperationStatus\": \"Charged\"\n" + "	}\n" + "}";
			
			/*responseString = "{\n" +
"	\"requestError\": {\n" +
"		\"policyException\": {\n" +
"			\"messageId\": \"POL0002\",\n" +
"			\"text\": \"Invalid input value for message part %1\",\n" +
"			\"variables\": \"Already charged for this reference code\"\n" +
"		}\n" +
"	}\n" +
"}";*/
		} catch (IOException e) {

			e.printStackTrace();
		}

		return Response.status(201).entity(responseString).build();
	}

	@GET
	@Path("/transaction/{endUserId}/list")
	public Response listTransactionsServices(@Context HttpHeaders headers, @PathParam("endUserId") String endUserId) {

		String outputString = "{\"HTTP GET \": \"Headers : " + getHeadersInfo(headers) + "\",\"Date\": \"" + new Date()
				+ "\"}";

		String responseString = null;

		try {

			File file = new File("D:/logs.txt");

			if (!file.exists()) {

				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("List Transactions Service -------------> " + "\n");
			bw.write(outputString + "\n");
			bw.close();

			responseString = "{\n" + "	\"paymentTransactionList\": {\n" + "		\"amountTransaction\": [{\n"
					+ "			\"endUserId\": \"tel:+94775747251\",\n" + "			\"paymentAmount\": {\n"
					+ "				\"chargingInformation\": {\n" + "					\"amount\": \"9\",\n"
					+ "					\"currency\": \"USD\",\n"
					+ "					\"description\": \"Alien Invaders\"\n" + "				}\n"
					+ "			},\n" + "			\"referenceCode\": \"REF-ASM600-239238\",\n"
					+ "			\"serverReferenceCode\": \"tx-a3c0e4e006da40a8a5b5-045972478cc3\",\n"
					+ "			\"transactionOperationStatus\": \"Charged\"\n" + "		}, {\n"
					+ "			\"endUserId\": \" tel:+00123456789\",\n" + "			\"paymentAmount\": {\n"
					+ "				\"chargingInformation\": {\n" + "					\"amount\": \"6\",\n"
					+ "					\"currency\": \"USD\",\n"
					+ "					\"description\": \" Snakes Alive \"\n" + "				}\n"
					+ "			},\n" + "			\"referenceCode\": \"REF-ASM600-2392344\",\n"
					+ "			\"serverReferenceCode\": \"tx-a3c0e4e006da60a8a5b5-044972478cc3\",\n"
					+ "			\"transactionOperationStatus\": \"Charged\"\n" + "		}],\n"
					+ "		\"resourceURL\": \"http://localhost:8080/DemoService/wso2/wallet/v1/transaction/tel%3A%2B94775747251/list/123456789\"\n"
					+ "	}\n" + "}";
		} catch (IOException e) {

			e.printStackTrace();
		}

		return Response.status(200).entity(responseString).build();
	}

	@GET
	@Path("/transaction/{endUserId}/list/{transactionId}")
	public Response listTransactionsRecallerServices(@Context HttpHeaders headers,
			@PathParam("endUserId") String endUserId, @PathParam("transactionId") String transactionId) {

		String outputString = "{\"HTTP GET \": \"Headers : " + getHeadersInfo(headers) + "\",\"Date\": \"" + new Date()
				+ "\"}";

		String responseString = null;

		try {

			File file = new File("D:/logs.txt");

			if (!file.exists()) {

				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("List Transactions Recaller Service -------------> " + "\n");
			bw.write(outputString + "\n");
			bw.close();

			responseString = "{\n" + "	\"paymentTransactionList\": {\n" + "		\"amountTransaction\": [{\n"
					+ "			\"endUserId\": \"tel:+94775747251\",\n" + "			\"paymentAmount\": {\n"
					+ "				\"chargingInformation\": {\n" + "					\"amount\": \"9\",\n"
					+ "					\"currency\": \"USD\",\n"
					+ "					\"description\": \"Alien Invaders\"\n" + "				}\n"
					+ "			},\n" + "			\"referenceCode\": \"REF-ASM600-239238\",\n"
					+ "			\"serverReferenceCode\": \"tx-a3c0e4e006da40a8a5b5-045972478cc3\",\n"
					+ "			\"transactionOperationStatus\": \"Charged\"\n" + "		}, {\n"
					+ "			\"endUserId\": \" tel:+00123456789\",\n" + "			\"paymentAmount\": {\n"
					+ "				\"chargingInformation\": {\n" + "					\"amount\": \"6\",\n"
					+ "					\"currency\": \"USD\",\n"
					+ "					\"description\": \" Snakes Alive \"\n" + "				}\n"
					+ "			},\n" + "			\"referenceCode\": \"REF-ASM600-2392344\",\n"
					+ "			\"serverReferenceCode\": \"tx-a3c0e4e006da60a8a5b5-044972478cc3\",\n"
					+ "			\"transactionOperationStatus\": \"Charged\"\n" + "		}],\n"
					+ "		\"resourceURL\": \"http://localhost:8080/DemoService/wso2/wallet/v1/transaction/tel%3A%2B94775747251/list/123456789\"\n"
					+ "	}\n" + "}";
		} catch (IOException e) {

			e.printStackTrace();
		}

		return Response.status(200).entity(responseString).build();
	}

	@POST
	@Path("/transaction/{endUserId}/refund")
	public Response refundServices(@Context HttpHeaders headers, String jsonBody,
			@PathParam("endUserId") String endUserId) {

		String outputString = "{\"HTTP POST \": \"Headers : " + getHeadersInfo(headers) + "\" ,\"JsonBody \": \""
				+ jsonBody.replace("\"", "\'") + "\",\"Date\": \"" + new Date() + "\"}";

		String responseString = null;

		try {

			File file = new File("D:/logs.txt");

			if (!file.exists()) {

				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("Refund Service -------------> " + "\n");
			bw.write(outputString + "\n");
			bw.close();

			responseString = "{\n" + "	\"refundTransaction\": {\n" + "		\"clientCorrelator\": \"54321\",\n"
					+ "		\"endUserId\": \"tel:+94775747251\",\n"
					+ "		\"originalReferenceCode\": \"ABC - 12345\",\n"
					+ "		\"originalServerReferenceCode\": \"WALLET_REF_XX67675XX\",\n"
					+ "		\"paymentAmount\": {\n" + "			\"chargingInformation\": {\n"
					+ "				\"amount\": \"10\",\n" + "				\"currency\": \"USD\",\n"
					+ "				\"description\": \"Alien Invaders Game\"\n" + "			},\n"
					+ "			\"chargingMetaData\": {\n" + "				\"onBehalfOf\": \"Example Games Inc\",\n"
					+ "				\"purchaseCategoryCode\": \"Game\",\n" + "				\"channel\": \"WAP\"\n"
					+ "			}\n" + "		},\n" + "		\"referenceCode\": \"REF-12345\",\n"
					+ "		\"serverReferenceCode\": \"ABC-123\",\n"
					+ "		\"resourceURL\": \"http://localhost:8080/DemoService/wso2/wallet/v1/transaction/tel%3A%2B94775747251/refund/123456789\",\n"
					+ "		\"transactionOperationStatus\": \"Refunded\"\n" + "	}\n" + "}";
		} catch (IOException e) {

			e.printStackTrace();
		}

		return Response.status(201).entity(responseString).build();
	}

	@GET
	@Path("/transaction/{endUserId}/refund/{transactionId}")
	public Response refundRecallerServices(@Context HttpHeaders headers, @PathParam("endUserId") String endUserId,
			@PathParam("transactionId") String transactionId) {

		String outputString = "{\"HTTP GET \": \"Headers : " + getHeadersInfo(headers) + "\",\"Date\": \"" + new Date()
				+ "\"}";

		String responseString = null;

		try {

			File file = new File("D:/logs.txt");

			if (!file.exists()) {

				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("Refund Recaller Service -------------> " + "\n");
			bw.write(outputString + "\n");
			bw.close();

			responseString = "{\n" + "	\"refundTransaction\": {\n" + "		\"clientCorrelator\": \"54321\",\n"
					+ "		\"endUserId\": \"tel:+94775747251\",\n"
					+ "		\"originalReferenceCode\": \"ABC - 12345\",\n"
					+ "		\"originalServerReferenceCode\": \"WALLET_REF_XX67675XX\",\n"
					+ "		\"paymentAmount\": {\n" + "			\"chargingInformation\": {\n"
					+ "				\"amount\": \"10\",\n" + "				\"currency\": \"USD\",\n"
					+ "				\"description\": \"Alien Invaders Game\"\n" + "			},\n"
					+ "			\"chargingMetaData\": {\n" + "				\"onBehalfOf\": \"Example Games Inc\",\n"
					+ "				\"purchaseCategoryCode\": \"Game\",\n" + "				\"channel\": \"WAP\"\n"
					+ "			}\n" + "		},\n" + "		\"referenceCode\": \"REF-12345\",\n"
					+ "		\"serverReferenceCode\": \"ABC-123\",\n"
					+ "		\"resourceURL\": \"http://localhost:8080/DemoService/wso2/wallet/v1/transaction/tel%3A%2B94775747251/refund/123456789\",\n"
					+ "		\"transactionOperationStatus\": \"Refunded\"\n" + "	}\n" + "}";
		} catch (IOException e) {

			e.printStackTrace();
		}

		return Response.status(200).entity(responseString).build();
	}

	@GET
	@Path("/transaction/{endUserId}/balance")
	public Response balanceLookupServices(@Context HttpHeaders headers, @PathParam("endUserId") String endUserId) {

		String outputString = "{\"HTTP GET \": \"Headers : " + getHeadersInfo(headers) + "\",\"Date\": \"" + new Date()
				+ "\"}";

		String responseString = null;

		try {

			File file = new File("D:/logs.txt");

			if (!file.exists()) {

				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("Balance Lookup Service -------------> " + "\n");
			bw.write(outputString + "\n");
			bw.close();

			responseString = "{\n" + "	\"accountBalance\": {\n" + "		\"endUserId\": \"tel:+94775747251\",\n"
					+ "		\"serverReferenceCode\": \"WALLET_REF_XX67675XX\",\n" + "		\"accountInfo\": {\n"
					+ "			\"accountStatus\": \"Active\",\n" + "			\"accountCurrency\": \"LKR\",\n"
					+ "			\"accountBalance\": \"500.45\"\n" + "		},\n"
					+ "		\"resourceURL\": \"http://localhost:8080/DemoService/wso2/wallet/v1/transaction/tel%3A%2B94775747251/balance/123456789\"\n"
					+ "	}\n" + "}";
		} catch (IOException e) {

			e.printStackTrace();
		}

		return Response.status(200).entity(responseString).build();
	}

	@GET
	@Path("/transaction/{endUserId}/balance/{transactionId}")
	public Response balanceLookupRecallerServices(@Context HttpHeaders headers,
			@PathParam("endUserId") String endUserId, @PathParam("transactionId") String transactionId) {

		String outputString = "{\"HTTP GET \": \"Headers : " + getHeadersInfo(headers) + "\",\"Date\": \"" + new Date()
				+ "\"}";

		String responseString = null;

		try {

			File file = new File("D:/logs.txt");

			if (!file.exists()) {

				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("Balance Lookup Recaller Service -------------> " + "\n");
			bw.write(outputString + "\n");
			bw.close();

			responseString = "{\n" + "	\"accountBalance\": {\n" + "		\"endUserId\": \"tel:+94775747251\",\n"
					+ "		\"serverReferenceCode\": \"WALLET_REF_XX67675XX\",\n" + "		\"accountInfo\": {\n"
					+ "			\"accountStatus\": \"Active\",\n" + "			\"accountCurrency\": \"LKR\",\n"
					+ "			\"accountBalance\": \"500.45\"\n" + "		},\n"
					+ "		\"resourceURL\": \"http://localhost:8080/DemoService/wso2/wallet/v1/transaction/tel%3A%2B94775747251/balance/123456789\"\n"
					+ "	}\n" + "}";
		} catch (IOException e) {

			e.printStackTrace();
		}

		return Response.status(200).entity(responseString).build();
	}

	private String getHeadersInfo(HttpHeaders httpHeaders) {

		StringBuilder headers = new StringBuilder();

		for (Map.Entry<String, List<String>> entry : httpHeaders.getRequestHeaders().entrySet()) {

			String key = entry.getKey();
			headers.append(key);
			headers.append(" & ");
			Object value = entry.getValue();
			headers.append(value);
		}

		return headers.toString();
	}
}
