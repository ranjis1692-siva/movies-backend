**Movie (Entity)**
  - Maps the MOVIE database table using JPA entity annotations.

**MovieController**
  - Exposes REST endpoints for:
      1. Searching movies with pagination
      2. Fetching movie details by ID

**MovieService**
  - Contains the business logic.
  - Acts as an intermediary between the controller and the repository.

**MovieRepository**
  - Defines JPA repository methods for fetching paginated and filtered movie data.


**Pagination & Performance Optimization**

  - To efficiently handle larger datasets, pagination is implemented using Spring Data JPA’s Pageable abstraction.

The search endpoint accepts page parameter, while I have the page size as 20.
  - Instead of loading the full MOVIE table into memory, the query fetches only the required subset of records.
  - This reduces:
      1. Full table scans
      2. Memory usage
      3. Response time for large datasets
   
    
Spring Data JPA translates the Pageable request into database-level LIMIT and OFFSET queries, ensuring that pagination is handled directly at the database layer rather than in application memory.


**CORS issue**
After I created the endpoints and exposed them on to port 8080, I encountered the CORS error while trying to access from the 5173 PORT(frontend). So I added The @CrossOrigin(origins = ["http://localhost:5173"]) on the controller, which solved my issue. This again is very similar to Java with Springboot annotations.

