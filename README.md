
# CRUD-OPERATION-USING-RESTAPI-SPRING-BOOT-SECURITY

plication using custom authentication and authorization mechanisms while integrating a robust data management system.


## API Reference


#### Get Person

```http
  Get/person/getall
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `email`   | `string` |  Unique email of the person |
| `password`| `string`|password for the person's account|
| `firstName`| `string`| firstname for the person's account|
|`lastName`|`string`| lastName for the person's account|
|`address`|`List<Address>`| Optional list of address details|



#### Create Person

```http
  POST/person/create
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `email`   | `string` |  Unique email of the person |
| `password`| `string`|password for the person's account|
| `firstName`| `string`| firstname for the person's account|
|`lastName`|`string`| lastName for the person's account|
|`address`|`List<Address>`| Optional list of address details|

#### Update Person

```http
  POST/person/update/${id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **Required**. Id of item to update|
| `email`   | `string` |  Unique email of the person |
| `password`| `string`|password for the person's account|
| `firstName`| `string`| firstname for the person's account|
|`lastName`|`string`| lastName for the person's account|
|`address`|`List<Address>`| Optional list of address details|

#### Delete Person

```http
  DELETE/person/delete/${id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **Required**. Id of item to delete|
| `email`   | `string` |  Unique email of the person |
| `password`| `string`|password for the person's account|
| `firstName`| `string`| firstname for the person's account|
|`lastName`|`string`| lastName for the person's account|
|`address`|`List<Address>`| Optional list of address details|



## Authors

- [@01prashu](https://www.github.com/01prashu)


