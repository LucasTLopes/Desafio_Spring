### Retrieve a Cart 

```
GET /api/v1/cart


Response: HTTP 200
Content: paginated list 

{
    "purchases": [
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
    ],
    "totalCart": 12500
}
```
