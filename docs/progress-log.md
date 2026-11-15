# SmartCart Progress Log

## 2026-10-25 — Day 1: Project Foundation

- Scope: Define the initial SmartCart requirements and architecture.
- Documentation: README, architecture, backlog, and progress log.
- Repository: Initial folder structure and Git configuration.
- Local validation: Run the Day 1 checks before committing.
- Git commit: Verify after creating the initial commit.
- GitHub push: Verify after publishing the repository.
- Next milestone: Initialize the Spring Boot API, add a health endpoint,
  and write the first automated test.

## Daily Entry Template

### YYYY-MM-DD — Day N

- Goal:
- Files changed:
- Implementation completed:
- Tests and checks:
- Commit:
- Lessons learned or blockers:
- Next step:

## Session 2: First Spring Boot API

### Completed
- [ ] Created or verified the Spring Boot backend
- [ ] Implemented the health endpoint
- [ ] Added a controller test
- [ ] Ran Maven tests successfully
- [ ] Started the application locally
- [ ] Verified the endpoint response

### Concepts Learned
- Java application entry point
- Spring Boot application startup
- REST controllers
- HTTP GET requests
- JSON responses
- Controller testing with MockMvc

### Next Steps
- Understand dependency injection and service layers
- Add DTOs and request validation
- Begin PostgreSQL configuration and database migrations

## Day 3 – Spring Boot Backend Foundation

**Completed:**
- Started building the SmartCart backend using Java 21 and Spring Boot 4.1.2.
- Established the backend project structure.
- Created and verified the application startup and health-check functionality.
- Started preparing the backend for database integration.

## Day 4 – PostgreSQL and Docker Integration

**Completed:**
- Configured PostgreSQL 16 using Docker.
- Created the `smartcart` database.
- Configured the application to connect to PostgreSQL.
- Configured the database container to expose PostgreSQL on host port `15433`.
- Verified the database connection from the Spring Boot application.

## Day 5 – Flyway Database Migration

**Completed:**
- Integrated Flyway for database schema version management.
- Created the initial database migration for the products table.
- Verified that Flyway successfully applied the migration.
- Confirmed that the application could connect to PostgreSQL and validate the database schema.

## Day 6 – Product Entity and Repository

**Completed:**
- Created the Product entity.
- Implemented the ProductRepository using Spring Data JPA.
- Established the initial database interaction layer for product operations.

## Day 7 – Product Service and Controller

**Completed:**
- Implemented the ProductService layer.
- Created the ProductController.
- Established the REST API structure for product operations.
- Implemented product retrieval and creation functionality.
- Verified the product API using Postman.

## Day 8 – DTOs and Request Validation

**Completed:**
- Introduced DTOs to separate API request/response structures from database entities.
- Implemented product request and response DTOs.
- Added validation for product input fields.
- Improved API responses for invalid requests.
- Added global exception handling for application errors.
- Verified HTTP 400 and 404 error handling.

## Day 9 – Backend Testing

**Completed:**
- Added and executed backend tests.
- Created tests for the health-check functionality.
- Added product controller and service test coverage.
- Verified the application and database integration through the test suite.
- Fixed issues identified during testing.

## Day 10 – Product Search and Database Pagination Preparation

**Completed:**
- Explored product search and pagination requirements.
- Added a repository method for case-insensitive product name searching.
- Implemented service-level product search and pagination using Spring Data `Pageable`.
- Added logic to return all products when the search term is empty.
- Verified the existing product API and database connectivity.

## Day 11 – Product API Pagination and Search

**Completed:**
- Updated the ProductController to support paginated product listing.
- Added the following query parameters:
  - `search` – search products by name.
  - `page` – select the page number (default: `0`).
  - `size` – specify the page size (default: `10`).
- Updated ProductControllerTest to support Spring Data paginated responses.
- Executed the complete Maven test suite successfully.

**Testing result:**
- Total tests: 8
- Passed: 8
- Failed: 0
- Errors: 0

**API examples:**
- `GET /api/products`
- `GET /api/products?page=0&size=5`
- `GET /api/products?search=mouse`
- `GET /api/products?search=mouse&page=0&size=5`

**Pending work for the next session:**
- Review the Spring Data `PageImpl` JSON serialization warning.
- Improve the stability of the paginated API response structure.
- Add more tests for search, pagination, and invalid parameters.
- Verify the API responses using Postman.

**Status:** Product search and pagination implementation completed. GitHub checkpoint pending.
