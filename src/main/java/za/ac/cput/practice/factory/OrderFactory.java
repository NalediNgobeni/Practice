package za.ac.cput.practice.factory;

import za.ac.cput.practice.domain.InStoreOrder;
import za.ac.cput.practice.domain.OnlineOrder;
import za.ac.cput.practice.util.Helper;

import java.util.Date;
import java.util.UUID;

public class OrderFactory {

    public static OnlineOrder createOnlineOrder(
            String deliveryAddress,
            String shippingCode
    ) {

        if (Helper.isNullOrEmpty(deliveryAddress) ||
                Helper.isNullOrEmpty(shippingCode)) {
            return null;
        }


        return new OnlineOrder.Builder()
                .setOrderId(generateOrderId())
                .setDate(new Date())
                .setStatus("CREATED")
                .setDeliveryAddress(deliveryAddress)
                .setShippingCode(shippingCode)
                .build();
    }

    public static InStoreOrder createInStoreOrder(
            double immediatePayment,
            String cashierName
    ) {

        if (immediatePayment <= 0) {
            throw new IllegalArgumentException("Payment must be greater than zero");
        }

        if (Helper.isNullOrEmpty(cashierName)) {
            return null;
        }

        return new InStoreOrder.Builder()
                .setOrderId(generateOrderId())
                .setDate(new Date())
                .setStatus("PAID")
                .immediatePayment(immediatePayment)
                .cashierName(cashierName)
                .build();
    }

    private static String generateOrderId() {
        return "ORD-" + UUID.randomUUID().toString();
    }

}