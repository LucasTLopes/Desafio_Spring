### Create a Customer resource

```
POST api/v1/insert-customer-request

Accept: application/json
Content-Type: application/json

[
    {
        "id": 1,
        "name": "Igor",
        "state": "SP",
        "cpf": "111111111-11"
    },
]

RESPONSE: HTTP 201 (Created)
Location header: /api/v1/insert-customer-request
```

### Retrieve a Customer list

```
GET /api/v1/customers

[
    {
        "id": 1,
        "name": "Igor",
        "state": "SP"
    },
]


Response: HTTP 200
Content: paginated list 
```