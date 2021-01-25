# this project is a demo of issue [https://github.com/OpenLiberty/open-liberty/issues/15476](https://github.com/OpenLiberty/open-liberty/issues/15476)


The problem is that this entity model will not autocreate on postgres, and works fine on derby

requirement is a running postgres database instance. Update the server.xml to have the datasource pointing to the postgres instance

## Steps to reproduce

```
1. update server.xml with a running postgres instane of you own
2. run mvn liberty:dev
3. You might need to create the schema test on postgres
4. open https://localhost:9443/openliberty-JPA-issues/api/test
5. watch the terminal ...
     
```


