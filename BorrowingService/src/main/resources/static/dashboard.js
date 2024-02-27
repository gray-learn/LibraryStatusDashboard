$(document).ready(function() {
    // Function to retrieve and display books
    function loadBooks() {
        $.get('/books', function(data) {
            $('#totalBooksTable tbody').empty(); // Clear existing data
            data.forEach(function(book) {
                $('#totalBooksTable tbody').append('<tr>' +
                    '<td>' + book.id + '</td>' +
                    '<td>' + book.name + '</td>' +
                    '<td>' + book.isbn + '</td>' +
                    '<td><b>' + book.status + '</b></td>' +
                    '</tr>');
            });
        });

        $.get('/availableBooks', function(data) {
            $('#availableBooksTable tbody').empty(); // Clear existing data
            data.forEach(function(book) {
                $('#availableBooksTable tbody').append('<tr>' +
                    '<td>' + book.id + '</td>' +
                    '<td>' + book.name + '</td>' +
                    '<td>' + book.isbn + '</td>' +
                    '<td><b>' + book.status + '</b></td>' +
                    '</tr>');
            });
        });

        $.get('/borrowedBooks', function(data) {
            $('#borrowedBooksTable tbody').empty(); // Clear existing data
            data.forEach(function(book) {
                $('#borrowedBooksTable tbody').append('<tr>' +
                    '<td>' + book.id + '</td>' +
                    '<td>' + book.name + '</td>' +
                    '<td>' + book.isbn + '</td>' +
                    '<td><b>' + book.status + '</b></td>' +
                    '</tr>');
            });
        });
    }

    $('#addBookForm').on('submit', function(e) {
        e.preventDefault(); // Prevent the form from submitting via the browser
        var bookData = {
            name: $('#name').val(),
            isbn: $('#isbn').val()
        };

        $.ajax({
            url: '/add', // Adjust the URL as needed
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(bookData),
            success: function(response) {
                alert('Book added successfully');
                loadBooks(); // Reload the book list
            },
            error: function(xhr, status, error) {
                alert('Error adding book: ' + xhr.responseText);
            }
        });
    });

    $('#return-button').on('click', function() {
        var bookId = $('#return-book-id').val();
        if(bookId) { // Ensure bookId is not empty
            console.log('Return book with ID:', bookId);
            $.ajax({
                url: '/update/' + bookId,
                type: 'PUT',
                success: function(response) {
                    alert('Book Return successfully!');
                    $('#return-book-id').val('');
                    loadBooks(); // Reload the book list
                },
                error: function(xhr, status, error) {
                    alert('Error Return book: ' + xhr.responseText);
                }
            });
        } else {
            alert('Please enter a book ID.');
        }
    });

    $('#borrow-button').on('click', function() {
        var bookId = $('#borrow-book-id').val();
        if(bookId) { // Ensure bookId is not empty
            console.log('Borrow book with ID:', bookId);
            $.ajax({
                url: '/update/' + bookId,
                type: 'PUT',
                success: function(response) {
                    alert('Book borrow successfully!');
                    $('#borrow-book-id').val('');
                    loadBooks(); // Reload the book list
                },
                error: function(xhr, status, error) {
                    alert('Error borrow book: ' + xhr.responseText);
                }
            });
        } else {
            alert('Please enter a book ID.');
        }
    });

    // Bind onclick event for deleting books
    $('#delete-button').on('click', function() {
        var bookId = $('#delete-book-id').val();
        if(bookId) { // Ensure bookId is not empty
            console.log('Deleting book with ID:', bookId);
            $.ajax({
                url: '/delete/' + bookId,
                type: 'DELETE',
                success: function(response) {
                    alert('Book deleted successfully!');
                    $('#delete-button').val('');
                    loadBooks(); // Reload the book list
                },
                error: function(xhr, status, error) {
                    alert('Error deleting book: ' + xhr.responseText);
                }
            });
        } else {
            alert('Please enter a book ID.');
        }
    });

    // Initial load of books
    loadBooks();
});
