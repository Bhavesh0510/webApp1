<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Web page for Alien</title>
</head>
<body>
    <h4>For Record Addition</h4>
    <form action="addAlien" method="get">
        <label>Enter Alien Id: </label>
        <input type="text" name="aid"><br><br>
        <label>Enter Alien Name: </label>
        <input type="text" name="aname"><br><br>
        <label>Enter Alien Tech: </label>
        <input type="text" name="tech"><br><br>
        <input type="submit"><br><br>
    </form>

    <h4>For Search</h4>
    <form action="getAlien" method="get">
        <label>Enter Alien Id: </label>
        <input type="text" name="aid"><br><br>
        <input type="submit"><br><br>
    </form>

    <h4>For record Deletion</h4>
    <form action="delAlien" method="get">
        <label>Enter Alien Id: </label>
        <input type="text" name="aid"><br><br>
        <input type="submit"><br><br>
    </form>

    <h4>For record Updation</h4>
    <form action="delAlien2" method="get">
        <label>Enter Old Alien Id: </label>
        <input type="text" name="aid"><br><br>
        <input type="submit"><br>
    </form>
</body>
</html>
