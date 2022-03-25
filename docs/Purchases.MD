### Create a Purchase resource

```
POST api/v1/purchase-request

Accept: application/json
Content-Type: application/json

[
    {
        "productId":1,
        "name":"Serra de Bancada",
        "brand":"FORTGPRO",
        "quantity":5
    },
]

RESPONSE: HTTP 201 (Created)
Location header: /api/v1/insert-articles-request
```

### Retrieve a Purchases list of articles

```
/api/v1/purchases

[
    {
        "productId":1,
        "name":"Serra de Bancada",
        "brand":"FORTGPRO",
        "quantity":5
    },
]


Response: HTTP 200
Content: paginated list 
```

