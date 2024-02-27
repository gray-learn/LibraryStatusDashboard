# Project Library Status Dashboard


# Microservices API Documentation

This document outlines the primary endpoints for the `BookService`, `BorrowingService`, and the Eureka Discovery Service within our microservices architecture.

## Eureka Discovery Service

The Eureka Discovery Service acts as a registry for all our microservices, enabling them to discover and communicate with each other dynamically.

### Endpoints

- **Eureka Dashboard**
- **Method & Path**: `GET /`
- **Purpose**: Displays the Eureka Dashboard UI, which lists all registered services and their available instances.

## BookService

The `BookService` manages the library's collection of books, supporting operations such as adding, listing, updating, and deleting books.

### Endpoints

- **List All Books**
- **Method & Path**: `GET /books`
- **Purpose**: Retrieves a list of all books in the library.

- **Get Available Books**
- **Method & Path**: `GET /availableBooks`
- **Purpose**: Fetches books that are currently marked as "AVAILABLE".

- **Get Borrowed Books**
- **Method & Path**: `GET /borrowedBooks`
- **Purpose**: Lists books that are currently marked as "BORROWED".

- **Add a Book**
- **Method & Path**: `POST /add`
- **Purpose**: Adds a new book to the collection. Requires a JSON payload with book details.

- **Update a Book**
- **Method & Path**: `PUT /update/{id}`
- **Purpose**: Updates the details of an existing book. Requires book ID in the URL and a JSON payload with new details.

- **Delete a Book**
- **Method & Path**: `DELETE /delete/{id}`
- **Purpose**: Removes a book from the collection. Requires book ID in the URL.

## BorrowingService

The `BorrowingService` handles the processes of borrowing and returning books, updating their status between "BORROWED" and "AVAILABLE".
