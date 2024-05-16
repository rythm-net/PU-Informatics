<?php

$customers = array("Ivan Petrov", "Maria Ivanova", "Dragan Draganov");

$id = $_GET["id"];

header("Content-Type: text/html");

?>

<html>
<body>

Customers:<br><br>
<?php if ($id == "") {?>

<table>
<?php
  for($i=0; $i < sizeof($customers); $i++) {
     print("<tr><td>");
?>
<?=$customers[$i]?>
   </td>
   </tr>
<?php
  }
} else {
  print($customers[$id]);
}
?>
</table>
</body>
</html>
