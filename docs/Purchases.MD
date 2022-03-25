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
    {
        "productId":2,
        "name":"Furadeira",
        "brand":"Black & Decker",
        "quantity":7
    }
]

RESPONSE: HTTP 201 (Created)
Location header: /api/v1/insert-articles-request
```

### Retrieve a Purchases list of articles

```
GET /api/v1/purchases

[
    {
        "id": 879,
        "articles": [
            {
                "productId": 1,
                "name": "Serra de Bancada",
                "category": "Ferramentas",
                "brand": "FORTGPRO",
                "price": 1800,
                "quantity": 5,
                "freeShipping": true,
                "prestige": "****"
            },
            {
                "productId": 2,
                "name": "Furadeira",
                "category": "Ferramentas",
                "brand": "Black & Decker",
                "price": 500,
                "quantity": 7,
                "freeShipping": true,
                "prestige": "****"
            }
        ],
        "total": 12500
    }
]


Response: HTTP 200
Content: paginated list 
```

