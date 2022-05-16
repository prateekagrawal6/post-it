# Efecte Post IT application

## Introduction
Post IT is a digital Sticky Notes application and this application provides you end points to do CRUD operation on the same.

###End-points for Note Creation
@PostMapping("/note/create")

###End-points for Note Read
To read list of note.
@GetMapping("/note/")
To read a particular note.
@GetMapping("/note/{id}")

###End-points for Note Update
@PutMapping("/note/update")

###End-points for Note Deletion
To delete all the notes.
@DeleteMapping("/note/")
To delete a particular note.
@DeleteMapping("/note/{id}")

Default Port : 8080,
Context-root : /

Sample requests and responses:
To Create:
end-point: /note/create
request: 
{
"note":"Hello, this is my new note"
}
response:
{
"id": 7,
"note": "Hello, this is my new note"
}

To Read list of notes:
end-point: /note/
response:
[
{
"id": 1,
"note": "Hello, this is my first note"
},
{
"id": 3,
"note": "Hello, this is my third note"
},
{
"id": 5,
"note": "Hello, this is my fourth note"
},
{
"id": 6,
"note": "Hello, this is my new note"
},
{
"id": 7,
"note": "Hello, this is my new note"
}
]


