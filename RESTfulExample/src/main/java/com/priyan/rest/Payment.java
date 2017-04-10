package com.priyan.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/payment/v1")
@Consumes("application/json")
@Produces("application/json")
public class Payment {

	@POST
	@Path("/{msisdn}/transactions/amount")
	public Response paymentChargeServices(@PathParam("msisdn") String msisdn) {




		
		String responseString = "{\n" +
				"	\"amountTransaction\": {\n" +
				"		\"clientCorrelator \": \"123456: AIN12345\",\n" +
				"		\"endUserId\": \"tel:+94775747251\",\n" +
				"		\"paymentAmount\": {\n" +
				"			\"chargingInformation\": {\n" +
				"				\"amount\": \"10\",\n" +
				"				\"currency\": \"LKR\",\n" +
				"				\"description\": \"Alien Invaders Game\"\n" +
				"			},\n" +
				"			\"totalAmountCharged\": \"12.99\",\n" +
				"			\"chargingMetaData\": {\n" +
				"				\"onBehalfOf\": \"Example Games Inc\",\n" +
				"				\"purchaseCategoryCode\": \"Game\",\n" +
				"				\"channel\": \"WAP\",\n" +
				"				\"taxAmount\": \"0\"\n" +
				"			}\n" +
				"		},\n" +
				"		\"referenceCode\": \"REF-12345\",\n" +
				"		\"serverReferenceCode\": \"ABC-123\",\n" +
				"		\"transactionOperationStatus\": \"Charged\",\n" +
				"		\"resourceURL\": \"https://ww.google.com/tel:+9477xxxxxxx/transactions/amount/abc123\"\n" +
				"	}\n" +
				"}";

		return Response.status(201).entity(responseString).build();
	}
	
	/*@POST
	@Path("/{msisdn}/transactions/amount")
	public Response paymentRefundServices(@PathParam("msisdn") String msisdn) {

		String responseString = "{\n" +
				"	\"amountTransaction\": {\n" +
				"		\"clientCorrelator\": \"54321\",\n" +
				"		\"endUserId\": \"tel:+00123456789\",\n" +
				"		\"paymentAmount\": {\n" +
				"			\"chargingInformation\": {\n" +
				"				\"amount\": \"10\",\n" +
				"				\"currency\": \"USD\",\n" +
				"				\"description\": \"Alien Invaders\"\n" +
				"			},\n" +
				"			\"chargingMetaData\": {\n" +
				"				\"onBehalfOf\": \"Example Games Inc\",\n" +
				"				\"purchaseCategoryCode\": \"Game\",\n" +
				"				\"channel\": \"WAP\",\n" +
				"				\"taxAmount\": \"0\"\n" +
				"			},\n" +
				"			\"totalAmountRefunded\": \"10\"\n" +
				"		},\n" +
				"		\"referenceCode\": \"REF-12345\",\n" +
				"		\"originalServerReferenceCode\": \"ABC-123\",\n" +
				"		\"resourceURL\": \"<Resource URL>\",\n" +
				"		\"transactionOperationStatus\": \"Refunded\"\n" +
				"	}\n" +
				"}";

		return Response.status(201).entity(responseString).build();
	}*/
}
