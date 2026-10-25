# SmartCart — E-commerce Platform

SmartCart is a portfolio project demonstrating full-stack development
with React, Java, Spring Boot, PostgreSQL, Docker, GitHub Actions,
AWS, and AI-powered shopping assistance.

## 1. Problem Statement

SmartCart provides an online shopping experience where customers can
browse products, search the catalog, manage a shopping cart, and place
orders through a secure checkout workflow.

AI-assisted features will help customers discover relevant products
and obtain grounded answers to shopping questions.

## 2. Technology Stack

- Frontend: React
- Backend: Java and Spring Boot
- Database: PostgreSQL
- Database migrations: Flyway and SQL
- Persistence: Spring Data JPA and JDBC
- Security: Spring Security
- Containers: Docker and Docker Compose
- Version control: Git and GitHub
- CI/CD: GitHub Actions
- Cloud: AWS
- AI: LLM API, product recommendations, and retrieval-augmented generation

## 3. Planned Features

- Product catalog and product details
- Search, filtering, sorting, and pagination
- User registration and authentication
- Role-based authorization
- Shopping cart management
- Checkout and order creation
- Stock management and transaction-safe inventory updates
- Payment-provider sandbox integration
- Input validation and consistent API errors
- Unit and integration tests
- Structured logging and monitoring
- Docker-based local development
- GitHub Actions CI pipeline
- Cost-conscious AWS deployment
- AI-powered product recommendations
- Shopping assistance grounded in approved product information

## 4. Architecture

The React frontend communicates with the Spring Boot REST API.
The backend validates requests, applies business rules, checks
permissions, and accesses PostgreSQL.

Payment operations will use a supported payment provider's sandbox.
The application will not collect or store raw card numbers or CVV data.

AI requests will be routed through the backend. Provider credentials
must never be exposed in frontend code.

See [docs/architecture.md](docs/architecture.md).

## 5. Repository Structure

- `apps/web/` - React frontend
- `apps/api/` - Spring Boot backend
- `database/migrations/` - Versioned SQL migrations
- `docs/` - Project documentation
- `infra/docker/` - Docker configuration
- `scripts/` - Development scripts
- `.github/workflows/` - GitHub Actions workflows

## 6. Development Status

Current milestone: Project foundation and repository setup.

The application code will be implemented incrementally. Features will
be marked complete only after their acceptance criteria and relevant
tests have been satisfied.

## 7. Engineering Principles

- Use appropriate Java types for business concepts.
- Use BigDecimal for monetary calculations.
- Validate incoming requests.
- Keep controllers focused on HTTP concerns.
- Put business rules in service classes.
- Separate persistence concerns from API DTOs.
- Use database migrations for schema changes.
- Use transactions for operations requiring atomic database changes.
- Use parameterized queries.
- Enforce authentication and authorization on the backend.
- Never commit passwords, API keys, or cloud credentials.
- Never handle raw payment card details directly.
- Test important business rules and security boundaries.
- Treat AI output as untrusted input.
- Restrict AI operations to explicitly permitted actions.

## 8. Development Backlog

See [docs/backlog.md](docs/backlog.md).

## 9. Progress Log

See [docs/progress-log.md](docs/progress-log.md).

## 10. License

A suitable license will be selected before publishing the repository
as an open-source project.
