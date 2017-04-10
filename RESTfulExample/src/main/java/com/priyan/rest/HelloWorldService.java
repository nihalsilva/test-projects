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

@Path("/telco")
public class HelloWorldService {

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

	@POST
	@Path("/demo")
	@Consumes("application/json")
	public Response getMsgHeaders(@Context HttpHeaders headers, String jsonBody) {

		String output = "{\"HTTP POST \": \"Headers : " + getHeadersInfo(headers) + "\" ,\"jsonBody\": \""
				+ jsonBody.replace("\"", "\'") + "\",\"Date\": \"" + new Date() + "\"}";
		try {

			// File("/home/dialog/jboss/smsc/workspace/smpp/sms/logs/smscomp_logs.txt");
			File file = new File("D:/logs.txt");
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(output + "\n");
			bw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return Response.status(200).entity(output).build();
	}

	@POST
	@Path("/demo/{randomNumber}")
	@Consumes("application/json")
	public Response getMsg(@Context HttpHeaders headers, @PathParam("randomNumber") String randomNumber,
			String jsonBody) {
		String output = "{\"HTTP POST \": \"Headers : " + getHeadersInfo(headers) + " & Random No : " + randomNumber
				+ "\" ,\"jsonBody\": \"" + jsonBody.replace("\"", "\'") + "\",\"Date\": \"" + new Date() + "\"}";
		try {
			// File file = new
			// File("/home/dialog/jboss/smsc/workspace/smpp/sms/logs/smscomp_logs.txt");
			File file = new File("D:/logs.txt");
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(output + "\n");
			bw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return Response.status(200).entity(output).build();
	}

	@GET
	@Path("/listtran/{msisdn}/transactions")
	@Consumes("application/json")
	@Produces("application/json")
	public Response listTransactions(@Context HttpHeaders headers, @PathParam("msisdn") String msisdn,
			String jsonBody) {

		/*
		 * String output = "{\"HTTP POST \": \"Headers : " +
		 * getHeadersInfo(headers) + "\" ,\"jsonBody\": \"" +
		 * jsonBody.replace("\"", "\'") + "\",\"Date\": \"" + new Date() +
		 * "\"}";
		 */

		String responseString = "{\n" + "    \"paymentTransactionList\": {\n" + "        \"amountTransaction\": [\n"
				+ "            {\n" + "                \"endUserId\": \" tel:+00123456789\",\n"
				+ "                \"paymentAmount\": {\n" + "                    \"chargingInformation\": {\n"
				+ "                        \"amount\": \"9\",\n" + "                        \"currency\": \"USD\",\n"
				+ "                        \"description\": \"Alien Invaders\"\n" + "                    }\n"
				+ "                },\n" + "                \"referenceCode\": \"REF-ASM600-239238\",\n"
				+ "                \"serverReferenceCode\": \"tx-a3c0e4e006da40a8a5b5-045972478cc3\",\n"
				+ "                \"resourceURL\": \"https://www.example.com/listtranactions\",\n"
				+ "                \"transactionOperationStatus\": \"Charged\"\n" + "            },\n"
				+ "            {\n" + "                \"endUserId\": \" tel:+00123456789\",\n"
				+ "                \"paymentAmount\": {\n" + "                    \"chargingInformation\": {\n"
				+ "                        \"amount\": \"6\",\n" + "                        \"currency\": \"USD\",\n"
				+ "                        \"description\": \" Snakes Alive \"\n" + "                    }\n"
				+ "                },\n" + "                \"referenceCode\": \"REF-ASM600-2392344\",\n"
				+ "                \"serverReferenceCode\": \"tx-a3c0e4e006da60a8a5b5-044972478cc3\",\n"
				+ "                \"resourceURL\": \"https://www.example.com/listtranactions\",\n"
				+ "                \"transactionOperationStatus\": \"Charged\"\n" + "            }\n" + "        ],\n"
				+ "        \"resourceURL\": \"https://www.example.com/listtranactions\"\n" + "    }\n" + "}";

		/*
		 * try {
		 * 
		 * // File file = new // File(
		 * "/home/dialog/jboss/smsc/workspace/smpp/sms/logs/smscomp_logs.txt");
		 * File file = new File(
		 * "D:/WSO2telco/Configs and Logs/Demo App Logs/logs.txt"); if
		 * (!file.exists()) { file.createNewFile(); } FileWriter fw = new
		 * FileWriter(file.getAbsoluteFile(), true); BufferedWriter bw = new
		 * BufferedWriter(fw); bw.write(output + "\n"); bw.close(); } catch
		 * (IOException e) {
		 * 
		 * e.printStackTrace(); }
		 */

		return Response.status(200).entity(responseString).build();
	}

	@POST
	@Path("/listtran/{msisdn}/transactions/amount")
	@Consumes("application/json")
	@Produces("application/json")
	public Response refundTransactions(@Context HttpHeaders headers, @PathParam("msisdn") String msisdn,
			String jsonBody) {

		String responseString = "{\n" + "    \"amountTransaction\": {\n" + "        \"clientCorrelator\": \"54321\",\n"
				+ "        \"endUserId\": \"tel:+16309700001\",\n" + "        \"paymentAmount\": {\n"
				+ "            \"chargingInformation\": {\n" + "                \"amount\": \"10\",\n"
				+ "                \"currency\": \"USD\",\n" + "                \"description\": \"Alien Invaders\"\n"
				+ "            },\n" + "            \"chargingMetaData\": {\n"
				+ "                \"onBehalfOf\": \"Example Games Inc\",\n"
				+ "                \"purchaseCategoryCode\": \"Game\",\n" + "                \"channel\": \"WAP\",\n"
				+ "                \"taxAmount\": \"0\"\n" + "            },\n"
				+ "            \"totalAmountRefunded\": \"10\"\n" + "        },\n"
				+ "        \"referenceCode\": \"REF-12345\",\n"
				+ "        \"originalServerReferenceCode\": \"ABC-123\",\n"
				+ "        \"resourceURL\": \"http://example.com/payment/v1/tel%3A%2B16309700001/transactions/amount/efg789\",\n"
				+ "        \"transactionOperationStatus\": \"Refunded\"\n" + "    }\n" + "}";

		return Response.status(201).entity(responseString).build();
	}

	@POST
	@Path("/demo/notifymo")
	@Consumes("application/json")
	public Response notifymo(@Context HttpHeaders headers, String jsonBody) {

		String output = "{\"HTTP POST \": \"Headers : " + getHeadersInfo(headers) + "\" ,\"jsonBody\": \""
				+ jsonBody.replace("\"", "\'") + "\",\"Date\": \"" + new Date() + "\"}";
		try {

			// File("/home/dialog/jboss/smsc/workspace/smpp/sms/logs/smscomp_logs.txt");
			File file = new File("D:/logs.txt");
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(output + "\n");
			bw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return Response.status(200).build();
	}

	@POST
	@Path("/demo/notifymoerror")
	@Consumes("application/json")
	public Response notifymoerror(@Context HttpHeaders headers, String jsonBody) {

		String output = "{\"HTTP POST \": \"Headers : " + getHeadersInfo(headers) + "\" ,\"jsonBody\": \""
				+ jsonBody.replace("\"", "\'") + "\",\"Date\": \"" + new Date() + "\"}";
		try {

			// File("/home/dialog/jboss/smsc/workspace/smpp/sms/logs/smscomp_logs.txt");
			File file = new File("D:/logs.txt");
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(output + "\n");
			bw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return Response.status(400).build();
	}

	@POST
	@Path("/ussdmo/inbound/subscriptions")
	@Consumes("application/json")
	@Produces("application/json")
	public Response ussdMOSubscription() {

		String responseString = "{\"subscription\": {\n" + "\"callbackReference\": {\n"
				+ "\"callbackData\": \"doSomething()\",\n" + "\"notifyURL\": \" http://ussd.response.receive.url \"\n"
				+ "},\n" + "\"destinationAddress\": \"3456\" ,\n" + "“clientCorrelator”:”123456:AIN12345”,\n"
				+ "\"resourceURL\": \"http://test/ussd/v1/inbound/subscriptions/sub678\"\n" + "}}";

		return Response.status(201).entity(responseString).build();
	}
}