# qr-code-api
API for creating and reading QR Code

# 2 types of barcode
- Linear barcode
- 2D barcode

# Different kinds of codes
## UPC (Universal Product Code) 
   - `UPC-A:` 12 digit code 6 for manufacturer id number, 5 for item number and 1 for check number
   - `UPC-E:` 8 digit code for small packages

## EAN (Europian Article Number) 
- Specifically EAN-13 a 13 digit code, structured by leading "o" and a UPC-A code. Usually used  for Point of Sale scanning.

## Code 128
- Compact and high density code usually used for logistics and transportation industries for ordering and distribution.

## PDF 417
- Is a stacked linear barcode comprised of multiple 1D barcodes stacked one on top of another. Usually used for boarding passes, Identification cards, and inventory management.

## QR Code
- A 2D barcode that can contain large data in a limited space. Data such as: numeric, and alpanumeric, bytes/ binaries

##### Note
- Create folder where you will store the qr codes (Make sure that folder has read and write access)

## Sample QrCode Generation Data in Linux (Ubuntu) 
```
destinationWithFileName: //home//path//to//my-singled-valued-qr-code.jpg
```

## Sample QrCode Generation in Windows
```
destinationWithFileName: C:\\path\\to\\my-singled-valued-qr-code.jpg
```

# Useful Links
## Reference
https://www.baeldung.com/java-generating-barcodes-qr-codes

## Code
[Github Repository](https://github.com/eugenp/tutorials/tree/master/spring-boot-modules/spring-boot-libraries/src/main/java/com/baeldung/barcodes)  

[Generating Barcode Sample](https://github.com/eugenp/tutorials/blob/master/spring-boot-modules/spring-boot-libraries/src/main/java/com/baeldung/barcodes/generators/ZxingBarcodeGenerator.java)  

[Reading barcode using camera by JavaFX 1](https://github.com/karanja-simon/JavaFXQRGenerator)  

[Reading barcode using camera by JavaFX 2](https://github.com/giobyte8/QRScanner)

# Postman
[![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/26932885-f1a5f28f-d3e8-4014-9f4b-71d96e99f920?action=collection%2Ffork&source=rip_markdown&collection-url=entityId%3D26932885-f1a5f28f-d3e8-4014-9f4b-71d96e99f920%26entityType%3Dcollection%26workspaceId%3D28603b1f-569b-406a-a966-85be190a9f4d)
