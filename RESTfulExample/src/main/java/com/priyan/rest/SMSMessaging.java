package com.priyan.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/smsmessaging/v1")
@Consumes("application/json")
@Produces("application/json")
public class SMSMessaging {

	@POST
	@Path("/outbound/{shortCode}/requests")
	public Response sendSMSServices(@PathParam("shortCode") String shortCode) {

		String responseString = "{\n" + "	\"outboundSMSMessageRequest\": {\n"
				+ "		\"address\": [\"tel:+00123456788\",\n" + "			\"tel:+00123456789\"\n" + "		],\n"
				+ "		\"deliveryInfoList\": {\n" + "			\"deliveryInfo\": [{\n"
				+ "				\"address\": \"tel:+00123456788\",\n"
				+ "				\"deliveryStatus\": \"MessageWaiting\"\n" + "			}, {\n"
				+ "				\"address\": \"tel:+00123456789\",\n"
				+ "				\"deliveryStatus\": \"MessageWaiting\"\n" + "			}],\n"
				+ "			\"resourceURL\": \"www.google.com/1\"\n" + "		},\n"
				+ "		\"senderAddresses\": [{\n" + "			\"senderAddress\": \"3456\",\n"
				+ "			\"operatorCode\": \"MNO1\",\n" + "			\"senderName\": \"ApplicationOne\"\n"
				+ "		}, {\n" + "			\"senderAddress\": \"123456789\",\n"
				+ "			\"operatorCode\": \"MNO2\",\n" + "			\"senderName\": \"ApplicationOne\"\n"
				+ "		}],\n" + "		\"outboundSMSTextMessage\": {\n" + "			\"message\": \"Hello World\"\n"
				+ "		},\n" + "		\"clientCorrelator\": \"123456\",\n" + "		\"receiptRequest\": {\n"
				+ "			\"notifyURL\": \"http://application.example.com/notifications/DeliveryInfoNotification\",\n"
				+ "			\"callbackData\": \"some-data-useful-to-the-requester\"\n" + "		},\n"
				+ "		\"resourceURL\": \"www.google.com/2\"\n" + "	}\n" + "}";

		return Response.status(201).entity(responseString).build();
	}

	@POST
	@Path("/outbound/{shortCode}/subscriptions")
	public Response outboundSubscriptionServices(@PathParam("shortCode") String shortCode) {

		String responseString = "{\n" + "	\"deliveryReceiptSubscription\": {\n" + "		\"callbackReference\": {\n"
				+ "			\"callbackData\": \"some-data-useful-to-the-requester\",\n"
				+ "			\"notifyURL\": \"http: //www.yoururl.here/noti:cations/DeliveryInfoNoti:cation\"\n"
				+ "		},\n" + "		\"filterCriteria\": \"some-meaningful-:lter-string\",\n"
				+ "		\"resourceURL\": \"www.google.com\",\n" + "		\"operatorCode\": \"OPERATOR1\"\n" + "	}\n"
				+ "}";

		return Response.status(201).entity(responseString).build();
	}

	@DELETE
	@Path("/outbound/{shortCode}/subscriptions/{subscriptionId}")
	public Response deleteOutboundSubscriptionServices(@PathParam("shortCode") String shortCode,
			@PathParam("subscriptionId") String subscriptionId) {

		return Response.status(204).build();
	}
}
