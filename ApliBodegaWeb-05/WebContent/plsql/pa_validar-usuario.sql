CREATE  PROCEDURE pa_validar_usuario
@p_loguinUsuario varchar(10),
@p_claveUsuario varchar(10),
@p_codigoEmpleado varchar(10)OUTPUT,
@p_nombreEmpleado varchar(10)OUTPUT,
@p_apellidoEmpleado varchar(10)OUTPUT,
@p_mensajeError varchar(300) OUTPUT

AS
DECLARE @codigoUsuario varchar(11);
BEGIN TRY
	BEGIN TRAN

	SELECT @codigoUsuario = USU.codigo_usu,
			@p_codigoEmpleado = EMP.codigo_emp,
			@p_nombreEmpleado = EMP.nombre_emp,
			@p_apellidoEmpleado = EMP.apellidos_emp  FROM  tbUsuario USU INNER JOIN tbEmpleado EMP
	ON USU.codigo_emp = EMP.codigo_emp AND USU.login_usu = @p_loguinUsuario
									   AND USU.pass_usu = @p_claveUsuario;

	IF @codigoUsuario <> ''
		BEGIN
		
			
			PRINT 'CODIGO EMPLEADO: '+@p_codigoEmpleado+' NOMBRE:  '+@p_nombreEmpleado+'  APELLIDO: '+@p_apellidoEmpleado;
			PRINT 'MENSAJE ERROR: '+@p_mensajeError;

			COMMIT TRANSACTION
		END
	ELSE 
		BEGIN
			PRINT 'USUARIO NO EXISTE. '
			SET @p_mensajeError = 'Usuario no existe.';
			PRINT '@p_mensajeError: '+@p_mensajeError;
			ROLLBACK
		END

  
	END TRY	


BEGIN CATCH
	SET @p_mensajeError = ERROR_MESSAGE();
	PRINT '@p_mensajeError: '+@p_mensajeError;
END CATCH	