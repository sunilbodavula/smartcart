# SmartCart Architecture

## 1. Architectural Style

SmartCart will initially use a modular monolith.

The frontend and backend are separate applications. The Spring Boot
backend will contain logical modules for catalog, identity, cart,
checkout, orders, payments, inventory, and AI assistance.

## 2. High-Level Architecture

Customer
   |
   v
React Frontend
   |
   | HTTPS / REST API
   v
Spring Boot Backend
   |
   +-- Controllers and DTOs
   |
   +-- Services and business rules
   |
   +-- Security and authorization
   |
   +-- Repositories and data access
   |
   +-- AI integration
   |
   +-- Payment-provider integration
   |
   v
PostgreSQL

Supporting components:
- Flyway for database migrations
- Docker Compose for local development
- GitHub Actions for automated checks
- AWS for deployment and monitoring

## 3. Backend Layers

### Controller Layer

Receives HTTP requests, validates request structure, and returns
appropriate HTTP responses.

### Service Layer

Contains business rules, such as calculating order totals,
checking product availability, and coordinating checkout.

### Repository Layer

Communicates with PostgreSQL using Spring Data JPA or JDBC.

### DTOs

Define the data accepted by the API and returned to clients.
Database entities will not automatically become public API contracts.

### Security Layer

Authenticates users and checks permissions before protected
operations are executed.

## 4. Initial Domain Entities

### users
Identity, account status, and role information.

### products
Product name, description, price, category, and publication status.

### inventory
Available stock and inventory-related information.

### carts
Shopping cart ownership and lifecycle.

### cart_items
Products and quantities belonging to a cart.

### orders
Customer, order status, totals, and timestamps.

### order_items
Purchased product information, quantity, and price snapshot.

### payments
Payment-provider reference, amount, currency, and status.
Never store raw card numbers or CVV data.

### ai_interactions
Minimal metadata about AI assistance, such as operation type,
outcome, and timestamp.

Constraints, relationships, and indexes will be defined through
versioned database migrations.

## 5. API Design

The backend will expose versioned REST endpoints under `/api/v1`.

Planned endpoint groups:

- `/api/v1/auth`
- `/api/v1/products`
- `/api/v1/cart`
- `/api/v1/orders`
- `/api/v1/payments`
- `/api/v1/assistant`

The exact request and response contracts will be documented as
each endpoint is implemented.

## 6. Checkout and Inventory

Checkout will validate the cart, product prices, and stock on the
server rather than trusting values supplied by the browser.

Database transactions and appropriate concurrency controls will
protect order creation and stock updates.

External payment calls will be designed separately from long-running
database transactions. Payment status changes must be handled safely,
including retries and duplicate notifications.

## 7. AI Architecture

AI requests will be sent through the backend.

The backend will:
- Check the requesting user's permissions.
- Send only the information needed for the request.
- Ground product answers in approved product information.
- Validate AI output before using it.
- Restrict any tool calls to an explicit allowlist.
- Recheck permissions before performing actions.
- Avoid exposing secrets or unnecessary personal information.

AI recommendations will not bypass stock checks, prices, security,
or checkout validation.

## 8. Security

- Keep secrets out of Git.
- Validate and constrain incoming requests.
- Enforce authorization on the backend.
- Apply least-privilege database permissions.
- Use secure authentication and session handling.
- Avoid logging credentials or payment-sensitive information.
- Verify payment-provider callbacks.
- Protect against unauthorized access and unsafe AI tool calls.

## 9. Deployment

Local development will use Docker Compose.

GitHub Actions will run automated checks before changes are merged.

AWS deployment will be planned only after estimating costs and
reviewing resource permissions, secrets, monitoring, and cleanup.

## 10. Delivery Sequence

1. Repository foundation
2. Spring Boot application and health endpoint
3. PostgreSQL connection and migrations
4. Product catalog APIs
5. React frontend
6. Search and pagination
7. Cart and checkout
8. Orders and inventory
9. Authentication and authorization
10. Tests, logging, and error handling
11. Docker Compose and CI
12. AWS deployment and monitoring
13. AI recommendations and grounded shopping assistance
