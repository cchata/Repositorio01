

--pa_cargo_generar_codigo2--
DECLARE @codigo_generado varchar(10);
EXECUTE pa_cargo_generar_codigo2  @codigo_generado OUTPUT;
SELECT @codigo_generado  AS Codigo_generado;
-- . --


--pa_empleado_generar_codigo2--
declare @codigo_generado varchar(10);
EXECUTE pa_empleado_generar_codigo2  @codigo_generado OUTPUT;
SELECT @codigo_generado AS codigo_generado_empleado;
-- . --



--pa_empleado_generar_codigo2--
USE [bdBodega]
GO

DECLARE	@return_value int,
		@codigo_generado varchar(10)

EXEC	@return_value = [dbo].[pa_producto_generar_codigo2]
		@codigo_generado = @codigo_generado OUTPUT

SELECT	@codigo_generado as N'@codigo_generado'

SELECT	'Return Value' = @return_value

GO
-- pa_validar_usuario --
DECLARE	@return_value int,
		@p_codigoEmpleado varchar(10),
		@p_nombreEmpleado varchar(10),
		@p_apellidoEmpleado varchar(10),
		@p_mensajeError varchar(300)

EXEC	@return_value = [dbo].[pa_validar_usuario]
		@p_loguinUsuario = N'cchata',
		@p_claveUsuario = N'root',
		@p_codigoEmpleado = @p_codigoEmpleado OUTPUT,
		@p_nombreEmpleado = @p_nombreEmpleado OUTPUT,
		@p_apellidoEmpleado = @p_apellidoEmpleado OUTPUT,
		@p_mensajeError = @p_mensajeError OUTPUT

SELECT	@p_codigoEmpleado as N'@p_codigoEmpleado',
		@p_nombreEmpleado as N'@p_nombreEmpleado',
		@p_apellidoEmpleado as N'@p_apellidoEmpleado',
		@p_mensajeError as N'@p_mensajeError'

SELECT	'Return Value' = @return_value

GO
-- . --