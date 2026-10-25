# SmartCart Development Backlog

Priority:
- P0: Essential foundation or initial functionality
- P1: Important production-minded capability
- P2: Advanced capability or improvement

## Epic 1: Foundation

- [ ] P0: Define requirements and architecture.
- [ ] P0: Create repository structure and README.
- [ ] P0: Initialize Spring Boot with Java 21.
- [ ] P0: Add a health endpoint and automated test.
- [ ] P0: Initialize the React application.
- [ ] P0: Establish configuration and secret-management conventions.

Acceptance:
- The backend starts locally.
- The health endpoint returns the documented response.
- The React application starts locally.
- No credentials are committed.

## Epic 2: Java and Spring Boot Fundamentals

- [ ] P0: Practice classes, records, enums, and interfaces in the domain.
- [ ] P0: Use collections and generics appropriately.
- [ ] P0: Use BigDecimal for money.
- [ ] P0: Learn exceptions and Optional through application code.
- [ ] P0: Implement constructor-based dependency injection.
- [ ] P0: Separate controllers, services, and repositories.
- [ ] P0: Create DTOs and validation rules.

Acceptance:
- Domain rules are separated from HTTP handling.
- Dependencies are injected through constructors.
- Invalid requests receive appropriate error responses.

## Epic 3: PostgreSQL and Persistence

- [ ] P0: Design the initial relational schema.
- [ ] P0: Configure PostgreSQL connectivity.
- [ ] P0: Add Flyway migrations.
- [ ] P0: Implement repository access with JPA.
- [ ] P1: Practice JDBC for selected queries.
- [ ] P0: Learn and apply transaction boundaries.
- [ ] P1: Add indexes based on observed query patterns.

Acceptance:
- Migrations work against a clean database.
- Relationships and constraints are enforced.
- Queries use safe parameter binding.
- Transaction-sensitive behavior is tested.

## Epic 4: Product Catalog

- [ ] P0: Create products.
- [ ] P0: Retrieve a product by ID.
- [ ] P0: List products.
- [ ] P0: Update permitted product fields.
- [ ] P0: Deactivate or remove products safely.
- [ ] P1: Add search, filters, sorting, and pagination.
- [ ] P1: Add product categories.

Acceptance:
- API responses follow a consistent format.
- Missing products return 404.
- Invalid data is rejected.
- Search and pagination have automated tests.

## Epic 5: React Frontend

- [ ] P0: Build the product listing page.
- [ ] P0: Build the product details page.
- [ ] P0: Integrate the product APIs.
- [ ] P0: Add loading, empty, and error states.
- [ ] P1: Add search and filters.
- [ ] P1: Add accessible and responsive layouts.

Acceptance:
- Products are loaded from the backend.
- API failures are presented clearly.
- Frontend code contains no private backend secrets.

## Epic 6: Cart, Checkout, Orders, and Inventory

- [ ] P0: Add cart management.
- [ ] P0: Validate quantities and product availability.
- [ ] P0: Calculate totals on the server.
- [ ] P0: Create orders and order items.
- [ ] P0: Implement transaction-safe inventory updates.
- [ ] P1: Handle concurrent stock changes.
- [ ] P1: Add order history and status transitions.
- [ ] P1: Make checkout retry behavior safe.

Acceptance:
- Invalid quantities are rejected.
- Orders use trusted server-side prices.
- Failed checkout does not leave inconsistent database state.
- Stock cannot be oversold through ordinary concurrent requests.

## Epic 7: Authentication and Security

- [ ] P0: Implement authentication using Spring Security.
- [ ] P0: Define customer, staff, and administrator permissions.
- [ ] P0: Protect private endpoints.
- [ ] P0: Enforce authorization for administrative operations.
- [ ] P1: Add rate limiting and security headers.
- [ ] P1: Review CORS, cookies, and CSRF requirements.
- [ ] P1: Review sensitive logging and secret handling.

Acceptance:
- Unauthorized users cannot perform protected actions.
- Access checks are enforced by the backend.
- Authentication and authorization failures are tested.

## Epic 8: Payments

- [ ] P1: Select a suitable payment provider.
- [ ] P1: Configure sandbox credentials safely.
- [ ] P1: Implement a server-side payment workflow.
- [ ] P1: Verify provider notifications.
- [ ] P1: Handle retries and duplicate notifications safely.

Acceptance:
- Sandbox payments can be tested without real charges.
- The application does not handle raw card numbers or CVV.
- Payment status is not trusted solely from browser input.

## Epic 9: Testing and Observability

- [ ] P0: Add unit tests for business rules.
- [ ] P0: Add API integration tests.
- [ ] P1: Test database migrations.
- [ ] P1: Add centralized API error handling.
- [ ] P1: Add structured logging.
- [ ] P1: Add health checks and request correlation IDs.
- [ ] P1: Review performance and database query plans.

Acceptance:
- Documented commands run the tests.
- Important failure paths are covered.
- Logs do not expose secrets.
- Health checks provide useful operational information.

## Epic 10: Docker and CI/CD

- [ ] P0: Add backend Dockerfile.
- [ ] P0: Add frontend Dockerfile.
- [ ] P0: Add Docker Compose for local development.
- [ ] P0: Add GitHub Actions CI.
- [ ] P0: Run tests and builds in CI.
- [ ] P1: Add dependency and security checks.

Acceptance:
- Local services start through documented commands.
- CI fails when required tests fail.
- Credentials are not embedded in container images.

## Epic 11: AWS Deployment and Monitoring

- [ ] P1: Compare deployment options and estimate costs.
- [ ] P1: Choose an appropriate initial architecture.
- [ ] P1: Configure least-privilege access.
- [ ] P1: Configure secrets safely.
- [ ] P1: Deploy the application.
- [ ] P1: Add logs, health monitoring, and alerts.
- [ ] P1: Document rollback and cleanup procedures.

Acceptance:
- Deployment is repeatable.
- Resources and recurring costs are documented.
- Logs and health checks are available.
- Cleanup procedures are tested where practical.

## Epic 12: AI Shopping Assistance

- [ ] P1: Define the AI use cases and safety boundaries.
- [ ] P1: Integrate an LLM through the backend.
- [ ] P1: Add product recommendation suggestions.
- [ ] P1: Ground answers in trusted product information.
- [ ] P2: Add RAG over approved product and help documentation.
- [ ] P2: Evaluate retrieval relevance and answer grounding.
- [ ] P2: Add narrowly scoped, permission-checked tools.
- [ ] P2: Test prompt injection and unsafe tool requests.

Acceptance:
- AI output is treated as untrusted.
- Product facts come from trusted data.
- AI cannot bypass prices, inventory, or authorization.
- Tool arguments are validated.
- Sensitive actions require appropriate confirmation.
- AI failure does not break ordinary shopping functionality.

## Day 1 Completion

- [ ] Requirements and architecture documented.
- [ ] Repository folders created.
- [ ] README and backlog created.
- [ ] Git configuration files created.
- [ ] Initial Git commit created.
- [ ] Repository pushed to GitHub.
