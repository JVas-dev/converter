# converter
back : 
nvm spring-boot:run
front:
npm run-script serve

Create DB:

CREATE DATABASE converter
    WITH 
    OWNER = "User"
    ENCODING = 'UTF8'
    LC_COLLATE = 'en_US.UTF-8'
    LC_CTYPE = 'en_US.UTF-8'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

