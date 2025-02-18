# Payment Service

## Payment Flow

1. Order Creation - User -> OrderService
2. Payment Link Generation - User -> PaymentService
3. Order Details Fetch - PaymentService -> OrderService
4. User is Navigated to Payment Link followed by user getting redirected to the callback URL
5. Payment Status check - Callback window -> PaymentService
6. Webhook Status Update - PaymentGateway -> PaymentService

## APIs

1. Get Payment Status
2. Create Payment Link
3. Handle Webhook Event