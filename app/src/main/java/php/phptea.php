<?php
require("fpd/fpdf.php");

$pdf = new FPDF();

       $DesayHoy1  = urldecode($_POST['DesayHoy1']);
       $DesayHoy2   = urldecode($_POST['DesayHoy2']);
       $DesayHoy3  = urldecode($_POST['DesayHoy3']);

       $ComHoy1  = urldecode($_POST['ComHoy1']);
       $ComHoy2  = urldecode($_POST['ComHoy2']);
       $ComHoy2   = urldecode($_POST['ComHoy2']);

       $MerHoy1  = urldecode($_POST['MerHoy1']);
       $MerHoy2  = urldecode($_POST['MerHoy2']);

       $CenaHoy1  = urldecode($_POST['CenaHoy2']);
       $CenaHoy2   = urldecode($_POST['CenaHoy2']);
       $CenaHoy3  = urldecode($_POST['CenaHoy3']);

       $DesayMan1  = urldecode($_POST['DesayMan1']);
       $DesayMan2   = urldecode($_POST['DesayMan2']);
       $DesayMan3  = urldecode($_POST['DesayMan3']);

       $ComMan1  = urldecode($_POST['ComMan1']);
       $ComMan2  = urldecode($_POST['ComHoy2']);
       $ComMan2   = urldecode($_POST['ComMan2']);

       $MerMan1  = urldecode($_POST['MerMan1']);
       $MerMan2  = urldecode($_POST['MerMan2']);

       $CenaMan1  = urldecode($_POST['CenaMan2']);
       $CenaMan2   = urldecode($_POST['CenaMan2']);
       $CenaMan3  = urldecode($_POST['CenaMan3']);

       $pdf->AddPage();
       $pdf->SetFont("Arial","B",14);

       $pdf->Write(6, "ELECCION DE HOY:");
       $pdf->SetFont("Arial","",12);
       $pdf->Ln( 12 );
       $pdf->Write(6, "ELECCION DESAYUNO 1:".$DesayHoy1);
       $pdf->Ln( 12 );
       $pdf->Write(6, "ELECCION DESAYUNO 2:".$DesayHoy2);
       $pdf->Ln( 12 );
       $pdf->Write(6, "ELECCION DESAYUNO 3:".$DesayHoy3);
       $pdf->Ln( 12 );
       $pdf->Write(6, "ELECCION COMIDA 1:".$ComHoy1);
       $pdf->Ln( 12 );
       $pdf->Write(6, "ELECCION COMIDA 2:".$ComHoy2);
       $pdf->Ln( 12 );
       $pdf->Write(6, "ELECCION COMIDA 3:".$ComHoy3);
       $pdf->Ln( 12 );
       $pdf->Write(6, "ELECCION MERIENDA 1:".$MerHoy1);
       $pdf->Ln( 12 );
       $pdf->Write(6, "ELECCION MERIENDA 2:".$MerHoy2);
       $pdf->Ln( 12 );
       $pdf->Write(6, "ELECCION CENA 1:".$CenaHoy1);
       $pdf->Ln( 12 );
       $pdf->Write(6, "ELECCION CENA 2:".$CenaHoy2);
       $pdf->Ln( 12 );
       $pdf->Write(6, "ELECCION CENA 3:".$CenaHoy3);
       $pdf->Ln( 12 );

       $pdf->SetFont("Arial","B",14);
       $pdf->Write(6, "ELECCION DE MAÑANA:");
       $pdf->SetFont("Arial","",12);
       $pdf->Ln( 12 );
       $pdf->Write(6, "ELECCION DESAYUNO 1:".$DesayMan1);
       $pdf->Ln( 12 );
       $pdf->Write(6, "ELECCION DESAYUNO 2:".$DesayMan2);
       $pdf->Ln( 12 );
       $pdf->Write(6, "ELECCION DESAYUNO 3:".$DesayMan3);
       $pdf->Ln( 12 );
       $pdf->Write(6, "ELECCION COMIDA 1:".$ComMan1);
       $pdf->Ln( 12 );
       $pdf->Write(6, "ELECCION COMIDA 2:".$ComMan2);
       $pdf->Ln( 12 );
       $pdf->Write(6, "ELECCION COMIDA 3:".$ComMan3);
       $pdf->Ln( 12 );
       $pdf->Write(6, "ELECCION MERIENDA 1:".$MerMan1);
       $pdf->Ln( 12 );
       $pdf->Write(6, "ELECCION MERIENDA 2:".$MerMan2);
       $pdf->Ln( 12 );
       $pdf->Write(6, "ELECCION CENA 1:".$CenaMan1);
       $pdf->Ln( 12 );
       $pdf->Write(6, "ELECCION CENA 2:".$CenaMan2);
       $pdf->Ln( 12 );
       $pdf->Write(6, "ELECCION CENA 3:".$CenaMan3);
       $pdf->Ln( 12 );


       $to = "juanmajr97@gmail.com";
       $from = "me@domain.com";
       $subject = "send email with pdf attachment";
       $message = "<p>Please see the attachment.</p>";

       $separator = md5(time());

       // carriage return type (we use a PHP end of line constant)
      $eol = PHP_EOL;
      // attachment name
      $filename = "example.pdf";
      // encode data (puts attachment in proper format)
      $pdfdoc = $pdf->Output("", "S");
      $attachment = chunk_split(base64_encode($pdfdoc));
      // main header (multipart mandatory)
      $headers  = "From: ".$from.$eol;
      $headers .= "MIME-Version: 1.0".$eol;
      $headers .= "Content-Type: multipart/mixed; boundary=\"".$separator."\"".$eol.$eol;
      $headers .= "Content-Transfer-Encoding: 7bit".$eol;
      $headers .= "This is a MIME encoded message.".$eol.$eol;
      // message
      $headers .= "--".$separator.$eol;
      $headers .= "Content-Type: text/html; charset=\"iso-8859-1\"".$eol;
      $headers .= "Content-Transfer-Encoding: 8bit".$eol.$eol;
      $headers .= $message.$eol.$eol;
      // attachment
      $headers .= "--".$separator.$eol;
      $headers .= "Content-Type: application/octet-stream; name=\"".$filename."\"".$eol;
    $headers .= "Content-Transfer-Encoding: base64".$eol;
      $headers .= "Content-Disposition: attachment".$eol.$eol;
      $headers .= $attachment.$eol.$eol;
      $headers .= "--".$separator."--";
      // send message
      mail($to, $subject, "", $headers);


 ?>
