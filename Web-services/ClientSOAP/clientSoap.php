<?php
$mt = 0;
if (isset($_POST['action'])) {
    $action = $_POST['action'];
    if ($action == "OK") {
        $mt = $_POST['montant'];
        $clientSO = new SoapClient("http://localhost:9191/BanqueWS?wsdl");
        $param = new stdClass();
        $param->montant = $mt;
        $rep = $clientSO->__soapCall("Convert", array($param));
        $res = $rep->return;
    } elseif ($action == "comptes") {
        $clientSO = new SoapClient("http://localhost:9191/BanqueWS?wsdl");
        $cptes = $clientSO->__soapCall("listCompte", array());
    }
} ?>
<html>
<body>
    <form method="post" action="clientSoap.php">
        Montant :<input type="text" name="montant" value="<?php echo ($mt) ?>">
        <input type="submit" value="OK" name="action">
        <input type="submit" value="comptes" name="action">
    </form>
    Result :
    <?php if (isset($res)) { ?>
        <?php echo ($res) ?> en EURO = <?php echo($res)?> en DH
    <?php } ?>
    <?php if (isset($cptes)) { ?>
    <table border="1" width="80%">
        <tr>
            <th>CODE</th>
            <th>SOLD</th>
        </tr>
        <?php foreach ($cptes->return as $cp) { ?>
            <tr>
                <td><?php echo ($cp->code) ?></td>
                <td><?php echo ($cp->solde) ?></td>
            </tr>
        <?php } ?>
    </table>
    <?php } ?>
</body>

</html>