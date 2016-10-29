USE [bdBodega]
GO
/****** Object:  StoredProcedure [dbo].[pa_producto_actulizar_stock]    Script Date: 16/10/2016 16:35:35 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[pa_producto_actulizar_stock2]
@p_codigoPro varchar(20),
@p_cantidad int,
@p_mensaje_error varchar(200) OUTPUT
AS
BEGIN TRY
	BEGIN TRAN

	
	IF (EXISTS (SELECT codigo_pro FROM tbProducto WHERE codigo_pro=@p_codigoPro))
		BEGIN
						 
			UPDATE tbProducto SET stock_max_pro=stock_max_pro-@p_cantidad
			WHERE codigo_pro=@p_codigoPro;
							
		END
	ELSE
		BEGIN
		    SET @p_mensaje_error ='Código de producto no existe';
			PRINT 'Código de producto no existe';
			RETURN
		END
END TRY	

BEGIN CATCH
	SET @p_mensaje_error = ERROR_MESSAGE();
	PRINT '@p_mensajeError: '+@p_mensaje_error;
END CATCH	