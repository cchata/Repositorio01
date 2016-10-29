USE [bdBodega]
GO

CREATE PROCEDURE pa_proveedor_generar_codigo2
@codigo_generado varchar(11) OUTPUT
AS
BEGIN
	DECLARE @codigo AS CHAR(11)
	DECLARE @valor AS INT
	SET @codigo=(SELECT MAX(codigo_prov) FROM tbProveedor)
	
	IF @codigo IS NULL
		BEGIN
			SET @valor=1
		END
	ELSE
		BEGIN
			SET @valor=CONVERT(INT,SUBSTRING(@codigo,7,11))+1
		END
		
	IF @valor<10000000
		BEGIN
			SET @codigo='PROV'+(CASE
								WHEN @valor<10 THEN '000000'+CONVERT(CHAR(1),@valor) ---9
								WHEN @valor<100 THEN '00000'+CONVERT(CHAR(2),@valor) ---99
								WHEN @valor<1000 THEN '0000'+CONVERT(CHAR(3),@valor) ---999
								WHEN @valor<10000 THEN '000'+CONVERT(CHAR(4),@valor) ---9999
								WHEN @valor<100000 THEN '00'+CONVERT(CHAR(5),@valor) ---99999
								WHEN @valor<1000000 THEN '0'+CONVERT(CHAR(6),@valor) ---999999
								ELSE CONVERT(CHAR(7),@valor)						 ---9999999
								END)
			SET  @codigo_generado = @codigo;
		END
	ELSE
		BEGIN
			PRINT 'Código de proveedor desbordo'
			
		END
 RETURN;
END