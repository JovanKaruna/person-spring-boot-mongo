# Person Service Spring Boot MongoDB
Person Service using Spring Boot and MongoDB. This is an exercise for Future Blibli

## API
```GET /api/person``` : to get list of all person<br>
example:
```
{
  "errorMessage": null,
  "errorCode": null,
  "success": true,
  "requestId": "RANDOM",
  "content": [
    {
      "personCode": "1",
      "personName": "string",
      "addresses": [
        {
          "addressName": "string",
          "address": "string",
          "city": "string"
        }
      ],
      "id": "600e8abf48c0c652c0ba19b6",
      "markForDelete": false,
      "version": 0,
      "createdBy": "jovan",
      "createdDate": 1611565759795,
      "updatedBy": "a",
      "updatedDate": 1611567604362,
      "storeId": "10001"
    },
    {
      "personCode": "2",
      "personName": "Jovan Karuna",
      "addresses": [
        {
          "addressName": "jln b",
          "address": "alamat rumah",
          "city": "Jakarta"
        },
        {
          "addressName": "jln a",
          "address": "alamat kantor",
          "city": "Bandung"
        }
      ],
      "id": "600e957148c0c661f4e3e00d",
      "markForDelete": false,
      "version": 0,
      "createdBy": "a",
      "createdDate": 1611568497390,
      "updatedBy": "a",
      "updatedDate": 1611568497390,
      "storeId": "10001"
    }
  ],
  "metadata": {
    "page": 0,
    "size": 10,
    "totalItems": 2
  }
}
```

```GET /api/person/{code}``` : to get person by personCode<br>
example response with /api/person/1:
```
{
  "errorMessage": null,
  "errorCode": null,
  "success": true,
  "requestId": "RANDOM",
  "value": {
    "personCode": "1",
    "personName": "string",
    "addresses": [
      {
        "addressName": "string",
        "address": "string",
        "city": "string"
      }
    ],
    "id": "600e8abf48c0c652c0ba19b6",
    "markForDelete": false,
    "version": 0,
    "createdBy": "jovan",
    "createdDate": 1611565759795,
    "updatedBy": "a",
    "updatedDate": 1611567604362,
    "storeId": "10001"
  }
}
```

```POST /api/person``` : to create person data<br>
example request body:
```
{
  "addresses": [
    {
      "address": "alamat rumah",
      "addressName": "jln b",
      "city": "Jakarta"
    },
    {
      "address": "alamat kantor",
      "addressName": "jln a",
      "city": "Bandung"
    }
  ],
  "personCode": "2",
  "personName": "Jovan Karuna"
}
```

```UPDATE /api/person/{code}``` : to update person data with the same personCode<br>
example request body:
```
{
  "addresses": [
    {
      "address": "string",
      "addressName": "string",
      "city": "string"
    }
  ],
  "personName": "string"
}
```

```DELETE /api/person/{code}``` : delete a person data with the same personCode<br>

## Author
Jovan Karuna Cahyadi