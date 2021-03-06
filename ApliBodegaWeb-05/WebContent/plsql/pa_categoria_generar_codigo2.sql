USE [bdBodega]
GO
/****** Object:  StoredProcedure [dbo].[pa_categoria_generar_codigo]    Script Date: 10/10/2016 17:20:01 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[pa_categoria_generar_codigo2]
@codigo_generado varchar(10) OUTPUT
AS
BEGIN
	DECLARE @codigo AS CHAR(10)
	DECLARE @valor AS INT
	SET @codigo=(SELECT MAX(codigo_cat) FROM tbCategoria)
	
	IF @codigo IS NULL
		BEGIN
			SET @valor=1
		END
	ELSE
		BEGIN
			SET @valor=CONVERT(INT,SUBSTRING(@codigo,7,10))+1
		END
		
	IF @valor<10000000
		BEGIN
			SET @codigo='CAT'+(CASE
								WHEN @valor<10 THEN '000000'+CONVERT(CHAR(1),@valor) ---9
								WHEN @valor<100 THEN '00000'+CONVERT(CHAR(2),@valor) ---99
								WHEN @valor<1000 THEN '0000'+CONVERT(CHAR(3),@valor) ---999
								WHEN @valor<10000 THEN '000'+CONVERT(CHAR(4),@valor) ---9999
								WHEN @valor<100000 THEN '00'+CONVERT(CHAR(5),@valor) ---99999
								WHEN @valor<1000000 THEN '0'+CONVERT(CHAR(6),@valor) ---999999
								ELSE CONVERT(CHAR(7),@valor)						 ---9999999
								END)
			SET @codigo_generado = @codigo;
		END
	ELSE
		BEGIN
			PRINT 'C�digo de categoria desbordo'
			
		END
 RETURN;
END