# Product Service API Documentation

## API Versioning Strategy

This API uses **URL-based versioning** for better clarity and maintainability.

### Current API Version: V1

Base URL: `http://localhost:8080/api/v1`

### API Endpoints

#### 1. Get All Products
- **Method**: GET
- **Endpoint**: `/api/v1/products`
- **Response**: List of ProductResponse objects
- **Status Code**: 200 OK

#### 2. Get Product by ID
- **Method**: GET
- **Endpoint**: `/api/v1/products/{id}`
- **Path Parameter**: `id` (Long) - Product ID
- **Response**: ProductResponse object
- **Status Code**: 200 OK
- **Error**: 404 Not Found if product doesn't exist

#### 3. Create Product
- **Method**: POST
- **Endpoint**: `/api/v1/products`
- **Request Body**: ProductRequest object
  ```json
  {
    "productName": "Sample Product",
    "productPrice": 150,
    "quantity": 25
  }
  ```
- **Response**: Created ProductResponse object
- **Status Code**: 201 Created

#### 4. Update Product
- **Method**: PUT
- **Endpoint**: `/api/v1/products/{id}`
- **Path Parameter**: `id` (Long) - Product ID to update
- **Request Body**: ProductRequest object
- **Response**: Updated ProductResponse object
- **Status Code**: 200 OK
- **Error**: 404 Not Found if product doesn't exist

#### 5. Delete Product
- **Method**: DELETE
- **Endpoint**: `/api/v1/products/{id}`
- **Path Parameter**: `id` (Long) - Product ID to delete
- **Response**: No content
- **Status Code**: 204 No Content
- **Error**: 404 Not Found if product doesn't exist

## Error Handling

All error responses follow a consistent format with HTTP status codes:
- **400**: Bad Request
- **404**: Not Found (ProductNotFoundException)
- **500**: Internal Server Error

## Future Versioning

When introducing breaking changes:
1. Create new controllers at `/api/v2/products`
2. Keep `/api/v1/products` for backward compatibility
3. Update clients to migrate to new versions
4. Eventually deprecate old versions with notice period
