### Create a Article resource

```
POST /api/v1/insert-articles-request

Accept: application/json
Content-Type: application/json

[
   {
      "productId":"13",
      "name":"Serra de Bancada",
      "category":"Ferramentas",
      "brand":"FORTGPRO",
      "price":"1800",
      "quantity":5,
      "freeShipping":true,
      "prestige":"****"
   }
]

RESPONSE: HTTP 201 (Created)
Location header: /api/v1/insert-articles-request
```

### Retrieve a paginated list of articles

```
/api/v1/articles

[
   {
      "productId":"13",
      "name":"Serra de Bancada",
      "category":"Ferramentas",
      "brand":"FORTGPRO",
      "price":"1800",
      "quantity":5,
      "freeShipping":true,
      "prestige":"****"
   }
]


Response: HTTP 200
Content: paginated list 
```

Obs: Possible filters than can be used: 

    * freeShipping: true || false
    * category: NAME
    * product: NAME
    * order:[0-3]
    * brand: NAME