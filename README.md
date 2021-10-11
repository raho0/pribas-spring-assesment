- Timelines requests (timeline):

| field             | type              | description                                           | example    |
| ----------------- | ----------------- | ----------------------------------------------------- | ---------- |
| creationDate      | String (optional) | which retrieves timelines created on a given date     | 09-09-2021 |
| creationDateStart | String (optional) | which retrieves timelines created after a given date  | 08-09-2021 |
| creationDateEnd   | String (optional) | which retrieves timelines created before a given date | 11-09-2021 |

​	*(You can also use "add", "update", "delete" operations)

### Successful Response: 

```
http://localhost:8080/timeline/get?creationDateStart=08-09-2021?creationDateEnd=11-09-2021
```

```json
[
  {
    "title": "pribas gmbh history timeline",
    "description": "keeps important moments of pribas history",
    "user_id": 1,
    "creation_date": "09-09-2021",
    "tags": [
      "business",
      "work",
      "pribas"
    ],
    "moments": [
      {
        "title": "company establishment",
        "description": "pribas gmbh established in Frankfurt to provide IT solutions for airline industry",
        "moment_date": "09-09-1990 14:00",
        "creation_date": "09-09-2021"
      },
      {
        "title": "proprietary b2b distribution",
        "description": "started proprietary b2b distribution",
        "moment_date": "01-06-1995 14:00",
        "creation_date": "09-09-2021"
      },
      {
        "title": "b2b booking UIs",
        "description": "first implementation of b2b booking UIs",
        "moment_date": "01-06-2000 14:00",
        "creation_date": "09-09-2021"
      }
    ]
  }
]
```



- Moments requests ("/moment"):

| field           | type              | description                                         | example          |
| --------------- | ----------------- | --------------------------------------------------- | ---------------- |
| momentDate      | String (optional) | which retrieves moments created on a given date     | 09-09-1990 14:00 |
| momentDateStart | String (optional) | which retrieves moments created after a given date  | 01-06-1995 14:00 |
| creationDateEnd | String (optional) | which retrieves moments created before a given date | 01-06-2000 14:00 |

​	* (You can also use "add", "update", "delete" operations)

### Successful Response: 

```
http://localhost:8080/moment/get?momentDateStart=01-06-2000 13:00?momentDateEnd=01-06-2000 15:00
```

```json
[
  {
    "title": "b2b booking UIs",
    "description": "first implementation of b2b booking UIs",
    "moment_date": "01-06-2000 14:00",
    "creation_date": "09-09-2021"
  }
]
```



* User request ("/user")

  

  You can use "add", "update", "delete", "get" methods

----

You can access H2 database at: 

```
http://localhost:8080/h2-console 
```

JDBC config:

```
JDBC URL: "jdbc:h2:mem:test"
User Name: "sa"
Password: ""
```

---

