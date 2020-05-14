jdbc 

1. loading driver

   Class.forNum("com.mysql.cj.jdbc.Driver");

2. connect to db

   DriverManager.getConnection(url, userid, password);

3. statement 

   conn.createStataement("SELECT *FROM users");

4. result 

   insert/update/delete -> int

   select -> resultSet 

5. Disconnect