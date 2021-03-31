for using swagger use 
http://localhost:8085/swagger-ui/
default port 8085

Database: postgres,

##### END POINT #####
#POST 
http://localhost:8085/api/
**post a long url**
reqbody 
{
  "longUrl": "string",
  "parameters": "{
      "value" : "data"
  }",
  "shortUrlDomain": "string"
}

#GET 
** get all click events **
http://localhost:8085/api/clickevents

#GET 
** Get all short url count **
http://localhost:8085/api/count

#GET
** Redirect to long Url from short url **
http://localhost:8085/{shortUrl}

#GET
** get url info from url unique id **
http://localhost:8085/api/{uniqueId}
